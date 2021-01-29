package cn.bdqn.sm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.bdqn.sm.pojo.User;

public interface UserService {
	/**
	 * 用户登录
	 * @param userName
	 * @param userPassword
	 * @return
	 */
	public User login(@Param("userName") String userName,
			@Param("password") String userPassword);

	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public int userAdd(User user);

	/**
	 * 显示所有用户
	 * @return
	 */
	public List<User> showUserList();
	/**
	 * 验证用户是否存在
	 * @param userCode
	 * @return
	 */
	public User yanZhengByUserCode(String userCode);
	/**
	 * 查看用户
	 * @param id
	 * @return
	 */
	public User showUser(Integer id);
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	public int deleteUser(Integer id);
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	public int updateUser(User user);
}
