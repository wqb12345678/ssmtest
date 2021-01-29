package cn.bdqn.sm.service.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bdqn.sm.dao.role.RoleMapper;
import cn.bdqn.sm.pojo.Role;
@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleMapper roleMapper;
	public List<Role> getRoleList() {
		List<Role> roleList = roleMapper.getRoleList();
		return roleList;
	}

}
