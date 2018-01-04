/**
* Title: getDataByDynamicSQL.java
* Description: 
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date 2018年1月4日
* @version 1.0
*/
package com.tongji.testfunction;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.tongji.bean.Employee;

import com.tongji.dao.EmployeeMapperDynamicSQL;

/**  
* Title: getDataByDynamicSQL 
* Description:  
* @author mdm(computer in lab)  
* @date 2018年1月4日  
*/
public class getDataByDynamicSQL {
	/**
	 * 功能：通过xml文件获得SqlSessionFactory
	 * @return
	 * @throws IOException
	 */
	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource ="mybatis-config.xml";
		InputStream inputStream=Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	/**
	 * 功能：<!-- 查询员工，要求，携带了哪个字段查询条件就带上这个字段的值 -->
	 <!-- public List<Employee> getEmpsByConditionIf(Employee employee); -->
	 * 
	 * @throws IOException
	 */
	@Test
	public void testgetEmpsByConditionIf() throws IOException {
		// 1、获取sqlSessionFactory对象
				SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
				// 2、获取sqlSession对象
				SqlSession openSession = sqlSessionFactory.openSession();
				try {
					// 3、获取接口的实现类对象
					//会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
					EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);
					
					Employee employee=new Employee(null, "%a%", null, null, null, null);
					List<Employee> emps = mapper.getEmpsByConditionIf(employee);
					for(Employee emp:emps)
					{
						System.out.println(emp);
					}
				
				} finally {
					openSession.close();
				}
	}
	
}
