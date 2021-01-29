package cn.bdqn.sm.dao.bill;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;

import cn.bdqn.sm.pojo.Bill;
import cn.bdqn.sm.pojo.Provider;

@Resource
public interface BillMapper {
	public List<Bill> getBills();
	public int billAdd(Bill bill);
	public List<Provider> getProviders();
	public int delBill(Integer id);
	public Bill getBillandProName(@Param("id")Integer id);
	public Bill getBill(@Param("id")Integer id);
	public int updateBill(Bill bill);
}
