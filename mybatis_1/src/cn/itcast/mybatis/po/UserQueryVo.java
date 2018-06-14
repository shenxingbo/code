package cn.itcast.mybatis.po;
/**
 * vo:视图
 * po:持久层
 * pojo:我们自定义的类似于pojo的对象
 */


//下面我们要定义映射文件，综合查询是一种复杂查询
//这种查询一般都需要

public class UserQueryVo {
	private UserCustom userCustom;

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}
	
}
