package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 货柜信息
 *
 * @author 
 * @email
 */
@TableName("huogui")
public class HuoguiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public HuoguiEntity() {

	}

	public HuoguiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 船只
     */
    @TableField(value = "chuanzhi_id")

    private Integer chuanzhiId;


    /**
     * 货柜编号
     */
    @TableField(value = "huogui_uuid_number")

    private String huoguiUuidNumber;


    /**
     * 货柜型号
     */
    @TableField(value = "huogui_xinghao")

    private String huoguiXinghao;


    /**
     * 货柜类型
     */
    @TableField(value = "huogui_types")

    private Integer huoguiTypes;


    /**
     * 假删
     */
    @TableField(value = "huogui_delete")

    private Integer huoguiDelete;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：船只
	 */
    public Integer getChuanzhiId() {
        return chuanzhiId;
    }


    /**
	 * 获取：船只
	 */

    public void setChuanzhiId(Integer chuanzhiId) {
        this.chuanzhiId = chuanzhiId;
    }
    /**
	 * 设置：货柜编号
	 */
    public String getHuoguiUuidNumber() {
        return huoguiUuidNumber;
    }


    /**
	 * 获取：货柜编号
	 */

    public void setHuoguiUuidNumber(String huoguiUuidNumber) {
        this.huoguiUuidNumber = huoguiUuidNumber;
    }
    /**
	 * 设置：货柜型号
	 */
    public String getHuoguiXinghao() {
        return huoguiXinghao;
    }


    /**
	 * 获取：货柜型号
	 */

    public void setHuoguiXinghao(String huoguiXinghao) {
        this.huoguiXinghao = huoguiXinghao;
    }
    /**
	 * 设置：货柜类型
	 */
    public Integer getHuoguiTypes() {
        return huoguiTypes;
    }


    /**
	 * 获取：货柜类型
	 */

    public void setHuoguiTypes(Integer huoguiTypes) {
        this.huoguiTypes = huoguiTypes;
    }
    /**
	 * 设置：假删
	 */
    public Integer getHuoguiDelete() {
        return huoguiDelete;
    }


    /**
	 * 获取：假删
	 */

    public void setHuoguiDelete(Integer huoguiDelete) {
        this.huoguiDelete = huoguiDelete;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Huogui{" +
            "id=" + id +
            ", chuanzhiId=" + chuanzhiId +
            ", huoguiUuidNumber=" + huoguiUuidNumber +
            ", huoguiXinghao=" + huoguiXinghao +
            ", huoguiTypes=" + huoguiTypes +
            ", huoguiDelete=" + huoguiDelete +
            ", createTime=" + createTime +
        "}";
    }
}
