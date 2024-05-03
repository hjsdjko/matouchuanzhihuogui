package com.entity.model;

import com.entity.HuoguiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 货柜信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class HuoguiModel implements Serializable {
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
     * 货柜编号
     */
    private String huoguiUuidNumber;


    /**
     * 货柜型号
     */
    private String huoguiXinghao;


    /**
     * 货柜类型
     */
    private Integer huoguiTypes;


    /**
     * 假删
     */
    private Integer huoguiDelete;


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
	 * 获取：货柜编号
	 */
    public String getHuoguiUuidNumber() {
        return huoguiUuidNumber;
    }


    /**
	 * 设置：货柜编号
	 */
    public void setHuoguiUuidNumber(String huoguiUuidNumber) {
        this.huoguiUuidNumber = huoguiUuidNumber;
    }
    /**
	 * 获取：货柜型号
	 */
    public String getHuoguiXinghao() {
        return huoguiXinghao;
    }


    /**
	 * 设置：货柜型号
	 */
    public void setHuoguiXinghao(String huoguiXinghao) {
        this.huoguiXinghao = huoguiXinghao;
    }
    /**
	 * 获取：货柜类型
	 */
    public Integer getHuoguiTypes() {
        return huoguiTypes;
    }


    /**
	 * 设置：货柜类型
	 */
    public void setHuoguiTypes(Integer huoguiTypes) {
        this.huoguiTypes = huoguiTypes;
    }
    /**
	 * 获取：假删
	 */
    public Integer getHuoguiDelete() {
        return huoguiDelete;
    }


    /**
	 * 设置：假删
	 */
    public void setHuoguiDelete(Integer huoguiDelete) {
        this.huoguiDelete = huoguiDelete;
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
