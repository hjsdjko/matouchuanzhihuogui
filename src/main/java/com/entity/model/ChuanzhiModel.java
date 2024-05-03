package com.entity.model;

import com.entity.ChuanzhiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 船只信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ChuanzhiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


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
	 * 获取：船只编号
	 */
    public String getChuanzhiUuidNumber() {
        return chuanzhiUuidNumber;
    }


    /**
	 * 设置：船只编号
	 */
    public void setChuanzhiUuidNumber(String chuanzhiUuidNumber) {
        this.chuanzhiUuidNumber = chuanzhiUuidNumber;
    }
    /**
	 * 获取：船只名称
	 */
    public String getChuanzhiName() {
        return chuanzhiName;
    }


    /**
	 * 设置：船只名称
	 */
    public void setChuanzhiName(String chuanzhiName) {
        this.chuanzhiName = chuanzhiName;
    }
    /**
	 * 获取：船只类型
	 */
    public Integer getChuanzhiTypes() {
        return chuanzhiTypes;
    }


    /**
	 * 设置：船只类型
	 */
    public void setChuanzhiTypes(Integer chuanzhiTypes) {
        this.chuanzhiTypes = chuanzhiTypes;
    }
    /**
	 * 获取：船只图片
	 */
    public String getChuanzhiPhoto() {
        return chuanzhiPhoto;
    }


    /**
	 * 设置：船只图片
	 */
    public void setChuanzhiPhoto(String chuanzhiPhoto) {
        this.chuanzhiPhoto = chuanzhiPhoto;
    }
    /**
	 * 获取：船只型号
	 */
    public String getChuanzhiXinghao() {
        return chuanzhiXinghao;
    }


    /**
	 * 设置：船只型号
	 */
    public void setChuanzhiXinghao(String chuanzhiXinghao) {
        this.chuanzhiXinghao = chuanzhiXinghao;
    }
    /**
	 * 获取：船只材质
	 */
    public String getChuanzhiCaizhi() {
        return chuanzhiCaizhi;
    }


    /**
	 * 设置：船只材质
	 */
    public void setChuanzhiCaizhi(String chuanzhiCaizhi) {
        this.chuanzhiCaizhi = chuanzhiCaizhi;
    }
    /**
	 * 获取：详情
	 */
    public String getChuanzhiContent() {
        return chuanzhiContent;
    }


    /**
	 * 设置：详情
	 */
    public void setChuanzhiContent(String chuanzhiContent) {
        this.chuanzhiContent = chuanzhiContent;
    }
    /**
	 * 获取：假删
	 */
    public Integer getChuanzhiDelete() {
        return chuanzhiDelete;
    }


    /**
	 * 设置：假删
	 */
    public void setChuanzhiDelete(Integer chuanzhiDelete) {
        this.chuanzhiDelete = chuanzhiDelete;
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
