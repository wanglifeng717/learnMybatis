/**
* Title: EmployeeMapper.java
* Description: 
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date 2017年12月27日
* @version 1.0
*/
package com.tongji.dao;

import com.tongji.bean.Employee;

/**  
* Title: EmployeeMapper 
* Description:  
* @author mdm(computer in lab)  
* @date 2017年12月27日  
*/
public interface EmployeeMapper {
	public Employee getEmpById(Integer id);
}
