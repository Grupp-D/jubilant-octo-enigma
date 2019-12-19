//Nu fungerar avbryt-knapparna på rutorna, så när man klickar på avbryt så stängs pop-up fönstret men förstasidan är kvar.
package FFS;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;

public class ForstaSidaInloggad extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane group=new Pane();

        //bakgrund
        group.setBackground(new Background(new BackgroundImage(new Image(new FileInputStream("C:\\Users\\matil\\IdeaProjects\\1ik153\\bgrecept.jpg")),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(1400, 1111, true, true, true, true))));

        //Titel
        Label sidoNamn =new Label("Food For Students");
        sidoNamn.setFont(Font.font("Helvetica", FontWeight.BOLD, FontPosture.ITALIC, 80));
        sidoNamn.setTextFill(Color.SEAGREEN); //lightblue
        sidoNamn.setLayoutX(500);
        sidoNamn.setLayoutY(10);
        DropShadow dropShadow=new DropShadow();
        dropShadow.setOffsetX(6.0f);
        dropShadow.setOffsetY(4.0f);
        dropShadow.setColor(Color.rgb(50,50,50,.588));
        sidoNamn.setEffect(dropShadow);

        //listview
        ListView listView=new ListView();
        listView.setPrefWidth(220);
        listView.setLayoutX(1300);
        listView.setScaleY(8);
        listView.setPrefHeight(160);
        ScrollPane scrollPane= new ScrollPane();
        scrollPane.setPrefSize(120,120);
        scrollPane.setContent(listView);

        //Knappar
        Button button= new Button();
        button.setText("Logga ut");
        button.setTextFill(Color.LIGHTBLUE);
        button.setLayoutX(1100);
        button.setLayoutY(200);
        button.setPrefHeight(30);
        button.setTextFill(Color.GREEN);
        button.setFont(Font.font(20));
        button.setStyle("-fx-border-color: green;");
        button.setStyle("-fx-border-width: 10 20 20 10;");

        Button button2= new Button();
        button2.setText("Skapa nytt recept");
        button2.setTextFill(Color.LIGHTBLUE);
        button2.setLayoutX(1100);
        button2.setLayoutY(50);
        button2.setPrefHeight(30);
        button2.setPrefWidth(200);
        button2.setTextFill(Color.GREEN);
        button2.setFont(Font.font(20));
        button2.setStyle("-fx-border-color: green;");
        button2.setStyle("-fx-border-width: 10 20 20 10;");

        Button button3= new Button();
        button3.setText("Min profil");
        button3.setTextFill(Color.LIGHTBLUE);
        button3.setLayoutX(1100);
        button3.setLayoutY(170);
        button3.setPrefHeight(30);
        button3.setPrefWidth(120);
        button3.setTextFill(Color.GREEN);
        button3.setFont(Font.font(20));
        button3.setStyle("-fx-border-color: blue;");
        button3.setStyle("-fx-border-width: 10 20 20 10;");

        Button button4 = new Button();
        button4.setText("Lägg till kampanj");
        button4.setLayoutX(100);
        button4.setLayoutY(-100);
        button4.setPrefHeight(20);
        button4.setPrefWidth(140);
        button4.setTextFill(Color.GREEN);
        button4.setFont(Font.font(11));
        button4.setStyle("-fx-border-color: blue;");
        button4.setStyle("-fx-border-width: 10 20 20 10;");

        button2.setOnAction(eh -> { //om man klickar på skapa nytt recept
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
            ToggleGroup groupp = new ToggleGroup();
            nollhundra.setToggleGroup(groupp);
            hundratvahundra.setToggleGroup(groupp);
            tvahundratrehundra.setToggleGroup(groupp);
            trehundrafyrahundra.setToggleGroup(groupp);
            fyrahundrafemhundra.setToggleGroup(groupp);
            femhundraellermer.setToggleGroup(groupp);
            prisintervall.getChildren().addAll(nollhundra, hundratvahundra, tvahundratrehundra, trehundrafyrahundra, fyrahundrafemhundra, femhundraellermer);

            vbox.getChildren().addAll(rubrikRecept, textFieldRubrik, ingredienser, textAreaIngredienser, beskrivning, angeVart, textFieldBeskrivning, pris, prisintervall);

            HBox sparaavbryt = new HBox();
            sparaavbryt.setSpacing(20);
            Button spara = new Button("Spara");
            Button avbryt = new Button("Avbryt");
            sparaavbryt.getChildren().addAll(spara, avbryt);

            FileChooser fileChooser = new FileChooser();

            Button buttonn = new Button("Välj bild att ladda upp");
            buttonn.setOnAction(e -> {
                File selectedFile = fileChooser.showOpenDialog(primaryStage);
            });

            BorderPane borderPane = new BorderPane();
            borderPane.setLeft(vbox);
            borderPane.setBottom(sparaavbryt);
            borderPane.setTop(buttonn);
            BorderPane.setAlignment(buttonn, Pos.TOP_CENTER);

            hbox.getChildren().addAll(borderPane, sk);
            Scene scene = new Scene(hbox, 500, 630);
            Stage window1 = new Stage();
            window1.setScene(scene);
            window1.show();

            avbryt.setOnAction(e-> { //klick på avbrytknapp = fönstret stängs
                window1.close();
            });
        });

        button4.setOnAction(e-> { //om man vill lägga till ny kampanj
            GridPane pane = new GridPane();
            pane.setHgap(5.5);
            pane.setVgap(5.5);
            pane.setAlignment(Pos.CENTER);

            javafx.scene.control.Label headerlabel = new javafx.scene.control.Label("Lägg till kampanj");
            headerlabel.setFont(Font.font("Arial", FontWeight.BLACK, 24));

            pane.add(headerlabel, 0, 0);
            GridPane.setHalignment(headerlabel, HPos.CENTER);
            GridPane.setMargin(headerlabel, new Insets(20, 0, 20, 0));

            //kortfattad beskrivning
            pane.add(new Label("Kortfattad beskrivning (tex. Kycklingfilé för 79kr/kg)"), 0, 1);
            final TextField beskrivning = new TextField();
            pane.add(beskrivning, 0, 2);

            //Butik
            pane.add(new Label("Butik & stad - som har kampanjen"), 0, 4);
            final TextField butik = new TextField();
            pane.add(butik, 0, 5);

            // avbryt button
            Button avbrytknapp = new Button("Avbryt");
            avbrytknapp.setPrefHeight(20);
            avbrytknapp.setDefaultButton(true);
            avbrytknapp.setPrefWidth(60);
            pane.add(avbrytknapp, 0, 6);
            pane.setHalignment(avbrytknapp, HPos.LEFT);

            // spara button
            Button sparaknapp = new Button("Spara");
            sparaknapp.setPrefHeight(20);
            sparaknapp.setDefaultButton(true);
            sparaknapp.setPrefWidth(60);
            pane.add(sparaknapp, 0, 6);
            pane.setHalignment(sparaknapp, HPos.RIGHT);

            sparaknapp.setOnAction(ee -> {
                if (beskrivning.getText().isEmpty())
                {
                    Alert bskalert = new Alert(Alert.AlertType.INFORMATION);
                    bskalert.setTitle("Meddelande");
                    bskalert.setHeaderText("Det saknas beskrivning");
                    bskalert.showAndWait();
                }
                else if (butik.getText().isEmpty())
                {
                    Alert btkalert = new Alert(Alert.AlertType.INFORMATION);
                    btkalert.setTitle("Meddelande");
                    btkalert.setHeaderText("Det saknas butik & stad");
                    btkalert.showAndWait();
                }
                else
                {
                    Alert spalert = new Alert(Alert.AlertType.CONFIRMATION);
                    spalert.setTitle("Spara");
                    spalert.setHeaderText("Är du säker på att du vill publicera?");
                    spalert.showAndWait();
                }

            });

            Scene scene = new Scene(pane, 500, 300);
            Stage window = new Stage();
            window.setScene(scene);
            window.show();

            avbrytknapp.setOnAction(eee -> {
                window.close();
            });
        });

        //Dropshadow
        DropShadow dropShadow2 = new DropShadow();
        dropShadow2.setOffsetX(0.0);
        dropShadow2.setOffsetY(0.0);
        dropShadow2.setColor(Color.LIGHTGRAY);
        button.setEffect(dropShadow2);
        button2.setEffect(dropShadow2);
        button3.setEffect(dropShadow2);
        button4.setEffect(dropShadow2);

        //rundade kanter på knapparna
        button.setStyle("-fx-background-radius: 30");
        button2.setStyle("-fx-background-radius: 30");
        button3.setStyle("-fx-background-radius: 30");
        button4.setStyle("-fx-background-radius: 30");


        listView.getItems().addAll("Knapp");

        FlowPane flowPane=new FlowPane();
        flowPane.getChildren().addAll(button, button2,button3);
        flowPane.setPrefWidth(200);
        flowPane.setLayoutX(930);
        flowPane.setLayoutY(140);
        flowPane.setVgap(50);
        //button2.setMinWidth(flowPane.getPrefWidth());
        flowPane.setAlignment(Pos.CENTER); //centrerar knapparna

        HBox hBox = new HBox();
        hBox.setLayoutX(505);
        hBox.setLayoutY(150);
        TextField sokRuta = new TextField("Skriv in sökord här...");
        sokRuta.setPrefWidth(350);
        hBox.getChildren().add(sokRuta);


        //nya recept-flödet
        VBox vBox = new VBox();
        Label nyaRecept = new Label("Nya recept");
        nyaRecept.setFont(Font.font("Helvetica", FontWeight.BOLD,20));
        nyaRecept.setTextFill(Color.SEAGREEN); //lightcoral
        nyaRecept.setEffect(dropShadow2);
        vBox.setLayoutX(500);
        vBox.setLayoutY(195);
        ScrollPane beskrivningtextarea = new ScrollPane();
        vBox.setPadding(new Insets(5)); //padding för bättre utseende
        beskrivningtextarea.setPrefWidth(350);
        beskrivningtextarea.setPrefHeight(400);
        //nedan sätter så texten inuti anpassas till storleken ovan
        beskrivningtextarea.setFitToWidth(true);
        beskrivningtextarea.setFitToHeight(true);
        beskrivningtextarea.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        vBox.getChildren().addAll(nyaRecept,beskrivningtextarea);

        //kampanjrutan
        VBox vbox1 = new VBox();
        vbox1.setLayoutY(390);
        vbox1.setLayoutX(960);
        ScrollPane kampanjrutan = new ScrollPane();
        vbox1.setPadding(new Insets(5));
        vbox1.setSpacing(5);
        kampanjrutan.setPrefWidth(140);
        kampanjrutan.setPrefHeight(170);
        kampanjrutan.setFitToWidth(true);
        kampanjrutan.setFitToHeight(true);
        Label aktuellaKampanjer = new Label("Aktuella kampanjer");
        aktuellaKampanjer.setFont(Font.font("Helvetica", FontWeight.BOLD,14));
        aktuellaKampanjer.setTextFill(Color.SEAGREEN);
        kampanjrutan.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        TextFlow textFlowKampanjruta = new TextFlow();
        Label innehållKampanjruta = new Label("- Kyckling 79kr/kg, Ica Kvantum Teleborg, Växjö, 11/11 \n" +
                "- Körsbärstomater 10kr/asken, Stora Coop Norremark, Växjö, 18/11\n" +
                "- Färskpotatis 1kr/kg, City Gross, Växjö, 10/6\n" +
                "- Kvarg 20kr/l, Willys Teleborg, Växjö, 1/5\n\n\n");
        innehållKampanjruta.setFont(Font.font("Helvetica", FontPosture.ITALIC, 11));
        innehållKampanjruta.setWrapText(true);
        innehållKampanjruta.setTextAlignment(TextAlignment.JUSTIFY);
        innehållKampanjruta.setPrefWidth(120);
        textFlowKampanjruta.getChildren().add(innehållKampanjruta);
        kampanjrutan.setContent(textFlowKampanjruta);
        vbox1.getChildren().addAll(aktuellaKampanjer, kampanjrutan, button4);


        group.getChildren().addAll(hBox, sidoNamn, vBox, vbox1, flowPane);

        Scene scene = new Scene(group, 1200, 650);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
