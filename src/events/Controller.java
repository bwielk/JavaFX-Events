package events;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;

import java.time.LocalDate;

public class Controller {

    @FXML
    private TextField nameField;
    @FXML
    private Button greetingButton;
    @FXML
    private Button byeButton;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField secondNameField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField townField;
    @FXML
    private DatePicker dobField;
    @FXML
    private VBox vBoxId;
    @FXML
    private Label feedback;


    @FXML
    public void initialize(){
        greetingButton.setDisable(true);
        byeButton.setDisable(true);
    }
    @FXML
    public void onButtonClicked(ActionEvent e){
        if(e.getSource().equals(greetingButton)){
            System.out.println("Hello " + nameField.getText() + "! How are you?");
            System.out.println("The following button was pressed " + e.getSource());
        }else if(e.getSource().equals(byeButton)){
            System.out.println("Bye " + nameField.getText() + "! See you next time!");
            System.out.println("The following button was pressed " + e.getSource());
        }
    }

    @FXML
    public void handleKeyReleased(){
        String text = nameField.getText();
        boolean disabledButton = text.isEmpty() || text.trim().isEmpty();
        greetingButton.setDisable(disabledButton);
        byeButton.setDisable(disabledButton);
    }

    @FXML
    public void handleSubmitForm(){
        if(feedback != null){
            vBoxId.getChildren().remove(feedback);
        }
        String firstName = firstNameField.getText();
        String secondName = secondNameField.getText();
        String address = addressField.getText();
        String town = townField.getText();
        LocalDate dob = dobField.getValue();
        if(firstName.isEmpty() || secondName.isEmpty() || address.isEmpty() || town.isEmpty()){
            feedback = new Label("Please check if you have filled out all the fields");
        }else{
            feedback = new Label("Your details have been submitted");
            System.out.println("Here are your details "
                    + "\nNAME: " + firstName
                    + "\nSURNAME: " + secondName
                    + "\nADDRESS: " + address
                    + "\nTOWN: " + town
                    + "\nDATE OF BIRTH: " + dob.toString());
            firstNameField.clear();
            secondNameField.clear();
            addressField.clear();
            townField.clear();
            dobField.setValue(LocalDate.now());
        }
        vBoxId.getChildren().add(feedback);
    }
}
