package cn.bdqn.sm.dao.provider;

import java.util.List;

import javax.annotation.Resource;

import cn.bdqn.sm.pojo.Provider;

@Resource
public interface ProviderMapper {
	public List<Provider> getProviders();
	public Provider getProviderById(Integer id);
	public int providerAdd(Provider provider);
	public int delProvider(Integer id);
	public int updateProvider(Provider provider);
}
