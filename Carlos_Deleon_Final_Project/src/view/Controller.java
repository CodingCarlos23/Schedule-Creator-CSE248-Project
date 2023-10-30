package view;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import javafx.scene.Node;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.CourseFreqList;
import model.CourseList;
import model.Instructor;
import model.InstructorList;
import util.Backup;
import util.Tools;

public class Controller {

	InstructorList instructorList = InstructorList.getInstance();
	CourseList courseList = CourseList.getInstance();
	CourseFreqList courseFreq = CourseFreqList.getInstance();
    LinkedList<String> senorityList = Tools.getSeniorityList();
    
	Instructor instructor;

	@FXML
	private Label RecommendedCourse;

	@FXML
	private Label DisplayInfoLabel;

	@FXML
	private Label CourseFreq;
	
	public void initialize() {
		DisplayInfoLabel.setMaxWidth(800);
		DisplayInfoLabel.setWrapText(true);
		
		
//	    for(int i = 0; i < senorityList.size(); i++) {
//
//	    	System.out.println("It worked" + instructor);
//	    	
//	    }
		
	}

	@FXML
	private TextField idFeild;

	@FXML
	private Button Search;

	@FXML
	private TextField crnFeild;
	
	@FXML
	private Button crnAssign;
	
	//
	@FXML
	private Button Sun;

	// 7to8am
	@FXML
	private Button M7to8;
	@FXML
	private Button T7to8;
	@FXML
	private Button W7to8;
	@FXML
	private Button R7to8;
	@FXML
	private Button F7to8;

	// 8to12am
	@FXML
	private Button M8to12;
	@FXML
	private Button T8to12;
	@FXML
	private Button W8to12;
	@FXML
	private Button R8to12;
	@FXML
	private Button F8to12;

	// 12to3pm
	@FXML
	private Button M12to3;
	@FXML
	private Button T12to3;
	@FXML
	private Button W12to3;
	@FXML
	private Button R12to3;
	@FXML
	private Button F12to3;

	// 3to4pm
	@FXML
	private Button M3to4;
	@FXML
	private Button T3to4;
	@FXML
	private Button W3to4;
	@FXML
	private Button R3to4;
	@FXML
	private Button F3to4;

	// 4to6pm
	@FXML
	private Button M4to6;
	@FXML
	private Button T4to6;
	@FXML
	private Button W4to6;
	@FXML
	private Button R4to6;
	@FXML
	private Button F4to6;

	// 6to10pm
	@FXML
	private Button M6to10;
	@FXML
	private Button T6to10;
	@FXML
	private Button W6to10;
	@FXML
	private Button R6to10;
	@FXML
	private Button F6to10;

	//
	@FXML
	private Button Sat;

	public void schedulerView(ActionEvent event) throws IOException {
		// Load the FXML file for the new scene
		Parent newSceneParent = FXMLLoader.load(getClass().getResource("/view/Scheduler.fxml"));

		// Create a new scene
		Scene newScene = new Scene(newSceneParent);

		// Get the current stage
		Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

		// Set the new scene to the current stage
		currentStage.setScene(newScene);
		currentStage.show();
	}

