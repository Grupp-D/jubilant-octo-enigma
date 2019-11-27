package FFS;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;

public class ReceptRuta extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(5));

        VBox vbox = new VBox();
        vbox.setSpacing(2);

        Label rubrikRecept = new Label("Rubrik");
        TextField textFieldRubrik = new TextField();
        textFieldRubrik.setPrefWidth(380);

        Label ingredienser = new Label("Ingredienser");
        TextArea textAreaIngredienser = new TextArea();
        textAreaIngredienser.setMaxSize(200, 200);

       VBox sk = new VBox();
       Label specialkost = new Label("Allergier/Specialkost");
       CheckBox laktosfritt = new CheckBox("Laktosfritt");
       CheckBox glutenfritt = new CheckBox("Glutenfritt");
       CheckBox vegetariskt = new CheckBox("Vegetariskt");
       sk.getChildren().addAll(specialkost, laktosfritt, glutenfritt, vegetariskt);
       sk.setTranslateX(-170);
       sk.setTranslateY(467);

        Label beskrivning = new Label("Beskrivning");
        Label angeVart = new Label("Glöm inte berätta vart du köpt dina varor!");
        angeVart.setFont(Font.font("Times new roman", FontPosture.ITALIC, 12));
        TextArea textFieldBeskrivning = new TextArea();
        textFieldBeskrivning.setMaxSize(380, 400);

        VBox prisintervall = new VBox();
        Label pris = new Label("Prisintervall för receptet");
        RadioButton nollhundra = new RadioButton("0-100 kr");
        RadioButton hundratvahundra = new RadioButton("100-200 kr");
        RadioButton tvahundratrehundra = new RadioButton("200-300 kr");
        RadioButton trehundrafyrahundra = new RadioButton("300-400 kr");
        RadioButton fyrahundrafemhundra = new RadioButton("400-500 kr");
        RadioButton femhundraellermer = new RadioButton("500 kr eller mer");
        ToggleGroup group = new ToggleGroup();
        nollhundra.setToggleGroup(group);
        hundratvahundra.setToggleGroup(group);
        tvahundratrehundra.setToggleGroup(group);
        trehundrafyrahundra.setToggleGroup(group);
        fyrahundrafemhundra.setToggleGroup(group);
        femhundraellermer.setToggleGroup(group);
        prisintervall.getChildren().addAll(nollhundra, hundratvahundra, tvahundratrehundra, trehundrafyrahundra, fyrahundrafemhundra, femhundraellermer);

        vbox.getChildren().addAll(rubrikRecept, textFieldRubrik, ingredienser, textAreaIngredienser, beskrivning, angeVart, textFieldBeskrivning, pris, prisintervall);

        HBox sparaavbryt = new HBox();
        sparaavbryt.setSpacing(20);
        Button spara = new Button("Spara");
        Button avbryt = new Button("Avbryt");
        sparaavbryt.getChildren().addAll(spara, avbryt);

        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(vbox);
        borderPane.setBottom(sparaavbryt);


        hbox.getChildren().addAll(borderPane, sk);
        Scene scene = new Scene(hbox, 500, 630);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Skapa nytt recept");
        primaryStage.show();

    }
}
