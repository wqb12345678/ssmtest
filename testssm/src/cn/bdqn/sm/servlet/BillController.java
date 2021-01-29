package cn.bdqn.sm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.bdqn.sm.pojo.Bill;
import cn.bdqn.sm.pojo.Provider;
import cn.bdqn.sm.service.bill.BillService;

@Controller
@RequestMapping("/bill")
public class BillController {
	@Autowired
	private BillService billService;
	@RequestMapping("/showBills")
	public String showBills(Model model){
		List<Bill> bills = billService.showBills();
		model.addAttribute("bills", bills);
		return "billlist";
	}
	@RequestMapping("/tobilladd")
	public String toBillAdd(@ModelAttribute("bill")Bill bill,Model model){
		List<Provider> providers = billService.getProviders();
		model.addAttribute("providers", providers);
		return "billadd";
	}
	@RequestMapping("/billadd")
	public String billAdd(Bill bill,HttpSession session){
		int flag = billService.billAdd(bill);
		if(flag>0){
			return "redirect:/bill/showBills";
		}else{
			return "billadd";
		}		
	}
	@RequestMapping("/delbill")
	public void delBill(Integer id, HttpServletResponse response){
		int delNum = billService.delBill(id);
		boolean flag = false;
		if(delNum>0){
			flag = true;
		}else{
			flag = false; 
		}
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.print(flag);
	}
	@RequestMapping("/showbill")
	public String showBill(Integer id,Model model){
		Bill bill = billService.showBillandProName(id);
		model.addAttribute("bill", bill);
		return "billview";
	}
	@RequestMapping("/tobillmodify")
	public String toBillModify(Integer id,Model model){
		Bill bill = billService.showBill(id);
		List<Provider> providers = billService.getProviders();
		model.addAttribute("bill", bill);
		model.addAttribute("providers", providers);
		return "billmodify";
	}
	@RequestMapping("/updatebill")
	public String billModify(Bill bill){
		int updateBillNum = billService.updateBill(bill);
		if(updateBillNum>0){
			return "redirect:/bill/showBills";
		}else{
			return "billmodify";
		}
	}
}
