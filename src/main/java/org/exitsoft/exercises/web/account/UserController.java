package org.exitsoft.exercises.web.account;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.exitsoft.exercises.entity.account.User;
import org.exitsoft.exercises.service.account.AccountManager;
import org.exitsoft.orm.core.Page;
import org.exitsoft.orm.core.PageRequest;
import org.exitsoft.orm.core.PageRequest.Sort;
import org.exitsoft.orm.core.PropertyFilter;
import org.exitsoft.orm.core.PropertyFilters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 用户功能模块控制器
 * 
 * @author vincent
 *
 */
@Controller
@RequestMapping("/account/user")
public class UserController {
	
	@Autowired
	private AccountManager accountManager;
	
	/**
	 * 用户管理C,进入用户管理页面
	 * 
	 * <pre>
	 * uri:
	 * http://domain:port/projectname/account/user/view == WEB-INF/page/account/user/view.html
	 * </pre>
	 * 
	 * @return String
	 */
	@RequestMapping("view")
	public Page<User> view(PageRequest pageRequest,HttpServletRequest request) {
		List<PropertyFilter> filters = PropertyFilters.build(request, true);
		
		if (!pageRequest.isOrderBySetted()) {
			pageRequest.setOrderBy("id");
			pageRequest.setOrderDir(Sort.DESC);
		}
		
		return accountManager.searchUser(pageRequest, filters);
	}
	
	/**
	 * 保存用户C，成功时候重定向到用户管理C，方法签名为:{@link UserController#view(PageRequest, HttpServletRequest)}
	 * <pre>
	 * uri:
	 * （没异常时）http://domain:port/projectname/account/user/save == WEB-INF/page/account/user/view.html 
	 * </pre>
	 * 
	 * @param entity 用户实体
	 * 
	 * @return String
	 */
	@RequestMapping("save")
	public String save(@ModelAttribute("entity") User entity) {
		accountManager.saveUser(entity);
		return "redirect:/account/user/view";
	}
	
	/**
	 * 删除用户C，成功时候重定向到用户管理C，方法签名为:{@link #view(PageRequest, HttpServletRequest)}
	 * <pre>
	 * uri:
	 * （没异常时）http://domain:port/projectname/account/user/delete == WEB-INF/page/account/user/view.html 
	 * </pre>
	 * 
	 * @param entity 用户实体
	 * 
	 * @return String
	 */
	@RequestMapping("delete")
	public String delete(@RequestParam("ids")List<String> ids) {
		accountManager.deleteUser(ids);
		return "redirect:/account/user/view";
	}
	
	/**
	 * 读取用户信息C，该方法的返回数据由{@link #bindEntity(String)}进行二次绑定后返回，如果id为空返回new好的一个User
	 * 否则从数据库中获取用户
	 * <pre>
	 * uri:
	 * （没异常时）http://domain:port/projectname/account/user/read == WEB-INF/page/account/user/read.html 
	 * </pre>
	 * 
	 * @param entity 用户实体
	 * 
	 * @return String
	 */
	@RequestMapping("read")
	public void read() {}
	
	/**
	 * Spring 的 ModelAttribute方法，该方法每次都进入到Controller之前都会进入,
	 * 如果当前方法的url里存在参数id，就向数据库获取记录，否则返回一个new的实体
	 * 
	 * @param id 主键id
	 * 
	 * @return {@link User}
	 */
	@ModelAttribute("entity")
	public User bindEntity(@RequestParam(value="id",required=false)String id) {
		User entity = new User();
		if (StringUtils.isNotEmpty(id)) {
			entity = accountManager.getUser(id);
		}
		return entity;
	}
}
