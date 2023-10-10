package model;

public class Course implements Comparable<Course>{
	private int courseNumber;
	private String courseTitle;
	private int CRN;
	private String partOfTerm;//make array later
	private String campus;
	private String instructionMethod;
	private String daysOffered;
	private String beginTime;
	private String endTime;
	private String assignedInstructor;
	private int startTimeHour;
	private int startTimeMin;
	private int endTimeHour;
	private int endTimeMin;

	// Constructor
	public Course(int courseNumber, String courseTitle, int CRN, String partOfTerm, String campus,
			String instructionMethod, String daysOffered, String beginTime, String endTime) {
		this.courseNumber = courseNumber;
		this.courseTitle = courseTitle;
		this.CRN = CRN;
		this.partOfTerm = partOfTerm;
		this.campus = campus;
		this.instructionMethod = instructionMethod;
		this.daysOffered = daysOffered;
		this.beginTime = beginTime;
		this.endTime = endTime;

		String time = beginTime; // This is your time string
		Integer hour = -1; // -1 means it is online if the others are null
		Integer mins = -1;
		
		if (!time.equals("")) {
		    String[] parts = time.split(":"); // This will give you ["6", "00PM"]

		    String hourString = parts[0]; // This will give you "6"
		    hour = Integer.parseInt(hourString); // This will convert "6" to 6

		    String minsAndPeriod = parts[1]; // This will give you "30PM"
		    String minsString = minsAndPeriod.substring(0, 2); // This will give you "30"
		    mins = Integer.parseInt(minsString); // This will convert "30" to 30
		    
		    String period = parts[1].substring(2); // This will give you "PM"
		    if (period.equals("PM") && hour != 12) {
		        hour = hour + 12;
		    } else if (period.equals("AM") && hour == 12) {
		    	
		    }
		}
		startTimeHour = hour;
		startTimeMin = mins;
		
	}

	public int getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(int courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public int getCRN() {
		return CRN;
	}

	public void setCRN(int cRN) {
		CRN = cRN;
	}

	public String getPartOfTerm() {
		return partOfTerm;
	}

	public void setPartOfTerm(String partOfTerm) {
		this.partOfTerm = partOfTerm;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getInstructionMethod() {
		return instructionMethod;
	}

	public void setInstructionMethod(String instructionMethod) {
		this.instructionMethod = instructionMethod;
	}

	public String getDaysOffered() {
		return daysOffered;
	}

	public void setDaysOffered(String daysOffered) {
		this.daysOffered = daysOffered;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	public String getAssignedInstructor() {
		return assignedInstructor;
	}

	public void setAssignedInstructor(String assignedInstructor) {
		this.assignedInstructor = assignedInstructor;
	}

	@Override
	public String toString() {
		return "Course [courseNumber=" + courseNumber + ", courseTitle=" + courseTitle + ", CRN=" + CRN
				+ ", partOfTerm=" + partOfTerm + ", campus=" + campus + ", instructionMethod=" + instructionMethod
				+ ", daysOffered=" + daysOffered + ", beginTime=" + beginTime + ", endTime=" + endTime
				+ ", assignedInstructor=" + assignedInstructor + ", startTimeHour=" + startTimeHour + ", startTimeMin="
				+ startTimeMin + ", endTimeHour=" + endTimeHour + ", endTimeMin=" + endTimeMin + "]";
	}

	@Override
	public int compareTo(Course other) {
	    return Integer.compare(this.CRN, other.CRN);
	}

	
}
