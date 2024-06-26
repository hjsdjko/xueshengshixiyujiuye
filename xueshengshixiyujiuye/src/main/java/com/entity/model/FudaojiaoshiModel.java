package com.entity.model;

import com.entity.FudaojiaoshiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 辅导教师
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FudaojiaoshiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


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


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 创建时间 show2 photoShow
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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：教师姓名
	 */
    public String getFudaojiaoshiName() {
        return fudaojiaoshiName;
    }


    /**
	 * 设置：教师姓名
	 */
    public void setFudaojiaoshiName(String fudaojiaoshiName) {
        this.fudaojiaoshiName = fudaojiaoshiName;
    }
    /**
	 * 获取：头像
	 */
    public String getFudaojiaoshiPhoto() {
        return fudaojiaoshiPhoto;
    }


    /**
	 * 设置：头像
	 */
    public void setFudaojiaoshiPhoto(String fudaojiaoshiPhoto) {
        this.fudaojiaoshiPhoto = fudaojiaoshiPhoto;
    }
    /**
	 * 获取：教师手机号
	 */
    public String getFudaojiaoshiPhone() {
        return fudaojiaoshiPhone;
    }


    /**
	 * 设置：教师手机号
	 */
    public void setFudaojiaoshiPhone(String fudaojiaoshiPhone) {
        this.fudaojiaoshiPhone = fudaojiaoshiPhone;
    }
    /**
	 * 获取：邮箱
	 */
    public String getFudaojiaoshiEmail() {
        return fudaojiaoshiEmail;
    }


    /**
	 * 设置：邮箱
	 */
    public void setFudaojiaoshiEmail(String fudaojiaoshiEmail) {
        this.fudaojiaoshiEmail = fudaojiaoshiEmail;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：创建时间 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
