/**
 * 
 */
package com.aoeai.sample.controller;

import com.aoeai.sample.bean.User;
import com.aoeai.sample.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 用户
 */
@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username,
						@RequestParam("password") String password,
						ModelMap modelMap) {

		if (StringUtils.isEmpty(username)) {
			modelMap.put("error", 1);
			return "login";
		}

		modelMap.put("username", username);

		if (StringUtils.isEmpty(password)) {
			modelMap.put("error", 2);
			return "login";
		}

		return "redirect:/list.do";

	}

	/**
	 * 获取用户信息
	 * @param id 用户id
	 * @return json格式的用户信息
	 */
	@RequestMapping(value = "/getUser.do", method = RequestMethod.GET)
	@ResponseBody
	public User getUser(Integer id) {
		return userService.getUser(id);
	}

	/**
	 * 用户列表
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/list.do")
	public String list(ModelMap modelMap) {

		Map<String, Object> data = userService.getUserList(null);
		modelMap.put("dl", data);

		return "list";
	}

	@RequestMapping(value = "/update.do", method = RequestMethod.GET)
	@ResponseBody
	public String update(Integer id) {
		User user = userService.getUser(id);
		user.setName("更新+" + user.getName());
		if(user == null){
			return "用户不存在，userId=" + id;
		}
		userService.updateUser(user);

		return "用户更新成功，userId=" + id;
	}

	/**
	 * （物理）删除用户
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public String delete(Integer id) {
		userService.deleteUser(id);

		return "redirect:/list.do";
	}

}
