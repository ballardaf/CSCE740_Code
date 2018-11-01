package edu.sc.csce740;

import java.util.List;

public class Details {
	
	//Class Variables
	private String gpa;
	private List<CourseTaken> courseTaken;
	private List<Milestone> milestones;
	private List<String> notes;
	
	//General Constructor
	public Details(String gpa, List<CourseTaken> courseTaken, List<Milestone> milestones, List<String> notes) {
		super();
		this.gpa = gpa;
		this.courseTaken = courseTaken;
		this.milestones = milestones;
		this.notes = notes;
	}
	public Details(){
		
	}

	//Getters and Setters
	public String getGpa() {
		return gpa;
	}

	public void setGpa(String gpa) {
		this.gpa = gpa;
	}

	public List<CourseTaken> getCourseTaken() {
		return courseTaken;
	}

	public void setCourseTaken(List<CourseTaken> CourseTaken) {
		this.courseTaken = CourseTaken;
	}

	public List<Milestone> getMilestones() {
		return milestones;
	}

	public void setMilestones(List<Milestone> milestones) {
		this.milestones = milestones;
	}

	public List<String> getNotes() {
		return notes;
	}

	public void setNotes(List<String> notes) {
		this.notes = notes;
	}

	//General ToString Method
	@Override
	public String toString() {
		return "Details [gpa=" + gpa + ", CourseTaken=" + courseTaken + ", milestones=" + milestones + ", notes=" + notes + "]";
	}
	
	
	
	
	
	

}
