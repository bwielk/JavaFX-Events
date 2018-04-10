package events;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import java.time.LocalDate;
import java.util.ArrayList;

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
    private ArrayList<Label> feedback = new ArrayList<>();
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
            greetingButton.setDisable(true);
            byeButton.setDisable(true);
        }
        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException e){

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
    public void handleSubmitForm() {
        if(!feedback.isEmpty()) {
           for(int i=0; i<feedback.size(); i++){
               vBoxId.getChildren().remove(feedback.get(i));
           }
        }
        TextField[] formElements = {firstNameField, secondNameField, addressField, townField};
        for(TextField field : formElements){
            if (field.getText().isEmpty() || field.getText().trim().isEmpty()) {
                feedback.add(new Label("Please check if you have filled the " + field.getId() + " field"));
            } else {
                feedback.add(new Label("Your details have been submitted"));
                System.out.println("Here are your details "
                        + "\nNAME: " + firstNameField.getText().trim()
                        + "\nSURNAME: " + secondNameField.getText().trim()
                        + "\nADDRESS: " + addressField.getText().trim()
                        + "\nTOWN: " + townField.getText().trim()
                        + "\nDATE OF BIRTH: " + dobField.getValue().toString());
                for(TextField inputField : formElements){
                    inputField.clear();
                }
                dobField.setValue(LocalDate.now());
            }
        }
        if(!feedback.isEmpty()){
            vBoxId.getChildren().addAll(feedback);
        }
    }
}