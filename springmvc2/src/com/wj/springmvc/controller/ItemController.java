package com.wj.springmvc.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.wj.springmvc.exception.MyException;
import com.wj.springmvc.pojo.Item;
import com.wj.springmvc.pojo.QueryVo;
import com.wj.springmvc.service.IItemService;

@Controller
public class ItemController {
	
	
	@Autowired
	private IItemService itemService;

	@RequestMapping("itemList")
	public ModelAndView itemList() {
		ModelAndView mav = new ModelAndView();
		
//		List<Item> list = Arrays.asList(new Item(1,"����",1999,new Date(),"�ܺ���"),new Item(2,"����",1999,new Date(),"�ܺ���"),new Item(3,"�ֻ�",1999,new Date(),"�ܺ���"));
//		mav.addObject("itemList",list);
		/*mav.setViewName("jsp/itemList.jsp");*/
		
		List<Item> itemList = itemService.getItemList();
		mav.addObject("itemList",itemList);
		mav.setViewName("itemList");
		return mav;
	}
	
	
	@RequestMapping("itemEdit")
	public String itemEdit(Model model,HttpServletRequest request,@RequestParam(value="id",required=true,defaultValue="1") Integer ids) {
		String idStr = request.getParameter("id");
		Item item = null;
		if(null != idStr)
		item = itemService.getItemById(ids);
		model.addAttribute("item", item);
		return "itemEdit";
	}
	
	
	@RequestMapping("updateItem")
	public String updateItem(Item item,Model model,MultipartFile pictureFile) throws IllegalStateException, IOException {
		//ͼƬ�ϴ�
		String picName = UUID.randomUUID().toString();
		//��ȡ�ļ���
		String originFilename = pictureFile.getOriginalFilename();
		String extName = originFilename.substring(originFilename.lastIndexOf("."));
		//��ʼ�ϴ�
		pictureFile.transferTo(new File("D:/develop/bw/tomcat/image/" + picName + extName));
		item.setPic(picName + extName);
		itemService.updateItem(item);
		model.addAttribute("item", item);
		model.addAttribute("msg", "�޸���Ʒ�ɹ�");
//		return "itemEdit";
		
//		return "forward:itemList.action";
		return "redirect:itemList.action";
	}
	
	@RequestMapping("queryItem")
	public String queryItem(QueryVo vo,Integer[] ids) {
		
		for(Integer id : ids)
		System.out.println(id);
		
		if(null != vo.getItems() && vo.getItems().size() > 0) {
			for(Item item : vo.getItems()) {
				System.out.println(item);
			}
		}
		
		if(vo.getItem() != null) {
			System.out.println(vo);
		}
		
		return null;
	}
	
	@RequestMapping("queryVoid")
	public void queryVoid(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, MyException {
		//request��Ӧ
//		request.setAttribute("msg", "��ӭ");
//		request.getRequestDispatcher("jsp/msg.jsp").forward(request, response);
		//response��Ӧ
//		response.sendRedirect(request.getContextPath() + "/itemList.action");
		response.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
		
		if(true) {
			throw new MyException("����");
		}
		
		int i = 1 / 0;
		
		response.setHeader("content-type", "text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.println("hello���");
	}
	
	
}
