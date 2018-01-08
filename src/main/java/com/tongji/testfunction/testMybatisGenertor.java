/**
* Title: testMybatisGenertor.java
* Description: 
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date Jan 8, 2018
* @version 1.0
*/
package com.tongji.testfunction;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import com.tongji.bean.Employee;
import com.tongji.bean.EmployeeExample;
import com.tongji.bean.EmployeeExample.Criteria;
import com.tongji.dao.EmployeeMapper;

/**  
* Title: testMybatisGenertor 
* Description:  测试逆向工程生成的方法是否好用
* @author mdm(computer in lab)  
* @date Jan 8, 2018  
*/
public class testMybatisGenertor {
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
 * 功能：
 * 用java的方式逆向生成对应的Bean对象和Mapper文件，只要运行这个函数即可自动生成对应的文件。
 * @throws IOException
 * @throws XMLParserException
 * @throws InvalidConfigurationException
 * @throws SQLException
 * @throws InterruptedException
 */
	@Test
	public void testStartGenertorWithJava() throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
		 List<String> warnings = new ArrayList<String>();
		   boolean overwrite = true;
		   File configFile = new File("MBG.xml");
		   ConfigurationParser cp = new ConfigurationParser(warnings);
		   Configuration config = cp.parseConfiguration(configFile);
		   DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		   MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		   myBatisGenerator.generate(null);
	}
	@Test
	public void testExample() throws IOException {
		SqlSessionFactory sessionFactory = getSqlSessionFactory();
		SqlSession  openSession = sessionFactory.openSession();
		try {
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			//example封装查询条件
			//1.查询所有
			List<Employee> selectByExample = mapper.selectByExample(null);
			for(Employee emp:selectByExample) {
				//System.out.println(emp.getLastName());
			}
			//2.查询员工名字中有e字母的，和员工性别为1的
			EmployeeExample example = new EmployeeExample();
			
			Criteria createCriteria = example.createCriteria();
			createCriteria.andLastNameLike("%e%");
			createCriteria.andGenderEqualTo("1");
			//新加一个条件 select * from employees where (last_name like ? and gender =?) or email like "%e%"
			Criteria createCriteria2 = example.createCriteria();
			createCriteria2.andEmailLike("%e%");
			//把两个条件封装在一起。
			example.or(createCriteria2);
			
			List<Employee> emps = mapper.selectByExample(example);
			for(Employee emp:emps) {
				System.out.println(emp.getLastName()+":"+emp.getGender());
			}
		}finally {
			openSession.close();
		}
	}

	/**功能：
	 * 
	 * @param example
	 */
	private void selectByExample(EmployeeExample example) {
		// TODO Auto-generated method stub
		
	}
}
