package cn.itcast.mybatis.po;

import java.util.Date;
import java.util.List;

public class User {
	private int id;
	private String username;// �û�����
	private String sex;// �Ա�
	private Date birthday;// ����
	private String address;// ��ַ
	
	private List<Orders> ordersList;
	
	
	
	
	public List<Orders> getOrdersList() {
		return ordersList;
	}
	public void setOrdersList(List<Orders> ordersList) {
		this.ordersList = ordersList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "id = " +id + "username = " + username;
	}
	
	
}
