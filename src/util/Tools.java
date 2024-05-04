package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Course;
import model.CourseFreqList;
import model.CourseList;

public class Tools {
	
    private static List<String> currentList = new ArrayList<>();
    private static LinkedList<String> senorityList = new LinkedList<String>();
    private static List<List<String>> courseFreq = new LinkedList<>();

    public static List<List<String>> importInstructorsCSV(String csvFile) {
    	List<List<String>> result = new ArrayList<>();
    	int consecutiveNullLines = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    // Empty line found
                    consecutiveNullLines++;
                    if (consecutiveNullLines >= 4) {
                        break; // Stop after four consecutive null lines
                    }
                } else {
                	String[] cells = line.split(",",-1);
                    for (String cell : cells) {
                        currentList.add(cell);
                    }

                    // Check for the marker "—"
                    if (line.contains("-------------------------------------------------------------------------------------------------")) {
                        // Marker found, add the current list to the result and create a new list
                        if (!currentList.isEmpty()) {
                        	//System.out.println(currentList.size());
                            result.add(currentList);
                            String number = currentList.get(0).replaceAll("[^0-9]", ""); // Removes all non-digit characters
                            senorityList.add(number);
                            currentList = new ArrayList<>();
                        }
                    }

                    consecutiveNullLines = 0; // Reset the count of consecutive null lines
                }
            }

            // Add the last currentList to the result
            if (!currentList.isEmpty()) {
                result.add(currentList);
                String number = currentList.get(0).replaceAll("[^0-9]", ""); // Removes all non-digit characters
              //  senorityList.add(number);
            }

            // Find the maximum row length
            int maxRowLength = 0;
            for (List<String> list : result) {
                maxRowLength = Math.max(maxRowLength, list.size());
            }

            // Pad shorter rows to make them equal in length with empty strings
            for (List<String> list : result) {
                while (list.size() < maxRowLength) {
                    list.add(""); // Add empty strings for empty cells
                }
            }

            // Determine the column widths
            int[] columnWidths = new int[maxRowLength];
            for (List<String> list : result) {
                for (int i = 0; i < list.size(); i++) {
                    columnWidths[i] = Math.max(columnWidths[i], list.get(i).length());
                }
            }

            // Print the result with proper alignment
            for (List<String> list : result) {
                for (int i = 0; i < list.size(); i++) {
                    String cell = list.get(i);
                    //###System.out.print(String.format("%-" + (columnWidths[i] + 2) + "s", cell)); // Add 2 for padding
                }
               //### System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

       //### System.out.println(result);
		return result;
    }
    
    public static LinkedList<String> getSeniorityList() {
        return senorityList;
    }
    
    public static CourseList importCourseCSV(String csvFile) {
		CourseList courseList = CourseList.getInstance();

    	 String line;
         try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
             // Read the header line to skip it
             br.readLine();

             while ((line = br.readLine()) != null) {
                 String[] data = line.split(",");
                 
                 String daysOffered = "";
                 if (data.length > 18) {
                     daysOffered = data[18];
                 }
                 String beginTime = "";
                 if (data.length > 19) {
                     beginTime = data[19];
                 }
                 String endTime = "";
                 if (data.length > 20) {
                     endTime = data[20];
                 }
                 
                 DecimalFormat df = new DecimalFormat("000");
                 int number = Integer.parseInt(data[2]);
                 String str = data[1];
                 String formattedNumber = df.format(number);
                 //System.out.println(formattedNumber);
                 
                 // Assuming the CSV columns are in order, create a Course object
                 Course course = new Course(
                 		str + "" + formattedNumber,    // Course Number
                         data[3],                      // Course Title
                         data[4],    // CRN
                         data[6],                      // Part of Term
                         data[7],                      // Campus
                         data[9],                      // Instruction Method
                         daysOffered,                     // Days Offered 
                         beginTime,                     // Begin Time
                         endTime                      // End Time
                 );

                 // You can do whatever you want with the course object here
                 //System.out.println(course);
                 courseList.addCourse(course);;
             }
         } catch (IOException e) {
             e.printStackTrace();
         }
    	
		return courseList;
    	
    }
    
    public static CourseFreqList importCourseFreq(String csvFile) {
       
    	CourseFreqList courseFreq = CourseFreqList.getInstance();

//    	 List<List<String>> courseFreq = new LinkedList<>();
         try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
             String line;

             while ((line = br.readLine()) != null) {
                 String[] cells = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                 // Create a new LinkedList for each line
                 List<String> lineList = new LinkedList<>();
                 for (String cell : cells) {
                     lineList.add(cell);
                 }
                 // Add the lineList to the main courseFreq list
                 courseFreq.addCourse(lineList);
//                 courseFreq.add(lineList);
             }

         } catch (IOException e) {
             e.printStackTrace();
         }

    	
    	return courseFreq;
    	
    }
    
}
