package com.sylm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sylm.entity.User;
import com.sylm.mapper.UserMapper;

@RestController
public class UserController {

	@Autowired
	UserMapper userMapper;

	/**
	 * 跳转到用户列表页面
	 *
	 * @param model 用户设值返回页面
	 * @return
	 */

//	@GetMapping("users")
//	public String getAllUsers(Model model) {
//		List<User> userList = userMapper.getALLUsers();
//		model.addAttribute("userList", userList);
//
//		/**
//		 * 往前端 Thymeleaf 模板引擎时，开头不要加 "/" ，因为它默认配置的前缀就是：
//		 * spring.thymeleaf.prefix=classpath:/templates/
//		 */
//		System.out.println("findAllUsers");
//		return "userList";
//	}

	@GetMapping("getUsers")
	public ModelAndView getAllUsers(Model model) {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("userList", userMapper.getALLUsers());
		mv.setViewName("/userList");
		return mv;
	}
	
	@GetMapping("getUsersRest")
	@ResponseBody
	public List<User> getAllUsersRest(Model model) {
		return userMapper.getALLUsers();
	}

	/**
	 * 用户添加前页面跳转---用户点击"添加"按钮
	 *
	 * @param model
	 * @return
	 */
	@GetMapping("userCRUD")
	public String toAddUser(Model model) {
		List<User> departmnetList = userMapper.getALLUsers();
		model.addAttribute("userList", departmnetList);
		return "addUser";

	}

	/**
	 * 用户添加-----用户添加提交时进入
	 * <p/>
	 * SpringMVC 自动将请求参数和入参对象的属性进行一一映射绑定 要求是请求参数的名字和 User 的属性名一样
	 *
	 * @param user
	 * @return
	 */

	@PostMapping("userCRUD")
	public String addUser(User user) {
		System.out.println("=====" + user.getId());
		System.out.println("=====" + user.getUsername());
		System.out.println("=====" + user.getPassword());
		System.out.println("=====" + user.getDepartmentId());
		// user.setUsername("aa");
		userMapper.insertUser(user);
		return "redirect:/users";
	}

	/**
	 * 用户修改前页面跳转-----用户点击"修改"按钮时，进入此处进行跳转到编辑页面 因为修改与添加页面一致，所以复制一份新的，当然可以采用同一个页面。
	 *
	 * @param userId ：待修改的用户id
	 * @param model
	 * @return
	 */
	@GetMapping(value = "userCRUD/{userId}")
	public String EditUser(@PathVariable(value = "userId") Integer userId, Model model) {
		User user = userMapper.getUserById(userId);
		model.addAttribute("user", user);
		return "editUser";
	}

	/**
	 * 用户修改-----用户修改提交时进入
	 * <p/>
	 * SpringMVC 自动将请求参数和入参对象的属性进行一一映射绑定 要求是请求参数的名字和 User 的属性名一样
	 *
	 * @param user
	 * @return
	 */

	@PutMapping(value = "userCRUD")
	public String updateUser(User user) {
		userMapper.updateUser(user);
		System.out.println(user);
		return "redirect:/users";
	}

	/**
	 * 员工删除
	 *
	 */
	@DeleteMapping("userCRUD/{userId}")
	public String deleteEmployee(@PathVariable("userId") Integer id) {

		// System.out.println("userId");
		userMapper.deleteById(id);
		// System.out.println(id);
		return "redirect:/users";
	}
}