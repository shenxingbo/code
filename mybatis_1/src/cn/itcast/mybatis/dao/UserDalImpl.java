package cn.itcast.mybatis.dao;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.itcast.mybatis.mapper.UserMapper;
import cn.itcast.mybatis.po.User;

public class UserDalImpl implements UserDao {

	private SqlSessionFactory sqlSessionFactory;

	public UserDalImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User finUserById(int id) throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.selectOne("test.findUserById", id);
		sqlSession.close();
		return null;
	}

	@Override
	public void insertUser(User user) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		sqlSession.insert("test.insertUser", user);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public void deleteUser(int id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("test.deleteUser", id);
		sqlSession.close();
	}

}
