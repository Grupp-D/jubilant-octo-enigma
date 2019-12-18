import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Registrera extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws SQLException, ClassNotFoundException {
        primaryStage.setTitle("Registrera konto");

        // Create the registration form grid pane
        GridPane gridPane = createRegistrationFormPane();
        // Add UI controls to the registration form grid pane
        addUIControls(gridPane);
        // Create a scene with registration form grid pane as the root node
        Scene scene = new Scene(gridPane, 800, 500);
        // Set the scene in primary stage
        primaryStage.setScene(scene);

        primaryStage.show();
    }
    public static Boolean kontroll(String losen) {

        int antsiffror = 0;
        int antspecial = 0;
        int antversal = 0;

        if (losen.length() != 22) {
            return false;
        } else {
            //Kontrollerar ett tecken i taget, adderar in värdet i variabeln
            for (int i = 0; i < losen.length(); i++) {
                if (Character.isDigit(losen.charAt(i))) {
                    antsiffror += 1;
                } else if (!Character.isLetterOrDigit(losen.charAt(i))) {
                    antspecial += 1;
                } else if (Character.isUpperCase(losen.charAt(i))) {
                    antversal += 1;
                }
            }
            //Kontrollerar så minumum har uppfyllts
            if (antsiffror == 3 && antspecial == 3 && antversal < 1) {
                return true;
            } else {
                return false;
            }
        }
    }



    private GridPane createRegistrationFormPane() {
        // Instantiate a new Grid Pane
        GridPane gridPane = new GridPane();

        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        gridPane.setHgap(10);

        // Set the vertical gap between rows
        gridPane.setVgap(10);

        // Add Column Constraints

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200, 200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }

    private void addUIControls(GridPane gridPane) throws SQLException, ClassNotFoundException {
        // Add Header
        javafx.scene.control.Label headerLabel = new javafx.scene.control.Label("Registrera konto");
        //headerLabel.setFont("Arial", FontWeight.BOLD, 24);
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 15));

        //t.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));
        gridPane.add(headerLabel, 0, 0, 2, 1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));

                /*
                // Add Name Label
                javafx.scene.control.Label nameLabel = new javafx.scene.control.Label("Full Name : ");
                gridPane.add(nameLabel, 0,1);
                // Add Name Text Field
                javafx.scene.control.TextField nameField = new javafx.scene.control.TextField();
                nameField.setPrefHeight(40);
                gridPane.add(nameField, 1,1);
                 */


        // Add Email Label
        javafx.scene.control.Label emailLabel = new javafx.scene.control.Label("Email : ");
        gridPane.add(emailLabel, 0, 2);

        // Add Email Text Field
        javafx.scene.control.TextField emailField = new javafx.scene.control.TextField();
        emailField.setPrefHeight(40);
        gridPane.add(emailField, 1, 2);

        // Add Password Label
        javafx.scene.control.Label passwordLabel = new javafx.scene.control.Label("Lösenord : ");
        gridPane.add(passwordLabel, 0, 3);

        // Add Password Field
        PasswordField passwordField = new PasswordField();
        passwordField.setPrefHeight(40);
        gridPane.add(passwordField, 1, 3);

        // Add Submit Button
        javafx.scene.control.Button submitButton = new Button("Skapa");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(submitButton, 0, 4, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0, 20, 0));


        submitButton.setOnAction(new EventHandler<ActionEvent>() {




            @Override
            public void handle(ActionEvent event) {



                       /* if(nameField.getText().isEmpty()) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Meddelande");
                            alert.setHeaderText("Berkäknat värde");
                            alert.showAndWait();
                          /*
                            showAlert(Alert);.AlertType.ERROR);//, gridPane.getScene().getWindow(), "Form Error!", "Please enter your name");
                            return;}
                           */

                if (emailField.getText().isEmpty()) {
                            /*showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your email id");
                            return;
                             */
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Meddelande");
                    alert.setHeaderText("Du har inte fyllt i någon mailadress");
                    alert.showAndWait();
                } else if (passwordField.getText().isEmpty()) {
                            /*showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter a password");
                            return;
                             */
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Meddelande");
                    alert.setHeaderText("Du har inte fyllt i något lösenord");
                    alert.showAndWait();
                } else if (emailField.getText().length() != 22) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Meddelande");
                    alert.setHeaderText("Du har inte fyllt i en LNU-Emailadess");
                    alert.showAndWait();

                    // } else if (kontroll(passwordField) ==true){
                }else {Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Meddelande");
                    alert.setHeaderText("Du har skapat ett konto!");
                    alert.showAndWait();

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException ex) {
                    System.out.println("Driver not loaded");
                }
                try (
                        Connection conn = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/ffs?useSSL=false",
                                "root", "123456"
                        )){
                    PreparedStatement ReggaKonto= conn.prepareStatement("insert into konto values (?,?)");
                    ReggaKonto.setString(1, emailField.getText());
                    ReggaKonto.setString(2, passwordField.getText());
                    ReggaKonto.executeUpdate();

                }catch (SQLException o) {
                    o.printStackTrace();

                }
                emailField.setText("");
                passwordField.setText("");


                }
            }
        });
    }
}
