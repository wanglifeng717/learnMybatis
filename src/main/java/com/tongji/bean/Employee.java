/**
* Title: employee.java
* Description: 这是一个员工的javaBean的类
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date 2017年12月24日
* @version 1.0
*/
package com.tongji.bean;

import java.sql.Date;

/**  
* Title: employee 
* Description:  这是一个员工的javaBean的类
* @author mdm(computer in lab)  
* @date 2017年12月24日  
*/
public class Employee {

	Integer id;          //这个属性和数据库的字段如果不同，查询的时候必须用别名
	String lastName;
	Date hireDate;
	Department  dept;
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	public Employee() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Employee(Integer id, String lastName, Date hireDate) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.hireDate = hireDate;
	}
	public int getId() {
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
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", hireDate=" + hireDate + "]";
	}
	
	

	
	
	
}
