package p1;

public class Course {
	private int courseNumber;
	private String courseTitle;
	private int CRN;
	private String partOfTerm;//make array later
	private String campus;
	private String instructionMethod;
	private String daysOffered;
	private String beginTime;
	private String endTime;

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

	@Override
	public String toString() {
		return "Course [courseNumber=" + courseNumber + ", courseTitle=" + courseTitle + ", CRN=" + CRN
				+ ", partOfTerm=" + partOfTerm + ", campus=" + campus + ", instructionMethod=" + instructionMethod
				+ ", daysOffered=" + daysOffered + ", beginTime=" + beginTime + ", endTime=" + endTime + "]";
	}

	
	
}
