package com.entity.vo;

import com.entity.GongzuoguanlirenEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 工作管理人
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("gongzuoguanliren")
public class GongzuoguanlirenVO implements Serializable {
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
