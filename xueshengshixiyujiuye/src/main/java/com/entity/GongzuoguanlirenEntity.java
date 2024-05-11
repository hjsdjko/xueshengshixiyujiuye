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
 * 工作管理人
 *
 * @author 
 * @email
 */
@TableName("gongzuoguanliren")
public class GongzuoguanlirenEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public GongzuoguanlirenEntity() {

	}

	public GongzuoguanlirenEntity(T t) {
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
     * 账户
     */
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @TableField(value = "password")

    private String password;


    /**
     * 工作管理人姓名
     */
    @TableField(value = "gongzuoguanliren_name")

    private String gongzuoguanlirenName;


    /**
     * 头像
     */
    @TableField(value = "gongzuoguanliren_photo")

    private String gongzuoguanlirenPhoto;


    /**
     * 工作管理人手机号
     */
    @TableField(value = "gongzuoguanliren_phone")

    private String gongzuoguanlirenPhone;


    /**
     * 邮箱
     */
    @TableField(value = "gongzuoguanliren_email")

    private String gongzuoguanlirenEmail;


    /**
     * 性别
     */
    @TableField(value = "sex_types")

    private Integer sexTypes;


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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }
    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }
    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：工作管理人姓名
	 */
    public String getGongzuoguanlirenName() {
        return gongzuoguanlirenName;
    }
    /**
	 * 获取：工作管理人姓名
	 */

    public void setGongzuoguanlirenName(String gongzuoguanlirenName) {
        this.gongzuoguanlirenName = gongzuoguanlirenName;
    }
    /**
	 * 设置：头像
	 */
    public String getGongzuoguanlirenPhoto() {
        return gongzuoguanlirenPhoto;
    }
    /**
	 * 获取：头像
	 */

    public void setGongzuoguanlirenPhoto(String gongzuoguanlirenPhoto) {
        this.gongzuoguanlirenPhoto = gongzuoguanlirenPhoto;
    }
    /**
	 * 设置：工作管理人手机号
	 */
    public String getGongzuoguanlirenPhone() {
        return gongzuoguanlirenPhone;
    }
    /**
	 * 获取：工作管理人手机号
	 */

    public void setGongzuoguanlirenPhone(String gongzuoguanlirenPhone) {
        this.gongzuoguanlirenPhone = gongzuoguanlirenPhone;
    }
    /**
	 * 设置：邮箱
	 */
    public String getGongzuoguanlirenEmail() {
        return gongzuoguanlirenEmail;
    }
    /**
	 * 获取：邮箱
	 */

    public void setGongzuoguanlirenEmail(String gongzuoguanlirenEmail) {
        this.gongzuoguanlirenEmail = gongzuoguanlirenEmail;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }
    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
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
        return "Gongzuoguanliren{" +
            "id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", gongzuoguanlirenName=" + gongzuoguanlirenName +
            ", gongzuoguanlirenPhoto=" + gongzuoguanlirenPhoto +
            ", gongzuoguanlirenPhone=" + gongzuoguanlirenPhone +
            ", gongzuoguanlirenEmail=" + gongzuoguanlirenEmail +
            ", sexTypes=" + sexTypes +
            ", createTime=" + createTime +
        "}";
    }
}
