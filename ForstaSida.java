package FFS;

import com.sun.javafx.scene.layout.region.BorderImageWidthConverter;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

public class ForstaSida extends Application {

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
        button.setText("Registrera konto");
        button.setTextFill(Color.LIGHTBLUE);
        button.setLayoutX(1100);
        button.setLayoutY(200);
        button.setPrefHeight(30);
        button.setTextFill(Color.GREEN);
        button.setFont(Font.font(20));
        button.setStyle("-fx-border-color: green;");
        button.setStyle("-fx-border-width: 10 20 20 10;");

        Button button2= new Button();
        button2.setText("Logga in");
        button2.setTextFill(Color.LIGHTBLUE);
        button2.setLayoutX(1100);
        button2.setLayoutY(50);
        button2.setPrefHeight(30);
        button2.setPrefWidth(150);
        button2.setTextFill(Color.GREEN);
        button2.setFont(Font.font(20));
        button2.setStyle("-fx-border-color: green;");
        button2.setStyle("-fx-border-width: 10 20 20 10;");

        button2.setOnAction(e-> {
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
            testLogin.setOnAction(eee -> {
                if(username.getText().equals("ab111cd@student.lnu.se"))
                    result.setText("OK");
                else
                    result.setText("No way");
            });
            Scene scene = new Scene(pane);
            Stage window = new Stage();
            window.setScene(scene);
            window.showAndWait();
        });

        Button button3= new Button();
        button3.setText("Hem");
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

        DropShadow dropShadow2 = new DropShadow();
        dropShadow2.setOffsetX(0.0);
        dropShadow2.setOffsetY(0.0);
        dropShadow2.setColor(Color.LIGHTGRAY);
        //Dropshadow
        button.setEffect(dropShadow2);
        button2.setEffect(dropShadow2);
        button3.setEffect(dropShadow2);

        //rundade kanter på knapparna
        button.setStyle("-fx-background-radius: 30");
        button2.setStyle("-fx-background-radius: 30");
        button3.setStyle("-fx-background-radius: 30");


        listView.getItems().addAll("Knapp");

        FlowPane flowPane=new FlowPane();
        flowPane.getChildren().addAll(button, button2,button3);
        flowPane.setPrefWidth(200);
        flowPane.setLayoutX(930);
        flowPane.setLayoutY(140);
        flowPane.setVgap(50);
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
        vbox1.getChildren().addAll(aktuellaKampanjer, kampanjrutan);


        group.getChildren().addAll(hBox, sidoNamn, vBox, vbox1, flowPane);

        Scene scene = new Scene(group, 1200, 650);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    }

