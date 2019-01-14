package com.wj.springmvc.exception;

public class MyException extends Exception{

	private String msg;
	
	public MyException() {
		// TODO Auto-generated constructor stub
	}
	

	public MyException(String msg) {
		this.msg = msg;
	}



	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
