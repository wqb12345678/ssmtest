package cn.bdqn.sm.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;

import cn.bdqn.sm.pojo.User;
@Resource
public interface UserMapper {
	public User getUserByNameAndPassword(@Param("userName")String userName,
			@Param("userPassword")String userPassword);
	public int userAdd(User user);
	public List<User> getUserList();
	public User yanZhengByUserCode(String userCode);
	public User getUserById(Integer id);
	public int deleteUser(Integer id);
	public int updateUser(User user);
}
