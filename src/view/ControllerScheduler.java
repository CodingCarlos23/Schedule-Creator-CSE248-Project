package view;

import java.io.IOException;
import java.util.Iterator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.CourseFreqList;
import model.CourseList;
import model.Instructor;
import model.InstructorList;

public class ControllerScheduler {
	InstructorList instructorList = InstructorList.getInstance();
	CourseList courseList = CourseList.getInstance();
	CourseFreqList courseFreq = CourseFreqList.getInstance();
	Instructor instructor;

	@FXML
	private Label DisplayInfoLabel;

	@FXML
	private Label CourseInfo;
	
	@FXML
	private TextField idFeild;

	@FXML
	private Button Search;    
    
    @FXML
    private Button SwitchToMain;
    
	public void SwitchToMain(ActionEvent event) throws IOException {
		// Load the FXML file for the new scene
		Parent newSceneParent = FXMLLoader.load(getClass().getResource("/view/Main.fxml"));

		// Create a new scene
		Scene newScene = new Scene(newSceneParent);

		// Get the current stage
		Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

		// Set the new scene to the current stage
		currentStage.setScene(newScene);
		currentStage.show();
	}

	public void initialize() {
		//DisplayInfoLabel.setMaxWidth(800);
		DisplayInfoLabel.setWrapText(true);
	}
    
	public void Search(ActionEvent e) {
		Iterator<Instructor> it = instructorList.getInstructors().iterator();
		while (it.hasNext()) {
			instructor = it.next();
			if (instructor.getIdNo().equals(idFeild.getText())) {
				DisplayInfoLabel.setText(instructor.getName() + instructor.getIdNo() + " " + instructor.getCampus());
				CourseInfo.setText(instructor.getClassesAssigned().toString());
				break;
			}
		}
	}
    
}
