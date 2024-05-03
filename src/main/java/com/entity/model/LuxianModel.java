package com.entity.model;

import com.entity.LuxianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 路线信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class LuxianModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 船只
     */
    private Integer chuanzhiId;


    /**
     * 路线编号
     */
    private String luxianUuidNumber;


    /**
     * 路线详情
     */
    private String luxianContent;


    /**
     * 假删
     */
    private Integer luxianDelete;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：船只
	 */
    public Integer getChuanzhiId() {
        return chuanzhiId;
    }


    /**
	 * 设置：船只
	 */
    public void setChuanzhiId(Integer chuanzhiId) {
        this.chuanzhiId = chuanzhiId;
    }
    /**
	 * 获取：路线编号
	 */
    public String getLuxianUuidNumber() {
        return luxianUuidNumber;
    }


    /**
	 * 设置：路线编号
	 */
    public void setLuxianUuidNumber(String luxianUuidNumber) {
        this.luxianUuidNumber = luxianUuidNumber;
    }
    /**
	 * 获取：路线详情
	 */
    public String getLuxianContent() {
        return luxianContent;
    }


    /**
	 * 设置：路线详情
	 */
    public void setLuxianContent(String luxianContent) {
        this.luxianContent = luxianContent;
    }
    /**
	 * 获取：假删
	 */
    public Integer getLuxianDelete() {
        return luxianDelete;
    }


    /**
	 * 设置：假删
	 */
    public void setLuxianDelete(Integer luxianDelete) {
        this.luxianDelete = luxianDelete;
    }
    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
