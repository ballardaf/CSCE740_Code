package edu.sc.csce740;

public class RequirementCheckResults {
	
	//Class Variables
	private String name;
	private Boolean passed;
	private Details details;
	
	//General Constructor
	public RequirementCheckResults(String name, Boolean passed, Details details) {
		super();
		this.name = name;
		this.passed = passed;
		this.details = details;
	}

	//Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getPassed() {
		return passed;
	}
	public void setPassed(Boolean passed) {
		this.passed = passed;
	}
	public Details getDetails() {
		return details;
	}
	public void setDetails(Details details) {
		this.details = details;
	}

	//General ToString Method
	@Override
	public String toString() {
		return "RequirementCheckResults [name=" + name + ", passed=" + passed + ", details=" + details + "]";
	}	
	
}
