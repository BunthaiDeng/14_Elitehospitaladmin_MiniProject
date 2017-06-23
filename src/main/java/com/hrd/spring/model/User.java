package com.hrd.spring.model;

public class User{
	private int id;
	private String username;
	private String email;
	private String gender;
	private String phonenumber;
	private String status;
	private String userhash;
	private String createddate;
		
	public User() {
		super();
	}

	public User(int id, String name, String email, String gender, String phone, String status, String userhash,
			String createddate) {
		super();
		this.id = id;
		this.username = name;
		this.email = email;
		this.gender = gender;
		this.phonenumber = phone;
		this.status = status;
		this.userhash = userhash;
		this.createddate = createddate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String name) {
		this.username = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phone) {
		this.phonenumber = phone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserhash() {
		return userhash;
	}

	public void setUserhash(String userhash) {
		this.userhash = userhash;
	}

	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", gender=" + gender
				+ ", phonenumber=" + phonenumber + ", status=" + status + ", userhash=" + userhash + ", createddate="
				+ createddate + "]";
	}	
	
}

//public class User {
//	
//	private String ID;
//	private String Name;
//	private String Sex;
//	private String 	DOB;
//	private String Role;
//	
//	public User() {
//		super();
//	}
//
//	
//
//	public User(String iD, String username, String sex, String dOB, String role) {
//		super();
//		ID = iD;
//		Name = username;
//		Sex = sex;
//		DOB = dOB;
//		Role = role;
//	}
//
//
//
//	public String getRole() {
//		return Role;
//	}
//
//
//
//	public void setRole(String role) {
//		Role = role;
//	}
//
//
//
//	public String getID() {
//		return ID;
//	}
//
//	public void setID(String iD) {
//		ID = iD;
//	}
//
//	public String getName() {
//		return Name;
//	}
//
//	public void setName(String username) {
//		Name = username;
//	}
//
//	public String getSex() {
//		return Sex;
//	}
//
//	public void setSex(String sex) {
//		Sex = sex;
//	}
//
//	public String getDOB() {
//		return DOB;
//	}
//
//	public void setDOB(String dOB) {
//		DOB = dOB;
//	}
//	
//}
