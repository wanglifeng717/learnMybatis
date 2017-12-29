/**
* Title: EmployeeMapperAnnotation.java
* Description: 这是一个bean类的映射的接口文件
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date 2017年12月28日
* @version 1.0
*/
package com.tongji.dao;

import org.apache.ibatis.annotations.Select;

import com.tongji.bean.Employee;

/**  
* Title: EmployeeMapperAnnotation 
* Description:  这里我们不采用原来的把接口注册到映射的xml文件中
* 而是直接在接口上加注解。
* @author mdm(computer in lab)  
* @date 2017年12月28日  
*/

public interface  EmployeeMapperAnnotation {
	@Select("select * from employees where employee_id=#{id}")
	public Employee getEmpById(Integer id);
}
