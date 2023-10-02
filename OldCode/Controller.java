package p1;

import java.util.Iterator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
	
    InstructorList instructorList = InstructorList.getInstance();
   
    @FXML
    private Label DisplayInfoLabel;

    public void initialize() {
        DisplayInfoLabel.setMaxWidth(800);
        DisplayInfoLabel.setWrapText(true);
    }

	
	@FXML
	private TextField idFeild;
	
	@FXML
	private Button Search;
	
	//
	@FXML
	private Button Sun; 
	
	//7to8am
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
	
	//8to12am
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
	
	//12to3pm
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
	
	//3to4pm
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

	//4to6pm
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

	//6to10pm
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
	
	public void Search(ActionEvent e) {
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
		Iterator<Instructor> it = instructorList.getInstructors().iterator();
		while (it.hasNext()) {
		    Instructor instructor = it.next();
		    if (instructor.getIdNo().equals(idFeild.getText())) {
		        // Found the instructor with the target ID
		    	
		    	//Sun
				if(instructor.getSun().equals("Sun")) {
					Sun.setStyle("-fx-background-color: #90EE90");
				}
		    	//7to8
				if(instructor.getSchedule()[0][0] == true ) {
					M7to8.setStyle("-fx-background-color: #90EE90");
				}
				if(instructor.getSchedule()[0][1] == true) {
					T7to8.setStyle("-fx-background-color: #90EE90");
				}
				if(instructor.getSchedule()[0][2] == true) {
					W7to8.setStyle("-fx-background-color: #90EE90");
				}
				if(instructor.getSchedule()[0][3] == true) {
					R7to8.setStyle("-fx-background-color: #90EE90");
				}
				if(instructor.getSchedule()[0][4] == true) {
					F7to8.setStyle("-fx-background-color: #90EE90");
				}

				//8to12 later will have to fix to make it deal with this being in the cell above it because no *
				if(instructor.getSchedule()[1][0] == true ) {
				    M8to12.setStyle("-fx-background-color: #90EE90");
				}
				if(instructor.getSchedule()[1][1] == true) {
				    T8to12.setStyle("-fx-background-color: #90EE90");
				}
				if(instructor.getSchedule()[1][2] == true) {
				    W8to12.setStyle("-fx-background-color: #90EE90");
				}
				if(instructor.getSchedule()[1][3] == true) {
				    R8to12.setStyle("-fx-background-color: #90EE90");
				}
				if(instructor.getSchedule()[1][4] == true) {
				    F8to12.setStyle("-fx-background-color: #90EE90");
				}

				//12to3
				if(instructor.getSchedule()[2][0] == true ) {
				    M12to3.setStyle("-fx-background-color: #90EE90");
				}
				if(instructor.getSchedule()[2][1] == true) {
				    T12to3.setStyle("-fx-background-color: #90EE90");
				}
				if(instructor.getSchedule()[2][2] == true) {
				    W12to3.setStyle("-fx-background-color: #90EE90");
				}
				if(instructor.getSchedule()[2][3] == true) {
				    R12to3.setStyle("-fx-background-color: #90EE90");
				}
				if(instructor.getSchedule()[2][4] == true) {
				    F12to3.setStyle("-fx-background-color: #90EE90");
				}

				//3to4
				if(instructor.getSchedule()[3][0] == true ) {
				    M3to4.setStyle("-fx-background-color: #90EE90");
				}
				if(instructor.getSchedule()[3][1] == true) {
				    T3to4.setStyle("-fx-background-color: #90EE90");
				}
				if(instructor.getSchedule()[3][2] == true) {
				    W3to4.setStyle("-fx-background-color: #90EE90");
				}
				if(instructor.getSchedule()[3][3] == true) {
				    R3to4.setStyle("-fx-background-color: #90EE90");
				}
				if(instructor.getSchedule()[3][4] == true) {
				    F3to4.setStyle("-fx-background-color: #90EE90");
				}

				//4-6
				if(instructor.getSchedule()[4][0] == true ) {
				    M4to6.setStyle("-fx-background-color: #90EE90");
				}
				if(instructor.getSchedule()[4][1] == true ) {
				    T4to6.setStyle("-fx-background-color: #90EE90");
				}
				if(instructor.getSchedule()[4][2] == true ) {
				    W4to6.setStyle("-fx-background-color: #90EE90");
				}
				if(instructor.getSchedule()[4][3] == true ) {
				    R4to6.setStyle("-fx-background-color: #90EE90");
				}
				if(instructor.getSchedule()[4][4] == true ) {
				    F4to6.setStyle("-fx-background-color: #90EE90");
				}
				
				//6-10
				if(instructor.getSchedule()[5][0] == true ) {
				    M6to10.setStyle("-fx-background-color: #90EE90");
				}
				if(instructor.getSchedule()[5][1] == true ) {
				    T6to10.setStyle("-fx-background-color: #90EE90");
				}
				if(instructor.getSchedule()[5][2] == true ) {
				    W6to10.setStyle("-fx-background-color: #90EE90");
				}
				if(instructor.getSchedule()[5][3] == true ) {
				    R6to10.setStyle("-fx-background-color: #90EE90");
				}
				if(instructor.getSchedule()[5][4] == true ) {
				    F6to10.setStyle("-fx-background-color: #90EE90");
				}

				
				//Sat
				if(instructor.getSat().equals("Sat")) {
					Sat.setStyle("-fx-background-color: #90EE90");
				}
				
				DisplayInfoLabel.setText(instructor.toString());
		        break;
		    } else {
		    	DisplayInfoLabel.setText("No instructor with that ID try again");
		    }
		}
		
	}
	
	public void Monday(ActionEvent e) {
		M7to8.setStyle("-fx-background-color: #90EE90");

		System.out.println("Monday 7-8");
	}
}
