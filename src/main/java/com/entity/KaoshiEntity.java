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
 * 考试信息
 *
 * @author 
 * @email
 * @date 2021-05-08
 */
@TableName("kaoshi")
public class KaoshiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public KaoshiEntity() {

	}

	public KaoshiEntity(T t) {
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
     * 考试标题
     */
    @TableField(value = "kaoshi_name")

    private String kaoshiName;


    /**
     * 考试学科
     */
    @TableField(value = "xueke_types")

    private Integer xuekeTypes;


    /**
     * 考试时间
     */
    @TableField(value = "kaoshi_shijian")

    private String kaoshiShijian;


    /**
     * 负责教师
     */
    @TableField(value = "jiaoshi_id")

    private Integer jiaoshiId;


    /**
     * 考试地址
     */
    @TableField(value = "kaoshi_dizhi")

    private String kaoshiDizhi;


    /**
     * 详情信息
     */
    @TableField(value = "kaoshi_content")

    private String kaoshiContent;


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
	 * 设置：考试标题
	 */
    public String getKaoshiName() {
        return kaoshiName;
    }


    /**
	 * 获取：考试标题
	 */

    public void setKaoshiName(String kaoshiName) {
        this.kaoshiName = kaoshiName;
    }
    /**
	 * 设置：考试学科
	 */
    public Integer getXuekeTypes() {
        return xuekeTypes;
    }


    /**
	 * 获取：考试学科
	 */

    public void setXuekeTypes(Integer xuekeTypes) {
        this.xuekeTypes = xuekeTypes;
    }
    /**
	 * 设置：考试时间
	 */
    public String getKaoshiShijian() {
        return kaoshiShijian;
    }


    /**
	 * 获取：考试时间
	 */

    public void setKaoshiShijian(String kaoshiShijian) {
        this.kaoshiShijian = kaoshiShijian;
    }
    /**
	 * 设置：负责教师
	 */
    public Integer getJiaoshiId() {
        return jiaoshiId;
    }


    /**
	 * 获取：负责教师
	 */

    public void setJiaoshiId(Integer jiaoshiId) {
        this.jiaoshiId = jiaoshiId;
    }
    /**
	 * 设置：考试地址
	 */
    public String getKaoshiDizhi() {
        return kaoshiDizhi;
    }


    /**
	 * 获取：考试地址
	 */

    public void setKaoshiDizhi(String kaoshiDizhi) {
        this.kaoshiDizhi = kaoshiDizhi;
    }
    /**
	 * 设置：详情信息
	 */
    public String getKaoshiContent() {
        return kaoshiContent;
    }


    /**
	 * 获取：详情信息
	 */

    public void setKaoshiContent(String kaoshiContent) {
        this.kaoshiContent = kaoshiContent;
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
        return "Kaoshi{" +
            "id=" + id +
            ", kaoshiName=" + kaoshiName +
            ", xuekeTypes=" + xuekeTypes +
            ", kaoshiShijian=" + kaoshiShijian +
            ", jiaoshiId=" + jiaoshiId +
            ", kaoshiDizhi=" + kaoshiDizhi +
            ", kaoshiContent=" + kaoshiContent +
            ", createTime=" + createTime +
        "}";
    }
}
