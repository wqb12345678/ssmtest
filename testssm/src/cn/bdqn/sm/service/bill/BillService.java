package cn.bdqn.sm.service.bill;

import java.util.List;

import cn.bdqn.sm.pojo.Bill;
import cn.bdqn.sm.pojo.Provider;

public interface BillService {
	/**
	 * 显示订单信息
	 * @return
	 */
	public List<Bill> showBills();
	/**
	 * 显示供应商信息
	 * @return
	 */
	public List<Provider> getProviders();
	/**
	 * 添加订单
	 * @param bill
	 * @return
	 */
	public int billAdd(Bill bill);
	/**
	 * 删除订单
	 * @param id
	 * @return
	 */
	public int delBill(Integer id);
	/**
	 * 查看订单
	 * @param id
	 * @return
	 */
	public Bill showBillandProName(Integer id);
	/**
	 * 显示订单信息
	 * @param id
	 * @return
	 */
	public Bill showBill(Integer id);
	/**
	 * 修改订单信息
	 * @param bill
	 * @return
	 */
	public int updateBill(Bill bill);
}
