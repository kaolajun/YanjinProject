package com.yanjin.demo2;

import java.util.ArrayList;
import java.util.List;

class Department {
	private int number;
	private String name;
	private String position;
	private List<Employee> emps;
	
	public List<Employee> getEmps() {
		return emps;
	}
	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	public Department() {
		this.emps = new ArrayList<Employee>();
	}
	public Department(int number, String name, String position) {
		this();
		this.number = number;
		this.name = name;
		this.position = position;
	}
	@Override
	public String toString() {
		return "部门编号为： " + this.number + " 部门名称为： " + this.name 
				+ " 部门在： " + this.position;
	}
}
