
package edu.sc.csce740;

public class Course {

	private String name;
	private String id;
	private String numCredits;
	
	public Course(){
		name = "";
		id = "";
		numCredits = "";
	}
	
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
	
	public String toString()
	{
		return "Courses [name=" + name + "" + ", id=" + id + ", numCredits=" + numCredits +"]";
	}
}

