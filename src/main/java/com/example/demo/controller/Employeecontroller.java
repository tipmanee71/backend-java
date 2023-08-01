package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.model.Product;
import com.example.demo.repository.EmployeeRepository;

@RestController
public class Employeecontroller {

	@Autowired
	EmployeeRepository employeeRepository;

//	private List<Employee> data = new ArrayList<Employee>();

	@GetMapping("employee")
	public List<Employee> getEmployee() {
		return employeeRepository.findAll();
	}

	@PostMapping("/employee") // ยิง method //ถ้ามี post จะมี body
	public Employee addEmployee(@RequestBody Employee body) {
//		for (int i = 0; i < data.size(); i++) {
//			if (body.getEmployeeid() == data.get(i).getEmployeeid()) { /// หาเพื่อมีหรือไม่แต่ไม่ได้นำไปใช่ต่อ
//				return null;
//			}
//		}
		// data.add(body);

		return employeeRepository.save(body);
	}

	// สามารถส่งไอดีอะไรก็ได้ที่เป็น integer ถ้าส่งชนิดอื่นจะerror

	@GetMapping("/employee/{employeeid}")
	public Optional<Employee> getEmployeeDetail(@PathVariable Integer employeeid) {
//		System.out.println("empolyeeid =" + employeeid);
//
//		for (int i = 0; i < data.size(); i++) {
//			if (employeeid == data.get(i).getEmployeeid()) { // หาว่ามีและนำไปใช้ต่อ
//				return data.get(i);
//			}
//		}

		Optional<Employee> employee = employeeRepository.findById(employeeid);

		return employee;
	}

	@PutMapping("employee/{employeeid}")
	public Employee updateEmployee(@PathVariable Integer employeeid, @RequestBody Employee body) {

//		for (int i = 0; i < data.size(); i++) {
//			if (employeeid == data.get(i).getEmployeeid()) {
//
//				data.get(i).setFirstName(body.getFirstName());
//				data.get(i).setLastName(body.getLastName());
//				data.get(i).setSalary(body.getSalary());
//
//				return data.get(i);
//			}
//		}

		Optional<Employee> employee = employeeRepository.findById(employeeid);

		if (employee.isPresent()) {
			// or Employee employeeEdit =	employee.get();
			employee.get().setFirstName(body.getFirstName());   // or //employeeEdit.setFirstName(body.getFirstName()); 
			employee.get().setLastName(body.getLastName());		// or //employeeEdit.setLastName(body.getLastName());	
			employee.get().setSalary(body.getSalary());			// or //employeeEdit.setSalary(body.getSalary());	
			employee.get().setEmployeeid(body.getEmployeeid());	// or //employeeEdit.setEmployeeid(body.getEmployeeid());

			employeeRepository.save(employee.get()); //or //	employeeRepository.save(employeeEdit);
			return employee.get();

		} else {
			return null;
		}

	}

	@DeleteMapping("employee/{employeeid}")
	public String deleteString(@PathVariable Integer employeeid, @RequestBody Employee body) {

//		for (int i = 0; i < data.size(); i++) {
//			if (employeeid == data.get(i).getEmployeeid()) {
//				data.remove(i);
//				return "delete sucsess;";
//
//			}
//		}
//
//		return "employee not found";
	
			Optional<Employee> employee = employeeRepository.findById(employeeid);		
		
			if ( employee.isPresent()) {
				employeeRepository.delete(employee.get());
				
				return "delete sucsess;";
				
			}else {
				return "employee not found";
			}
		
		}


}