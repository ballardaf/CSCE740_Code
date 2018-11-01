package edu.sc.csce740;

public class Milestone {
	
	//Class Variables
	private String milestone;
	private Term term;
	
	//General Constructor
	public Milestone(String milestone, Term term) {
		super();
		this.milestone = milestone;
		this.term = term;
	}
	
	public Milestone() 
	{
		this.milestone = "defaultMilestone";
		this.term = new Term();
	}

	//Getters and Setters
	public String getMilestone() {
		return milestone;
	}
	public void setMilestone(String milestone) {
		this.milestone = milestone;
	}
	public Term getTerm() {
		return term;
	}
	public void setTerm(Term term) {
		this.term = term;
	}
	
	//General ToString Method
	@Override
	public String toString() {
		return "Milestone [milestone=" + milestone + ", term=" + term + "]";
	}	
	
}
