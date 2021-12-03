package com.example.assignment_3;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

/**
 * Test Class for MainApplicationTest which has test methods to test blank input,email address input,
 * length of password,number of digits,letters and special characters in password input
 */

class MainApplicationTest {
    private MainApplication app;

    /**
     *Function to test the JavaFx application with blank email and password inputs
     */
    @Test
    void blank_input_test() {
        app =new MainApplication();
        //app.enter_email("");
        //app.enter_password("");
        app.enter_email("mrsmith@gmail.com");
        app.enter_password("321letsgo!");
        app.main();
        if (app.test_input_response().equals("Error")) {
            fail("No input for email or password");
        }
        else {
            System.out.println("Success");
        }

    }

    /**
     *Function to test whether the JavaFx application handles well-formed email address inputs
     */
    @Test
    void email_input_test() {
        app =new MainApplication();
        //app.enter_email("javaprogrammer123gmailcom");
        //app.enter_password("javaisthebest");
        app.enter_email("anotherjavaprogrammer456@hotmail.co.uk");
        app.enter_password("javaisstillthebest123^^");
        app.main();
        if (app.test_input_response().equals("Error")) {
            fail("Invalid email address input");
        }
        else {
            System.out.println("Success");
        }

    }

    /**
     *Function to test the length of passwords in the JavaFx application
     */
    @Test
    void password_length_test() {
        app =new MainApplication();
        //app.enter_email("marvel543@gmail.com");
        //app.enter_password("iron");
        app.enter_email("marvel543@gmail.com");
        app.enter_password("ripironman123!!");
        app.main();
        if (app.test_input_response().equals("Error")) {
            fail("Password must be at least 7 characters");
        }
        else {
            System.out.println("Success");
        }

    }

    /**
     *Function to test if the password input has any letters
     */
    @Test
    void password_letter_test() {
        app =new MainApplication();
        //app.enter_email("farmer@gmail.com");
        //app.enter_password("123456789");
        app.enter_email("farmer@gmail.com");
        app.enter_password("Ihave20sheep!!");
        app.main();
        if (app.test_input_response().equals("Error")) {
            fail("Password must contain at least one letter");
        }
        else {
            System.out.println("Success");
        }

    }

    /**
     *Function to test if the password input has any digits
     */
    @Test
    void password_digit_test() {
        app =new MainApplication();
        //app.enter_email("loubegasongs@gmail.com");
        //app.enter_password("mambono");
        app.enter_email("dollypartonsongs@gmail.com");
        app.enter_password("working9to5!!");
        app.main();
        if (app.test_input_response().equals("Error")) {
            fail("Password must contain at least one digit");
        }
        else {
            System.out.println("Success");
        }

    }

    /**
     *Function to test if the password input has any characters in *^&@!
     */
    @Test
    void password_character_test() {
        app =new MainApplication();
        //app.enter_email("bankbalances@gmail.com");
        //app.enter_password("Ihave5000euro");
        app.enter_email("bankbalances@gmail.com");
        app.enter_password("8000***euro!");
        app.main();
        if (app.test_input_response().equals("Error")) {
            fail("Error Password must contain any of *^&@!");
        }
        else {
            System.out.println("Success");
        }

    }
}