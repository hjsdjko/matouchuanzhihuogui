
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 船只信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/chuanzhi")
public class ChuanzhiController {
    private static final Logger logger = LoggerFactory.getLogger(ChuanzhiController.class);

    @Autowired
    private ChuanzhiService chuanzhiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("chuanzhiDeleteStart",1);params.put("chuanzhiDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = chuanzhiService.queryPage(params);

        //字典表数据转换
        List<ChuanzhiView> list =(List<ChuanzhiView>)page.getList();
        for(ChuanzhiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChuanzhiEntity chuanzhi = chuanzhiService.selectById(id);
        if(chuanzhi !=null){
            //entity转view
            ChuanzhiView view = new ChuanzhiView();
            BeanUtils.copyProperties( chuanzhi , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ChuanzhiEntity chuanzhi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,chuanzhi:{}",this.getClass().getName(),chuanzhi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");

        Wrapper<ChuanzhiEntity> queryWrapper = new EntityWrapper<ChuanzhiEntity>()
            .eq("chuanzhi_uuid_number", chuanzhi.getChuanzhiUuidNumber())
            .eq("chuanzhi_name", chuanzhi.getChuanzhiName())
            .eq("chuanzhi_types", chuanzhi.getChuanzhiTypes())
            .eq("chuanzhi_xinghao", chuanzhi.getChuanzhiXinghao())
            .eq("chuanzhi_caizhi", chuanzhi.getChuanzhiCaizhi())
            .eq("chuanzhi_delete", chuanzhi.getChuanzhiDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChuanzhiEntity chuanzhiEntity = chuanzhiService.selectOne(queryWrapper);
        if(chuanzhiEntity==null){
            chuanzhi.setChuanzhiDelete(1);
            chuanzhi.setCreateTime(new Date());
            chuanzhiService.insert(chuanzhi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChuanzhiEntity chuanzhi, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,chuanzhi:{}",this.getClass().getName(),chuanzhi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(StringUtil.isEmpty(role))
//            return R.error(511,"权限为空");
        //根据字段查询是否有相同数据
        Wrapper<ChuanzhiEntity> queryWrapper = new EntityWrapper<ChuanzhiEntity>()
            .notIn("id",chuanzhi.getId())
            .andNew()
            .eq("chuanzhi_uuid_number", chuanzhi.getChuanzhiUuidNumber())
            .eq("chuanzhi_name", chuanzhi.getChuanzhiName())
            .eq("chuanzhi_types", chuanzhi.getChuanzhiTypes())
            .eq("chuanzhi_xinghao", chuanzhi.getChuanzhiXinghao())
            .eq("chuanzhi_caizhi", chuanzhi.getChuanzhiCaizhi())
            .eq("chuanzhi_delete", chuanzhi.getChuanzhiDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChuanzhiEntity chuanzhiEntity = chuanzhiService.selectOne(queryWrapper);
        if("".equals(chuanzhi.getChuanzhiPhoto()) || "null".equals(chuanzhi.getChuanzhiPhoto())){
                chuanzhi.setChuanzhiPhoto(null);
        }
        if(chuanzhiEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      chuanzhi.set
            //  }
            chuanzhiService.updateById(chuanzhi);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<ChuanzhiEntity> list = new ArrayList<>();
        for(Integer id:ids){
            ChuanzhiEntity chuanzhiEntity = new ChuanzhiEntity();
            chuanzhiEntity.setId(id);
            chuanzhiEntity.setChuanzhiDelete(2);
            list.add(chuanzhiEntity);
        }
        if(list != null && list.size() >0){
            chuanzhiService.updateBatchById(list);
        }
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<ChuanzhiEntity> chuanzhiList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ChuanzhiEntity chuanzhiEntity = new ChuanzhiEntity();
//                            chuanzhiEntity.setChuanzhiUuidNumber(data.get(0));                    //船只编号 要改的
//                            chuanzhiEntity.setChuanzhiName(data.get(0));                    //船只名称 要改的
//                            chuanzhiEntity.setChuanzhiTypes(Integer.valueOf(data.get(0)));   //船只类型 要改的
//                            chuanzhiEntity.setChuanzhiPhoto("");//照片
//                            chuanzhiEntity.setChuanzhiXinghao(data.get(0));                    //船只型号 要改的
//                            chuanzhiEntity.setChuanzhiCaizhi(data.get(0));                    //船只材质 要改的
//                            chuanzhiEntity.setChuanzhiContent("");//照片
//                            chuanzhiEntity.setChuanzhiDelete(1);//逻辑删除字段
//                            chuanzhiEntity.setCreateTime(date);//时间
                            chuanzhiList.add(chuanzhiEntity);


                            //把要查询是否重复的字段放入map中
                                //船只编号
                                if(seachFields.containsKey("chuanzhiUuidNumber")){
                                    List<String> chuanzhiUuidNumber = seachFields.get("chuanzhiUuidNumber");
                                    chuanzhiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> chuanzhiUuidNumber = new ArrayList<>();
                                    chuanzhiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("chuanzhiUuidNumber",chuanzhiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //船只编号
                        List<ChuanzhiEntity> chuanzhiEntities_chuanzhiUuidNumber = chuanzhiService.selectList(new EntityWrapper<ChuanzhiEntity>().in("chuanzhi_uuid_number", seachFields.get("chuanzhiUuidNumber")).eq("chuanzhi_delete", 1));
                        if(chuanzhiEntities_chuanzhiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ChuanzhiEntity s:chuanzhiEntities_chuanzhiUuidNumber){
                                repeatFields.add(s.getChuanzhiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [船只编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        chuanzhiService.insertBatch(chuanzhiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = chuanzhiService.queryPage(params);

        //字典表数据转换
        List<ChuanzhiView> list =(List<ChuanzhiView>)page.getList();
        for(ChuanzhiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChuanzhiEntity chuanzhi = chuanzhiService.selectById(id);
            if(chuanzhi !=null){


                //entity转view
                ChuanzhiView view = new ChuanzhiView();
                BeanUtils.copyProperties( chuanzhi , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ChuanzhiEntity chuanzhi, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,chuanzhi:{}",this.getClass().getName(),chuanzhi.toString());
        Wrapper<ChuanzhiEntity> queryWrapper = new EntityWrapper<ChuanzhiEntity>()
            .eq("chuanzhi_uuid_number", chuanzhi.getChuanzhiUuidNumber())
            .eq("chuanzhi_name", chuanzhi.getChuanzhiName())
            .eq("chuanzhi_types", chuanzhi.getChuanzhiTypes())
            .eq("chuanzhi_xinghao", chuanzhi.getChuanzhiXinghao())
            .eq("chuanzhi_caizhi", chuanzhi.getChuanzhiCaizhi())
            .eq("chuanzhi_delete", chuanzhi.getChuanzhiDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChuanzhiEntity chuanzhiEntity = chuanzhiService.selectOne(queryWrapper);
        if(chuanzhiEntity==null){
            chuanzhi.setChuanzhiDelete(1);
            chuanzhi.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      chuanzhi.set
        //  }
        chuanzhiService.insert(chuanzhi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
