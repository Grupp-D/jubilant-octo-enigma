package FFS;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Login extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Login");
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.4));
        pane.setHgap(5.5);
        pane.setVgap(5.5);
        pane.add(new Label("Användarnamn:"), 0, 0);
        final TextField username = new TextField();
        pane.add(username, 1, 0);
        pane.add(new Label("Lösenord:"), 0, 1);
        final PasswordField password = new PasswordField();
        pane.add(password, 1, 1);
        final Label result = new Label();
        pane.add(result, 0, 2);
        Button testLogin = new Button("Login");
        pane.add(testLogin, 1, 2);
        GridPane.setHalignment(testLogin, HPos.RIGHT);
        Button regestrering = new Button("Registrera");
        pane.add(regestrering,1,2);
        GridPane.setHalignment(regestrering, HPos.LEFT);
        testLogin.setOnAction(e -> {
            if(username.getText().equals("ab111cd@student.lnu.se"))
                result.setText("OK");
            else
                result.setText("No way");
        });
        Scene scene = new Scene(pane);primaryStage.setScene(scene);primaryStage.show();

    }
}
