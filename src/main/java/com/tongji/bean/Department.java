/**
* Title: Department.java
* Description: 
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date 2018年1月4日
* @version 1.0
*/
package com.tongji.bean;

import java.io.Serializable;
import java.util.List;

/**  
* Title: Department 
* Description:  部门的javabean类。一个部门有很多的员工
* @author mdm(computer in lab)  
* @date 2018年1月4日  
*/
public class Department implements Serializable {

	private Integer id;
	private String departmentName;
	private List<Employee> employees;
	
	
	
	public Department() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Department(Integer id, String departmentName, List<Employee> employees) {
		super();
		this.id = id;
		this.departmentName = departmentName;
		this.employees = employees;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", departmentName=" + departmentName + ", employees=" + employees + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	
}
