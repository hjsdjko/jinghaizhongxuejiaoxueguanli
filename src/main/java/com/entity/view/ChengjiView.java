package com.entity.view;

import com.entity.ChengjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 考试成绩
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-05-08
 */
@TableName("chengji")
public class ChengjiView extends ChengjiEntity implements Serializable {
    private static final long serialVersionUID = 1L;



		//级联表 kaoshi
			/**
			* 考试标题
			*/
			private String kaoshiName;
			/**
			* 考试学科
			*/
			private Integer xuekeTypes;
				/**
				* 考试学科的值
				*/
				private String xuekeValue;
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

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 性别
			*/
			private Integer sexTypes;
				/**
				* 性别的值
				*/
				private String sexValue;
			/**
			* 身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 手机号
			*/
			private String yonghuPhone;
			/**
			* 邮箱
			*/
			private String yonghuEmail;
			/**
			* 照片
			*/
			private String yonghuPhoto;

	public ChengjiView() {

	}

	public ChengjiView(ChengjiEntity chengjiEntity) {
		try {
			BeanUtils.copyProperties(this, chengjiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

















				//级联表的get和set kaoshi
					/**
					* 获取： 考试标题
					*/
					public String getKaoshiName() {
						return kaoshiName;
					}
					/**
					* 设置： 考试标题
					*/
					public void setKaoshiName(String kaoshiName) {
						this.kaoshiName = kaoshiName;
					}
					/**
					* 获取： 考试学科
					*/
					public Integer getXuekeTypes() {
						return xuekeTypes;
					}
					/**
					* 设置： 考试学科
					*/
					public void setXuekeTypes(Integer xuekeTypes) {
						this.xuekeTypes = xuekeTypes;
					}


						/**
						* 获取： 考试学科的值
						*/
						public String getXuekeValue() {
							return xuekeValue;
						}
						/**
						* 设置： 考试学科的值
						*/
						public void setXuekeValue(String xuekeValue) {
							this.xuekeValue = xuekeValue;
						}
					/**
					* 获取： 考试时间
					*/
					public String getKaoshiShijian() {
						return kaoshiShijian;
					}
					/**
					* 设置： 考试时间
					*/
					public void setKaoshiShijian(String kaoshiShijian) {
						this.kaoshiShijian = kaoshiShijian;
					}
					/**
					* 获取： 负责教师
					*/
					public Integer getJiaoshiId() {
						return jiaoshiId;
					}
					/**
					* 设置： 负责教师
					*/
					public void setJiaoshiId(Integer jiaoshiId) {
						this.jiaoshiId = jiaoshiId;
					}
					/**
					* 获取： 考试地址
					*/
					public String getKaoshiDizhi() {
						return kaoshiDizhi;
					}
					/**
					* 设置： 考试地址
					*/
					public void setKaoshiDizhi(String kaoshiDizhi) {
						this.kaoshiDizhi = kaoshiDizhi;
					}
					/**
					* 获取： 详情信息
					*/
					public String getKaoshiContent() {
						return kaoshiContent;
					}
					/**
					* 设置： 详情信息
					*/
					public void setKaoshiContent(String kaoshiContent) {
						this.kaoshiContent = kaoshiContent;
					}








				//级联表的get和set yonghu
					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 性别
					*/
					public Integer getSexTypes() {
						return sexTypes;
					}
					/**
					* 设置： 性别
					*/
					public void setSexTypes(Integer sexTypes) {
						this.sexTypes = sexTypes;
					}


						/**
						* 获取： 性别的值
						*/
						public String getSexValue() {
							return sexValue;
						}
						/**
						* 设置： 性别的值
						*/
						public void setSexValue(String sexValue) {
							this.sexValue = sexValue;
						}
					/**
					* 获取： 身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}
					/**
					* 获取： 照片
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 照片
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}




}
