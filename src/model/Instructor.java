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
		am7to8Days = String.format("%-20s", am7to8Days);
		this.am7to8Days = am7to8Days;
		pm3to4Days = String.format("%-20s", pm3to4Days);
		this.pm3to4Days = pm3to4Days;
		this.sat = sat;
		this.sun = sun;
		lateAftDays = String.format("%-5s", lateAftDays);
		this.lateAftDays = lateAftDays;
		this.evesDays = evesDays;
		this.intVal = intVal;
		this.fallWrkload = fallWrkload;
		
		
		
		//7to8
		if (am7to8Days.contains("M") && am7to8Days.contains("*")) {
			schedule[0][0] = true;
		}
		if (am7to8Days.charAt(2) == 'T' && am7to8Days.contains("*")) {
			schedule[0][1] = true;
		}
		if (am7to8Days.contains("W") && am7to8Days.contains("*")) {
			schedule[0][2] = true;
		}
		if (am7to8Days.charAt(4) == 'T' && am7to8Days.contains("*")) {
			schedule[0][3] = true;
		}
		if (am7to8Days.contains("F") && am7to8Days.contains("*")) {
			schedule[0][4] = true;
		}
		
		//8to12 will have to fix later to account for *
		if (am7to8Days.charAt(am7to8Days.length() - 8) == 'M' && am7to8Days.contains("*")) {
			schedule[1][0] = true;
		}
		if (am7to8Days.charAt(am7to8Days.length() - 7) == 'T' && am7to8Days.contains("*")) {
			schedule[1][1] = true;
		}
		if (am7to8Days.charAt(am7to8Days.length() - 3) == 'W' && am7to8Days.contains("*")) {
			schedule[1][2] = true;
		}
		if (am7to8Days.charAt(am7to8Days.length() - 2) == 'T' && am7to8Days.contains("*")) {
			schedule[1][3] = true;
		}
		if (am7to8Days.charAt(am7to8Days.length() - 1) == 'F' && am7to8Days.contains("*")) {
			schedule[1][4] = true;
		}
		
		//12to3
		if (pm3to4Days.contains("M") && !pm3to4Days.contains("*")) {
		    schedule[2][0] = true;
		}
		if (pm3to4Days.charAt(1) == 'T' && !pm3to4Days.contains("*")) {
		    schedule[2][1] = true;
		}
		if (pm3to4Days.contains("W") && !pm3to4Days.contains("*")) {
		    schedule[2][2] = true;
		}
		if (pm3to4Days.charAt(3) == 'T' && !pm3to4Days.contains("*")) {
		    schedule[2][3] = true;
		}
		if (pm3to4Days.contains("F") && !pm3to4Days.contains("*")) {
		    schedule[2][4] = true;
		}
		
		//3to4
		if (pm3to4Days.contains("M") && pm3to4Days.contains("*")) {
		    schedule[3][0] = true;
		}
		if (pm3to4Days.charAt(2) == 'T' && pm3to4Days.contains("*")) {
		    schedule[3][1] = true;
		}
		if (pm3to4Days.contains("W") && pm3to4Days.contains("*")) {
		    schedule[3][2] = true;
		}
		if (pm3to4Days.charAt(4) == 'T' && pm3to4Days.contains("*")) {
		    schedule[3][3] = true;
		}
		if (pm3to4Days.contains("F") && pm3to4Days.contains("*")) {
		    schedule[3][4] = true;
		}

		
		//4to6
		if (lateAftDays.contains("M")) {
			schedule[4][0] = true;
		}
		if (lateAftDays.charAt(2) == 'T') {
			schedule[4][1] = true;
		}
		if (lateAftDays.contains("W")) {
			schedule[4][2] = true;
		}
		if (lateAftDays.charAt(4) == 'T') {
			schedule[4][3] = true;
		}
		if (lateAftDays.contains("F")) {
			schedule[4][4] = true;
		}
		
		//4to6
		if (evesDays.contains("M")) {
		    schedule[5][0] = true;
		}
		if (evesDays.charAt(1) == 'T') {
		    schedule[5][1] = true;
		}
		if (evesDays.contains("W")) {
		    schedule[5][2] = true;
		}
		if (evesDays.charAt(3) == 'T') {
		    schedule[5][3] = true;
		}
		if (evesDays.contains("F")) {
		    schedule[5][4] = true;
		}

		
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
				+ numEves + ", am7to8Days=" + am7to8Days + ", pm3to4Days=" + pm3to4Days + ", sat=" + sat + ", sun="
				+ sun + ", lateAftDays=" + lateAftDays + ", evesDays=" + evesDays + ", intVal=" + intVal
				+ ", fallWrkload=" + fallWrkload + ", schedule=" + Arrays.toString(schedule) + ", classesAssigned="
				+ classesAssigned + "]";
	}
	
	@Override
	public int compareTo(Instructor other) {
	    return Integer.compare(Integer.parseInt(this.idNo), Integer.parseInt(other.idNo));
	}

	public String getCourses() {
		return courses;
	}

}
