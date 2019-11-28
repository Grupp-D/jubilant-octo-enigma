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


                listView.getItems().addAll("Knapp");

                FlowPane flowPane=new FlowPane();
                flowPane.getChildren().addAll(button);
                flowPane.setPrefWidth(200);
                flowPane.setLayoutX(1250);
                flowPane.setLayoutY(50);
                button.setMinWidth(flowPane.getPrefWidth());




                Group group=new Group();
                group.getChildren().addAll(imageView,sidoNamn,flowPane);

                Scene scene=new Scene(group);
                primaryStage.setScene(scene);
                primaryStage.show();
            }



        }






