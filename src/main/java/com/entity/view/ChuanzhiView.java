package com.entity.view;

import com.entity.ChuanzhiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 船只信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("chuanzhi")
public class ChuanzhiView extends ChuanzhiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 船只类型的值
		*/
		private String chuanzhiValue;



	public ChuanzhiView() {

	}

	public ChuanzhiView(ChuanzhiEntity chuanzhiEntity) {
		try {
			BeanUtils.copyProperties(this, chuanzhiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 船只类型的值
			*/
			public String getChuanzhiValue() {
				return chuanzhiValue;
			}
			/**
			* 设置： 船只类型的值
			*/
			public void setChuanzhiValue(String chuanzhiValue) {
				this.chuanzhiValue = chuanzhiValue;
			}









}
