package com.v;

public interface Employee {
	public abstract void giveHike(double amount);
	public abstract void payCut(double amount);
	
	public int getId();

	public void setId(int id);

	public String getName();

	public void setName(String name);

	public double getSalary();

	public void setSalary(double salary);
}
