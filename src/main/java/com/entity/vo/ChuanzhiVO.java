package com.entity.vo;

import com.entity.ChuanzhiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 船只信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("chuanzhi")
public class ChuanzhiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 船只编号
     */

    @TableField(value = "chuanzhi_uuid_number")
    private String chuanzhiUuidNumber;


    /**
     * 船只名称
     */

    @TableField(value = "chuanzhi_name")
    private String chuanzhiName;


    /**
     * 船只类型
     */

    @TableField(value = "chuanzhi_types")
    private Integer chuanzhiTypes;


    /**
     * 船只图片
     */

    @TableField(value = "chuanzhi_photo")
    private String chuanzhiPhoto;


    /**
     * 船只型号
     */

    @TableField(value = "chuanzhi_xinghao")
    private String chuanzhiXinghao;


    /**
     * 船只材质
     */

    @TableField(value = "chuanzhi_caizhi")
    private String chuanzhiCaizhi;


    /**
     * 详情
     */

    @TableField(value = "chuanzhi_content")
    private String chuanzhiContent;


    /**
     * 假删
     */

    @TableField(value = "chuanzhi_delete")
    private Integer chuanzhiDelete;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
	 * 设置：船只编号
	 */
    public String getChuanzhiUuidNumber() {
        return chuanzhiUuidNumber;
    }


    /**
	 * 获取：船只编号
	 */

    public void setChuanzhiUuidNumber(String chuanzhiUuidNumber) {
        this.chuanzhiUuidNumber = chuanzhiUuidNumber;
    }
    /**
	 * 设置：船只名称
	 */
    public String getChuanzhiName() {
        return chuanzhiName;
    }


    /**
	 * 获取：船只名称
	 */

    public void setChuanzhiName(String chuanzhiName) {
        this.chuanzhiName = chuanzhiName;
    }
    /**
	 * 设置：船只类型
	 */
    public Integer getChuanzhiTypes() {
        return chuanzhiTypes;
    }


    /**
	 * 获取：船只类型
	 */

    public void setChuanzhiTypes(Integer chuanzhiTypes) {
        this.chuanzhiTypes = chuanzhiTypes;
    }
    /**
	 * 设置：船只图片
	 */
    public String getChuanzhiPhoto() {
        return chuanzhiPhoto;
    }


    /**
	 * 获取：船只图片
	 */

    public void setChuanzhiPhoto(String chuanzhiPhoto) {
        this.chuanzhiPhoto = chuanzhiPhoto;
    }
    /**
	 * 设置：船只型号
	 */
    public String getChuanzhiXinghao() {
        return chuanzhiXinghao;
    }


    /**
	 * 获取：船只型号
	 */

    public void setChuanzhiXinghao(String chuanzhiXinghao) {
        this.chuanzhiXinghao = chuanzhiXinghao;
    }
    /**
	 * 设置：船只材质
	 */
    public String getChuanzhiCaizhi() {
        return chuanzhiCaizhi;
    }


    /**
	 * 获取：船只材质
	 */

    public void setChuanzhiCaizhi(String chuanzhiCaizhi) {
        this.chuanzhiCaizhi = chuanzhiCaizhi;
    }
    /**
	 * 设置：详情
	 */
    public String getChuanzhiContent() {
        return chuanzhiContent;
    }


    /**
	 * 获取：详情
	 */

    public void setChuanzhiContent(String chuanzhiContent) {
        this.chuanzhiContent = chuanzhiContent;
    }
    /**
	 * 设置：假删
	 */
    public Integer getChuanzhiDelete() {
        return chuanzhiDelete;
    }


    /**
	 * 获取：假删
	 */

    public void setChuanzhiDelete(Integer chuanzhiDelete) {
        this.chuanzhiDelete = chuanzhiDelete;
    }
    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
