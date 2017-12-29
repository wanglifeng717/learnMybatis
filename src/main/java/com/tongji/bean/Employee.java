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

	int id;          //这个属性和数据库的字段如果不同，查询的时候必须用别名
	String LastName;
	Date hireDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLast_name() {
		return LastName;
	}
	public void setLast_name(String last_name) {
		this.LastName = last_name;
	}
	public Date getHire_date() {
		return hireDate;
	}
	public void setHire_date(Date hire_date) {
		this.hireDate = hire_date;
	}
	@Override
	public String toString() {
		return "employee [id=" + id + ", lastName=" + LastName + ", hireDate=" + hireDate + "]";
	}
	
	
}
