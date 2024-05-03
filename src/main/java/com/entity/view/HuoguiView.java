package com.entity.view;

import com.entity.HuoguiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 货柜信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("huogui")
public class HuoguiView extends HuoguiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 货柜类型的值
		*/
		private String huoguiValue;



		//级联表 chuanzhi
			/**
			* 船只编号
			*/
			private String chuanzhiUuidNumber;
			/**
			* 船只名称
			*/
			private String chuanzhiName;
			/**
			* 船只类型
			*/
			private Integer chuanzhiTypes;
				/**
				* 船只类型的值
				*/
				private String chuanzhiValue;
			/**
			* 船只图片
			*/
			private String chuanzhiPhoto;
			/**
			* 船只型号
			*/
			private String chuanzhiXinghao;
			/**
			* 船只材质
			*/
			private String chuanzhiCaizhi;
			/**
			* 详情
			*/
			private String chuanzhiContent;
			/**
			* 假删
			*/
			private Integer chuanzhiDelete;

	public HuoguiView() {

	}

	public HuoguiView(HuoguiEntity huoguiEntity) {
		try {
			BeanUtils.copyProperties(this, huoguiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 货柜类型的值
			*/
			public String getHuoguiValue() {
				return huoguiValue;
			}
			/**
			* 设置： 货柜类型的值
			*/
			public void setHuoguiValue(String huoguiValue) {
				this.huoguiValue = huoguiValue;
			}




				//级联表的get和set chuanzhi
					/**
					* 获取： 船只编号
					*/
					public String getChuanzhiUuidNumber() {
						return chuanzhiUuidNumber;
					}
					/**
					* 设置： 船只编号
					*/
					public void setChuanzhiUuidNumber(String chuanzhiUuidNumber) {
						this.chuanzhiUuidNumber = chuanzhiUuidNumber;
					}
					/**
					* 获取： 船只名称
					*/
					public String getChuanzhiName() {
						return chuanzhiName;
					}
					/**
					* 设置： 船只名称
					*/
					public void setChuanzhiName(String chuanzhiName) {
						this.chuanzhiName = chuanzhiName;
					}
					/**
					* 获取： 船只类型
					*/
					public Integer getChuanzhiTypes() {
						return chuanzhiTypes;
					}
					/**
					* 设置： 船只类型
					*/
					public void setChuanzhiTypes(Integer chuanzhiTypes) {
						this.chuanzhiTypes = chuanzhiTypes;
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
					/**
					* 获取： 船只图片
					*/
					public String getChuanzhiPhoto() {
						return chuanzhiPhoto;
					}
					/**
					* 设置： 船只图片
					*/
					public void setChuanzhiPhoto(String chuanzhiPhoto) {
						this.chuanzhiPhoto = chuanzhiPhoto;
					}
					/**
					* 获取： 船只型号
					*/
					public String getChuanzhiXinghao() {
						return chuanzhiXinghao;
					}
					/**
					* 设置： 船只型号
					*/
					public void setChuanzhiXinghao(String chuanzhiXinghao) {
						this.chuanzhiXinghao = chuanzhiXinghao;
					}
					/**
					* 获取： 船只材质
					*/
					public String getChuanzhiCaizhi() {
						return chuanzhiCaizhi;
					}
					/**
					* 设置： 船只材质
					*/
					public void setChuanzhiCaizhi(String chuanzhiCaizhi) {
						this.chuanzhiCaizhi = chuanzhiCaizhi;
					}
					/**
					* 获取： 详情
					*/
					public String getChuanzhiContent() {
						return chuanzhiContent;
					}
					/**
					* 设置： 详情
					*/
					public void setChuanzhiContent(String chuanzhiContent) {
						this.chuanzhiContent = chuanzhiContent;
					}
					/**
					* 获取： 假删
					*/
					public Integer getChuanzhiDelete() {
						return chuanzhiDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setChuanzhiDelete(Integer chuanzhiDelete) {
						this.chuanzhiDelete = chuanzhiDelete;
					}












}
