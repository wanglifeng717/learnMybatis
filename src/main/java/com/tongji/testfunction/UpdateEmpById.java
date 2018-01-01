/**
* Title: UpdateEmpById.java
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

import oracle.sql.OpaqueDescriptor;

/**  
* Title: UpdateEmpById 
* Description:  测试更新一个数据表的方法
* @author mdm(computer in lab)  
* @date 2017年12月29日  
*/
public class UpdateEmpById {

	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource ="mybatis-config.xml";
		InputStream inputStream=Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	/**
	 * 功能：根据ID值更新一条记录。
	 * SqlSessionFactory.openSession();手动提交
	 * SqlSessionFactory.openSession(true);自动提交
	 * @throws IOException
	 */
	@Test
	public void testUpdateEmpById() throws IOException {
		SqlSessionFactory sessionFactory=getSqlSessionFactory();
		//1.获取到的sqlSession不会自动提交数据
		SqlSession openSession = sessionFactory.openSession();
		try {
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			Employee employee = new Employee(3, "4444",new Date(new java.util.Date().getTime()));
			mapper.updateEmp(employee);
			//2.手动提交
			openSession.commit();
		}finally {
			openSession.close();
		}
	}
}
