package cn.itcast.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itcast.mybatis.po.UUID;
import cn.itcast.mybatis.po.User;

public class MybatisFirst {
	// 根据id查询用户的信息

	@Test
	public void findUserByIdTest() throws IOException {
		
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sessionFactory.openSession();

		User user = sqlSession.selectOne("test.findUserById", 1);
		System.out.println(user);
		sqlSession.close();
	}

	@Test
	public void findUserByNameTest() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sessionFactory.openSession();

		List<User> list = sqlSession.selectList("test.findUserByname", "小明");
		System.out.println(list);
		sqlSession.close();
	}

	
	@Test
	public void insertUserTest() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sessionFactory.openSession();
		User user = new User();
		
		user.setUsername("王小军");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setAddress("河南郑州");
		sqlSession.insert("test.insertUser", user);
		sqlSession.commit();
		
		System.out.println(user.getId());
		sqlSession.close();
	}
	
	@Test
	public void insertUUIDTest() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sessionFactory.openSession();

		UUID uuid = new UUID();
		uuid.setUsrname("test");;
		
		sqlSession.insert("uuid.insertTestByUUID", uuid);
		sqlSession.commit();
		
		System.out.println(uuid.getId());
		sqlSession.close();
	}

	@Test
	public void deleteUserTest() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sessionFactory.openSession();
	
		sqlSession.delete("test.deleteUser",new Integer(28));
		sqlSession.commit();
		
		sqlSession.close();
	}
	
	
	@Test
	public void updateUserTest() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sessionFactory.openSession();
		User user = new User();
		user.setId(27);
		user.setUsername("王大军");
		user.setBirthday(new Date());
		user.setSex("2");
		user.setAddress("河南郑州");
		sqlSession.update("test.updateUser", user);
		sqlSession.commit();
		
		System.out.println(user.getId());
		sqlSession.close();
	}
	
}
