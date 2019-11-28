package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class Forstasidan extends Application {


            @Override
            public void start(Stage primaryStage) throws Exception{
                HBox hBox1=new HBox();
                Label sidoNamn =new Label("Food For Students");

                //Titel
                sidoNamn.setFont(Font.font("Helvetica", FontWeight.BOLD,80));
                sidoNamn.setFont(Font.font("Helvetica", FontPosture.ITALIC,80));
                sidoNamn.setTextFill(Color.LIGHTBLUE);
                sidoNamn.setLayoutX(500);
                sidoNamn.setLayoutY(10);

                //Skuggning
                DropShadow dropShadow=new DropShadow();
                dropShadow.setOffsetX(6.0f);
                dropShadow.setOffsetY(4.0f);
                dropShadow.setColor(Color.rgb(50,50,50,.588));
                sidoNamn.setEffect(dropShadow);


                //Bild
                Image startSida=new Image(new FileInputStream("C:\\Users\\Gustav\\IdeaProjects\\Projektledning\\bilder\\Projekt.Startsida.Bild.jpg"));
                ImageView imageView=new ImageView(startSida);

                imageView.setFitWidth(1550);
                imageView.setFitHeight(800);

                Image spaghetti=new Image(new FileInputStream("C:\\Users\\Gustav\\IdeaProjects\\Projektledning\\bilder\\spaghetti.jpg"));
                ImageView spaghettiBild=new ImageView(spaghetti);

                spaghettiBild.setX(820);
                spaghettiBild.setY(200);
                spaghettiBild.setRotate(360);
                spaghettiBild.setFitHeight(300);
                spaghettiBild.setFitWidth(300);

                Label spaghettiTitel = new Label("Pasta Bolognese");
                spaghettiTitel.setMaxSize(100,100);
                spaghettiTitel.setLayoutX(830);
                spaghettiTitel.setLayoutY(500);
                spaghettiTitel.setMaxWidth(1000);
                spaghettiTitel.setFont(Font.font("Helvetica", FontPosture.ITALIC,30));

                Text spaghettiRecept= new Text("Skala och hacka löken. Skala och tärna moroten ytterst fint. Skala rotsellerin och riv den grovt. Fräs grönsakerna mjuka i smöret. Lägg i färsen och fräs den gyllenbrun...");
                spaghettiRecept.setLayoutX(830);
                spaghettiRecept.setLayoutY(570);
                spaghettiRecept.setWrappingWidth(300);
                spaghettiRecept.setFont(Font.font("Helvetica", FontPosture.ITALIC,20));

                Image tacos=new Image(new FileInputStream("C:\\Users\\Gustav\\IdeaProjects\\Projektledning\\bilder\\tacos.jpg"));
                ImageView tacosBild= new ImageView(tacos);
                tacosBild.setX(480);
                tacosBild.setY(200);
                tacosBild.setRotate(360);
                tacosBild.setFitHeight(300);
                tacosBild.setFitWidth(300);
                tacosBild.setEffect(dropShadow);

                Label tacosTitel= new Label("Tacos");
                tacosTitel.setMaxSize(100,100);
                tacosTitel.setLayoutX(480);
                tacosTitel.setLayoutY(500);
                tacosTitel.setMaxWidth(1000);
                tacosTitel.setFont(Font.font("Helvetica", FontPosture.ITALIC,30));

                Text tacosRecept= new Text("Stek köttfärsen i några matskedar smör eller neutral olja och häll sedan över tacokryddan enligt anvisning på påsen.\n" +
                        "Hacka lök, finfördela gurka, tomat och paprika...");
                tacosRecept.setLayoutX(480);
                tacosRecept.setLayoutY(570);
                tacosRecept.setWrappingWidth(300);
                tacosRecept.setFont(Font.font("Helvetica", FontPosture.ITALIC,20));



                //ListWiew
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
                button.setText("Recept");
                button.setTextFill(Color.LIGHTBLUE);
                button.setLayoutX(1300);
                button.setLayoutY(50);
                button.setPrefHeight(80);
                button.setTextFill(Color.GREEN);
                button.setFont(Font.font(40));
                //button.setStyle("-fx-background-color: blue;");
                button.setStyle("-fx-border-color: green;");
                button.setStyle("-fx-border-width: 10 20 20 10;");

                Button button2= new Button();
                button2.setText("Mitt konto");
                button2.setTextFill(Color.LIGHTBLUE);
                button2.setLayoutX(1300);
                button2.setLayoutY(50);
                button2.setPrefHeight(80);
                button2.setTextFill(Color.GREEN);
                button2.setFont(Font.font(40));
                //button.setStyle("-fx-background-color: blue;");
                button2.setStyle("-fx-border-color: green;");
                button2.setStyle("-fx-border-width: 10 20 20 10;");

                Button button3= new Button();
                button3.setText("Kontakta oss");
                button3.setTextFill(Color.LIGHTBLUE);
                button3.setLayoutX(1300);
                button3.setLayoutY(170);
                button3.setPrefHeight(80);
                button3.setTextFill(Color.GREEN);
                button3.setFont(Font.font(40));
                //button.setStyle("-fx-background-color: blue;");
                button3.setStyle("-fx-border-color: blue;");
                button3.setStyle("-fx-border-width: 10 20 20 10;");

                Button button4= new Button();
                button4.setText("Våra leverantörer");
                button4.setMaxWidth(400);
                button4.setTextFill(Color.LIGHTBLUE);
                button4.setLayoutX(1100);
                button4.setLayoutY(50);
                button4.setPrefHeight(80);
                button4.setTextFill(Color.GREEN);
                button4.setFont(Font.font(40));
                //button.setStyle("-fx-background-color: blue;");
                button4.setStyle("-fx-border-color: green;");
                button4.setStyle("-fx-border-width: 10 20 20 10;");

                Button button5= new Button();
                button5.setText("Recept");
                button5.setTextFill(Color.LIGHTBLUE);
                button5.setLayoutX(1300);
                button5.setLayoutY(50);
                button5.setPrefHeight(80);
                button5.setTextFill(Color.GREEN);
                button5.setFont(Font.font(40));
                //button.setStyle("-fx-background-color: blue;");
                button5.setStyle("-fx-border-color: green;");
                button5.setStyle("-fx-border-width: 10 20 20 10;");

                button.setEffect(dropShadow);
                button2.setEffect(dropShadow);
                button3.setEffect(dropShadow);
                button4.setEffect(dropShadow);
                button5.setEffect(dropShadow);

                spaghettiBild.setEffect(dropShadow);

                listView.getItems().addAll("Knapp");

                FlowPane flowPane=new FlowPane();
                flowPane.getChildren().addAll(button,button3,button4,button5);
                flowPane.setPrefWidth(200);
                flowPane.setLayoutX(1150);
                flowPane.setLayoutY(50);
                button2.setMinWidth(flowPane.getPrefWidth());
                flowPane.setVgap(50);




                Group group=new Group();
                group.getChildren().addAll(imageView,spaghettiBild,tacosBild,spaghettiTitel,tacosTitel, tacosRecept, spaghettiRecept,sidoNamn,flowPane);

                Scene scene=new Scene(group);
                primaryStage.setScene(scene);
                primaryStage.show();
            }



        }






