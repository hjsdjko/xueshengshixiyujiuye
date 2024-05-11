package com.entity.view;

import com.entity.FudaojiaoshiLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 辅导教师留言
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("fudaojiaoshi_liuyan")
public class FudaojiaoshiLiuyanView extends FudaojiaoshiLiuyanEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 fudaojiaoshi
			/**
			* 教师姓名
			*/
			private String fudaojiaoshiName;
			/**
			* 头像
			*/
			private String fudaojiaoshiPhoto;
			/**
			* 教师手机号
			*/
			private String fudaojiaoshiPhone;
			/**
			* 邮箱
			*/
			private String fudaojiaoshiEmail;

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 头像
			*/
			private String yonghuPhoto;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 邮箱
			*/
			private String yonghuEmail;
			/**
			* 假删
			*/
			private Integer yonghuDelete;

	public FudaojiaoshiLiuyanView() {

	}

	public FudaojiaoshiLiuyanView(FudaojiaoshiLiuyanEntity fudaojiaoshiLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, fudaojiaoshiLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}










				//级联表的get和set fudaojiaoshi

					/**
					* 获取： 教师姓名
					*/
					public String getFudaojiaoshiName() {
						return fudaojiaoshiName;
					}
					/**
					* 设置： 教师姓名
					*/
					public void setFudaojiaoshiName(String fudaojiaoshiName) {
						this.fudaojiaoshiName = fudaojiaoshiName;
					}

					/**
					* 获取： 头像
					*/
					public String getFudaojiaoshiPhoto() {
						return fudaojiaoshiPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setFudaojiaoshiPhoto(String fudaojiaoshiPhoto) {
						this.fudaojiaoshiPhoto = fudaojiaoshiPhoto;
					}

					/**
					* 获取： 教师手机号
					*/
					public String getFudaojiaoshiPhone() {
						return fudaojiaoshiPhone;
					}
					/**
					* 设置： 教师手机号
					*/
					public void setFudaojiaoshiPhone(String fudaojiaoshiPhone) {
						this.fudaojiaoshiPhone = fudaojiaoshiPhone;
					}

					/**
					* 获取： 邮箱
					*/
					public String getFudaojiaoshiEmail() {
						return fudaojiaoshiEmail;
					}
					/**
					* 设置： 邮箱
					*/
					public void setFudaojiaoshiEmail(String fudaojiaoshiEmail) {
						this.fudaojiaoshiEmail = fudaojiaoshiEmail;
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
					* 获取： 头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}

					/**
					* 获取： 用户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 用户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}

					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
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
					* 获取： 假删
					*/
					public Integer getYonghuDelete() {
						return yonghuDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setYonghuDelete(Integer yonghuDelete) {
						this.yonghuDelete = yonghuDelete;
					}












}
