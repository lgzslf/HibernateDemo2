package com.lgz;

import java.util.Date;

public class Person {

	private Integer id;
	private String name;
	private int password;
	private Date birthday;
	
	//通过<property name="count" formula="select count(*) from t_person"></property>获取数据
	private int count;
	
	


	public Person(){}


	public Person(String name, int password, Date birthday) {
		super();
		this.name = name;
		this.password = password;
		this.birthday = birthday;
	}


	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", password=" + password + ", birthday=" + birthday + "]";
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPassword() {
		return password;
	}


	public void setPassword(int password) {
		this.password = password;
	}


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	

	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}
	
}
