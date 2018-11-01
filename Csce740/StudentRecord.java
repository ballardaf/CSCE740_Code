package edu.sc.csce740;

import java.util.List;


public class StudentRecord {
	
	//Class Variables
	private Student student;
	private String department; //all upper case and no spaces with under scores
	private Term termBegan;
	
	private Degree degreeSought;
	private Degree certificateSought;
	private List<Degree> previousDegrees;
	
	
	private List<Professor> advisors;
	private List<Professor> committee;
	
	private List<CourseTaken> coursesTaken;
	
	private List<Milestone> milestonesSet;
	
	private List<String> notes;
	
	public StudentRecord()
	{
		/*
		this.student =  new Student();
		this.department = "COMPUTER_SCIENCE";
		this.termBegan = new Term();
		
		this.degreeSought = new Degree();
		this.certificateSought = new Degree();
		this.previousDegrees.add(new Degree());

		this.advisors.add(new Professor());
		this.committee.add(new Professor());
		this.coursesTaken.add(new CourseTaken());
		this.milestonesSet.add(new Milestone());
		this.notes.add("defaultNote");
		*/
	}
	
	public StudentRecord(Student student, String department,
			Degree degreeSought, Degree certificateSought,
			List<Degree> previousDegrees, Term termBegan, Term graduation, Term term,
			List<Professor> advisors, List<Professor> committee, List<CourseTaken> coursesTaken,
			List<Milestone> milestonesSet, List<String> notes) {
		
		this.student = student;
		this.department = department;
		
		this.degreeSought = degreeSought;
		this.certificateSought = certificateSought;
		this.previousDegrees = previousDegrees;

		this.advisors = advisors;
		this.committee = committee;
		this.coursesTaken = coursesTaken;
		this.milestonesSet = milestonesSet;
		this.notes = notes;
	}

	//Getters and Setters
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Degree getDegreeSought() {
		return degreeSought;
	}

	public void setDegreeSought(Degree degreeSought) {
		this.degreeSought = degreeSought;
	}

	public Degree getCertificateSought() {
		return certificateSought;
	}

	public void setCertificateSought(Degree certificateSought) {
		this.certificateSought = certificateSought;
	}

	public List<Degree> getPreviousDegrees() {
		return previousDegrees;
	}

	public void setPreviousDegrees(List<Degree> previousDegrees) {
		this.previousDegrees = previousDegrees;
	}

	public Term getTermBegan() {
		return termBegan;
	}

	public void setTermBegan(Term termBegan) {
		this.termBegan = termBegan;
	}


	public List<Professor> getAdvisors() {
		return advisors;
	}

	public void setAdvisors(List<Professor> advisors) {
		this.advisors = advisors;
	}

	public List<Professor> getCommittee() {
		return committee;
	}

	public void setCommittee(List<Professor> committee) {
		this.committee = committee;
	}

	public List<CourseTaken> getCoursesTaken() {
		return coursesTaken;
	}

	public void setCoursesTaken(List<CourseTaken> coursesTaken) {
		this.coursesTaken = coursesTaken;
	}

	public List<Milestone> getMilestonesSet() {
		return milestonesSet;
	}

	public void setMilestonesSet(List<Milestone> milestonesSet) {
		this.milestonesSet = milestonesSet;
	}

	public List<String> getNotes() {
		return notes;
	}

	public void setNotes(List<String> notes) {
		this.notes = notes;
	}
	

	public void addNote(String note) {
		this.notes.add(note);
	}
	
	
	
	@Override
	public String toString() {
		return "StudentRecord [student=" + student + ", department="
				+ department + ", degreeSought=" + degreeSought
				+ ", certificateSought=" + certificateSought
				+ ", previousDegrees=" + previousDegrees + ", termBegan="
				+ termBegan +", advisors=" + advisors + ", committee=" + committee
				+ ", coursesTaken=" + coursesTaken + ", milestonesSet="
				+ milestonesSet + ", notes=" + notes + "]";
	}
		
}
