package cn.bdqn.sm.service.provider;

import java.util.List;

import cn.bdqn.sm.pojo.Provider;

public interface ProviderService {
	/**
	 * 显示所有供货商
	 * @return
	 */
	public List<Provider> showProviders();
	/**
	 * 通过id查供货商
	 * @param id
	 * @return
	 */
	public Provider showProvider(Integer id);
	/**
	 * 添加供货商
	 * @param provider
	 * @return
	 */
	public int providerAdd(Provider provider);
	/**
	 * 删除供货商性息
	 * @param id
	 * @return
	 */
	public int delProvider(Integer id);
	/**
	 * 修改供应商性息
	 * @param provider
	 * @return
	 */
	public int updateProvider(Provider provider);
}
