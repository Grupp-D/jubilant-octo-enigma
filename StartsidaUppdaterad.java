package FoodForStudents;

//Den här versionen byter startsidan när man klickar OK på loggga in-rutan.

        import javafx.application.Application;
        import javafx.application.Platform;
        import javafx.geometry.HPos;
        import javafx.geometry.Insets;
        import javafx.geometry.Pos;
        import javafx.scene.Group;
        import javafx.scene.Scene;
        import javafx.scene.control.*;
        import javafx.scene.effect.DropShadow;
        import javafx.scene.image.Image;
        import javafx.scene.layout.*;
        import javafx.scene.paint.Color;
        import javafx.scene.text.*;
        import javafx.stage.FileChooser;
        import javafx.stage.Stage;
        import javafx.stage.Window;

        import javax.swing.*;
        import java.io.File;
        import java.io.FileInputStream;
        import java.util.Optional;

public class StartsidaUppdaterad extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane group = new Pane();

        //bakgrund
        group.setBackground(new Background(new BackgroundImage(new Image(new FileInputStream("C:\\Users\\stenm\\OneDrive\\1ik153\\images\\brooke.jpg")),
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
        registreringsKnapp.setStyle("-fx-border-color: green;");
        registreringsKnapp.setStyle("-fx-border-width: 10 20 20 10;");

        Button hemKnapp = new Button();
        hemKnapp.setText("Hem");
        hemKnapp.setTextFill(Color.LIGHTBLUE);
        hemKnapp.setLayoutX(1100);
        hemKnapp.setLayoutY(170);
        hemKnapp.setPrefHeight(30);
        hemKnapp.setPrefWidth(120);
        hemKnapp.setTextFill(Color.GREEN);
        hemKnapp.setFont(Font.font(20));
        hemKnapp.setStyle("-fx-border-color: blue;");
        hemKnapp.setStyle("-fx-border-width: 10 20 20 10;");

        /*
        Button minProfil = new Button();
        minProfil.setText("Min Profil");
        minProfil.setTextFill(Color.LIGHTBLUE);
        minProfil.setLayoutX(1100);
        minProfil.setLayoutY(170);
        minProfil.setPrefHeight(30);
        minProfil.setPrefWidth(120);
        minProfil.setTextFill(Color.GREEN);
        minProfil.setFont(Font.font(20));
        minProfil.setStyle("-fx-border-color: blue;");
        minProfil.setStyle("-fx-border-width: 10 20 20 10;");
         */

        //knapp För nytt recept
        Button nyttReceptKnapp= new Button();
        nyttReceptKnapp.setText("Skapa nytt recept");
        nyttReceptKnapp.setTextFill(Color.LIGHTBLUE);
        nyttReceptKnapp.setLayoutX(1100);
        nyttReceptKnapp.setLayoutY(50);
        nyttReceptKnapp.setPrefHeight(30);
        nyttReceptKnapp.setPrefWidth(200);
        nyttReceptKnapp.setTextFill(Color.GREEN);
        nyttReceptKnapp.setFont(Font.font(20));
        nyttReceptKnapp.setStyle("-fx-border-color: green;");
        nyttReceptKnapp.setStyle("-fx-border-width: 10 20 20 10;");

        nyttReceptKnapp.setOnAction(eh -> {
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
            window1.showAndWait();
        });

        Button laggTillKampanjKnapp = new Button();
        laggTillKampanjKnapp.setText("Lägg till kampanj");
        laggTillKampanjKnapp.setLayoutX(100);
        laggTillKampanjKnapp.setLayoutY(-100);
        laggTillKampanjKnapp.setPrefHeight(50);
        laggTillKampanjKnapp.setPrefWidth(200);
        laggTillKampanjKnapp.setTextFill(Color.GREEN);
        laggTillKampanjKnapp.setFont(Font.font(20));
        laggTillKampanjKnapp.setStyle("-fx-border-color: blue;");
        laggTillKampanjKnapp.setStyle("-fx-border-width: 10 20 20 10;");


        laggTillKampanjKnapp.setOnAction(e -> {
            GridPane pane1 = new GridPane();
            pane1.setHgap(5.5);
            pane1.setVgap(5.5);
            pane1.setAlignment(Pos.CENTER);

            javafx.scene.control.Label headerlabel1 = new javafx.scene.control.Label("Lägg till kampanj");
            headerlabel1.setFont(Font.font("Arial", FontWeight.BLACK, 24));

            pane1.add(headerlabel1, 0, 0);
            GridPane.setHalignment(headerlabel1, HPos.CENTER);
            GridPane.setMargin(headerlabel1, new Insets(20, 0, 20, 0));

            //kortfattad beskrivning
            pane1.add(new Label("Kortfattad beskrivning (tex. Kycklingfilé för 79kr/kg)"), 0, 1);
            final TextField beskrivning1 = new TextField();
            pane1.add(beskrivning1, 0, 2);

            //Butik
            pane1.add(new Label("Butik & stad - som har kampanjen"), 0, 4);
            final TextField butik1 = new TextField();
            pane1.add(butik1, 0, 5);

            // avbryt button
            Button avbrytknapp1 = new Button("Avbryt");
            avbrytknapp1.setPrefHeight(20);
            avbrytknapp1.setDefaultButton(true);
            avbrytknapp1.setPrefWidth(60);
            pane1.add(avbrytknapp1, 0, 6);
            pane1.setHalignment(avbrytknapp1, HPos.LEFT);

            // spara button
            Button sparaknapp1 = new Button("Spara");
            sparaknapp1.setPrefHeight(20);
            sparaknapp1.setDefaultButton(true);
            sparaknapp1.setPrefWidth(60);
            pane1.add(sparaknapp1, 0, 6);
            pane1.setHalignment(sparaknapp1, HPos.RIGHT);

            avbrytknapp1.setOnAction(eee -> {
                Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
                alert1.setTitle("Meddelande");
                alert1.setHeaderText("Är du säker på att du vill avbryta?");
                alert1.showAndWait();
            });
            sparaknapp1.setOnAction(ee -> {
                if (beskrivning1.getText().isEmpty())
                {
                    Alert bskalert = new Alert(Alert.AlertType.INFORMATION);
                    bskalert.setTitle("Meddelande");
                    bskalert.setHeaderText("Det saknas beskrivning");
                    bskalert.showAndWait();
                }
                else if (butik1.getText().isEmpty())
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

            Scene scene = new Scene(pane1, 500, 300);
            Stage window = new Stage();
            window.setScene(scene);
            window.showAndWait();
        });

            //loggain knapp
            Button loggaInKnapp = new Button();
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

            FlowPane flowPane = new FlowPane();
            flowPane.getChildren().addAll(registreringsKnapp, loggaInKnapp, hemKnapp);
            flowPane.setPrefWidth(200);
            flowPane.setLayoutX(930);
            flowPane.setLayoutY(140);
            flowPane.setVgap(50);
            //button2.setMinWidth(flowPane.getPrefWidth());
            flowPane.setAlignment(Pos.CENTER); //centrerar knapparna

            FlowPane flowPane1 = new FlowPane();
            flowPane1.getChildren().addAll(nyttReceptKnapp, laggTillKampanjKnapp); //här låg min profil tidigare
            flowPane1.setPrefWidth(200);
          //  flowPane1.setPrefHeight(300);
            flowPane1.setLayoutX(930);
            flowPane1.setLayoutY(140);
            flowPane1.setVgap(50);
            //button2.setMinWidth(flowPane.getPrefWidth());
            flowPane1.setAlignment(Pos.CENTER); //centrerar knapparna


            registreringsKnapp.setOnAction(ee -> {
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

                //fält där inmatad text döljs
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

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Meddelande");
                        alert.setHeaderText("Du har inte fyllt i något lösenord");
                        alert.showAndWait();
                    } else if (anvandarnamn.getText().length() != 22) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Meddelande");
                        alert.setHeaderText("Du har inte fyllt i en LNU-Emailadess");
                        alert.showAndWait();
                    } else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Meddelande");
                        alert.setHeaderText("Du har skapat ett konto!");
                        alert.showAndWait();

                    }
                });
                avbrytknapp.setOnAction(eed -> {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Meddelande");
                    alert.setHeaderText("Är du säker på att du vill avbryta?");
                });
                Scene scene = new Scene(regpane, 500, 280);
                Stage window = new Stage();
                window.setScene(scene);
                window.showAndWait();
            });


            /*Button loggautknapp = new Button();
            loggautknapp.setText("Logga ut");
            loggautknapp.setTextFill(Color.LIGHTBLUE);
            loggautknapp.setLayoutX(1100);
            loggautknapp.setLayoutY(200);
            loggautknapp.setPrefHeight(30);
            loggautknapp.setTextFill(Color.GREEN);
            loggautknapp.setFont(Font.font(20));
            loggautknapp.setStyle("-fx-border-color: green;");
            loggautknapp.setStyle("-fx-border-width: 10 20 20 10;");
             */

            //Här krävs det en kontroll med databasen! Matchar informationen ska användaren loggas in, annars bör ett felmeddelande komma upp.
            loggaInKnapp.setOnAction(eee -> {
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

                loggaKnapp.setOnAction(f -> {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Välkommen");
                    alert.setHeaderText("Välkommen " + beskrivning.getText() + "! :)");
                    alert.showAndWait();

             //Här sker sidbytet där flowpane innehållande loggain knapp osv tas bort och en ny flowpane läggs till med nya knappar
                    flowPane.getChildren().removeAll(flowPane.getChildren());
                    group.getChildren().addAll(flowPane1);
                });

                Scene scene = new Scene(regpane, 300, 200);
                Stage window = new Stage();
                window.setTitle("Logga in");
                window.setScene(scene);
                window.showAndWait();
            });


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
            nyaRecept.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
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
            vBox.getChildren().addAll(nyaRecept, beskrivningtextarea);

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
            aktuellaKampanjer.setFont(Font.font("Helvetica", FontWeight.BOLD, 14));
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


