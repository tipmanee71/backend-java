package com.example.demo.model;

public class Employee {
	private Integer employee;
	private String firstName;
	private String lastName;
	private Integer sarary;
	
	
	public Employee() {
		super();
	}
	public Employee(Integer employee, String firstName, String lastName, Integer sarary) {
		super();
		this.employee = employee;
		this.firstName = firstName;
		this.lastName = lastName;
		this.sarary = sarary;
	}
	public Integer getEmployee() {
		return employee;
	}
	public void setEmployee(Integer employee) {
		this.employee = employee;
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
	public Integer getSarary() {
		return sarary;
	}
	public void setSarary(Integer sarary) {
		this.sarary = sarary;
	}
	

}
