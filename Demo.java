package p1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Demo extends Application {

	public static void main(String[] args) {

		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		// code for data
		String csvFile = "C:\\Users\\carlo\\Desktop\\Instructors.csv";
		String line = "";
		String cvsSplitBy = "\t";
		boolean found = false;
		int count = 0;
		TreeSet<Instructor> instructorsList = new TreeSet<>(); // tree set is good for large data and finds things fast
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
								list.get(0)[7], 
								list.get(1)[6], 
								list.get(0)[8], 
								list.get(0)[9] + " " + list.get(1)[8],
								list.get(0)[10], 
								sat, //sat
								sun, //sun
								list.get(0)[12], //late aftdays
								list.get(0)[13],//evesdays
								list.get(0)[14], //int
								list.get(0)[15]); //fallwork
						instructorsList.add(instructor);
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
		for (Instructor instructor : instructorsList) {
			System.out.println(instructor);
		}

		int size = instructorsList.size();
		System.out.println("The size of the TreeSet is: " + size);

		// code for GUI
		primaryStage.setTitle("Hello World!");
		StackPane root = new StackPane();
		List<Node> list = new ArrayList<>();
		VBox displayInstructorBoxTop = new VBox();
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

		root.getChildren().add(displayInstructorBoxTop);

		Scene scene = new Scene(root, 300, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
