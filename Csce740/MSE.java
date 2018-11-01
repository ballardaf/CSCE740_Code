package edu.sc.csce740;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class MSE {

	//Class Variables
	private List<RequirementCheckResults> mSE = new ArrayList<RequirementCheckResults>();

	//General Constructor
	public MSE(List<RequirementCheckResults> mSE) {
		super();
		this.mSE = mSE;
	}
	public MSE(){
		
	}
	
	//Getters and Setters
	public List<RequirementCheckResults> getmSE() {
		return mSE;
	}

	public void setmSE(List<RequirementCheckResults> mSE) {
		this.mSE = mSE;
	}

	public void create_MSE(StudentRecord studRec){
		core_courses_mse(studRec.getCoursesTaken());
		additional_credits_mse(studRec.getCoursesTaken());
		experience(studRec.getCoursesTaken());
		time_limit_mse(studRec.getTermBegan().getYear());
		gpa(studRec.getCoursesTaken());
		milestones_mse(studRec.getMilestonesSet());
	}

	public void core_courses_mse(List<CourseTaken> courses){
		//Function Variables
		List<CourseTaken> core_course_list = new ArrayList<CourseTaken>();
		List<String> core_course_notes = new ArrayList<String>();
		int year = Calendar.getInstance().get(Calendar.YEAR);
		boolean passed = false;
		int passedVal = 0;
		boolean [] coursePassed = new boolean[5];
		Arrays.fill(coursePassed, Boolean.FALSE);

		String [] courseNames = new String[5];
		courseNames[0] = "csce740";
		courseNames[1] = "csce741";
		courseNames[2] = "csce742";
		courseNames[3] = "csce743";
		courseNames[4] = "csce743";
		
		//Uses Course Taken Object to compute CORE_COURSES_MENG rule
		for(int index=0; index<courses.size(); index++){
			for(int i=0; i<courseNames.length; i++){
				if(courses.get(index) != null && courses.get(index).getCourse().getId().equals(courseNames[i])){
					if(courses.get(index).getGrade() == 'A' || courses.get(index).getGrade() == 'B'){
						if(year - courses.get(index).getTerm().getYear() < 6){
						core_course_list.add(courses.get(index));
						passedVal++;
						coursePassed[i] = true;
						}
					}
				}
				
			}
		}
		
		for(int i=0; i<courseNames.length; i++){
			if(!coursePassed[i]){
				core_course_notes.add("You have not passed " + courseNames[i]);
			}
		}
		
		if(passedVal == 5){
			passed = true;
		}
		
		
		Details core_details = new Details(null, core_course_list, null, core_course_notes);
		RequirementCheckResults core_courses = new RequirementCheckResults("CORE_COURSES_MSE", passed, core_details);
		this.mSE.add(core_courses);
	}
	
	public void additional_credits_mse(List<CourseTaken> courses){
		//Function Variables
		List<CourseTaken> core_course_list = new ArrayList<CourseTaken>();
		List<String> core_course_notes = new ArrayList<String>();
		int year = Calendar.getInstance().get(Calendar.YEAR);
		boolean passed = false;
		int passedVal = 0;
		boolean [] coursePassed = new boolean[19];
		Arrays.fill(coursePassed, Boolean.FALSE);
		
		String [] courseNames = new String[19];
		courseNames[0] = "csce510";
		courseNames[1] = "csce512";
		courseNames[2] = "csce515";
		courseNames[3] = "csce516";
		courseNames[4] = "csce520";
		courseNames[5] = "csce522";
		courseNames[6] = "csce547";
		courseNames[7] = "csce721";
		courseNames[8] = "csce723";
		courseNames[9] = "csce725";
		courseNames[10] = "csce744";
		courseNames[11] = "csce745";
		courseNames[12] = "csce767";
		courseNames[13] = "csce782";
		courseNames[14] = "csce821";
		courseNames[15] = "csce822";
		courseNames[16] = "csce826";
		courseNames[17] = "csce846";
		courseNames[18] = "csce872";
		
		//Uses Course Taken Object to compute CORE_COURSES_MENG rule
		for(int index=0; index<courses.size(); index++){
			for(int i=0; i<courseNames.length; i++){
				if(courses.get(index) != null && courses.get(index).getCourse().getId().equals(courseNames[i])){
					if(courses.get(index).getGrade() == 'A' || courses.get(index).getGrade() == 'B'){
						if(year - courses.get(index).getTerm().getYear() < 6){
						core_course_list.add(courses.get(index));
						coursePassed[i] = true;
						String credStr = courses.get(index).getCourse().getNumCredits();
			   			int credVal = Integer.valueOf(credStr);
			   			passedVal = passedVal + credVal;
						}
					}
				}
				
			}
		}
		
		if(passedVal >= 15){
			passed = true;
		}
		
		if(!passed){
			int missing =  15 - passedVal;
			core_course_notes.add("You need " + missing + " more hours of graduate courses.");
		}
		
		Details core_details = new Details(null, core_course_list, null, core_course_notes);
		RequirementCheckResults core_courses = new RequirementCheckResults("ADDITIONAL_CREDITS_MSE", passed, core_details);
		this.mSE.add(core_courses);
	}
	
	public void experience(List<CourseTaken> courses){
		//Function Variables
		List<CourseTaken> core_course_list = new ArrayList<CourseTaken>();
		List<String> core_course_notes = new ArrayList<String>();
		int year = Calendar.getInstance().get(Calendar.YEAR);
		boolean passed = false;
		
		//Uses Course Taken Object to compute CORE_COURSES_MENG rule
		for(int index=0; index<courses.size(); index++){
			if(courses.get(index) != null && courses.get(index).getCourse().getId().equals("csce793")){
				if(courses.get(index).getGrade() == 'A' || courses.get(index).getGrade() == 'B' || courses.get(index).getGrade() == 'P'){
					if(year - courses.get(index).getTerm().getYear() < 6){
						core_course_list.add(courses.get(index));
						passed = true;	
					}
				}
			}
		}
		
		if(!passed){
			core_course_notes.add("You have not passed CSCE793.");
		}
		
		Details core_details = new Details(null, core_course_list, null, core_course_notes);
		RequirementCheckResults core_courses = new RequirementCheckResults("EXPERIENCE", passed, core_details);
		this.mSE.add(core_courses);
	}
	
	public void time_limit_mse(int year){
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		boolean passed = false;
		List<String> core_course_notes = new ArrayList<String>();
		
		if(currentYear - year < 7){
			passed = true;
		}
		
		if(!passed){
			core_course_notes.add("It has been six years since you have been admitted.");
		}
		
		Details core_details = new Details(null, null, null, core_course_notes);
		RequirementCheckResults core_courses = new RequirementCheckResults("TIME_LIMIT_MSE", passed, core_details);
		this.mSE.add(core_courses);
	}
	
	public void gpa(List<CourseTaken> courses){
		int year = Calendar.getInstance().get(Calendar.YEAR);
		List<Integer> grades = new ArrayList<Integer>();
		int hoursTotal = 0;
		int classGrade = 0;
		double totalGPA = 0;
		String totalGPAString = "";
		boolean passed = false;
		List<String> core_course_notes = new ArrayList<String>();
		
		for(int index=0; index<courses.size(); index++){
			if(courses.get(index) != null && year - courses.get(index).getTerm().getYear() < 6){
				if(courses.get(index).getGrade() != 'P'){
					if(courses.get(index).getGrade() != '_'){
						classGrade = gpa(courses.get(index).getGrade(),courses.get(index).getCourse().getNumCredits());
						grades.add(classGrade);
						int hoursVal = Integer.valueOf(courses.get(index).getCourse().getNumCredits());
						hoursTotal = hoursTotal + hoursVal;
					}
				}
			}
		}
		
		for(int i=0; i<grades.size(); i++){
			totalGPA = totalGPA + grades.get(i);
		}
		
		totalGPA = totalGPA / (double) hoursTotal;
		BigDecimal bd = new BigDecimal(totalGPA);
		bd = bd.round(new MathContext(3));
		double rounded = bd.doubleValue();
		totalGPAString = Double.toString(rounded);
		
		if(rounded >= 3.00){
			passed = true;
		}
		
		if(!passed){
			core_course_notes.add("Your GPA must be 3.00 or higher.");
		}
		
		Details core_details = new Details(totalGPAString, null, null, core_course_notes);
		RequirementCheckResults core_courses = new RequirementCheckResults("GPA", passed, core_details);
		this.mSE.add(core_courses);
	}
	
	public int gpa(char iGrade, String iHours){
		int gpa = 0;
		int hours = Integer.valueOf(iHours);
		
		char[] grade = new char[5];
		grade[0] = 'F';
		grade[1] = 'D';
		grade[2] = 'C';
		grade[3] = 'B';
		grade[4] = 'A';
				
		for(int i=4; i>0; i--){
			if(iGrade == grade[i]){
				gpa = i*hours;
			}
		}
		
		
		return gpa;
	}
	
	public void milestones_mse(List<Milestone> milestones){
		List<Milestone> core_miles_list = new ArrayList<Milestone>();
		List<String> core_miles_notes = new ArrayList<String>();
		int passedVal = 0;
		boolean passed = false;
		boolean [] milesPassed = new boolean[5];
		Arrays.fill(milesPassed, Boolean.FALSE);
		
		String [] milesNames = new String[5];
		milesNames[0] = "ACADEMIC_ADVISOR_APPOINTED";
		milesNames[1] = "PROGRAM_OF_STUDY_SUBMITTED";
		milesNames[2] = "COMPREHENSIVE_EXAM_PASSED";
		milesNames[3] = "REPORT_SUBMITTED";
		milesNames[4] = "REPORT_APPROVED";
		
		for(int index=0; index<milestones.size(); index++){
			for(int i=0; i<milesNames.length; i++){
				if(milestones.get(index) != null && milestones.get(index).getMilestone().equals(milesNames[i])){
					core_miles_list.add(milestones.get(index));
					passedVal++;
					milesPassed[i] = true;
				}
			}
		}
		
		for(int i=0; i<milesNames.length; i++){
			if(!milesPassed[i]){
				core_miles_notes.add("Missing milestone " + milesNames[i]);
			}
		}
		
		if(passedVal == 5){
			passed = true;
		}
		
		Details core_details = new Details(null, null, core_miles_list, core_miles_notes);
		RequirementCheckResults core_courses = new RequirementCheckResults("MILESTONES_MSE", passed, core_details);
		this.mSE.add(core_courses);
	}
	
}


