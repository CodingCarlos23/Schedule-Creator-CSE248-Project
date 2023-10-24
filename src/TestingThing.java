import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Instructor;

public class TestingThing {
    public static void main(String[] args) {
        String csvFile = "Data/InstructorsV2.csv"; // Replace with the path to your CSV file
        List<List<String>> result = new ArrayList<>();
        List<String> currentList = new ArrayList<>();
        LinkedList<String> senorityList = new LinkedList<String>();
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
                	// THE ISSUE IS IT IS NOT ADDING THE BLANKS THAT WHY IT IS NOT ALLINGING FIGURE OUT HOW TO ADD BLANKS IF NOT BUFFER THEN APPACHE
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
                            //add INSTRUCTOR HERE
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
                    System.out.print(String.format("%-" + (columnWidths[i] + 2) + "s", cell)); // Add 2 for padding
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(result);
        
        //#
       // System.out.println(result.get(i).get(0));//id
       // System.out.println(result.get(i).get(16));//homecamp
       // System.out.println(result.get(i).get(31));//busphone
        //System.out.println(result.get(i).get(1) + result.get(i).get(2));//name
        //System.out.println(result.get(i).get(17));//address
        //System.out.println(result.get(i).get(32) + result.get(i).get(33));//citystatezip
        //System.out.println(result.get(i).get(3));//homephone
       // System.out.println(result.get(i).get(18));//collegeData
       // System.out.println(result.get(i).get(34) + " " + result.get(i).get(35) + " " + result.get(i).get(36) + " " + result.get(i).get(37) + " " + result.get(i).get(38) + " " + result.get(i).get(39) + " " + result.get(i).get(40) + " " + result.get(i).get(41) + " " + result.get(i).get(42));
//        int currentIndex = 49;
//        StringBuilder output = new StringBuilder();
//        while (currentIndex < result.get(i).size() && !result.get(i).get(currentIndex).isEmpty()) {
//            output.append(result.get(i).get(currentIndex)).append(" ");
//            currentIndex++;
//        }
//        System.out.println(output.toString()); //combine the two course lines
//       
//        String number = result.get(i).get(0).replaceAll("[^0-9]", ""); // Removes all non-digit characters

       // System.out.println(result.get(i).get(4));//rank
        //System.out.println(result.get(i).get(5));//online
       // System.out.println(result.get(i).get(6));//campus
       // System.out.println(result.get(i).get(7));//2nd crse
        //System.out.println(result.get(i).get(22));//3rd crse
       // System.out.println("");//numeves
        //System.out.println(result.get(i).get(9));// 7-8
        //System.out.println(result.get(i).get(24));// 8 to 12
       // System.out.println(result.get(i).get(25));//12 to 3
      //  System.out.println(result.get(i).get(10));//3-4
       // System.out.println(result.get(i).get(11));//sat
       // System.out.println(result.get(i).get(26));//sun
       // System.out.println(result.get(i).get(12));//late aft day 4to6
       // System.out.println(result.get(i).get(13));//eves day 6 to 10
      //  System.out.println("");
       // System.out.println(result.get(i).get(15));
        //#
        
        //
        int i = 0;

        int currentIndex = 49;
        StringBuilder output = new StringBuilder();
        while (currentIndex < result.get(i).size() && !result.get(i).get(currentIndex).isEmpty()) {
            output.append(result.get(i).get(currentIndex)).append(" ");
            currentIndex++;
        }
        System.out.println(output.toString()); //combine the two course lines
       
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
        
        //Schedule instructor setter
    	boolean [][] schedule  = new boolean [6][5];
    	String days = instructor.getAm7to8Days();
//#
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
        
    	days = instructor.getPm12to3();// CHANGE THE TUES AND THURS TO GET MULITPLE INDEXS
    	System.out.println(days);
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
    	System.out.println(days);
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
    	System.out.println(days);
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
    	System.out.println(days);
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
//#
    	instructor.setSchedule(schedule);
    	//
        
        System.out.println(instructor);
        instructor.printSchedule();
        System.out.println(senorityList);
        //

        System.out.println("Done");
        
        
    }
}
