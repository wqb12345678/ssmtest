package cn.bdqn.sm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.bdqn.sm.dao.UserMapper;
import cn.bdqn.sm.pojo.User;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	public User login(String userName, String userPassword) {
		User user = userMapper.getUserByNameAndPassword(userName, userPassword);
		return user;
	}
	public int userAdd(User user) {
		int flagNum = userMapper.userAdd(user);
		return flagNum;
	}
	public List<User> showUserList() {
		List<User> userList = userMapper.getUserList();
		return userList;
	}
	public User yanZhengByUserCode(String userCode) {
		User user = userMapper.yanZhengByUserCode(userCode);
		return user;
	}
	public User showUser(Integer id) {
		User user = userMapper.getUserById(id);
		return user;
	}
	public int deleteUser(Integer id) {
		int deleteUserNum = userMapper.deleteUser(id);
		return deleteUserNum;
	}
	public int updateUser(User user) {
		int updateUserNum = userMapper.updateUser(user);
		return updateUserNum;
	}
}
