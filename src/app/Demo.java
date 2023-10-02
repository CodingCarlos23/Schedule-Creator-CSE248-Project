package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
		
		// ArrayList<Instructor> instructorsList = new ArrayList<Instructor>();

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			ArrayList<String[]> list = null;
		    int consecutiveNullLines = 0; // Counter for consecutive null lines

			while ((line = br.readLine()) != null || consecutiveNullLines != 2) {
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
					if (count == 4) {
						String[] empt = { " ", " ", " ", " ", " ", " ", " ", " ", " " };

						for (String[] array : list) {
							// System.out.println(Arrays.toString(array));
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
						
						String sun;
						try {
							sun = list.get(1)[10];
				        } catch (ArrayIndexOutOfBoundsException e) {
							sun = "";
				        }
						//

						Instructor instructor = new Instructor(
								list.get(0)[0], 
								list.get(1)[0], 
								list.get(2)[0],
								list.get(0)[1] + "," + list.get(0)[2], 
								list.get(1)[1],
								list.get(2)[1] + "," + list.get(2)[2], 
								list.get(0)[3], 
								list.get(1)[2],
								list.get(2)[3] + " " + list.get(3)[2], 
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
						System.out.println("1");
						// break;//////////////////////////////////////change delte this

					}
				} else {
					if(line == null) {
						consecutiveNullLines++;
						break;
					}
					String[] values = line.split(cvsSplitBy);
					for (String value : values) {
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

                // Assuming the CSV columns are in order, create a Course object
                Course course = new Course(
                        Integer.parseInt(data[2]),    // Course Number
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
                System.out.println(course);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //////course parsing done


        int size = instructorList.getSize();
        System.out.println("The size of the TreeSet is: " + size);

		// code for GUI
		
		// Old GUI code for the following
		/*
		//Title
		Label title = new Label("Display teacher scheduler");
		final double MAX_FONT_SIZE = 30.0; // define max font size you need
		title.setFont(new Font(MAX_FONT_SIZE)); // set to Label

		// Gets instructors
		primaryStage.setTitle("Teacher Scheduler");
		ScrollPane root = new ScrollPane();
		//StackPane root = new StackPane();
		List<Node> list = new ArrayList<>();
		VBox displayInstructorBoxTop = new VBox(10);
		Label name = new Label(instructorsList.last().getName());
		Label id = new Label(instructorsList.last().getIdNo());
		Label rank = new Label(instructorsList.last().getRank());
		Label homeCamp = new Label(instructorsList.last().getHomeCamp());
		Label prefCamp = new Label(instructorsList.last().getCampus());
		Label onlineCert = new Label(instructorsList.last().getOnl());
		Label courses = new Label(instructorsList.last().getCourses());
		Label secoundCrse = new Label(instructorsList.last().getSecondCrse());
		Label thirdCrse = new Label(instructorsList.last().getThirdCrse());
		Label sat = new Label(instructorsList.last().getSat());
		Label sun = new Label(instructorsList.last().getSun());
		
		
		displayInstructorBoxTop.getChildren().addAll(name,id,rank,homeCamp,prefCamp,onlineCert,courses,secoundCrse,thirdCrse,sat,sun);


		//
		HBox week = new HBox(10);
		Button sunday = new Button("Sunday");
		
		// week Monday- Friday row buttons
		
		//Box 7-8am
		HBox box7to8am = new HBox(10);
		Button monday7to8am = new Button("Monday 7-8am");
		Button tuesday7to8am = new Button("Tuesday 7-8am");
		Button wednesday7to8am = new Button("Wednesday 7-8am");
		Button thursday7to8am = new Button("Thursday 7-8am");
		Button friday7to8am = new Button("Friday 7-8am");
		box7to8am.getChildren().addAll(monday7to8am, tuesday7to8am, wednesday7to8am, thursday7to8am, friday7to8am);
		//Box 8-12pm
		HBox box8to12 = new HBox(10);
		Button monday8to12 = new Button("Monday 8-12pm");
		Button tuesday8to12 = new Button("Tuesday 8-12pm");
		Button wednesday8to12 = new Button("Wednesday 8-12pm");
		Button thursday8to12 = new Button("Thursday 8-12pm");
		Button friday8to12 = new Button("Friday 8-12pm");
		box8to12.getChildren().addAll(monday8to12, tuesday8to12, wednesday8to12, thursday8to12, friday8to12);
		//Box 3-4pm
		HBox box3to4pm = new HBox(10);
		Button monday3to4pm = new Button("Monday 3-4pm");
		Button tuesday3to4pm = new Button("Tuesday 3-4pm");
		Button wednesday3to4pm = new Button("Wednesday 3-4pm");
		Button thursday3to4pm = new Button("Thursday 3-4pm");
		Button friday3to4pm = new Button("Friday 3-4pm");
		box3to4pm.getChildren().addAll(monday3to4pm, tuesday3to4pm, wednesday3to4pm, thursday3to4pm, friday3to4pm);
		//Box 4-6pm
		HBox box4to6pm = new HBox(10);
		Button monday4to6pm = new Button("Monday 4-6pm");
		Button tuesday4to6pm = new Button("Tuesday 4-6pm");
		Button wednesday4to6pm = new Button("Wednesday 4-6pm");
		Button thursday4to6pm = new Button("Thursday 4-6pm");
		Button friday4to6pm = new Button("Friday 4-6pm");
		box4to6pm.getChildren().addAll(monday4to6pm, tuesday4to6pm, wednesday4to6pm, thursday4to6pm, friday4to6pm);
		//Box 6-10pm
		HBox box6to10pm = new HBox(10);
		Button monday6to10pm = new Button("Monday 6-10pm");
		Button tuesday6to10pm = new Button("Tuesday 6-10pm");
		Button wednesday6to10pm = new Button("Wednesday 6-10pm");
		Button thursday6to10pm = new Button("Thursday 6-10pm");
		Button friday6to10pm = new Button("Friday 6-10pm");
		box6to10pm.getChildren().addAll(monday6to10pm, tuesday6to10pm, wednesday6to10pm, thursday6to10pm, friday6to10pm);

		
		//
		VBox midweek = new VBox(20);
		midweek.getChildren().addAll(box7to8am, box8to12, box3to4pm, box4to6pm, box6to10pm);
		
		Button saturday = new Button("Saturday");

		week.getChildren().addAll(sunday, midweek, saturday);
		
		// search feature
		 TextField textField = new TextField("Search here for IDNo must be all digits");
		 Button button = new Button("Search");
	     Label resultLabel = new Label();
	     textField.setPadding(new Insets(10, 10, 10, 10));
	     textField.setMinSize(100, 20);


	        button.setOnAction(e -> {
	            String input = textField.getText();
	            for (Instructor instructor : instructorsList) {
	                if (instructor.getIdNo().equals(input)) {
	                	
	                	//changes buttons back to normal
	                	saturday.setStyle("");
	                	sunday.setStyle("");
	                	
	                	monday7to8am.setStyle("");
	                	tuesday7to8am.setStyle("");
	                	wednesday7to8am.setStyle("");
	                	thursday7to8am.setStyle("");
	                	friday7to8am.setStyle("");

	                	monday8to12.setStyle("");
	                	tuesday8to12.setStyle("");
	                	wednesday8to12.setStyle("");
	                	thursday8to12.setStyle("");
	                	friday8to12.setStyle("");

	                	monday3to4pm.setStyle("");
	                	tuesday3to4pm.setStyle("");
	                	wednesday3to4pm.setStyle("");
	                	thursday3to4pm.setStyle("");
	                	friday3to4pm.setStyle("");

	                	monday4to6pm.setStyle("");
	                	tuesday4to6pm.setStyle("");
	                	wednesday4to6pm.setStyle("");
	                	thursday4to6pm.setStyle("");
	                	friday4to6pm.setStyle("");

	                	monday6to10pm.setStyle("");
	                	tuesday6to10pm.setStyle("");
	                	wednesday6to10pm.setStyle("");
	                	thursday6to10pm.setStyle("");
	                	friday6to10pm.setStyle("");
	                	//
	                	
	                    resultLabel.setText(instructor.toString());
	                    
	                    //resets labels
	                    name.setText(instructor.getName());
	                    id.setText(instructor.getIdNo());
	                    rank.setText(instructor.getRank());
	                    homeCamp.setText(instructor.getHomeCamp());
	                    prefCamp.setText(instructor.getCampus());
	                    onlineCert.setText(instructor.getOnl());
	                    courses.setText(instructor.getCourses());
	                    secoundCrse.setText(instructor.getSecondCrse());
	                    thirdCrse.setText(instructor.getThirdCrse());
	                    sat.setText(instructor.getSat());
	                    sun.setText(instructor.getSun());
	                    //
	                    
	                    //sun
	                    if(instructor.getSun().equals("Sun")) {
	                    	sunday.setStyle("-fx-background-color: #00FF00"); // Bright green color
	                    }
	                    //mon 7-8am
	                    if(instructor.getAm7to8Days().contains("*") && instructor.getAm7to8Days().contains("M")) {
	                    	monday7to8am.setStyle("-fx-background-color: #00FF00"); // Bright green color
	                    }
	                    // Tuesday 7-8am
	                    if(instructor.getAm7to8Days().contains("*") && instructor.getAm7to8Days().contains("T")) {
	                        tuesday7to8am.setStyle("-fx-background-color: #00FF00"); // Bright green color
	                    }

	                    // Wednesday 7-8am
	                    if(instructor.getAm7to8Days().contains("*") && instructor.getAm7to8Days().contains("W")) {
	                        wednesday7to8am.setStyle("-fx-background-color: #00FF00"); // Bright green color
	                    }
	                    
	                    // have to add condition if only thursday but no tuesday
	                    // Thursday 7-8am
	                    if(instructor.getAm7to8Days().contains("*") && instructor.getAm7to8Days().indexOf("T") != instructor.getAm7to8Days().lastIndexOf("T")) {
	                        thursday7to8am.setStyle("-fx-background-color: #00FF00"); // Bright green color
	                    }

	                    // Friday 7-8am
	                    if(instructor.getAm7to8Days().contains("*") && instructor.getAm7to8Days().contains("F")) {
	                        friday7to8am.setStyle("-fx-background-color: #00FF00"); // Bright green color
	                    }
	                    
	                    //*
	                    // have to fix later to account for broken parts(the columns are alligned very bad have to do if * in or not then seperate if else
	                    //*
	                    
	                    //mon 8-12pm
	                    if(instructor.getAm7to8Days().contains("M")) {
	                    	monday8to12.setStyle("-fx-background-color: #00FF00"); // Bright green color
	                    }

		                 // Tuesday 8-12pm
		                 if(instructor.getAm7to8Days().contains("T")) {
		                     tuesday8to12.setStyle("-fx-background-color: #00FF00"); // Bright green color
		                 }
	
		                 // Wednesday 8-12pm
		                 if(instructor.getAm7to8Days().contains("W")) {
		                     wednesday8to12.setStyle("-fx-background-color: #00FF00"); // Bright green color
		                 }
	
		                 // Thursday 8-12pm
		                 if(instructor.getAm7to8Days().charAt(instructor.getAm7to8Days().length() - 1) == 'T' && instructor.getAm7to8Days().charAt(instructor.getAm7to8Days().length() - 2) == 'T') {
		                	 thursday8to12.setStyle("-fx-background-color: #00FF00"); // Bright green color
		                 }
	
		                 // Friday 8-12pm
		                 if(instructor.getAm7to8Days().contains("F")) {
		                     friday8to12.setStyle("-fx-background-color: #00FF00"); // Bright green color
		                 }
	                    
		                 //mon 3-4pm
		                 if(instructor.getPm3to4Days().contains("*") && instructor.getPm3to4Days().contains("M")) {
		                	 monday3to4pm.setStyle("-fx-background-color: #00FF00"); // Bright green color
		                 }

			              // Tuesday 3-4pm
			              if(instructor.getPm3to4Days().contains("*") && instructor.getPm3to4Days().contains("T")) {
			                  tuesday3to4pm.setStyle("-fx-background-color: #00FF00"); // Bright green color
			              }
	
			              // Wednesday 3-4pm
			              if(instructor.getPm3to4Days().contains("*") && instructor.getPm3to4Days().contains("W")) {
			                  wednesday3to4pm.setStyle("-fx-background-color: #00FF00"); // Bright green color
			              }
	
			              // Thursday 3-4pm
			              if(instructor.getPm3to4Days().length() >= 4 && instructor.getPm3to4Days().charAt(3) == 'T') {
			                  thursday3to4pm.setStyle("-fx-background-color: #00FF00"); // Bright green color
			              }
	
			              // Friday 3-4pm
			              if(instructor.getPm3to4Days().contains("*") && instructor.getPm3to4Days().contains("F")) {
			                  friday3to4pm.setStyle("-fx-background-color: #00FF00"); // Bright green color
			              }
			       
			                 //mon 4-6pm
			                 if(instructor.getPm3to4Days().contains("M")) {
			                	 monday4to6pm.setStyle("-fx-background-color: #00FF00"); // Bright green color
			                 }   

			              // Tuesday 4-6pm
			              if(instructor.getPm3to4Days().contains("T")) {
			                  tuesday4to6pm.setStyle("-fx-background-color: #00FF00"); // Bright green color
			              }

			              // Wednesday 4-6pm
			              if(instructor.getPm3to4Days().contains("W")) {
			                  wednesday4to6pm.setStyle("-fx-background-color: #00FF00"); // Bright green color
			              }

			              // Thursday 4-6pm
			              if(instructor.getPm3to4Days().length() >= 4 && instructor.getPm3to4Days().charAt(3) == 'T') {
			                  thursday4to6pm.setStyle("-fx-background-color: #00FF00"); // Bright green color
			              }

			              // Friday 4-6pm
			              if(instructor.getPm3to4Days().contains("F")) {
			                  friday4to6pm.setStyle("-fx-background-color: #00FF00"); // Bright green color
			              }
			                 
			                 //late after
			              //monday 4 -6pm
			                 if(instructor.getLateAftDays().contains("M")) {
			                	 monday4to6pm.setStyle("-fx-background-color: #00FF00"); // Bright green color
			                 }   
			              // Tuesday 4-6pm
			                 if(instructor.getLateAftDays().contains("T")) {
			                     tuesday4to6pm.setStyle("-fx-background-color: #00FF00"); // Bright green color
			                 }

			                 // Wednesday 4-6pm
			                 if(instructor.getLateAftDays().contains("W")) {
			                     wednesday4to6pm.setStyle("-fx-background-color: #00FF00"); // Bright green color
			                 }

			                 // Thursday 4-6pm
			                 if(instructor.getLateAftDays().length() >= 4 && instructor.getLateAftDays().charAt(3) == 'T') {
			                     thursday4to6pm.setStyle("-fx-background-color: #00FF00"); // Bright green color
			                 }

			                 // Friday 4-6pm
			                 if(instructor.getLateAftDays().contains("F")) {
			                     friday4to6pm.setStyle("-fx-background-color: #00FF00"); // Bright green color
			                 }
			                 
			                 	//eves
				              //monday
			                 if(instructor.getEvesDays().contains("M")) {
			                	 monday6to10pm.setStyle("-fx-background-color: #00FF00"); // Bright green color
			                 }  
			              // Tuesday 6-10pm
			                 if(instructor.getEvesDays().contains("T")) {
			                     tuesday6to10pm.setStyle("-fx-background-color: #00FF00"); // Bright green color
			                 }

			                 // Wednesday 6-10pm
			                 if(instructor.getEvesDays().contains("W")) {
			                     wednesday6to10pm.setStyle("-fx-background-color: #00FF00"); // Bright green color
			                 }

			                 // Thursday 6-10pm
			                 if(instructor.getEvesDays().length() >= 4 && instructor.getEvesDays().charAt(3) == 'T') {
			                     thursday6to10pm.setStyle("-fx-background-color: #00FF00"); // Bright green color
			                 }

			                 // Friday 6-10pm
			                 if(instructor.getEvesDays().contains("F")) {
			                     friday6to10pm.setStyle("-fx-background-color: #00FF00"); // Bright green color
			                 }
			                 
			                 
			                 
		                    //sat
		                    if(instructor.getSat().equals("Sat")) {
		                    	saturday.setStyle("-fx-background-color: #00FF00"); // Bright green color
		                    }
	                    return;
	                }
	            }
	            resultLabel.setText("Instructor with ID " + input + " not found.");
	            
	        });

	        VBox searchBox = new VBox(10);
	        searchBox.getChildren().addAll(textField, button, resultLabel);
		//search end
		
        VBox vbox = new VBox(title, searchBox, displayInstructorBoxTop, week);
        root.setContent(vbox);
		//root.getChildren().add(vbox);
		*/
		//old gui code stop
		
		Parent root = FXMLLoader.load(getClass().getResource("/view/Main.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
