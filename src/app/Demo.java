package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Course;
import model.CourseList;
import model.Instructor;
import model.InstructorList;

public class Demo extends Application {

	public static void main(String[] args) {

		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		// code for data
		String csvFile = "Data/Instructors.csv";
		String line = "";
		String cvsSplitBy = "\t";
		boolean found = false;
		int count = 0;
		
		//TreeSet<Instructor> instructorsList = new TreeSet<>(); // tree set is good for large data and finds things fast
		
	    InstructorList instructorList = InstructorList.getInstance();
		CourseList courseList = CourseList.getInstance();
		// ArrayList<Instructor> instructorsList = new ArrayList<Instructor>();
	    int consecutiveNullLines = 0; // Counter for consecutive null lines

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			ArrayList<String[]> list = null;
		   // int consecutiveNullLines = 0; // Counter for consecutive null lines

			while ((line = br.readLine()) != null && consecutiveNullLines < 2) {
				if (found) {

					//
					String[] values;
					if (line == null) {
						values = new String[15];
						for (int i = 0; i < values.length; i++) {
							values[i] = "";
						}
						list.add(values);
					} else {
						values = line.split(",");
					}
					if (list == null) {
						list = new ArrayList<String[]>();
					}

					list.add(values);
					count++;
					
					String[] x = {""};
					if (list.size() > 3 && list.get(3).length != 0) {/// ITS WORKSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS
					    x = list.get(3);
					    System.out.println(x + "CHECK IT OUT");
					    // rest of your code
					} else {
					    System.out.println("Index out of bounds");
					}

					System.out.println(x);
					
					String[] targetArray = {"—"};
					boolean contains = list.stream().anyMatch(array -> Arrays.equals(array, targetArray));
					System.out.println(contains);

					System.out.println("^");
					System.out.println(list.size());
					
					String targetString = "—"; // replace with the string you're looking for
					boolean isit = Arrays.asList(x).contains(targetString);
					System.out.println(isit);
					System.out.println();

					if ((count == 4) || (contains && count == 3)) { // FIX THIS NOW || !x.contains("—") && count == 3
						//the courses are not getting the part under it 

						String[] empt = { " ", " ", " ", " ", " ", " ", " ", " ", " " };

						for (String[] array : list) {
							System.out.println("HERE" + Arrays.toString(array));
							System.out.println(array.equals(("—")));
							System.out.println(Arrays.asList(array).contains("—"));
						}
						//
						// cant do sun because out of bounds will fix later
						// add code to detect sun, do a if null make it space other get space
						
						
						//
						String sat;
						try {
							sat = list.get(0)[11];
				        } catch (ArrayIndexOutOfBoundsException e) {
							sat = "";
				        }
						
						String sun = "";
						try {
							sun = list.get(1)[10];
				        } catch (ArrayIndexOutOfBoundsException e) {
							sun = "";
				        }
						//
						String course = "";
						if (list.size() > 3 && list.get(3).length > 2) {
							course = list.get(2)[3] + " " + list.get(3)[2];
						} else {
							course = list.get(2)[3];
							System.out.println(list.get(3).length);
						}
						Instructor instructor = new Instructor(
								list.get(0)[0], 
								list.get(1)[0], 
								list.get(2)[0],
								list.get(0)[1] + "," + list.get(0)[2], 
								list.get(1)[1],
								list.get(2)[1] + "," + list.get(2)[2], 
								list.get(0)[3], 
								list.get(1)[2],
								course, // nine
								list.get(0)[4], 
								list.get(0)[5], 
								list.get(0)[6],
								list.get(0)[7], //2nd crse
								list.get(1)[6], //3rd crse
								list.get(0)[8], //numeves
								list.get(0)[9] + " " + list.get(1)[8],//7to8
								list.get(0)[10], //3to4
								sat, //sat
								sun, //sun
								list.get(0)[12], //late aftdays
								list.get(0)[13],//evesdays
								
								list.get(0)[14], //int
								list.get(0)[15]); //fallwork
						instructorList.addInstructor(instructor);
						list = new ArrayList<String[]>();
						//
						count = 0;
						found = false;
						System.out.println(instructor);
						// break;//////////////////////////////////////change delte this

					}
				} else {
					if(line == null) {
						consecutiveNullLines++;
						break;
					}
					String[] values = line.split(cvsSplitBy);
					for (String value : values) {
						if(value == null) {
							consecutiveNullLines++;
						}
						if(values == null) {
							consecutiveNullLines++;
						}
						if (value.contains("—")) {
							found = true;
							break;
						}
					}
				}

				//
				
			}

//            if(list != null) {
//            	Instructor instructor = new Instructor(list.get(0)[0], list.get(1)[0], list.get(2)[0], list.get(0)[1]+ "," + list.get(0)[2], list.get(1)[1], list.get(2)[1] + "," + list.get(2)[2], list.get(0)[3], list.get(1)[2], list.get(2)[3] + " " + list.get(3)[2], list.get(0)[4], list.get(0)[5], list.get(0)[6], list.get(0)[7], list.get(1)[6], list.get(0)[8], list.get(0)[9] + " " + list.get(1)[8], list.get(0)[10], list.get(0)[11], list.get(1)[8], list.get(0)[12], list.get(0)[13], list.get(0)[14], list.get(0)[15]);
//            	instructorsList.add(instructor);
//            	list = new ArrayList<String[]>();
//            }
			System.out.println(consecutiveNullLines + "Null count ");

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();
		
        instructorList.printInstructors();
        
        //////This is for course testing remove later
        
        csvFile = "Data/CourseInformation.csv"; // Replace with your CSV file path
        //String line;
        
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
                		str + " " + formattedNumber,    // Course Number
                        data[3],                      // Course Title
                        Integer.parseInt(data[4]),    // CRN
                        data[6],                      // Part of Term
                        data[7],                      // Campus
                        data[9],                      // Instruction Method
                        daysOffered,                     // Days Offered 
                        beginTime,                     // Begin Time
                        endTime                      // End Time
                );

                // You can do whatever you want with the course object here
                //System.out.println(course);
                courseList.addCourse(course);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //////course parsing done

        //* Code for setting instructors with class Assigned
        
        

        //*Class assigned end

        System.out.println();
       // courseList.printCourses();
        
        
        int size = instructorList.getSize();
        System.out.println("The size of the TreeSet is: " + size);
        size = courseList.getSize();
        System.out.println("The size of the TreeSet is: " + size);
		// code for GUI
		
		Parent root = FXMLLoader.load(getClass().getResource("/view/Main.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//delete these
        System.out.println(instructorList.getInstructors().first());
        System.out.println(courseList.getCourses().getFirst());
        instructorList.getInstructors().first().getClassesAssigned().add(courseList.getCourses().getFirst().getCourseNumber());
        courseList.getCourses().getFirst().setAssignedInstructor(instructorList.getInstructors().first().getName());
        System.out.println();
        System.out.println(instructorList.getInstructors().first());
        System.out.println(courseList.getCourses().getFirst());
        
        //System.out.println(courseList.getCourses().get(0));
        
        instructorList.printInstructors();
        
	}

}
