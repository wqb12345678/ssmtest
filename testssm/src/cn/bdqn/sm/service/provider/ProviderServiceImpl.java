package cn.bdqn.sm.service.provider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bdqn.sm.dao.provider.ProviderMapper;
import cn.bdqn.sm.pojo.Provider;
@Service
public class ProviderServiceImpl implements ProviderService {
	@Autowired
	private ProviderMapper providerMapper;
	public List<Provider> showProviders() {
		List<Provider> providers = providerMapper.getProviders();
		return providers;
	}
	public int providerAdd(Provider provider) {
		int addNum = providerMapper.providerAdd(provider);
		return addNum;
	}
	public Provider showProvider(Integer id) {
		Provider provider = providerMapper.getProviderById(id);
		return provider;
	}
	public int delProvider(Integer id) {
		int delNum = providerMapper.delProvider(id);
		return delNum;
	}
	public int updateProvider(Provider provider) {
		int updateNum = providerMapper.updateProvider(provider);
		return updateNum;
	}

}
