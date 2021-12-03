package com.example.assignment_3;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.IOException;

/**
 * Class for MainApplication which has methods to start application,checking test_input,entering email and password,checking an email and event handling
 */

public class MainApplication extends Application implements EventHandler<ActionEvent> {
    private static String message ="";
    private static String new_email;
    private static String new_password;
    private static boolean test_input =false;
    TextField email;
    Button button;
    Label title_label;
    Label email_label;
    Label password_label;
    TextField password;

    /**
     *Displays a window which generates text fields to input email and password and button to submit the input
     *
     * @param stage - creates window in JavaFx application
     */
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Registration Page!");
        button =new Button();
        button.setText("Submit");
        button.setOnAction(this);
        email = new TextField();

        title_label = new Label();
        title_label.setText("Register Here!");
        email_label = new Label("Email");
        password=new TextField();
        if(test_input){
            email.setText(new_email);
            password.setText(new_password);
            button.fire();
        }
        password_label= new Label("Password");
        VBox layout = new VBox();
        layout.getChildren().addAll(title_label,email_label,email,password_label,password,button);
        Scene scene = new Scene(layout, 320, 240);
        stage.setScene(scene);
        stage.show();
    }

    /**
     *function to run this JavaFx Application
     *
     */
    public static void main() {
        launch();
    }

    /**
     *Function to be used in test class to see if a particular test function passed
     *
     * @return message - a string saying either error or success
     */
    public static String test_input_response(){
        return message;
    }


    /**
     *function to programmatically enter an email in email text field
     *
     * @param test_email - the email address input to be tested
     */
    public static void enter_email(String test_email){
        test_input=true;
        new_email =test_email;

    }

    /**
     *function to programmatically enter a password in password text field
     *
     * @param test_password - the password input to be tested
     */
    public static void enter_password(String test_password){
        test_input=true;
        new_password=test_password;
    }

    /**
     *function to check if an email address input is well formed
     *
     * @param email_address - the email input that needs to be checked
     */
    public static boolean check_email(String email_address){
        String valid_email_format = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        Pattern email_pattern = Pattern.compile(valid_email_format);
        return email_pattern.matcher(email_address).matches();
    }

    @Override
    /**
     *function to handle events/notifications that occur in the JavaFx Application
     *
     * @param event - a notification that something has happened
     */
    public void handle(ActionEvent event){
        if(event.getSource()==button){
            String characters_pattern = "[*^&@!]";

            Pattern new_pattern = Pattern.compile(characters_pattern);
            Matcher pattern_matcher = new_pattern.matcher(password.getText());
            if(email.getText().isEmpty() || password.getText().isEmpty()){
                message ="Error";
                title_label.setText("Error try entering input again");
            }

            else if(!check_email(email.getText())){
                message ="Error";
                title_label.setText("Error invalid email address");
            }
            else if(password.getText().length() <=6){
                message ="Error";
                title_label.setText("Error password must be at least 7 characters");
            }
            else if(!password.getText().matches(".*[a-zA-Z]+.*")){
                message ="Error";
                title_label.setText("Error password must contain at least one letter");
            }
            else if(!password.getText().matches(".*[0-9]+.*")){
                message ="Error";
                title_label.setText("Error password must contain at least one digit");
            }
            else if(!pattern_matcher.find()){
                message ="Error";
                title_label.setText("Error Password must contain any of *^&@!");
            }
            else {
                title_label.setText("Thanks for your Input");
                message="Success";
            }
        }

    }
}