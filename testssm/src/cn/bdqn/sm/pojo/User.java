package cn.bdqn.sm.pojo;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;



public class User {
	private Integer id; //id 
	@NotEmpty(message="用户不能为空！")
	private String userCode; //鐢ㄦ埛缂栫爜
	@NotEmpty(message="用户姓名不能为空！")
	private String userName; //鐢ㄦ埛鍚嶇О
	
	@NotNull(message="密码不能为空！")
	@Length(min=6,max=10,message="用户密码长度6-10")
	private String userPassword; //鐢ㄦ埛瀵嗙爜
	
	private Integer gender;  //鎬у埆
	@Past(message="生日必须为过去时间！")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;  //鍑虹敓鏃ユ湡
	private String phone;   //鐢佃瘽
	private String address; //鍦板潃
	private Integer userRole;    //鐢ㄦ埛瑙掕壊
	private Integer createdBy;   //鍒涘缓鑰�
	private Date creationDate; //鍒涘缓鏃堕棿
	private Integer modifyBy;     //鏇存柊鑰�
	private Date modifyDate;   //鏇存柊鏃堕棿
	private String roleName;

	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getUserRole() {
		return userRole;
	}
	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Integer getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

}
