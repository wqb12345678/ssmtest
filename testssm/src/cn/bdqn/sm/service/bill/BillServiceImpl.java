package cn.bdqn.sm.service.bill;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bdqn.sm.dao.bill.BillMapper;
import cn.bdqn.sm.pojo.Bill;
import cn.bdqn.sm.pojo.Provider;
@Service
public class BillServiceImpl implements BillService {
	@Autowired
	private BillMapper billMapper;
	public List<Bill> showBills() {
		List<Bill> bills = billMapper.getBills();
		return bills;
	}
	public int billAdd(Bill bill) {
		int flag = billMapper.billAdd(bill);		
		return flag;
	}
	public List<Provider> getProviders() {
		List<Provider> providers = billMapper.getProviders();
		return providers;
	}
	public int delBill(Integer id) {
		int delBillNum = billMapper.delBill(id);
		return delBillNum;
	}
	public Bill showBillandProName(Integer id) {
		Bill bill = billMapper.getBillandProName(id);
		return bill;
	}
	public Bill showBill(Integer id) {
		Bill bill = billMapper.getBill(id);
		return bill;
	}
	public int updateBill(Bill bill) {
		int updateBill = billMapper.updateBill(bill);
		return updateBill;
	}

}
