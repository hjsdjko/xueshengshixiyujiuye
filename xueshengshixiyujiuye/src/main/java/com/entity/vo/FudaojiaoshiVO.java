package com.entity.vo;

import com.entity.FudaojiaoshiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 辅导教师
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("fudaojiaoshi")
public class FudaojiaoshiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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
     * 教师姓名
     */

    @TableField(value = "fudaojiaoshi_name")
    private String fudaojiaoshiName;


    /**
     * 头像
     */

    @TableField(value = "fudaojiaoshi_photo")
    private String fudaojiaoshiPhoto;


    /**
     * 教师手机号
     */

    @TableField(value = "fudaojiaoshi_phone")
    private String fudaojiaoshiPhone;


    /**
     * 邮箱
     */

    @TableField(value = "fudaojiaoshi_email")
    private String fudaojiaoshiEmail;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 创建时间 show2 photoShow
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
	 * 设置：教师姓名
	 */
    public String getFudaojiaoshiName() {
        return fudaojiaoshiName;
    }


    /**
	 * 获取：教师姓名
	 */

    public void setFudaojiaoshiName(String fudaojiaoshiName) {
        this.fudaojiaoshiName = fudaojiaoshiName;
    }
    /**
	 * 设置：头像
	 */
    public String getFudaojiaoshiPhoto() {
        return fudaojiaoshiPhoto;
    }


    /**
	 * 获取：头像
	 */

    public void setFudaojiaoshiPhoto(String fudaojiaoshiPhoto) {
        this.fudaojiaoshiPhoto = fudaojiaoshiPhoto;
    }
    /**
	 * 设置：教师手机号
	 */
    public String getFudaojiaoshiPhone() {
        return fudaojiaoshiPhone;
    }


    /**
	 * 获取：教师手机号
	 */

    public void setFudaojiaoshiPhone(String fudaojiaoshiPhone) {
        this.fudaojiaoshiPhone = fudaojiaoshiPhone;
    }
    /**
	 * 设置：邮箱
	 */
    public String getFudaojiaoshiEmail() {
        return fudaojiaoshiEmail;
    }


    /**
	 * 获取：邮箱
	 */

    public void setFudaojiaoshiEmail(String fudaojiaoshiEmail) {
        this.fudaojiaoshiEmail = fudaojiaoshiEmail;
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
	 * 设置：创建时间 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
