package com.ysy.factory;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Demo1Action extends ActionSupport{
	
	public String execute(){
		System.out.println("Demo1Action执行的execute方法");
		return "success";
	}
	
}
