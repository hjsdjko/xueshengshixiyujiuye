package com.entity.model;

import com.entity.GongzuoguanlirenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 工作管理人
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class GongzuoguanlirenModel implements Serializable {
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
     * 工作管理人姓名
     */
    private String gongzuoguanlirenName;


    /**
     * 头像
     */
    private String gongzuoguanlirenPhoto;


    /**
     * 工作管理人手机号
     */
    private String gongzuoguanlirenPhone;


    /**
     * 邮箱
     */
    private String gongzuoguanlirenEmail;


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
	 * 获取：工作管理人姓名
	 */
    public String getGongzuoguanlirenName() {
        return gongzuoguanlirenName;
    }


    /**
	 * 设置：工作管理人姓名
	 */
    public void setGongzuoguanlirenName(String gongzuoguanlirenName) {
        this.gongzuoguanlirenName = gongzuoguanlirenName;
    }
    /**
	 * 获取：头像
	 */
    public String getGongzuoguanlirenPhoto() {
        return gongzuoguanlirenPhoto;
    }


    /**
	 * 设置：头像
	 */
    public void setGongzuoguanlirenPhoto(String gongzuoguanlirenPhoto) {
        this.gongzuoguanlirenPhoto = gongzuoguanlirenPhoto;
    }
    /**
	 * 获取：工作管理人手机号
	 */
    public String getGongzuoguanlirenPhone() {
        return gongzuoguanlirenPhone;
    }


    /**
	 * 设置：工作管理人手机号
	 */
    public void setGongzuoguanlirenPhone(String gongzuoguanlirenPhone) {
        this.gongzuoguanlirenPhone = gongzuoguanlirenPhone;
    }
    /**
	 * 获取：邮箱
	 */
    public String getGongzuoguanlirenEmail() {
        return gongzuoguanlirenEmail;
    }


    /**
	 * 设置：邮箱
	 */
    public void setGongzuoguanlirenEmail(String gongzuoguanlirenEmail) {
        this.gongzuoguanlirenEmail = gongzuoguanlirenEmail;
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
