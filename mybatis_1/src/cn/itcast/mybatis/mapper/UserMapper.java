package cn.itcast.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import cn.itcast.mybatis.po.User;
import cn.itcast.mybatis.po.UserCustom;
import cn.itcast.mybatis.po.UserQueryVo;

public interface UserMapper {
	
	
	public List<UserCustom> findUserMap(HashMap<String, String> hashMap) throws Exception;

	public List<UserCustom> findUserList(UserQueryVo userQueryVo)throws Exception;
	
	public User findUserById(int id) throws Exception;
	
	public List<User> findUserByname(String username) throws Exception;
	
	
	public void insertUser(User user) throws Exception;
	
	public void deleteUser(int id) throws Exception;
	
	public void updateUser(User user) throws Exception;

	public int findUserCount() throws Exception;
	
	public User findUserResutMap(int id) throws Exception;
	
	public List<UserCustom> findUserListIf(UserQueryVo userQueryVo) throws Exception;
}
