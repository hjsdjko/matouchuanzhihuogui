package com.entity.vo;

import com.entity.HuoguiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 货柜信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("huogui")
public class HuoguiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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
