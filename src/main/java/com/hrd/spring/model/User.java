package com.hrd.spring.model;

public class User {
	
	private String ID;
	private String Name;
	private String Sex;
	private String 	DOB;
	private String Role;
	
	public User() {
		super();
	}

	

	public User(String iD, String name, String sex, String dOB, String role) {
		super();
		ID = iD;
		Name = name;
		Sex = sex;
		DOB = dOB;
		Role = role;
	}



	public String getRole() {
		return Role;
	}



	public void setRole(String role) {
		Role = role;
	}



	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSex() {
		return Sex;
	}

	public void setSex(String sex) {
		Sex = sex;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}
	
}
