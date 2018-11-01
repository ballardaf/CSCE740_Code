package edu.sc.csce740;

public class Student {

	//Class Variables
	private String id;
	private String firstName;
	private String lastName;
	
	//General Constructor
	public Student(String id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Student() {
		this.id = "defaultId";
		this.firstName = "defaultFirstName";
		this.lastName = "defaultLastName";
	}

	//Getters and Setters
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + "]";
	}
	
}
