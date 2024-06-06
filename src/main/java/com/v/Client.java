package com.v;

import java.lang.reflect.Proxy;

import com.v.proxy.EmployeeSalaryInvocationHandler;

public class Client {

	public static void main(String[] args) {

		ITEmployee employee = new ITEmployee();
		employee.setId(101);
		employee.setName("Rohit");
		employee.setSalary(90000); 
		
		EmployeeSalaryInvocationHandler handler = new EmployeeSalaryInvocationHandler(employee);

		// creating proxy object
		// 1st argument is class loader use implementation class of interface
		// 2nd argument is interface name, what base interface we have 
		// 3rd parameter is handler object 
		
		Employee employeeProxy = (Employee) Proxy.newProxyInstance(ITEmployee.class.getClassLoader(), new Class[] {Employee.class}, handler);
		employeeProxy.giveHike(2000);
		System.out.println(employeeProxy.getSalary()); 
	}
}
