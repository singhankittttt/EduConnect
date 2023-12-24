package com.proj.domain;

public class Student {

	private String usn, name, dept, email, mob, pwd;
	private int sem;

	public Student(String usn, String name, String dept, String email, String mob, String pwd, int sem) {
		super();
		this.usn = usn;
		this.name = name;
		this.dept = dept;
		this.email = email;
		this.mob = mob;
		this.pwd = pwd;
		this.sem = sem;
	}

	public String getUsn() {
		return usn;
	}

	public String getName() {
		return name;
	}

	public String getDept() {
		return dept;
	}

	public String getEmail() {
		return email;
	}

	public String getMob() {
		return mob;
	}

	public String getPwd() {
		return pwd;
	}

	public int getSem() {
		return sem;
	}
	
	

}
