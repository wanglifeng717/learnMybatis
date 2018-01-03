/**
* Title: DepartmentMapper.java
* Description: 
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date 2018年1月2日
* @version 1.0
*/
package com.tongji.dao;

import com.tongji.bean.Department;

/**  
* Title: DepartmentMapper 
* Description:  
* @author mdm(computer in lab)  
* @date 2018年1月2日  
*/
public interface DepartmentMapper {

	public Department getDeptById(Integer id);
	
	//查询当前部门，把当前部门里面的员工信息也全部查出来
	public Department getDeptByIdPlus(Integer id);
	
	//通过Id查询部门，分步走
	public Department getDeptByIdStep(Integer id);
}
