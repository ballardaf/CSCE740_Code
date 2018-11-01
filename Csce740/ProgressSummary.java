package edu.sc.csce740;

import java.util.List;

public class ProgressSummary {

	//Class Variables
	private Student student;
	private String department;
	private Term termBegan;
	private Degree degreeSought;
	private Degree certificateSought;
	private List<Professor> advisors;
	private List<Professor> committee;
	private List<RequirementCheckResults> requirementCheckResults;
	
	public ProgressSummary(){
		
	}
	
	//General Constructor
	public ProgressSummary(Student student, String department, Term termBegan, Degree degreeSought,
			Degree certificateSought, List<Professor> advisors, List<Professor> committee,
			List<RequirementCheckResults> requirementCheckResults) {
		super();
		this.student = student;
		this.department = department;
		this.termBegan = termBegan;
		this.degreeSought = degreeSought;
		this.certificateSought = certificateSought;
		this.advisors = advisors;
		this.committee = committee;
		this.requirementCheckResults = requirementCheckResults;
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
	public Term getTermBegan() {
		return termBegan;
	}
	public void setTermBegan(Term termBegan) {
		this.termBegan = termBegan;
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
	public List<RequirementCheckResults> getRequirementCheckResults() {
		return requirementCheckResults;
	}
	public void setRequirementCheckResults(List<RequirementCheckResults> requirementCheckResults) {
		this.requirementCheckResults = requirementCheckResults;
	}
	public void setRequirementCheckResults(StudentRecord activeStud){
		
		if(activeStud.getDegreeSought().getName().equals("PHD")){
			System.out.println(activeStud.getStudent().getId() + " is a PHD student!");
			PHD activeDeg = new PHD();
			activeDeg.create_PHD(activeStud);
			this.requirementCheckResults = activeDeg.getpHD();
		}
		if(activeStud.getDegreeSought().getName().equals("MSE")){
			System.out.println(activeStud.getStudent().getId() + " is a MSE student!");
			MSE activeDeg = new MSE();
			activeDeg.create_MSE(activeStud);
			this.requirementCheckResults = activeDeg.getmSE();
		}
		if(activeStud.getDegreeSought().getName().equals("MENG")){
			System.out.println(activeStud.getStudent().getId() + " is a MENG student!");
			MENG activeDeg = new MENG();
			activeDeg.create_MENG(activeStud);
			this.requirementCheckResults = activeDeg.getmENG();
		}
		if(activeStud.getDegreeSought().getName().equals("MS")){
			System.out.println(activeStud.getStudent().getId() + " is a MS student!");
			MS activeDeg = new MS();
			activeDeg.create_MS(activeStud);
			this.requirementCheckResults = activeDeg.getmS();
			
		}
		if(activeStud.getDegreeSought().getName().equals("INFORMATION_ASSURANCE")){
			System.out.println(activeStud.getStudent().getId() + " is a CGSIAS student!");
			CGSIAS activeDeg = new CGSIAS();
			activeDeg.create_CGSIAS(activeStud);
			this.requirementCheckResults = activeDeg.getcGSIAS();
		}
		
		
	}
	

	//General ToString Method
	@Override
	public String toString() {
		return "ProgressSummary [student=" + student + ", department=" + department + ", termBegan=" + termBegan
				+ ", degreeSought=" + degreeSought + ", certificateSought=" + certificateSought + ", advisors="
				+ advisors + ", committee=" + committee + ", requirementCheckResults=" + requirementCheckResults + "]";
	}

}
