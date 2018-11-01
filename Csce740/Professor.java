package edu.sc.csce740;

public class Professor {

	//Class Variables
	private String department;
	private String firstName;
	private String lastName;
	
	//General Constructor
	public Professor(String department, String firstName, String lastName) {
		super();
		this.department = department;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Professor() {
		this.department = "COMPUTER_SCIENCE";
		this.firstName = "defaultFirstName";
		this.lastName = "defaultLastName";
	}

	//Getters and Setters
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
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
	
	//General ToString Method
	@Override
	public String toString() {
		return "Professor [department=" + department + ", firstName="
				+ firstName + ", lastName=" + lastName + "]";
	}
		
}
