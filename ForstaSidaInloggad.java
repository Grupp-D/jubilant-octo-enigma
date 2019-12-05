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
import javafx.stage.Stage;

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
        //button.setStyle("-fx-background-color: blue;");
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
        //button.setStyle("-fx-background-color: blue;");
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
        //button.setStyle("-fx-background-color: blue;");
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

        button4.setOnAction(e-> {
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

            avbrytknapp.setOnAction(eee -> {
                Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
                alert.setTitle("Meddelande");
                alert.setHeaderText("Är du säker på att du vill avbryta?");
                alert.showAndWait();
            });

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
            primaryStage.setScene(scene);
            primaryStage.show();
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
        //sokRuta.setLayoutX(700);
        //sokRuta.setLayoutY(150);
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
