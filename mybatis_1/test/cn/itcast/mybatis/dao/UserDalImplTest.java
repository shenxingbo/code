package cn.itcast.mybatis.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.mapper.UserMapper;
import cn.itcast.mybatis.po.User;

public class UserDalImplTest {

	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void setUp() throws IOException {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
	}
	
	@Test
	public void testFinUserById() throws Exception {
		UserDao userDao = new UserDalImpl(sqlSessionFactory);
		User user = userDao.finUserById(1);
		System.out.println(user);
	}

}
