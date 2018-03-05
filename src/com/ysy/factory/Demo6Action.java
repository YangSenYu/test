package com.ysy.factory;

public class Demo6Action {
	public String method1(){
		System.out.println("执行的method1方法");
		return "success";
	}
	public String method2(){
		System.out.println("执行的method2方法");
		return "error";
	}
	public String method3(){
		System.out.println("执行的method3方法");
		return "test";
	}
	public String method4(){
		System.out.println("执行的method4方法");
		return "test";
	}
	public String method5(){
		System.out.println("执行的method5方法");
		return "redirect";
	}
	public String method6(){
		System.out.println("执行的method6方法");
		return "chainAction";
	}
	public String method7(){
		System.out.println("执行的method7方法");
		return "redirectAction";
	}
}
