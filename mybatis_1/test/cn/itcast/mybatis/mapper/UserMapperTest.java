package cn.itcast.mybatis.mapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.po.User;
import cn.itcast.mybatis.po.UserCustom;
import cn.itcast.mybatis.po.UserQueryVo;

public class UserMapperTest {
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws IOException {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
	}

	@Test
	public void testFindUserById() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserById(1);
		System.out.println(user);
		sqlSession.close();
	}
	
	
	@Test
	public void testFindUserByName() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> user = userMapper.findUserByname("С��");
		System.out.println(user);
		sqlSession.close();
	}
	
	@Test
	public void testFindUserList() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setSex("1");
		userCustom.setUsername("a");
		userQueryVo.setUserCustom(userCustom);
		List<UserCustom> list = userMapper.findUserList(userQueryVo);
		System.out.println(list); 
	}
	
	@Test
	public void testFindUserMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("sex", "1");
		map.put("username", "a");
		List<UserCustom> list = userMapper.findUserMap(map);
		System.out.println(list);
	} 
	
	
	@Test
	public void testFindUserCount() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		int count = userMapper.findUserCount();
		System.out.println(count);
	}
	
	@Test
	public void testFindUserResutMap() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User userCustom = userMapper.findUserResutMap(1);
		System.out.println(userCustom);
	}
	
	@Test
	public void testFindUserListIf() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		UserQueryVo user = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		List<UserCustom> list = userMapper.findUserListIf(null);
		System.out.println(list);
		
	}
	
	
}
