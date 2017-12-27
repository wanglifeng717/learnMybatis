/**
* Title: MybatisTest.java
* Description: 根据文档第一次使用mybatis，传入一个条SQL语句，得到一个javaBean对象
* Copyright: Copyright (c) 2017
* Company: TongjiUniversity
* @author mdm(computer in lab)
* @date 2017年12月24日
* @version 1.0
*/
package com.tongji.helloworld;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

/**  
* Title: MybatisTest 
* Description:  根据文档测试使用mybatis，传入一个条SQL语句，得到一个javaBean对象
* @author mdm(computer in lab)  
* @date 2017年12月24日  
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
			Employee employee=openSession.selectOne("com.tongji.helloworld.EmployeeMapper.getEmpById", 178);
			System.out.println(employee);
		}finally {
			openSession.close();
		}
	}
}
