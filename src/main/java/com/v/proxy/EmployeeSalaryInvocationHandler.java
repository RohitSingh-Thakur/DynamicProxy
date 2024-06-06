package com.v.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.v.Employee;

public class EmployeeSalaryInvocationHandler implements InvocationHandler {

	private Employee employeeTarget;

	public EmployeeSalaryInvocationHandler(Employee employeeTarget) {
		super();
		this.employeeTarget = employeeTarget;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		if (method.getName().equals("giveHike")) {

			// pre processing stuff
			Double amount = (Double) args[0];

			if (amount < 0.0) {
				throw new RuntimeException("Invalid amount entred..");
			}

		}

		// calling actual call to getHike()
		Object result = method.invoke(employeeTarget, args);

		// post processing stuff
		System.out.println("Executing method : " + method.getName() + " for employeId : " + employeeTarget.getId());

		return result;
	}

}
