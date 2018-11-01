package edu.sc.csce740;

public class CourseSR {

	//Class Variables
	private String name;
	private String id;
	private String numCredits;
	private Term term;
	private String grade;
	
	//General Constructor
	public CourseSR(String name, String id, String numCredits, Term term,
			String grade) {
		super();
		this.name = name;
		this.id = id;
		this.numCredits = numCredits;
		this.term = term;
		this.grade = grade;
	}
	
	//Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNumCredits() {
		return numCredits;
	}
	public void setNumCredits(String numCredits) {
		this.numCredits = numCredits;
	}
	public Term getTerm() {
		return term;
	}
	public void setTerm(Term term) {
		this.term = term;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	//General ToString Method
	@Override
	public String toString() {
		return "CourseSR [name=" + name + ", id=" + id + ", numCredits="
				+ numCredits + ", term=" + term + ", grade=" + grade + "]";
	}
		
}
