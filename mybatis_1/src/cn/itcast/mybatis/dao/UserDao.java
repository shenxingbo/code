package cn.itcast.mybatis.dao;

import cn.itcast.mybatis.po.User;

public interface UserDao {
	
	//����id��ѯ�û���Ϣ
	public User finUserById(int id) throws Exception;

	//����û���Ϣ
	public void insertUser(User user) throws Exception;
	
	// ɾ���û���Ϣ
	public void deleteUser(int id) throws Exception;

	
	
	
}
