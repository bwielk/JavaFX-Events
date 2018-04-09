package events;

import javafx.fxml.FXML;
import javafx.scene.control.*;
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
    private CheckBox clearTextCheckBox;


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
    public void handleChange(){
        System.out.println("The checkbox is " + (clearTextCheckBox.isSelected() ? "CHECKED" : "UNCHECKED"));
        if(clearTextCheckBox.isSelected()){
            nameField.clear();
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
        if(     (firstName.isEmpty() || firstName.trim().isEmpty()) ||
                (secondName.isEmpty() || secondName.trim().isEmpty()) ||
                (address.isEmpty() || address.trim().isEmpty()) ||
                (town.isEmpty() || town.trim().isEmpty())){
            feedback = new Label("Please check if you have filled out all the fields");
        }else{
            feedback = new Label("Your details have been submitted");
            System.out.println("Here are your details "
                    + "\nNAME: " + firstName.trim()
                    + "\nSURNAME: " + secondName.trim()
                    + "\nADDRESS: " + address.trim()
                    + "\nTOWN: " + town.trim()
                    + "\nDATE OF BIRTH: " + dob.toString().trim());
            firstNameField.clear();
            secondNameField.clear();
            addressField.clear();
            townField.clear();
            dobField.setValue(LocalDate.now());
        }
        vBoxId.getChildren().add(feedback);
    }
}
