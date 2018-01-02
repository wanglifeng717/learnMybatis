/**
* Title: EmployeeMapperPlus.java
* Description: 
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date 2018年1月2日
* @version 1.0
*/
package com.tongji.dao;

import com.tongji.bean.Employee;

/**  
* Title: EmployeeMapperPlus 
* Description:  接口的方法
* @author mdm(computer in lab)  
* @date 2018年1月2日  
*/
public interface EmployeeMapperPlus {

	//定义查询员工及其员工对应的部门的信息
	public Employee getEmpAndDept(Integer id);
	
	
	public Employee getEmpById(Integer id);
}
