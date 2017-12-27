/**
* Title: employee.java
* Description: 这是一个员工的javaBean的类
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date 2017年12月24日
* @version 1.0
*/
package com.tongji.helloworld;

import java.sql.Date;

/**  
* Title: employee 
* Description:  这是一个员工的javaBean的类
* @author mdm(computer in lab)  
* @date 2017年12月24日  
*/
public class Employee {

	int id;          //这个属性和数据库的字段如果不同，查询的时候必须用别名
	String last_name;
	Date hire_date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public Date getHire_date() {
		return hire_date;
	}
	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}
	@Override
	public String toString() {
		return "employee [id=" + id + ", last_name=" + last_name + ", hire_date=" + hire_date + "]";
	}
	
	
}
