package com.yanjin.demo2;

class Employee {
	private int number;
	private Department department;
	private String name;
	private String position;
	private Employee leader;
	private double salary;
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
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

	public Employee getLeader() {
		return leader;
	}

	public void setLeader(Employee leader) {
		this.leader = leader;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Employee() {};
	
	public Employee(int number,Department department,String name,String position,Employee leader,double salary) {
		this.number = number;
		this.department = department;
		this.name = name;
		this.position = position;
		this.leader = leader;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "���Ϊ: " + this.number + "�������� " + this.name + "��ְλ�� " + this.position 
				+ "���쵼�� " + (this.leader != null?this.leader.getName():"��") 
				+ "�����ʣ� " + this.salary + "�����ű�ţ� " + this.department.getNumber();
	}
	
	
	
	
	
}
