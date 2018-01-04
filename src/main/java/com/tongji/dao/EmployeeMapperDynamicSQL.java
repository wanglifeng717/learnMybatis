/**
* Title: EmployeeMapperDynamicSQL.java
* Description: 
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date 2018年1月4日
* @version 1.0
*/
package com.tongji.dao;

import java.util.List;

import com.tongji.bean.Employee;

/**  
* Title: EmployeeMapperDynamicSQL 
* Description:  
* @author mdm(computer in lab)  
* @date 2018年1月4日  
*/
public interface EmployeeMapperDynamicSQL {

	//参询员工，传进来的员工携带哪几个字段就用携带上哪几个字段。
	public List<Employee> getEmpsByConditionIf(Employee employee);
	//参询员工，传进来的员工携带哪几个字段就用携带上哪几个字段,只不过我们拿trim标签来模拟
	public List<Employee> getEmpsByConditionTrim(Employee employee);
	//查询员工，是按照选择某个条件，而不是向上面一样，所有条件去全部封装起来。
	public List<Employee> getEmpsByConditionChoose(Employee employee);
}
