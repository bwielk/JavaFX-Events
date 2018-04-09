package events;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class Controller {

    @FXML
    private TextField nameField;
    @FXML
    private Button greetingButton;
    @FXML
    private Button byeButton;

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
}
