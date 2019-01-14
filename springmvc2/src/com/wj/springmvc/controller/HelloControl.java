package com.wj.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloControl {

	@RequestMapping("hello")
	public ModelAndView hello() {
		System.out.println("hello springmvc..");
		ModelAndView mav = new ModelAndView();
		//����ģ�����ݣ����ڴ��ݵ�jsp
		mav.addObject("msg","hello springmvc.....");
		//������ͼ���ƣ�������Ӧ
		mav.setViewName("jsp/hello.jsp");
		return mav;
	}
}
