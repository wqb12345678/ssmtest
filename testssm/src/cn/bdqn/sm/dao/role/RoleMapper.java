package cn.bdqn.sm.dao.role;

import java.util.List;

import javax.annotation.Resource;

import cn.bdqn.sm.pojo.Role;

@Resource
public interface RoleMapper {
	public List<Role> getRoleList();
}
