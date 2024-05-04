package util;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Course;
import model.CourseList;
import model.Instructor;
import model.InstructorList;

public class TestingThing {
    public static void main(String[] args) {
	    InstructorList instructorList = InstructorList.getInstance();
        List<List<String>> result = new ArrayList<>();
		CourseList courseList = CourseList.getInstance();
        
        String csvFile = "Data/InstructorsV2.csv"; // Replace with the path to your CSV file
        result = Tools.importInstructorsCSV(csvFile);
        LinkedList<String> senorityList = Tools.getSeniorityList();
        System.out.println(result);
        System.out.println(senorityList);
        System.out.println("AHHHHHH");
        
        System.out.println();
        System.out.println();
        System.out.println("Instructor List starts");
        
        for(int i = 0; i < result.size(); i++) {
        	int currentIndex = 49;
        	StringBuilder output = new StringBuilder();
        	while (currentIndex < result.get(i).size() && !result.get(i).get(currentIndex).isEmpty()) {
        		output.append(result.get(i).get(currentIndex)).append(" ");
        		currentIndex++;
          	}         
        	
        	//instructor start
        	   String number = result.get(i).get(0).replaceAll("[^0-9]", ""); // Removes all non-digit characters
        	           Instructor instructor = new Instructor(
        	           		number, 
        	           		result.get(i).get(16), 
        	           		result.get(i).get(31), 
        	           		result.get(i).get(1) + result.get(i).get(2), 
        	           		result.get(i).get(17), 
        	           		result.get(i).get(32) + result.get(i).get(33), 
        	           		result.get(i).get(3), 
        	           		result.get(i).get(18), 
        	           		result.get(i).get(34) + " " + result.get(i).get(35) + " " + result.get(i).get(36) + " " + result.get(i).get(37) + " " + result.get(i).get(38) + " " + result.get(i).get(39) + " " + result.get(i).get(40) + " " + result.get(i).get(41) + " " + result.get(i).get(42) + " " + output.toString(), 
        	           		result.get(i).get(4), 
        	           		result.get(i).get(5), 
        	           		result.get(i).get(6), 
        	           		result.get(i).get(7), 
        	           		result.get(i).get(22), 
        	           		"", 
        	           		result.get(i).get(9), 
        	           		result.get(i).get(24), 
        	           		result.get(i).get(25), 
        	           		result.get(i).get(10), 
        	           		result.get(i).get(11), 
        	           		result.get(i).get(26), 
        	           		result.get(i).get(12), 
        	           		result.get(i).get(13),
        	           		"",
        	           		result.get(i).get(15));	
        	//instructor end
        	
        	//###
        	boolean [][] schedule  = new boolean [6][5];
        	String days = instructor.getAm7to8Days();
            for (int i1 = 0; i1 < days.length(); i1++) {
                char dayChar = days.charAt(i1);
                switch (dayChar) {
                    case 'M':
                        schedule[0][0] = true;
                        break;
                    case 'T':
                        if (i1 == 2) {
                            schedule[0][1] = true; // Tuesday
                        } else if (i1 == 4) {
                            schedule[0][3] = true; // Thursday
                        }
                        break;
                    case 'W':
                        schedule[0][2] = true;
                        break;
                    case 'F':
                        schedule[0][4] = true;
                        break;
                    default:
                        break; // Handle other characters as needed
                }
            } 	
        	days = instructor.getAm8to12pm();
            for (int i1 = 0; i1 < days.length(); i1++) {
                char dayChar = days.charAt(i1);
                switch (dayChar) {
                    case 'M':
                        schedule[1][0] = true;
                        break;
                    case 'T':
                        if (i1 == 1 || i1 == 2) {
                            schedule[1][1] = true; // Tuesday
                        } else if (i1 == 3 || i1 == 4) {
                            schedule[1][3] = true; // Thursday
                        }
                        break;
                    case 'W':
                        schedule[1][2] = true;
                        break;
                    case 'F':
                        schedule[1][4] = true;
                        break;
                    default:
                        break; // Handle other characters as needed
                }
            }
            
        	days = instructor.getPm12to3();
            for (int i1 = 0; i1 < days.length(); i1++) {
                char dayChar = days.charAt(i1);
                switch (dayChar) {
                    case 'M':
                        schedule[2][0] = true;
                        break;
                    case 'T':
                        if (i1 == 2 || i1 == 1) {
                            schedule[2][1] = true; // Tuesday
                        } else if (i1 == 4 || i1 == 3) {
                            schedule[2][3] = true; // Thursday
                        }
                        break;
                    case 'W':
                        schedule[2][2] = true;
                        break;
                    case 'F':
                        schedule[2][4] = true;
                        break;
                    default:
                        break; // Handle other characters as needed
                }
            }
            
        	days = instructor.getPm3to4Days();
            for (int i1 = 0; i1 < days.length(); i1++) {
                char dayChar = days.charAt(i1);
                switch (dayChar) {
                    case 'M':
                        schedule[3][0] = true;
                        break;
                    case 'T':
                        if (i1 == 2) {
                            schedule[3][1] = true; // Tuesday
                        } else if (i1 == 4) {
                            schedule[3][3] = true; // Thursday
                        }
                        break;
                    case 'W':
                        schedule[3][2] = true;
                        break;
                    case 'F':
                        schedule[3][4] = true;
                        break;
                    default:
                        break; // Handle other characters as needed
                }
            }
            
        	days = instructor.getLateAftDays();
            for (int i1 = 0; i1 < days.length(); i1++) {
                char dayChar = days.charAt(i1);
                switch (dayChar) {
                    case 'M':
                        schedule[4][0] = true;
                        break;
                    case 'T':
                        if (i1 == 1) {
                            schedule[4][1] = true; // Tuesday
                        } else if (i1 == 3) {
                            schedule[4][3] = true; // Thursday
                        }
                        break;
                    case 'W':
                        schedule[4][2] = true;
                        break;
                    case 'F':
                        schedule[4][4] = true;
                        break;
                    default:
                        break; // Handle other characters as needed
                }
            }
            
        	days = instructor.getEvesDays();
            for (int i1 = 0; i1 < days.length(); i1++) {
                char dayChar = days.charAt(i1);
                switch (dayChar) {
                    case 'M':
                        schedule[5][0] = true;
                        break;
                    case 'T':
                        if (i1 == 1) {
                            schedule[5][1] = true; // Tuesday
                        } else if (i1 == 3) {
                            schedule[5][3] = true; // Thursday
                        }
                        break;
                    case 'W':
                        schedule[5][2] = true;
                        break;
                    case 'F':
                        schedule[5][4] = true;
                        break;
                    default:
                        break; // Handle other characters as needed
                }
            }
        	instructor.setSchedule(schedule);
        	instructorList.addInstructor(instructor);
        	//###
        }
        
        instructorList.printInstructors();
        
        //course list
        csvFile = "Data/CourseInformation.csv"; // Replace with your CSV file path
        courseList = Tools.importCourseCSV(csvFile);
       
        courseList.printCourses();
        //
        
        //course freq
//        csvFile = "Data/Instructor_Frequency_v3.csv";
//        
//        List<List<String>> courseFreq = new LinkedList<>();
//        courseFreq = Tools.importCourseFreq(csvFile);
//        
//        for (List<String> list : courseFreq) {
//            System.out.println(list);
//        }
//        
//      System.out.println(courseFreq.get(26).get(10));

        // courseFreq
       
    }
    
}
