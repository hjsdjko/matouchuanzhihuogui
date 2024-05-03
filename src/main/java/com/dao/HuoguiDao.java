package com.dao;

import com.entity.HuoguiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.HuoguiView;

/**
 * 货柜信息 Dao 接口
 *
 * @author 
 */
public interface HuoguiDao extends BaseMapper<HuoguiEntity> {

   List<HuoguiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
