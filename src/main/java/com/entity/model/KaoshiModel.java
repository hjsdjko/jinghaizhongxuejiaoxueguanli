package com.entity.model;

import com.entity.KaoshiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 考试信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-05-08
 */
public class KaoshiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 考试标题
     */
    private String kaoshiName;


    /**
     * 考试学科
     */
    private Integer xuekeTypes;


    /**
     * 考试时间
     */
    private String kaoshiShijian;


    /**
     * 负责教师
     */
    private Integer jiaoshiId;


    /**
     * 考试地址
     */
    private String kaoshiDizhi;


    /**
     * 详情信息
     */
    private String kaoshiContent;


    /**
     * 创建时间
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
	 * 获取：考试标题
	 */
    public String getKaoshiName() {
        return kaoshiName;
    }


    /**
	 * 设置：考试标题
	 */
    public void setKaoshiName(String kaoshiName) {
        this.kaoshiName = kaoshiName;
    }
    /**
	 * 获取：考试学科
	 */
    public Integer getXuekeTypes() {
        return xuekeTypes;
    }


    /**
	 * 设置：考试学科
	 */
    public void setXuekeTypes(Integer xuekeTypes) {
        this.xuekeTypes = xuekeTypes;
    }
    /**
	 * 获取：考试时间
	 */
    public String getKaoshiShijian() {
        return kaoshiShijian;
    }


    /**
	 * 设置：考试时间
	 */
    public void setKaoshiShijian(String kaoshiShijian) {
        this.kaoshiShijian = kaoshiShijian;
    }
    /**
	 * 获取：负责教师
	 */
    public Integer getJiaoshiId() {
        return jiaoshiId;
    }


    /**
	 * 设置：负责教师
	 */
    public void setJiaoshiId(Integer jiaoshiId) {
        this.jiaoshiId = jiaoshiId;
    }
    /**
	 * 获取：考试地址
	 */
    public String getKaoshiDizhi() {
        return kaoshiDizhi;
    }


    /**
	 * 设置：考试地址
	 */
    public void setKaoshiDizhi(String kaoshiDizhi) {
        this.kaoshiDizhi = kaoshiDizhi;
    }
    /**
	 * 获取：详情信息
	 */
    public String getKaoshiContent() {
        return kaoshiContent;
    }


    /**
	 * 设置：详情信息
	 */
    public void setKaoshiContent(String kaoshiContent) {
        this.kaoshiContent = kaoshiContent;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
