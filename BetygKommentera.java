package FFS;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;


public class BetygKommentera extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox vbox = new VBox();
        vbox.setSpacing(3);
        vbox.setPadding(new Insets(5));

        Label betyg = new Label("Sätt ett betyg (1 är lägst, 5 är högst)");
        betyg.setFont(Font.font("Times new roman", FontPosture.ITALIC, 15));
        RadioButton ett = new RadioButton("1");
        RadioButton tva = new RadioButton("2");
        RadioButton tre = new RadioButton("3");
        RadioButton fyra = new RadioButton("4");
        RadioButton fem = new RadioButton("5");
        Label kommentar = new Label("Skriv en kommentar");
        kommentar.setFont(Font.font("Times new roman", FontPosture.ITALIC, 15));
        TextArea kommentarsfalt = new TextArea();
        kommentarsfalt.setMaxSize(300, 400);

        HBox hBox = new HBox();
        hBox.setLayoutY(300);
        Button spara = new Button("Spara");
        Button avbryt = new Button("Avbryt");
        hBox.setSpacing(202); //mellanrum mellan knapparna
        avbryt.setOnAction(e-> {
            primaryStage.close(); //stänger fönstret
        });
        hBox.getChildren().addAll(avbryt, spara);

        vbox.getChildren().addAll(betyg, ett, tva, tre, fyra, fem, kommentar, kommentarsfalt, hBox);
        Scene scene = new Scene(vbox, 310, 370);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Betygsätt & kommentera ett recept");
        primaryStage.show();
    }
}
