package com.ysy.factory;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Demo1Action extends ActionSupport{
	
	public String execute(){
		System.out.println("Demo1Actionִ�е�execute����");
		return "success";
	}
	
}
