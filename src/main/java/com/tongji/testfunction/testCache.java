/**
* Title: testCache.java
* Description: 
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date 2018年1月5日
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
* Title: testCache 
* Description:  测试一二级缓存的类
* @author mdm(computer in lab)  
* @date 2018年1月5日  
*/
public class testCache {
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
	 * 两级缓存：
	 * 一级缓存：（本地缓存）：sqlSession级别的缓存。一级缓存是一直开启的；SqlSession级别的一个Map
	 * 		与数据库同一次会话期间查询到的数据会放在本地缓存中。
	 * 		以后如果需要获取相同的数据，直接从缓存中拿，没必要再去查询数据库；
	 * 
	 * 		一级缓存失效情况（没有使用到当前一级缓存的情况，效果就是，还需要再向数据库发出查询）：
	 * 		1、sqlSession不同。
	 * 		2、sqlSession相同，查询条件不同.(当前一级缓存中还没有这个数据)
	 * 		3、sqlSession相同，两次查询之间执行了增删改操作(这次增删改可能对当前数据有影响)
	 * 		4、sqlSession相同，手动清除了一级缓存（缓存清空）
	 * 
	 * 二级缓存：（全局缓存）：基于namespace级别的缓存：一个namespace对应一个二级缓存：
	 * 		工作机制：
	 * 		1、一个会话，查询一条数据，这个数据就会被放在当前会话的一级缓存中；
	 * 		2、如果会话关闭；一级缓存中的数据会被保存到二级缓存中；新的会话查询信息，就可以参照二级缓存中的内容；
	 * 		3、sqlSession===EmployeeMapper==>Employee
	 * 						DepartmentMapper===>Department
	 * 			不同namespace查出的数据会放在自己对应的缓存中（map）
	 * 			效果：数据会从二级缓存中获取
	 * 				查出的数据都会被默认先放在一级缓存中。
	 * 				只有会话提交或者关闭以后，一级缓存中的数据才会转移到二级缓存中
	 * 		使用：
	 * 			1）、开启全局二级缓存配置：<setting name="cacheEnabled" value="true"/>
	 * 			2）、去mapper.xml中配置使用二级缓存只要文件中有这一行即可：
	 * 				<cache></cache>  啥都不写就是默认配置
	 * 			3）、我们的POJO需要实现序列化接口
					public class Employee implements Serializable {}
					
	 */
	/**
	 * 功能：
	 * 测试一级缓存，如果查询的的条件一样，就不会再次发送sql
	 * @throws IOException 
	 */
	@Test
	public void testFirstCache() throws IOException {
		// 1、获取sqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		// 2、获取sqlSession对象
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			// 3、获取接口的实现类对象
			//会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
			EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);
			
			Employee employee=new Employee(200, "%a%", null, null, 1, null);
			List<Employee> emps = mapper.getEmpsByConditionChoose(employee);
			for(Employee emp:emps)
			{
				System.out.println(emp);
			}
			
			//第二次查询是从一级缓存中拿到的数据，并没有发送新的sql
			List<Employee> emps2=mapper.getEmpsByConditionChoose(employee);			
			for(Employee emp:emps2)
			{
				System.out.println("emps2"+emp);
			}
		
		} finally {
			openSession.close();
		}	
	}
	/**
	 * 功能：
	 * 测试一级缓存失效的情况
	 * @throws IOException
	 */
	@Test
	public void testFirstLevelCache() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		try{
			EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);
			Employee employee=new Employee(200, "%a%", null, null, 1, null);
			List<Employee> emp01 = mapper.getEmpsByConditionChoose(employee);
			System.out.println(emp01);
			
			//xxxxx
			//1、sqlSession不同。
			//SqlSession openSession2 = sqlSessionFactory.openSession();
			//EmployeeMapperDynamicSQL mapper2 = openSession.getMapper(EmployeeMapperDynamicSQL.class);
			//List<Employee> emp02 = mapper2.getEmpsByConditionChoose(employee);
			
			//2、sqlSession相同，查询条件不同
			
			//3、sqlSession相同，两次查询之间执行了增删改操作(这次增删改可能对当前数据有影响)
			//mapper.addEmp(new Employee(null, "testCache", "cache", "1"));
			//System.out.println("数据添加成功");
			
			//4、sqlSession相同，手动清除了一级缓存（缓存清空）
			//openSession.clearCache();
			
			List<Employee> emp02 = mapper.getEmpsByConditionChoose(employee);
			//Employee emp03 = mapper.getEmpById(3);
			System.out.println(emp02);
			//System.out.println(emp03);
			System.out.println(emp01==emp02);
			
			//openSession2.close();
		}finally{
			openSession.close();
		}
	}
	/**
	 * 功能：
	 * 测试二级缓存。
	 * @throws IOException 
	 */
	@Test
	public void testSecondCache() throws IOException {
		// 1、获取sqlSessionFactory对象
				SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
				// 2、获取sqlSession对象
				SqlSession openSession = sqlSessionFactory.openSession();
				SqlSession openSession2 = sqlSessionFactory.openSession();
				try {
					// 3、获取接口的实现类对象
					//会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
					EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);
					EmployeeMapperDynamicSQL mapper2 = openSession2.getMapper(EmployeeMapperDynamicSQL.class);
					
					Employee employee=new Employee(200, "%a%", null, null, 1, null);
					List<Employee> emps = mapper.getEmpsByConditionChoose(employee);
					for(Employee emp:emps)
					{
						System.out.println(emp);
					}
					openSession.close();
					
					//第二次查询是从二级缓存中拿到的数据，并没有发送新的sql
					List<Employee> emps2=mapper2.getEmpsByConditionChoose(employee);			
					for(Employee emp:emps2)
					{
						System.out.println("emps2"+emp);
					}
					openSession2.close();
				
				} finally {
					
				}	
	}
	
}
