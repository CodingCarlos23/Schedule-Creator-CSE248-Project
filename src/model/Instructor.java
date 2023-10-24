package model;

import java.util.ArrayList;
import java.util.Arrays;
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
	private String am8to12pm;
	private String pm12to3;
	private String pm3to4Days;
	private String sat;
	private String sun;
	private String lateAftDays;
	private String evesDays;
	private String intVal;
	private String fallWrkload;
	private boolean [][] schedule  = new boolean [6][5];
    private ArrayList<String> classesAssigned = new ArrayList<String>(5);

	/*
	 * each row is a time of day so itll be easy (i hope)
	 * M T W T F
	 * [][][][][]
	 * [][][][][]
	 * [][][][][]
	 * [][][][][]
	 * [][][][][]
	 * [][][][][]
	 * 
	 */

	public Instructor(
			String idNo, 
			String homeCamp, 
			String busPhone, 
			String name, 
			String address, 
			String cityStateZip,
			String homePhone, 
			String collegeDate, 
			String courses,// nine
			String rank, 
			String onl, 
			String campus,
			String secondCrse, 
			String thirdCrse, 
			String numEves, 
			String am7to8Days, 
			String am8to12pm,
			String pm12to3,
			String pm3to4Days, 
			String sat,
			String sun, 
			String lateAftDays, //4to6
			String evesDays, //6to10
			String intVal, 
			String fallWrkload
			) 
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
		this.am8to12pm = am8to12pm;
		this.pm3to4Days = pm3to4Days;
		this.pm12to3 = pm12to3;
		this.sat = sat;
		this.sun = sun;
		this.lateAftDays = lateAftDays;
		this.evesDays = evesDays;
		this.intVal = intVal;
		this.fallWrkload = fallWrkload;
		
		

		
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

	public String getAm8to12pm() {
		return am8to12pm;
	}

	public void setAm8to12pm(String am8to12pm) {
		this.am8to12pm = am8to12pm;
	}

	public String getPm12to3() {
		return pm12to3;
	}

	public void setPm12to3(String pm12to3) {
		this.pm12to3 = pm12to3;
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

	public boolean[][] getSchedule() {
		return schedule;
	}

	public void setSchedule(boolean[][] schedule) {
		this.schedule = schedule;
	}
	
	 public ArrayList<String> getClassesAssigned() {
		return classesAssigned;
	}

	public void setClassesAssigned(ArrayList<String> classesAssigned) {
		this.classesAssigned = classesAssigned;
	}

	public void printSchedule() {
	        for (int i = 0; i < schedule.length; i++) {
	            for (int j = 0; j < schedule[i].length; j++) {
	                System.out.print(schedule[i][j] + " ");
	            }
	            System.out.println();
	        }
	    }

	@Override
	public String toString() {
		return "Instructor [idNo=" + idNo + ", homeCamp=" + homeCamp + ", busPhone=" + busPhone + ", name=" + name
				+ ", address=" + address + ", cityStateZip=" + cityStateZip + ", homePhone=" + homePhone
				+ ", collegeDate=" + collegeDate + ", courses=" + courses + ", rank=" + rank + ", onl=" + onl
				+ ", campus=" + campus + ", secondCrse=" + secondCrse + ", thirdCrse=" + thirdCrse + ", numEves="
				+ numEves + ", am7to8Days=" + am7to8Days + ", am8to12pm=" + am8to12pm + ", pm12to3=" + pm12to3
				+ ", pm3to4Days=" + pm3to4Days + ", sat=" + sat + ", sun=" + sun + ", lateAftDays=" + lateAftDays
				+ ", evesDays=" + evesDays + ", intVal=" + intVal + ", fallWrkload=" + fallWrkload + ", schedule="
				+ Arrays.toString(schedule) + ", classesAssigned=" + classesAssigned + "]";
	}
	
	@Override
	public int compareTo(Instructor other) {
	    return Integer.compare(Integer.parseInt(this.idNo), Integer.parseInt(other.idNo));
	}

	public String getCourses() {
		return courses;
	}

}