	public void Search(ActionEvent e) {
//		System.out.println("THIS" + instructorList);
//		System.out.println(instructorList.getInstructors().first().getName());
		Sun.setStyle("");
		M7to8.setStyle("");
		T7to8.setStyle("");
		W7to8.setStyle("");
		R7to8.setStyle("");
		F7to8.setStyle("");
		M8to12.setStyle("");
		T8to12.setStyle("");
		W8to12.setStyle("");
		R8to12.setStyle("");
		F8to12.setStyle("");
		M12to3.setStyle("");
		T12to3.setStyle("");
		W12to3.setStyle("");
		R12to3.setStyle("");
		F12to3.setStyle("");
		M3to4.setStyle("");
		T3to4.setStyle("");
		W3to4.setStyle("");
		R3to4.setStyle("");
		F3to4.setStyle("");
		M4to6.setStyle("");
		T4to6.setStyle("");
		W4to6.setStyle("");
		R4to6.setStyle("");
		F4to6.setStyle("");
		M6to10.setStyle("");
		T6to10.setStyle("");
		W6to10.setStyle("");
		R6to10.setStyle("");
		F6to10.setStyle("");
		Sat.setStyle("");
	    boolean instructorFound = false; // Flag to check if any instructor was found

//	    for(int i = 0; i < senorityList.size(); i++) {
//	    	System.out.println(senorityList.get(i));
//	    }
	    
	    
		Iterator<Instructor> it = instructorList.getInstructors().iterator();
		while (it.hasNext()) {
			
			
			instructor = it.next();
			if (instructor.getIdNo().equals(idFeild.getText())) {
				// Found the instructor with the target ID
	            instructorFound = true; // Set the flag to true

				// Sun
				if (instructor.getSun().equals("Sun")) {
					Sun.setStyle("-fx-background-color: #90EE90");
				}
				// 7to8
				if (instructor.getSchedule()[0][0] == true) {
					M7to8.setStyle("-fx-background-color: #90EE90");
				}
				if (instructor.getSchedule()[0][1] == true) {
					T7to8.setStyle("-fx-background-color: #90EE90");
				}
				if (instructor.getSchedule()[0][2] == true) {
					W7to8.setStyle("-fx-background-color: #90EE90");
				}
				if (instructor.getSchedule()[0][3] == true) {
					R7to8.setStyle("-fx-background-color: #90EE90");
				}
				if (instructor.getSchedule()[0][4] == true) {
					F7to8.setStyle("-fx-background-color: #90EE90");
				}

				// 8to12 later will have to fix to make it deal with this being in the cell
				// above it because no *
				if (instructor.getSchedule()[1][0] == true) {
					M8to12.setStyle("-fx-background-color: #90EE90");
				}
				if (instructor.getSchedule()[1][1] == true) {
					T8to12.setStyle("-fx-background-color: #90EE90");
				}
				if (instructor.getSchedule()[1][2] == true) {
					W8to12.setStyle("-fx-background-color: #90EE90");
				}
				if (instructor.getSchedule()[1][3] == true) {
					R8to12.setStyle("-fx-background-color: #90EE90");
				}
				if (instructor.getSchedule()[1][4] == true) {
					F8to12.setStyle("-fx-background-color: #90EE90");
				}

				// 12to3
				if (instructor.getSchedule()[2][0] == true) {
					M12to3.setStyle("-fx-background-color: #90EE90");
				}
				if (instructor.getSchedule()[2][1] == true) {
					T12to3.setStyle("-fx-background-color: #90EE90");
				}
				if (instructor.getSchedule()[2][2] == true) {
					W12to3.setStyle("-fx-background-color: #90EE90");
				}
				if (instructor.getSchedule()[2][3] == true) {
					R12to3.setStyle("-fx-background-color: #90EE90");
				}
				if (instructor.getSchedule()[2][4] == true) {
					F12to3.setStyle("-fx-background-color: #90EE90");
				}

				// 3to4
				if (instructor.getSchedule()[3][0] == true) {
					M3to4.setStyle("-fx-background-color: #90EE90");
				}
				if (instructor.getSchedule()[3][1] == true) {
					T3to4.setStyle("-fx-background-color: #90EE90");
				}
				if (instructor.getSchedule()[3][2] == true) {
					W3to4.setStyle("-fx-background-color: #90EE90");
				}
				if (instructor.getSchedule()[3][3] == true) {
					R3to4.setStyle("-fx-background-color: #90EE90");
				}
				if (instructor.getSchedule()[3][4] == true) {
					F3to4.setStyle("-fx-background-color: #90EE90");
				}

				// 4-6
				if (instructor.getSchedule()[4][0] == true) {
					M4to6.setStyle("-fx-background-color: #90EE90");
				}
				if (instructor.getSchedule()[4][1] == true) {
					T4to6.setStyle("-fx-background-color: #90EE90");
				}
				if (instructor.getSchedule()[4][2] == true) {
					W4to6.setStyle("-fx-background-color: #90EE90");
				}
				if (instructor.getSchedule()[4][3] == true) {
					R4to6.setStyle("-fx-background-color: #90EE90");
				}
				if (instructor.getSchedule()[4][4] == true) {
					F4to6.setStyle("-fx-background-color: #90EE90");
				}

				// 6-10
				if (instructor.getSchedule()[5][0] == true) {
					M6to10.setStyle("-fx-background-color: #90EE90");
				}
				if (instructor.getSchedule()[5][1] == true) {
					T6to10.setStyle("-fx-background-color: #90EE90");
				}
				if (instructor.getSchedule()[5][2] == true) {
					W6to10.setStyle("-fx-background-color: #90EE90");
				}
				if (instructor.getSchedule()[5][3] == true) {
					R6to10.setStyle("-fx-background-color: #90EE90");
				}
				if (instructor.getSchedule()[5][4] == true) {
					F6to10.setStyle("-fx-background-color: #90EE90");
				}

				// Sat
				if (instructor.getSat().equals("Sat")) {
					Sat.setStyle("-fx-background-color: #90EE90");
				}

				String classesWanted;
				if(instructor.getThirdCrse().contains("Y")) {
					classesWanted = "3";
				} else if (instructor.getSecondCrse().contains("Y")) {
					classesWanted = "2";
				} else {
					classesWanted ="1";
				}
				String info = instructor.getName() + " " + instructor.getIdNo() + " Courses currently assigned: " + instructor.getClassesAssigned().size() + " Courses they want: " + classesWanted + " " + instructor.getCampus() + " " + instructor.getAm7to8Days() + " " + instructor.getAm8to12pm() + " " + instructor.getPm12to3() + " " +  instructor.getPm3to4Days() + " " + instructor.getLateAftDays() + " " + instructor.getEvesDays() + " " + instructor.getCourses() + " " + instructor.getClassesAssigned();
				DisplayInfoLabel.setText(info.toString());

				for(int i = 0; i < courseFreq.getCourses().size(); i++) {
					if(courseFreq.getCourses().get(i).get(0).contains(instructor.getIdNo())) {
						CourseFreq.setText("Courses taught before: " + courseFreq.getCourses().get(i).get(10));
					}
				}

				LinkedList<String> courseAvailable = new LinkedList<String>();
				for (int i = 0; i < courseList.getCourses().size(); i++) {
						

					if(courseList.getCourses().get(i).getAssignedInstructor() == null) {
						if(instructor.getCourses().contains(courseList.getCourses().get(i).getCourseNumber())) {// and courseList course assinged is Null						
							
							boolean containsAllDays = true;
							if(courseList.getCourses().get(i).getDaysOffered().contains("M")) {
								if(instructor.getSchedule()[0][0] == true || instructor.getSchedule()[1][0] == true || instructor.getSchedule()[2][0] == true || instructor.getSchedule()[3][0] == true || instructor.getSchedule()[4][0] == true || instructor.getSchedule()[5][0] == true) {
									
								} else {
									containsAllDays = false;
								}
							}
							if(courseList.getCourses().get(i).getDaysOffered().contains("T")) {
								if(instructor.getSchedule()[0][1] == true || instructor.getSchedule()[1][1] == true || instructor.getSchedule()[2][1] == true || instructor.getSchedule()[3][1] == true || instructor.getSchedule()[4][1] == true || instructor.getSchedule()[5][1] == true) {
									
								} else {
									containsAllDays = false;
								}
							}
							if(courseList.getCourses().get(i).getDaysOffered().contains("W")) {
								if(instructor.getSchedule()[0][2] == true || instructor.getSchedule()[1][2] == true || instructor.getSchedule()[2][2] == true || instructor.getSchedule()[3][2] == true || instructor.getSchedule()[4][2] == true || instructor.getSchedule()[5][2] == true) {
									
								} else {
									containsAllDays = false;
								}
							}
							if(courseList.getCourses().get(i).getDaysOffered().contains("R")) {
								if(instructor.getSchedule()[0][3] == true || instructor.getSchedule()[1][3] == true || instructor.getSchedule()[2][3] == true || instructor.getSchedule()[3][3] == true || instructor.getSchedule()[4][3] == true || instructor.getSchedule()[5][3] == true) {
									
								} else {
									containsAllDays = false;
								}
							}
							if(courseList.getCourses().get(i).getDaysOffered().contains("F")) {
								if(instructor.getSchedule()[0][4] == true || instructor.getSchedule()[1][4] == true || instructor.getSchedule()[2][4] == true || instructor.getSchedule()[3][4] == true || instructor.getSchedule()[4][4] == true || instructor.getSchedule()[5][4] == true) {
									
								} else {
									containsAllDays = false;
								}
							}
							if(courseList.getCourses().get(i).getDaysOffered().contains("S")) {
								if(instructor.getSat().contains("Sat")) {
									
								} else {
									containsAllDays = false;
								}
							}
							if(courseList.getCourses().get(i).getDaysOffered().contains("U")) {
								if(instructor.getSat().contains("Sun")) {
									
								} else {
									containsAllDays = false;
								}
							}
							if(containsAllDays == true) {
								courseAvailable.add("| " + courseList.getCourses().get(i).getCourseNumber() + " " + courseList.getCourses().get(i).getDaysOffered() + " " + courseList.getCourses().get(i).getBeginTime()+ " " + courseList.getCourses().get(i).getEndTime() + " " + courseList.getCourses().get(i).getCRN() + " |");
							}
						}
							
						}


						

				}
				
				RecommendedCourse.setText(courseAvailable.toString());
				break;
			}
		}
		
	    // Check if any instructor was found
	    if (!instructorFound) {
	        DisplayInfoLabel.setText("No instructor found");
	        RecommendedCourse.setText(""); // Clear the recommended course text
	    }
	}
	
	public void crnAssign(ActionEvent e) {
		for (int i = 0; i < courseList.getCourses().size(); i++) {
			if(courseList.getCourses().get(i).getCRN().contains(crnFeild.getText())) {
				courseList.getCourses().get(i).setAssignedInstructor(instructor.getName());
		        instructor.getClassesAssigned().add(courseList.getCourses().get(i));
		        
		        Backup.backupInstructors(instructorList);
				Backup.backupCourses(courseList);
				instructorList.setInstance(instructorList);
				courseList.setInstance(courseList);
				RecommendedCourse.setText(instructor.getClassesAssigned().toString()); 
			}
		}
		
	}
	
}
