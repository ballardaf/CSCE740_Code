package edu.sc.csce740;



public class Term {

	//Class Variables
	private String semester;
	private Integer year;
	
	//General Constructor
	public Term(String semester, Integer year) {
		super();
		this.semester = semester;
		this.year = year;
	}
	
	public Term() {
		this.semester = "FALL";
		this.year = 2000;
	}

	//Getters and Setters
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	
	//General ToString Method
	@Override
	public String toString() {
		return "Term [semester=" + semester + ", year=" + year + "]";
	}
	
	
	
}
