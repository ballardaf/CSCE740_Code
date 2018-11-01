package edu.sc.csce740;

import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class GRADSDriver {

	public static void main(String[] args) 
	{
		System.out.println("Welcome to GRADS");
		GRADS grads = new GRADS();
		String recordFilePath_ = "C:/Users/Hero/git/GRADS/src/edu/sc/csce740/GRADS_Materials/data/poop.txt";
		
		//LOADING DATABASES
		try
		{
		//Have the grads system load the uses, records and courses 
		//grads.loadUsers("C:/Users/New Hotness/git/GRADS/src/edu/sc/csce740/GRADS_Materials/data/users.txt");
		//grads.loadCourses("C:/Users/New Hotness/git/GRADS/src/edu/sc/csce740/GRADS_Materials/data/courses.txt");
		//grads.loadRecords("C:/Users/New Hotness/git/GRADS/src/edu/sc/csce740/GRADS_Materials/data/students.txt");
		
		grads.loadUsers("C:/Users/Hero/git/GRADS/src/edu/sc/csce740/GRADS_Materials/data/users.txt");
		grads.loadCourses("C:/Users/Hero/git/GRADS/src/edu/sc/csce740/GRADS_Materials/data/courses.txt");	
		grads.loadRecords("C:/Users/Hero/git/GRADS/src/edu/sc/csce740/GRADS_Materials/data/students.txt");
		
		
		grads.setUser("katek");
		//grads.setUser("mmatthews");
		
		//GET STUDENT IDS FUNCTION TEST
		//System.out.println(grads.getStudentIDs());
		
		//ADD NOTE FUNCTION TEST
		//grads.addNote("mhunt", "shouldnt see in records class", false); //should work
		//grads.addNote("mhunt", "peep gonna fail again", true); // should work  
		
		//grads.addNote("rbob", "gonna fail", false); // should fail - not csce  
		//grads.addNote("adfa", "gonna fail", false); // should fail - no student record  
		
		//grads.setUser("mhunt");
		//grads.addNote("mhunt", "notes are gay", false); //should fail, not gpc
		
		//UPDATE TRANSCRIPT FUNCTION TEST
		//grads.setUser("mhunt");
		//StudentRecord temp = grads.getRecords().get(0);
		//temp.getDegreeSought().setName("UGH SCREW THIS");
		//grads.updateTranscript("mhunt", temp, false); //should work
		
		//temp.getStudent().setId("pika");
		//grads.updateTranscript("mhunt", temp, false); //shouldnlt work
		
		//temp.getStudent().setFirstName("pikachu!");
		//grads.updateTranscript("mhunt", temp, true); //should work
		
		//temp.getStudent().setFirstName("pikachu!");
		//grads.updateTranscript("mhunt", temp, true); //should work
		
		//grads.setUser("mmatthews");
		//temp.getStudent().setFirstName("Michelle");
		//grads.updateTranscript("mhunt", temp, true); //should work
		
		
		
		//CLEAR SESSION FUNCTION TEST
		//System.out.println(grads.getactiveUser_().toString());
		//grads.clearSession();
		//System.out.println(grads.getactiveUser_().toString());
		
		//GET TRANSCRIPT FUNCTION TEST
		//StudentRecord test = grads.getTranscript("mhunt");
		//System.out.println(test.toString());
		
		//GENERATE PROGRESS SUMMARY FUNCTION TEST
		ProgressSummary test = grads.generateProgressSummary("katek");
		System.out.println(test.toString());
		
		String recordsInJsonFormat = new GsonBuilder().setPrettyPrinting().create().toJson(test);
		
		PrintWriter file = new PrintWriter(recordFilePath_);
		file.write("");
		file.append(recordsInJsonFormat);
		file.close();
		
			
		//grads.loadUsers("C:/Users//Documents/Csce740/GRADS_Materials/GRADS_Materials/data/users.txt");
		//grads.loadCourses("C:/Users/Hero/Documents/Csce740/GRADS_Materials/GRADS_Materials/data/courses.txt");	
		//grads.loadRecords("C:/Users/Hero/Documents/Csce740/GRADS_Materials/GRADS_Materials/data/students.txt");
			
		}
		catch (Exception e)
		{
			System.err.println("Caught IOEception: " + e.getMessage());
		}
			
	}

}
