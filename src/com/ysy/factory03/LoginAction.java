package com.ysy.factory03;

public class LoginAction {
	private String name;
	private String pwd;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@SuppressWarnings("unused")
	private String login(){
		System.out.println("”√ªß√˚£∫"+name);
		System.out.println("√‹¬Î£∫"+pwd);
		return "success";
	}
	
}
