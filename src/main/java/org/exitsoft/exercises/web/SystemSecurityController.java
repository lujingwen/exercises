package org.exitsoft.exercises.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 系统安全功能模块控制器
 * 
 * @author vincent
 *
 */
@Controller
public class SystemSecurityController {
	
	/**
	 * 登录C,返回登录页面,如果当前用户已经存在，直接重定向到首页C({@link SystemSecurityController#index()})
	 * 
	 * <pre>
	 * uri:
	 * http://domain:port/projectname/login-view == WEB-INF/page/login.html
	 * </pre>
	 * 
	 * @see SystemSecurityController#index()
	 * 
	 * @return String 
	 */
	@RequestMapping("login-view")
	public String loginView() {
		return "login";
	}
	
	/**
	 * 登录C
	 * 
	 * @param username 用户名
	 * @param password 密码
	 * 
	 * @return 成功返回 index.html,否则返回login-view
	 */
	@RequestMapping("login")
	public String login(@RequestParam("username")String username,@RequestParam("password")String password) {
		if (username.equals("admin") && password.equals("admin")) {
			return "index";
		} else {
			return "login";
		}
	}
	
	
}
