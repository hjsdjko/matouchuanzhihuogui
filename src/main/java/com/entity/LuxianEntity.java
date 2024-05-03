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
 * 路线信息
 *
 * @author 
 * @email
 */
@TableName("luxian")
public class LuxianEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public LuxianEntity() {

	}

	public LuxianEntity(T t) {
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
     * 路线编号
     */
    @TableField(value = "luxian_uuid_number")

    private String luxianUuidNumber;


    /**
     * 路线详情
     */
    @TableField(value = "luxian_content")

    private String luxianContent;


    /**
     * 假删
     */
    @TableField(value = "luxian_delete")

    private Integer luxianDelete;


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
	 * 设置：路线编号
	 */
    public String getLuxianUuidNumber() {
        return luxianUuidNumber;
    }


    /**
	 * 获取：路线编号
	 */

    public void setLuxianUuidNumber(String luxianUuidNumber) {
        this.luxianUuidNumber = luxianUuidNumber;
    }
    /**
	 * 设置：路线详情
	 */
    public String getLuxianContent() {
        return luxianContent;
    }


    /**
	 * 获取：路线详情
	 */

    public void setLuxianContent(String luxianContent) {
        this.luxianContent = luxianContent;
    }
    /**
	 * 设置：假删
	 */
    public Integer getLuxianDelete() {
        return luxianDelete;
    }


    /**
	 * 获取：假删
	 */

    public void setLuxianDelete(Integer luxianDelete) {
        this.luxianDelete = luxianDelete;
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
        return "Luxian{" +
            "id=" + id +
            ", chuanzhiId=" + chuanzhiId +
            ", luxianUuidNumber=" + luxianUuidNumber +
            ", luxianContent=" + luxianContent +
            ", luxianDelete=" + luxianDelete +
            ", createTime=" + createTime +
        "}";
    }
}
