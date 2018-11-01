package edu.sc.csce740;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class PHD {

	//Class Variables
	private List<RequirementCheckResults> pHD = new ArrayList<RequirementCheckResults>();

	//General Constructors
	public PHD(List<RequirementCheckResults> pHD, List<CourseTaken> coursePHD) {
		super();
		this.pHD = pHD;
	}
	public PHD(){
		
	}
	
	//Getters and Setters
	public List<RequirementCheckResults> getpHD() {
		return pHD;
	}
	public void setpHD(List<RequirementCheckResults> pHD) {
		this.pHD = pHD;
	}
	
	public void create_PHD(StudentRecord studRec){
		core_courses_phd(studRec.getCoursesTaken());
		additonal_credits_phd(studRec.getCoursesTaken());
		degree_based_credits(studRec);
		thesis_credits_phd(studRec.getCoursesTaken());
		time_limit_phd(studRec.getTermBegan().getYear());
		gpa(studRec.getCoursesTaken());
		milestones_phd(studRec.getMilestonesSet());
	}
	

	public void core_courses_phd(List<CourseTaken> courses){
		//Function Variables
		List<CourseTaken> core_course_list = new ArrayList<CourseTaken>();
		List<String> core_course_notes = new ArrayList<String>();
		int year = Calendar.getInstance().get(Calendar.YEAR);
		boolean passed = false;
		int passedVal = 0;
		boolean [] coursePassed = new boolean[5];
		Arrays.fill(coursePassed, Boolean.FALSE);

		String [] courseNames = new String[5];
		courseNames[0] = "csce513";
		courseNames[1] = "csce531";
		courseNames[2] = "csce551";
		courseNames[3] = "csce750";
		courseNames[4] = "csce791";
		
		//Uses Course Taken Object to compute CORE_COURSES_PHD rule
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
		RequirementCheckResults core_courses = new RequirementCheckResults("CORE_COURSES_PHD", passed, core_details);
		this.pHD.add(core_courses);
	}
	
	public void additonal_credits_phd(List<CourseTaken> courses){
		List<CourseTaken> core_course_list = new ArrayList<CourseTaken>();
		List<String> core_course_notes = new ArrayList<String>();
		int passedVal = 0;
		boolean passed = false;
		int year = Calendar.getInstance().get(Calendar.YEAR);
		
		
		for(int index=0; index<courses.size(); index++){
			if(courses.get(index) != null && courses.get(index).getCourse().getId().contains("csce")){
				if(courses.get(index).getCourse().getId().equals("csce513") ||
				   courses.get(index).getCourse().getId().equals("csce531") ||
				   courses.get(index).getCourse().getId().equals("csce551") ||
				   courses.get(index).getCourse().getId().equals("csce750") ||
				   courses.get(index).getCourse().getId().equals("csce791") ||
				   courses.get(index).getCourse().getId().equals("csce799") ||
				   courses.get(index).getCourse().getId().equals("csce899") ){
				} else {
				   if(courses.get(index).getGrade() == 'A' || courses.get(index).getGrade() == 'B'){
					   if(year - courses.get(index).getTerm().getYear() < 6){
						   if (Integer.parseInt(courses.get(index).getCourse().getId().substring(courses.get(index).getCourse().getId().length() -3)) >= 700){ 
							    core_course_list.add(courses.get(index));	
						    	String credStr = courses.get(index).getCourse().getNumCredits();
					   			int credVal = Integer.valueOf(credStr);
					   			passedVal = passedVal + credVal;
						   }
					   }
				   }
				}
			}
		}
		
		if(passedVal >= 20){
			passed = true;
		}
		
		if(passedVal < 20){
			String failed = "You must pass 20 hours of CSCE couses numbered above 700 courses that are not courses.";
			core_course_notes.add(failed);			
		}
		
		Details core_details = new Details(null, core_course_list, null, core_course_notes);
		RequirementCheckResults core_courses = new RequirementCheckResults("ADDITIONAL_CREDITS_PHD", passed, core_details);
		this.pHD.add(core_courses);
		
	}
	
	public void degree_based_credits(StudentRecord studRec){
		List<CourseTaken> core_course_list = new ArrayList<CourseTaken>();
		List<String> core_course_notes = new ArrayList<String>();
		boolean passed = false;
		int year = Calendar.getInstance().get(Calendar.YEAR);
		boolean bachelor = false;
		boolean masters = false;
		int totalHoursCSCE = 0;
		int totalHoursnonCSCE = 0;
		
		
			
		for(int index=0; index<studRec.getPreviousDegrees().size(); index++){
			if(studRec.getPreviousDegrees().get(index).getName().equals("BS")){
				bachelor = true;
			} else{
				masters = true;
			}
		}
		
		for(int index=0; index<studRec.getCoursesTaken().size(); index++){
			if(studRec.getCoursesTaken().get(index) != null && year - studRec.getCoursesTaken().get(index).getTerm().getYear() < 6){
				if(studRec.getCoursesTaken().get(index).getGrade() == 'A' || 
				   studRec.getCoursesTaken().get(index).getGrade() == 'B' ){
					if(!studRec.getCoursesTaken().get(index).getCourse().getName().equals("csce799") || 
					   !studRec.getCoursesTaken().get(index).getCourse().getName().equals("csce899") ){
							if (studRec.getCoursesTaken().get(index).getCourse().getId().contains("csce") &&
								Integer.parseInt(studRec.getCoursesTaken().get(index).getCourse().getId().substring(studRec.getCoursesTaken().get(index).getCourse().getId().length() -3)) >= 500){
									String hours = studRec.getCoursesTaken().get(index).getCourse().getNumCredits();
									totalHoursCSCE = totalHoursCSCE + Integer.valueOf(hours);
									core_course_list.add(studRec.getCoursesTaken().get(index));
							}
							if (!studRec.getCoursesTaken().get(index).getCourse().getId().contains("csce") &&
								Integer.parseInt(studRec.getCoursesTaken().get(index).getCourse().getId().substring(studRec.getCoursesTaken().get(index).getCourse().getId().length() -3)) >= 500){
									String hours = studRec.getCoursesTaken().get(index).getCourse().getNumCredits();
									totalHoursnonCSCE = totalHoursnonCSCE + Integer.valueOf(hours);
									core_course_list.add(studRec.getCoursesTaken().get(index));
							}
					}
				}
				
			}
		}
		
		if(bachelor){
			if(totalHoursCSCE >= 24){
				passed = true;
			} else {
				int remain = 24 - totalHoursCSCE;
				String failed = "You must pass " + remain + " more hours of CSCE courses numbered above 700.";
				core_course_notes.add(failed);
			}
		}
		
		if(bachelor){
			if(totalHoursnonCSCE > 24){
				totalHoursnonCSCE = 24;
			}
			if(totalHoursCSCE + totalHoursnonCSCE >= 48){
				passed = true;
			} else {
				int remain = 48 - (totalHoursCSCE + totalHoursnonCSCE);
				String failed = "You must pass " + remain + " more hours of graduate courses";
				core_course_notes.add(failed);
			}
		}
		
		if(masters){
			if(totalHoursCSCE >= 24){
				passed = true;
			} else {
				int remain = 24 - totalHoursCSCE;
				String failed = "You must pass " + remain + " more hours of CSCE courses numbered above 700.";
				core_course_notes.add(failed);
			}
		}
		
		
		Details core_details = new Details(null, core_course_list, null, core_course_notes);
		RequirementCheckResults core_courses = new RequirementCheckResults("DEGREE_BASED_CREDITS", passed, core_details);
		this.pHD.add(core_courses);
	}
	
	public void thesis_credits_phd(List<CourseTaken> courses){
		List<CourseTaken> core_course_list = new ArrayList<CourseTaken>();
		List<String> core_course_notes = new ArrayList<String>();
		int passedVal = 0;
		boolean passed = false;
		int year = Calendar.getInstance().get(Calendar.YEAR);
		
		for(int index=0; index<courses.size(); index++){
			if(courses.get(index) != null && courses.get(index).getCourse().getId().contains("csce899")){
				if(courses.get(index).getGrade() == 'P'){
					if(year - courses.get(index).getTerm().getYear() < 6)
						core_course_list.add(courses.get(index));
						passedVal++;
				}
			}
		}
		
		if(passedVal == 2){
			passed = true;
		}
		if(passedVal == 1){
			String failed = "You must pass 6 more hours of CSCE899";
			core_course_notes.add(failed);
		}
		if(passedVal == 0){
			String failed = "You must pass 12 more hours of CSCE899";
			core_course_notes.add(failed);
		}
		
		Details core_details = new Details(null, core_course_list, null, core_course_notes);
		RequirementCheckResults core_courses = new RequirementCheckResults("THESIS_CREDITS_PHD", passed, core_details);
		this.pHD.add(core_courses);
	}
	
	public void time_limit_phd(int year){
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		boolean passed = false;
		List<String> core_course_notes = new ArrayList<String>();
		
		if(currentYear - year < 9){
			passed = true;
		}
		
		if(!passed){
			core_course_notes.add("It has been six years since you have been admitted.");
		}
		
		Details core_details = new Details(null, null, null, core_course_notes);
		RequirementCheckResults core_courses = new RequirementCheckResults("TIME_LIMIT_PHD", passed, core_details);
		this.pHD.add(core_courses);
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
			core_course_notes.add("Your GPA must be 3.00 or higher");
		}
		
		Details core_details = new Details(totalGPAString, null, null, core_course_notes);
		RequirementCheckResults core_courses = new RequirementCheckResults("GPA", passed, core_details);
		this.pHD.add(core_courses);
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
	
	
	public void milestones_phd(List<Milestone> milestones){
		List<Milestone> core_miles_list = new ArrayList<Milestone>();
		List<String> core_miles_notes = new ArrayList<String>();
		int passedVal = 0;
		boolean passed = false;
		boolean [] milesPassed = new boolean[9];
		Arrays.fill(milesPassed, Boolean.FALSE);
		
		String [] milesNames = new String[9];
		milesNames[0] = "DISSERTATION_ADVISOR_SELECTED";
		milesNames[1] = "PROGRAM_OF_STUDY_SUBMITTED";
		milesNames[2] = "DISSERTATION_COMMITTEE_FORMED";
		milesNames[3] = "QUALIFYING_EXAM_PASSED";
		milesNames[4] = "DISSERTATION_PROPOSAL_SCHEDULED";
		milesNames[5] = "COMPREHENSIVE_EXAM_PASSED";
		milesNames[6] = "DISSERTATION_SUBMITTED";
		milesNames[7] = "DISSERTATION_DEFENSE_SCHEDULED";
		milesNames[8] = "DISSERTATION_DEFENSE_PASSED";
		
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
		
		if(passedVal == 9){
			passed = true;
		}
		
		Details core_details = new Details(null, null, core_miles_list, core_miles_notes);
		RequirementCheckResults core_courses = new RequirementCheckResults("MILESTONES_PHD", passed, core_details);
		this.pHD.add(core_courses);
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
