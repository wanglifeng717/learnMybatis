/**
* Title: AddOneEmp.java
* Description: 
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date 2017年12月29日
* @version 1.0
*/
package com.tongji.testfunction;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.tongji.bean.Employee;
import com.tongji.dao.EmployeeMapper;

/**  
* Title: AddOneEmp 
* Description:  添加一个新员工
* @author mdm(computer in lab)  
* @date 2017年12月29日  
*/
public class AddOneEmp {
	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource ="mybatis-config.xml";
		InputStream inputStream=Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	/**
	 * 功能：我们提交现在提交是手动提交的。
	 * 我们可以使用自动提交的方式。
	 * SqlSessionFactory.openSession();手动提交
	 * SqlSessionFactory.openSession(true);自动提交
	 * 
	 * @throws IOException
	 */
	@Test
	public void testAddOneEmp() throws IOException {
		SqlSessionFactory sessionFactory=getSqlSessionFactory();
		//1.获取到的sqlSession不会自动提交数据
		SqlSession openSession = sessionFactory.openSession();
		try {
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			Employee employee = new Employee(3, "4443",new Date(new java.util.Date().getTime()));
			Integer valuesOfAdd = mapper.addEmp(employee);
			//可以打印出返回值。
			System.out.println(valuesOfAdd);
			//2.手动提交
			openSession.commit();
		}finally {
			openSession.close();
		}
	}
	/**
	 * 功能：测试获取mysql自增的主键的值得测试。
	 * 
	 * @throws IOException
	 */
	@Test
	public void testAddOneEmpForMysql() throws IOException {
		SqlSessionFactory sessionFactory=getSqlSessionFactory();
		//1.获取到的sqlSession不会自动提交数据
		SqlSession openSession = sessionFactory.openSession();
		try {
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			//这里ID的值我们Null 因为返回的值我们要赋进去。
			Employee employee = new Employee(null, "wwwwwzzzz",new Date(new java.util.Date().getTime()));
			mapper.addEmp(employee);
			//可以打印出返回值。
			System.out.println(employee.getId());
			//2.手动提交
			openSession.commit();
		}finally {
			openSession.close();
		}
	}
}
