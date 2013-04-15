package org.exitsoft.exercises.entity.account;

/**
 * 用户实体类
 * 
 * @author vincent
 *
 */
public class User {
	
	//登录帐号
	private String username;
	//登录密码
	private String password;
	//真实名称
	private String realname;
	
	/**
	 * 用户实体类
	 */
	public User() {
		
	}

	/**
	 * 获取登录帐号
	 * 
	 * @return String
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 设置登录帐号
	 * 
	 * @param username 登录帐号
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 获取登录密码
	 * 
	 * @return String
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置登录密码
	 * 
	 * @param password 登录密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 获取真实名称
	 * 
	 * @return String
	 */
	public String getRealname() {
		return realname;
	}

	/**
	 * 设置真实名称
	 * 
	 * @param realname 真实名称
	 */
	public void setRealname(String realname) {
		this.realname = realname;
	}
	
	

}
