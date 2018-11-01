package edu.sc.csce740;

public class CourseTaken {

	private Course course;
	private Term term;
	private char grade;
	
	public CourseTaken() 
	{
		this.course = new Course();
		this.term = new Term();
		this.grade = '_';
	}
	
	public CourseTaken(Course course, Term term, char grade)
	{
		this.course = course;
		this.term = term;
		this.grade = grade;
	}
	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Term getTerm() {
		return term;
	}

	public void setTerm(Term term) {
		this.term = term;
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "CourseTaken [course=" + course + ", term=" + term + ", grade=" + grade + "]";
	}
	
}
