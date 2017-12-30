/**
* Title: DeleteEmpById.java
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
* Title: DeleteEmpById 
* Description:  
* @author mdm(computer in lab)  
* @date 2017年12月29日  
*/
public class DeleteEmpById {

	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource ="mybatis-config.xml";
		InputStream inputStream=Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	@Test
	public void testDeleteEmpById() throws IOException {
		SqlSessionFactory sessionFactory=getSqlSessionFactory();
		//1.获取到的sqlSession不会自动提交数据
		SqlSession openSession = sessionFactory.openSession();
		try {
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			Employee employee = new Employee(3, "4443",new Date(new java.util.Date().getTime()));
			mapper.deleteEmpById(employee.getId());
			//2.手动提交
			openSession.commit();
		}finally {
			openSession.close();
		}
	}
}
