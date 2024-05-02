package com.entity.vo;

import com.entity.KaoshiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 考试信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-05-08
 */
@TableName("kaoshi")
public class KaoshiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

}
