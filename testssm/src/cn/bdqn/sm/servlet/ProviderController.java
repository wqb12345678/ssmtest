package cn.bdqn.sm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.bdqn.sm.pojo.Provider;
import cn.bdqn.sm.service.provider.ProviderService;

@Controller
@RequestMapping("/provider")
public class ProviderController {
	@Autowired
	private ProviderService providerService;
	@RequestMapping("/showproviders")
	public String showProviders(Model model){
		List<Provider> providers = providerService.showProviders();
		model.addAttribute("providers", providers);
		return "providerlist";
	}
	@RequestMapping("/toprovideradd")
	public String toProviderAdd(Integer id,Model model){
		Provider provider = providerService.showProvider(id);
		model.addAttribute("provider", provider);
		return "provideradd";
	}
	@RequestMapping("/provideradd")
	public String providerAdd(Provider provider){
		int addNum = providerService.providerAdd(provider);
		if(addNum>0){
			return "redirect:/provider/showproviders";
		}else{
			return "provideradd";
		}
	}
	@RequestMapping("/showprovider")
	public String showProvider(Integer id,Model model){
		Provider provider = providerService.showProvider(id);
		model.addAttribute("provider", provider);
		return "providerview";
	}
	@RequestMapping("/delprovider")
	public void delProvider(Integer id, HttpServletResponse response){
		int delNum = providerService.delProvider(id);
		boolean flag = false;
		if (delNum>0) {
			flag = true;
		} else {
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
	@RequestMapping("/toupdate")
	public String toUpdateProvider(Integer id,Model model){
		Provider provider = providerService.showProvider(id);
		model.addAttribute("provider", provider);
		return "providermodify";
	}
	@RequestMapping("/updateProvider")
	public String updateProvider(Provider provider){
		int updateNum = providerService.updateProvider(provider);
		if(updateNum>0){
			return "redirect:/provider/showproviders";
		}else{
			return "providermodify";
		}
	}
}
