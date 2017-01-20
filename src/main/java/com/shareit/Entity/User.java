package com.shareit.Entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	public User(Long id){
		this.id = id;
	}
	
	@Column(name = "userName")
	private String name;
	
	@Column(name = "userEmail", nullable = false, unique = true)
	private String email;
	
	@Column(name = "userMobile")
	private String phone;
	
	@Column(name = "userPassword")
	private String password;
	
	@Column(name = "userBirthday")
	private Date birthday;
	
	private transient String confirmPassword;
	
	public User(String name, String email, String password, String phone, Date birthday){
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.birthday = birthday;
	}
	
	public User(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	

}
