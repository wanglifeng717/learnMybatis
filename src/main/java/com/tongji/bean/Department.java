/**
* Title: Department.java
* Description: 
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date 2018年1月2日
* @version 1.0
*/
package com.tongji.bean;

import java.util.List;

/**  
* Title: Department 
* Description:  
* @author mdm(computer in lab)  
* @date 2018年1月2日  
*/
public class Department {

	private Integer id;
	private String departmentName;
	//一个部门会有很多员工，我们会需要这样的查询
	private List<Employee> employees;
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Department() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
	public Department(Integer id, String departmentName) {
		super();
		this.id = id;
		this.departmentName = departmentName;
	}
	
	@Override
	public String toString() {
		return "Department [id=" + id + ", departmentName=" + departmentName + "]";
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
	
}
