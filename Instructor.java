package p1;

import java.util.List;
//        String csvFile = "C:\\Users\\carlo\\Desktop\\Instructors.csv";

public class Instructor implements Comparable<Instructor>{
	private String idNo;
	private String homeCamp;
	private String busPhone;
	private String name;
	private String address;
	private String cityStateZip;
	private String homePhone;
	private String collegeDate;
	private String courses; // Use a List to store multiple courses
	private String rank;
	private String onl;
	private String campus;
	private String secondCrse;
	private String thirdCrse;
	private String numEves;
	private String am7to8Days;
	private String pm3to4Days;
	private String sat;
	private String sun;
	private String lateAftDays;
	private String evesDays;
	private String intVal;
	private String fallWrkload;

	public Instructor(
			String idNo, 
			String homeCamp, 
			String busPhone, 
			String name, 
			String address, 
			String cityStateZip,
			String homePhone, 
			String collegeDate, 
			String courses, 
			String rank, 
			String onl, 
			String campus,
			String secondCrse, 
			String thirdCrse, 
			String numEves, 
			String am7to8Days, 
			String pm3to4Days, 
			String sat,
			String sun, 
			String lateAftDays, 
			String evesDays, 
			String intVal, 
			String fallWrkload) 
	{
		super();
		this.idNo = idNo;
		this.homeCamp = homeCamp;
		this.busPhone = busPhone;
		this.name = name;
		this.address = address;
		this.cityStateZip = cityStateZip;
		this.homePhone = homePhone;
		this.collegeDate = collegeDate;
		this.courses = courses;
		this.rank = rank;
		this.onl = onl;
		this.campus = campus;
		this.secondCrse = secondCrse;
		this.thirdCrse = thirdCrse;
		this.numEves = numEves;
		this.am7to8Days = am7to8Days;
		this.pm3to4Days = pm3to4Days;
		this.sat = sat;
		this.sun = sun;
		this.lateAftDays = lateAftDays;
		this.evesDays = evesDays;
		this.intVal = intVal;
		this.fallWrkload = fallWrkload;
	}

	public Instructor() {
		// TODO Auto-generated constructor stub
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getHomeCamp() {
		return homeCamp;
	}

	public void setHomeCamp(String homeCamp) {
		this.homeCamp = homeCamp;
	}

	public String getBusPhone() {
		return busPhone;
	}

	public void setBusPhone(String busPhone) {
		this.busPhone = busPhone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCityStateZip() {
		return cityStateZip;
	}

	public void setCityStateZip(String cityStateZip) {
		this.cityStateZip = cityStateZip;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getCollegeDate() {
		return collegeDate;
	}

	public void setCollegeDate(String collegeDate) {
		this.collegeDate = collegeDate;
	}

	public void setCourses(String courses) {
		this.courses = courses;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getOnl() {
		return onl;
	}

	public void setOnl(String onl) {
		this.onl = onl;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getSecondCrse() {
		return secondCrse;
	}

	public void setSecondCrse(String secondCrse) {
		this.secondCrse = secondCrse;
	}

	public String getThirdCrse() {
		return thirdCrse;
	}

	public void setThirdCrse(String thirdCrse) {
		this.thirdCrse = thirdCrse;
	}

	public String getNumEves() {
		return numEves;
	}

	public void setNumEves(String numEves) {
		this.numEves = numEves;
	}

	public String getAm7to8Days() {
		return am7to8Days;
	}

	public void setAm7to8Days(String am7to8Days) {
		this.am7to8Days = am7to8Days;
	}

	public String getPm3to4Days() {
		return pm3to4Days;
	}

	public void setPm3to4Days(String pm3to4Days) {
		this.pm3to4Days = pm3to4Days;
	}

	public String getSat() {
		return sat;
	}

	public void setSat(String sat) {
		this.sat = sat;
	}

	public String getSun() {
		return sun;
	}

	public void setSun(String sun) {
		this.sun = sun;
	}

	public String getLateAftDays() {
		return lateAftDays;
	}

	public void setLateAftDays(String lateAftDays) {
		this.lateAftDays = lateAftDays;
	}

	public String getEvesDays() {
		return evesDays;
	}

	public void setEvesDays(String evesDays) {
		this.evesDays = evesDays;
	}

	public String getIntVal() {
		return intVal;
	}

	public void setIntVal(String intVal) {
		this.intVal = intVal;
	}

	public String getFallWrkload() {
		return fallWrkload;
	}

	public void setFallWrkload(String fallWrkload) {
		this.fallWrkload = fallWrkload;
	}

	@Override
	public String toString() {
		return "Instructor [idNo=" + idNo + ", homeCamp=" + homeCamp + ", busPhone=" + busPhone + ", name=" + name
				+ ", address=" + address + ", cityStateZip=" + cityStateZip + ", homePhone=" + homePhone
				+ ", collegeDate=" + collegeDate + ", courses=" + courses + ", rank=" + rank + ", onl=" + onl
				+ ", campus=" + campus + ", secondCrse=" + secondCrse + ", thirdCrse=" + thirdCrse + ", numEves="
				+ numEves + ", am7to8Days=" + am7to8Days + ", pm3to4Days=" + pm3to4Days + ", sat=" + sat + ", sun="
				+ sun + ", lateAftDays=" + lateAftDays + ", evesDays=" + evesDays + ", intVal=" + intVal
				+ ", fallWrkload=" + fallWrkload + "]";
	}
	
	@Override
	public int compareTo(Instructor other) {
	    return Integer.compare(Integer.parseInt(this.idNo), Integer.parseInt(other.idNo));
	}

	public String getCourses() {
		return courses;
	}

}
