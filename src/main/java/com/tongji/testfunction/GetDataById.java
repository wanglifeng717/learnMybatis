/**
* Title: MybatisTest.java
* Description: 根据文档第一次使用mybatis，传入一个条SQL语句，得到一个javaBean对象
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date 2017年12月24日
* @version 1.0
*/
package com.tongji.testfunction;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.tongji.bean.Employee;
import com.tongji.dao.EmployeeMapper;
import com.tongji.dao.EmployeeMapperAnnotation;

/**  
* Title: MybatisTest 
* Description:  根据文档测试使用mybatis，传入一个条SQL语句，得到一个javaBean对象
* @author mdm(computer in lab)  
* @date 2017年12月24日  
* 
* /**
 * 1、接口式编程
 * 	以前JDBC原生方式：		Dao接口	====>  DaoImpl
 * 	mybatis：	       Mapper接口   ====>  xxMapper.xml  这个配置文件就相当于对这个接口的实现
 * 
 * 2、SqlSession代表和数据库的一次会话；用完必须关闭；
 * 3、SqlSession和connection一样她都是非线程安全。每次使用都应该去获取新的对象。
 * 4、mapper接口没有实现类，但是mybatis会为这个接口生成一个代理对象。
 * 		（将接口和xml进行绑定）
 * 		EmployeeMapper empMapper =	sqlSession.getMapper(EmployeeMapper.class);
 * 5、两个重要的配置文件：
 * 		mybatis的全局配置文件：包含数据库连接池信息，事务管理器信息等...系统运行环境信息
 * 		sql映射文件：保存了每一个sq
*/
public class GetDataById {
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
	 * 功能：获取数据库的一条记录，转化为javaBean
	 * 1.根据XML配置文件（全局配置文件）创建一个SqlSessionFactory对象，有数据源一些运行环境信息
	 * 2.SQL映射文件：配置每个SQL，以及SQL的封装规则等
	 * 3.将SQL映射文件注册到全局配置文件中
	 * 4.写代码：
	 * 	1）.根据全局配置文件得到SqlSessionFactory
	 *  2).使用SqlSession工厂，获取到SqlSession对象，使用他来完成增删改查
	 *  	一个sqlSession就是代表和数据库的一次会话，用完关闭
	 *  3）.使用SQL的唯一标志来告诉mybatis执行哪个sql,SQL保存在映射文件中。
	 * @throws IOException 
	 *
	 */
	@Test
	public void selectOneTest() throws IOException {
		/**
		 * 2.获取sqlSession实例，能直接执行已经映射的SQL语句
		 */
		SqlSessionFactory sessionFactory=getSqlSessionFactory();
		SqlSession openSession=sessionFactory.openSession();
		try {
			//select的唯一ID推荐使用namespace+id的全名防止重复
			Employee employee=openSession.selectOne("com.tongji.dao.EmployeeMapper.getEmpById", 178);
			System.out.println(employee);
		}finally {
			openSession.close();
		}
	}
	/**
	 * 功能：通过接口的方式来调用增删改查
	 * 
	 * @throws IOException
	 */
	@Test
	public void selectByInterface() throws IOException {
		// 1、获取sqlSessionFactory对象
				SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
				// 2、获取sqlSession对象
				SqlSession openSession = sqlSessionFactory.openSession();
				try {
					// 3、获取接口的实现类对象
					//会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
					EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
					Employee employee = mapper.getEmpById(178);
					System.out.println(mapper.getClass());
					System.out.println(employee);
				} finally {
					openSession.close();
				}
	}
	/**
	 * 功能：基于注解的方式。我们定义一个接口，然后在接口的方法上写注解，然后把这个接口注册到全局的配置文件中
	 * 
	 * @throws IOException
	 */
	@Test
	public void selectByAnnotation() throws IOException {
		SqlSessionFactory sessionFactory = getSqlSessionFactory();
		SqlSession session= sessionFactory.openSession();
		try {
			EmployeeMapperAnnotation  mapperAnnotation = session.getMapper(EmployeeMapperAnnotation.class);
			Employee employee = mapperAnnotation.getEmpById(178);
			System.out.println(employee);
		} finally {
			session.close();
		}
	}
}
