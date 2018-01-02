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


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.tongji.bean.Employee;

/**  
* Title: EmployeeMapper 
* Description:  这是一个接口文件，用来定义方法。
* @author mdm(computer in lab)  
* @date 2017年12月27日  
*/
//1.mybatis允许增删改查直接定义以下类型的返回值
//	Integer，long,Boolean

public interface EmployeeMapper {
	
	public List<Employee> getEmpsByLastNameLike(String lastName);
	
	public Employee getEmpByMap(Map<String, Object> map);
	//多参数的输入mybatis是直接封装成了一个map,我们用注解，在引用的是有就不用写#{param1}了
	public Employee getEmpByIdAndLastName(@Param("id")Integer id,@Param("lastName")String lastName);
	
	public Employee getEmpById(Integer id);
	
	public Integer addEmp(Employee employee);
	
	public void updateEmp(Employee employee);
	
	public void deleteEmpById(Integer id);
}
