package com.cg.jdbcdemo.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.cg.jdbcdemo.dto.Employee;

public class EmployeeDAO {
	ArrayList<Employee> elist = null;

	public EmployeeDAO() {
		elist = new ArrayList<>();
		elist.add(new Employee(101, "Ajay", 1000, LocalDate.of(11, 10, 11)));//yy-mm-dd or yyyy-mm-dd
		elist.add(new Employee(102, "Vijay", 2000, LocalDate.of(03, 11, 11)));
		elist.add(new Employee(103, "Sujay", 3000, LocalDate.of(06, 06, 05)));
		elist.add(new Employee(104, "John", 1400, LocalDate.of(99, 10, 23)));
	}

	public List<Employee> getAllEmployees() {
		return elist;
	}

	public Employee getEmployee(int empid) {
		for (Employee e : elist) 
			if (e.getEmpid() == empid)
				return e;
			throw new RuntimeException("Employee Not Found Exception");
	}

	public boolean deleteEmployee(int empid) {
		for (Employee e : elist) 
			if (e.getEmpid() == empid) {
				elist.remove(e);
				return true;
			}
			return false;
		}
	public boolean insertEmployee(Employee emp) {
		return elist.add(emp);
	}
	
	public boolean modifyEmployee(Employee emp) {
		for(Employee e: elist)
			if(e.getEmpid()==emp.getEmpid()) {
				e.setEname(e.getEname());
				e.setSalary(emp.getSalary());
				return true;
			}
		throw new RuntimeException("Employee Not Found Exception");
	}

}
