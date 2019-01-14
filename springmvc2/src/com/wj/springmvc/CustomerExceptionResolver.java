package com.wj.springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.wj.springmvc.exception.MyException;
/**
 * 全局异常处理器
 * @author 24253
 *
 */
public class CustomerExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object arg2,
			Exception e) {
		ModelAndView mav = new ModelAndView();
		String msg = "系统异常,请联系管理员";
		if(e instanceof MyException) {
			msg = ((MyException)e).getMsg();
		}
		mav.addObject("msg", msg);
		mav.setViewName("msg");
		return mav;
	}

}
