package edu.sc.csce740;

public class Degree {

	//Class Variables
	private String name;
	private Term graduation;
	
	//General Constructor
	public Degree(String name, Term graduation) 
	{
		this.name = name;
		this.graduation = graduation;
	}
	
	public Degree() {
		this.name = "defaulDegreeName";
		this.graduation = new Term();
	}

	//Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Term getGraduation() {
		return graduation;
	}
	public void setGraduation(Term graduation) {
		this.graduation = graduation;
	}

	//General ToString Method
	@Override
	public String toString() {
		return "Degree [name=" + name + ", graduation=" + graduation + "]";
	}
		
}
