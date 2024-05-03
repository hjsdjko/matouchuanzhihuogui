
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
 * 货柜信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/huogui")
public class HuoguiController {
    private static final Logger logger = LoggerFactory.getLogger(HuoguiController.class);

    @Autowired
    private HuoguiService huoguiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private ChuanzhiService chuanzhiService;

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
        params.put("huoguiDeleteStart",1);params.put("huoguiDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = huoguiService.queryPage(params);

        //字典表数据转换
        List<HuoguiView> list =(List<HuoguiView>)page.getList();
        for(HuoguiView c:list){
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
        HuoguiEntity huogui = huoguiService.selectById(id);
        if(huogui !=null){
            //entity转view
            HuoguiView view = new HuoguiView();
            BeanUtils.copyProperties( huogui , view );//把实体数据重构到view中

                //级联表
                ChuanzhiEntity chuanzhi = chuanzhiService.selectById(huogui.getChuanzhiId());
                if(chuanzhi != null){
                    BeanUtils.copyProperties( chuanzhi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setChuanzhiId(chuanzhi.getId());
                }
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
    public R save(@RequestBody HuoguiEntity huogui, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,huogui:{}",this.getClass().getName(),huogui.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");

        Wrapper<HuoguiEntity> queryWrapper = new EntityWrapper<HuoguiEntity>()
            .eq("chuanzhi_id", huogui.getChuanzhiId())
            .eq("huogui_uuid_number", huogui.getHuoguiUuidNumber())
            .eq("huogui_xinghao", huogui.getHuoguiXinghao())
            .eq("huogui_types", huogui.getHuoguiTypes())
            .eq("huogui_delete", huogui.getHuoguiDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuoguiEntity huoguiEntity = huoguiService.selectOne(queryWrapper);
        if(huoguiEntity==null){
            huogui.setHuoguiDelete(1);
            huogui.setCreateTime(new Date());
            huoguiService.insert(huogui);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody HuoguiEntity huogui, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,huogui:{}",this.getClass().getName(),huogui.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(StringUtil.isEmpty(role))
//            return R.error(511,"权限为空");
        //根据字段查询是否有相同数据
        Wrapper<HuoguiEntity> queryWrapper = new EntityWrapper<HuoguiEntity>()
            .notIn("id",huogui.getId())
            .andNew()
            .eq("chuanzhi_id", huogui.getChuanzhiId())
            .eq("huogui_uuid_number", huogui.getHuoguiUuidNumber())
            .eq("huogui_xinghao", huogui.getHuoguiXinghao())
            .eq("huogui_types", huogui.getHuoguiTypes())
            .eq("huogui_delete", huogui.getHuoguiDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuoguiEntity huoguiEntity = huoguiService.selectOne(queryWrapper);
        if(huoguiEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      huogui.set
            //  }
            huoguiService.updateById(huogui);//根据id更新
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
        ArrayList<HuoguiEntity> list = new ArrayList<>();
        for(Integer id:ids){
            HuoguiEntity huoguiEntity = new HuoguiEntity();
            huoguiEntity.setId(id);
            huoguiEntity.setHuoguiDelete(2);
            list.add(huoguiEntity);
        }
        if(list != null && list.size() >0){
            huoguiService.updateBatchById(list);
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
            List<HuoguiEntity> huoguiList = new ArrayList<>();//上传的东西
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
                            HuoguiEntity huoguiEntity = new HuoguiEntity();
//                            huoguiEntity.setChuanzhiId(Integer.valueOf(data.get(0)));   //船只 要改的
//                            huoguiEntity.setHuoguiUuidNumber(data.get(0));                    //货柜编号 要改的
//                            huoguiEntity.setHuoguiXinghao(data.get(0));                    //货柜型号 要改的
//                            huoguiEntity.setHuoguiTypes(Integer.valueOf(data.get(0)));   //货柜类型 要改的
//                            huoguiEntity.setHuoguiDelete(1);//逻辑删除字段
//                            huoguiEntity.setCreateTime(date);//时间
                            huoguiList.add(huoguiEntity);


                            //把要查询是否重复的字段放入map中
                                //货柜编号
                                if(seachFields.containsKey("huoguiUuidNumber")){
                                    List<String> huoguiUuidNumber = seachFields.get("huoguiUuidNumber");
                                    huoguiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> huoguiUuidNumber = new ArrayList<>();
                                    huoguiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("huoguiUuidNumber",huoguiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //货柜编号
                        List<HuoguiEntity> huoguiEntities_huoguiUuidNumber = huoguiService.selectList(new EntityWrapper<HuoguiEntity>().in("huogui_uuid_number", seachFields.get("huoguiUuidNumber")).eq("huogui_delete", 1));
                        if(huoguiEntities_huoguiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(HuoguiEntity s:huoguiEntities_huoguiUuidNumber){
                                repeatFields.add(s.getHuoguiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [货柜编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        huoguiService.insertBatch(huoguiList);
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
        PageUtils page = huoguiService.queryPage(params);

        //字典表数据转换
        List<HuoguiView> list =(List<HuoguiView>)page.getList();
        for(HuoguiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        HuoguiEntity huogui = huoguiService.selectById(id);
            if(huogui !=null){

                //entity转view
                HuoguiView view = new HuoguiView();
                BeanUtils.copyProperties( huogui , view );//把实体数据重构到view中

                //级联表
                    ChuanzhiEntity chuanzhi = chuanzhiService.selectById(huogui.getChuanzhiId());
                if(chuanzhi != null){
                    BeanUtils.copyProperties( chuanzhi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setChuanzhiId(chuanzhi.getId());
                }
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
    public R add(@RequestBody HuoguiEntity huogui, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,huogui:{}",this.getClass().getName(),huogui.toString());
        Wrapper<HuoguiEntity> queryWrapper = new EntityWrapper<HuoguiEntity>()
            .eq("chuanzhi_id", huogui.getChuanzhiId())
            .eq("huogui_uuid_number", huogui.getHuoguiUuidNumber())
            .eq("huogui_xinghao", huogui.getHuoguiXinghao())
            .eq("huogui_types", huogui.getHuoguiTypes())
            .eq("huogui_delete", huogui.getHuoguiDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuoguiEntity huoguiEntity = huoguiService.selectOne(queryWrapper);
        if(huoguiEntity==null){
            huogui.setHuoguiDelete(1);
            huogui.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      huogui.set
        //  }
        huoguiService.insert(huogui);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
