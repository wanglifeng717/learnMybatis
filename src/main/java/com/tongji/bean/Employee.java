/**
* Title: Employee.java
* Description: 
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date 2018年1月4日
* @version 1.0
*/
package com.tongji.bean;

import java.io.Serializable;
import java.sql.Date;

/**  
* Title: Employee 
* Description: 员工的javaBean类，默认是一个员工属于一个部门 
* @author mdm(computer in lab)  
* @date 2018年1月4日  
*/
public class Employee implements Serializable{

	private Integer  id;
	private String  lastName;
	private String email;
	private Date hireDate;
	private Integer gender;
	private Department dept;
	
	
	
	
	public Employee() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Employee(Integer id, String lastName, String email, Date hireDate, Integer gender, Department dept) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.hireDate = hireDate;
		this.gender = gender;
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", email=" + email + ", hireDate=" + hireDate
				+ ", gender=" + gender + ", dept=" + dept + "]";
	}
	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
}
