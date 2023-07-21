package com.example.demo.model;

public class Employee {
	private Integer employeeid; //private เรียกใช้ได้แค่ภายใน class   
	private String firstName;
	private String lastName;
	private Integer salary;
	
	
	public Employee() {
		super();
	}
	public Employee(Integer employeeid, String firstName, String lastName, Integer salary) {
		super();
		this.employeeid = employeeid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}
	public Integer getEmployeeid() {
		return employeeid;
	}
	public void setEmployee(Integer employeeid) {
		this.employeeid = employeeid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
	

}
