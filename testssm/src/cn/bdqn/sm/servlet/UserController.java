package cn.bdqn.sm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.bdqn.sm.pojo.Role;
import cn.bdqn.sm.pojo.User;
import cn.bdqn.sm.service.UserService;
import cn.bdqn.sm.service.role.RoleService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;

	@RequestMapping(value = "/login")
	public ModelAndView login(@RequestParam("userCode") String userName,
			String userPassword) throws Exception {
		User user = userService.login(userName, userPassword);
		if (user != null) {
			List<Role> roleList = roleService.getRoleList();
			List<User> userList = userService.showUserList();
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("roleList", roleList);
			modelAndView.addObject("userList", userList);
			modelAndView.setViewName("userlist");
			return modelAndView;
		} else {
			throw new RuntimeException("运行时异常！");
		}
	}

	@RequestMapping("/showUsers")
	public String showUsers(Model model) {
		List<User> userList = userService.showUserList();
		model.addAttribute("userList", userList);
		return "userlist";
	}

	@RequestMapping("/showUser")
	public String showUser(Integer id, Model model) {
		User user = userService.showUser(id);
		model.addAttribute("user", user);
		return "userview";
	}

	@RequestMapping("/toadd")
	public String toUserAdd(@ModelAttribute("user") User user, Model model) {
		List<Role> roleList = roleService.getRoleList();
		model.addAttribute("roleList", roleList);
		return "useraddbyspring";
	}

/*	@RequestMapping("/add")
	public String userAdd(User user, HttpSession session) {
		int addFlag = userService.userAdd(user);
		ModelAndView modelAndView = new ModelAndView();
		if (addFlag > 0) {
			return "redirect:/user/showUsers";
		} else {
			return "useradd";
		}
	}*/
	@RequestMapping("/add")
	public String userAdd(@Valid User user,BindingResult bindingResult, HttpSession session) {
		if(bindingResult.hasErrors()){
			return "useraddbyspring";
		}
		int addFlag = userService.userAdd(user);
		ModelAndView modelAndView = new ModelAndView();
		if (addFlag > 0) {
			return "redirect:/user/showUsers";
		} else {
			return "useraddbyspring";
		}
	}
	// 验证用户是否存在
	@ResponseBody
	@RequestMapping("/yanzheng")
	public void yanZheng(String userCode, HttpServletResponse response) {
		User user = userService.yanZhengByUserCode(userCode);
		boolean flag = false;
		if (user != null) {
			flag = true;
		} else {
			flag = false;
		}
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.print(flag);
	}

	@RequestMapping("/tochangepwd")
	public String toChangePwd() {
		return "pwdmodify";
	}

	@RequestMapping("/")
	public String toLogin() {
		return "login";
	}

	@ResponseBody
	@RequestMapping("/deluser")
	public void delUser(Integer id, HttpServletResponse response) {
		int delNum = userService.deleteUser(id);
		boolean flag = false;
		if (delNum > 0) {
			flag = true;
		} else {
			flag = false;
		}
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.print(flag);
	}

	@RequestMapping("/toupdate")
	public String toUpdate(@ModelAttribute("user") User user, Model model) {
		User user2 = userService.showUser(user.getId());
		List<Role> roleList = roleService.getRoleList();
		model.addAttribute("user", user2);
		model.addAttribute("roleList", roleList);
		return "usermodify";
	}

	@RequestMapping("/updateuser")
	public String updateUser(User user) {
		int flag = userService.updateUser(user);
		if (flag > 0) {
			return "redirect:/user/showUsers";
		} else {
			return "usermodify";
		}
	}
	/*
	 * @ExceptionHandler(value={RuntimeException.class}) public String
	 * exceptionHandler(RuntimeException e, HttpServletRequest request){
	 * request.setAttribute("e", e.getMessage()); return "error"; }
	 */
}
