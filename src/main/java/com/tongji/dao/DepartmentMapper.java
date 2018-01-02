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
}
