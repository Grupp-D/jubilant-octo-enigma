package FoodForStudents;


//Hej gänget! jag har uppdaterat startsidan så att det kommer upp rutor när man klickar på knapparna "logga in" och "skapa konto".
// Skapa konto gör en viss kontroll vid inmatning och logga in gör ingen kontroll.
// 2019-12-12


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

public class StartsidaUppdaterad extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane group = new Pane();

        //bakgrund
        group.setBackground(new Background(new BackgroundImage(new Image(new FileInputStream("C:\\Users\\William\\OneDrive\\1ik153\\images\\brooke.jpg")),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(1400, 1111, true, true, true, true))));

        //Titel
        Label sidoNamn = new Label("Food For Students");
        sidoNamn.setFont(Font.font("Helvetica", FontWeight.BOLD, FontPosture.ITALIC, 80));
        sidoNamn.setTextFill(Color.SEAGREEN); //lightblue
        sidoNamn.setLayoutX(500);
        sidoNamn.setLayoutY(10);
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(6.0f);
        dropShadow.setOffsetY(4.0f);
        dropShadow.setColor(Color.rgb(50, 50, 50, .588));
        sidoNamn.setEffect(dropShadow);

        //listview
        ListView listView = new ListView();
        listView.setPrefWidth(220);
        listView.setLayoutX(1300);
        listView.setScaleY(8);
        listView.setPrefHeight(160);
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setPrefSize(120, 120);
        scrollPane.setContent(listView);

        //Knappar
        Button registreringsKnapp = new Button();
        registreringsKnapp.setText("Registrera konto");
        registreringsKnapp.setTextFill(Color.LIGHTBLUE);
        registreringsKnapp.setLayoutX(1100);
        registreringsKnapp.setLayoutY(200);
        registreringsKnapp.setPrefHeight(30);
        registreringsKnapp.setTextFill(Color.GREEN);
        registreringsKnapp.setFont(Font.font(20));
        //button.setStyle("-fx-background-color: blue;");
        registreringsKnapp.setStyle("-fx-border-color: green;");
        registreringsKnapp.setStyle("-fx-border-width: 10 20 20 10;");

        registreringsKnapp.setOnAction(e-> {
            GridPane regpane = new GridPane();
            regpane.setHgap(5.5);
            regpane.setVgap(5.5);
            regpane.setAlignment(Pos.CENTER);

            javafx.scene.control.Label headerlabel = new javafx.scene.control.Label("Registrera Konto");
            headerlabel.setFont(Font.font("Arial", FontWeight.BLACK, 24));

            regpane.add(headerlabel, 0, 0);
            GridPane.setHalignment(headerlabel, HPos.CENTER);
            GridPane.setMargin(headerlabel, new Insets(20, 0, 20, 0));

            //label för e-post
            regpane.add(new Label("Skriv in E-post"), 0, 1);

            final TextField anvandarnamn = new TextField("@student.lnu.se");
            regpane.add(anvandarnamn, 0, 2);



            //label för lösenord
            regpane.add(new Label("Skriv in lösenord"), 0, 4);

            //fält där inmatad text blir döljs
            PasswordField passwordField = new PasswordField();
            regpane.add(passwordField, 0, 5);

            // avbrytsknapp
            Button avbrytknapp = new Button("Avbryt");
            avbrytknapp.setPrefHeight(20);
            avbrytknapp.setDefaultButton(true);
            avbrytknapp.setPrefWidth(60);
            regpane.add(avbrytknapp, 0, 6);
            regpane.setHalignment(avbrytknapp, HPos.LEFT);

            // sparaknapp
            Button sparaknapp = new Button("Skapa");
            sparaknapp.setPrefHeight(20);
            sparaknapp.setDefaultButton(true);
            sparaknapp.setPrefWidth(60);
            regpane.add(sparaknapp, 0, 6);
            regpane.setHalignment(sparaknapp, HPos.RIGHT);

            sparaknapp.setOnAction(eee -> {
                if (anvandarnamn.getText().isEmpty()) {
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
                } else if (anvandarnamn.getText().length() != 22) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Meddelande");
                    alert.setHeaderText("Du har inte fyllt i en LNU-Emailadess");
                    alert.showAndWait();

                    // } else if (kontroll(passwordField) ==true){
                }
                else {Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Meddelande");
                    alert.setHeaderText("Du har skapat ett konto!");
                    alert.showAndWait();

                }
            });
                avbrytknapp.setOnAction(eed -> {
                    Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
                alert.setTitle("Meddelande");
                alert.setHeaderText("Är du säker på att du vill avbryta?");
                alert.showAndWait();

            });
            Scene scene = new Scene(regpane, 500, 280);
            //primaryStage.setScene(scene);
            //primaryStage.show();
            Stage window = new Stage();
            window.setScene(scene);
            window.showAndWait();
        });

            Button loggaInKnapp= new Button();
            loggaInKnapp.setText("Logga in");
            loggaInKnapp.setTextFill(Color.LIGHTBLUE);
            loggaInKnapp.setLayoutX(1100);
            loggaInKnapp.setLayoutY(50);
            loggaInKnapp.setPrefHeight(30);
            loggaInKnapp.setPrefWidth(150);
            loggaInKnapp.setTextFill(Color.GREEN);
            loggaInKnapp.setFont(Font.font(20));
            //button.setStyle("-fx-background-color: blue;");
            loggaInKnapp.setStyle("-fx-border-color: green;");
            loggaInKnapp.setStyle("-fx-border-width: 10 20 20 10;");

        loggaInKnapp.setOnAction(e-> {
            GridPane regpane = new GridPane();
            regpane.setHgap(5.5);
            regpane.setVgap(5.5);
            regpane.setAlignment(Pos.CENTER);

            //label för Epost
            regpane.add(new Label("Användarnamn (E-post)"), 0, 1);

            final TextField beskrivning = new TextField();
            regpane.add(beskrivning, 0, 2);

            //Lösen
            regpane.add(new Label("Lösenord"), 0, 4);

            PasswordField passwordField = new PasswordField();
            regpane.add(passwordField, 0, 5);

            // spara button
            Button loggaKnapp = new Button("Logga in");
            loggaKnapp.setPrefHeight(20);
            loggaKnapp.setDefaultButton(true);
            loggaKnapp.setPrefWidth(70);
            regpane.add(loggaKnapp, 0, 8);
            regpane.setHalignment(loggaKnapp, HPos.LEFT);

            loggaKnapp.setOnAction(eee -> {
                Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
                alert.setTitle("Välkommen");
                alert.setHeaderText("Välkommen! :)");
                alert.showAndWait();

            });

            Scene scene = new Scene(regpane, 300, 200);
            Stage window = new Stage();
            window.setScene(scene);
            window.showAndWait();
        });

            Button hemKnapp= new Button();
            hemKnapp.setText("Hem");
            hemKnapp.setTextFill(Color.LIGHTBLUE);
            hemKnapp.setLayoutX(1100);
            hemKnapp.setLayoutY(170);
            hemKnapp.setPrefHeight(30);
            hemKnapp.setPrefWidth(120);
            hemKnapp.setTextFill(Color.GREEN);
            hemKnapp.setFont(Font.font(20));
            //button.setStyle("-fx-background-color: blue;");
            hemKnapp.setStyle("-fx-border-color: blue;");
            hemKnapp.setStyle("-fx-border-width: 10 20 20 10;");

            DropShadow dropShadow2 = new DropShadow();
            dropShadow2.setOffsetX(0.0);
            dropShadow2.setOffsetY(0.0);
            dropShadow2.setColor(Color.LIGHTGRAY);
            //Dropshadow
            registreringsKnapp.setEffect(dropShadow2);
            loggaInKnapp.setEffect(dropShadow2);
            hemKnapp.setEffect(dropShadow2);

            //rundade kanter på knapparna
            registreringsKnapp.setStyle("-fx-background-radius: 30");
            loggaInKnapp.setStyle("-fx-background-radius: 30");
            hemKnapp.setStyle("-fx-background-radius: 30");


            listView.getItems().addAll("Knapp");

            FlowPane flowPane=new FlowPane();
            flowPane.getChildren().addAll(registreringsKnapp, loggaInKnapp,hemKnapp);
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



