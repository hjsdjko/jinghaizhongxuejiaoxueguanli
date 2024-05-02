package com.entity.vo;

import com.entity.KechengEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 课程信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-05-08
 */
@TableName("kecheng")
public class KechengVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 课程名称
     */

    @TableField(value = "kecheng_name")
    private String kechengName;


    /**
     * 课程类型
     */

    @TableField(value = "xueke_types")
    private Integer xuekeTypes;


    /**
     * 课程时间
     */

    @TableField(value = "kecheng_shijian")
    private String kechengShijian;


    /**
     * 上课教师
     */

    @TableField(value = "jiaoshi_id")
    private Integer jiaoshiId;


    /**
     * 详情信息
     */

    @TableField(value = "kecheng_content")
    private String kechengContent;


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
	 * 设置：课程名称
	 */
    public String getKechengName() {
        return kechengName;
    }


    /**
	 * 获取：课程名称
	 */

    public void setKechengName(String kechengName) {
        this.kechengName = kechengName;
    }
    /**
	 * 设置：课程类型
	 */
    public Integer getXuekeTypes() {
        return xuekeTypes;
    }


    /**
	 * 获取：课程类型
	 */

    public void setXuekeTypes(Integer xuekeTypes) {
        this.xuekeTypes = xuekeTypes;
    }
    /**
	 * 设置：课程时间
	 */
    public String getKechengShijian() {
        return kechengShijian;
    }


    /**
	 * 获取：课程时间
	 */

    public void setKechengShijian(String kechengShijian) {
        this.kechengShijian = kechengShijian;
    }
    /**
	 * 设置：上课教师
	 */
    public Integer getJiaoshiId() {
        return jiaoshiId;
    }


    /**
	 * 获取：上课教师
	 */

    public void setJiaoshiId(Integer jiaoshiId) {
        this.jiaoshiId = jiaoshiId;
    }
    /**
	 * 设置：详情信息
	 */
    public String getKechengContent() {
        return kechengContent;
    }


    /**
	 * 获取：详情信息
	 */

    public void setKechengContent(String kechengContent) {
        this.kechengContent = kechengContent;
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
