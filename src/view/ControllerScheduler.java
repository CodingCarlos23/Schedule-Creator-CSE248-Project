package view;

import java.util.Iterator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import model.Instructor;
import model.InstructorList;

public class ControllerScheduler {
    InstructorList instructorList = InstructorList.getInstance();

    @FXML
    private Button s1;
    
    public void initialize() {
        s1.setText("Your Text");
    }
    
}
