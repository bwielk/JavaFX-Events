package events;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import javax.xml.soap.Text;
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
        String firstName = firstNameField.getText();
        String secondName = secondNameField.getText();
        String address = addressField.getText();
        String town = townField.getText();
        String dob = dobField.getValue().toString();
        System.out.println("Here are your details "
                            + "\nNAME: " + firstName
                            + "\nSURNAME: " + secondName
                            + "\nADDRESS: " + address
                            + "\nTOWN: " + town
                            + "\nDATE OF BIRTH: " + dob);
        firstNameField.clear();
        secondNameField.clear();
        addressField.clear();
        townField.clear();
        dobField.setValue(LocalDate.now());
    }
}
