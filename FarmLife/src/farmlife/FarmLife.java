/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmlife;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.Group;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import java.util.TimerTask;
import java.util.Timer;
import javafx.stage.WindowEvent;
import javafx.geometry.HPos;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.scene.paint.Color;


/**
 *
 * @author Guilherme Manteigas - 170262014 - guilherme.manteigas@gmail.com
 * @author João Pascoal - 170262010 - jp_pascoal@hotmail.com
 * @author José Abreu - 170262013 - abreu.ricardo@live.com.pt
 * @version 1.0
 */
public class FarmLife extends Application {
    Simulator simulator;
    Timer timer = new Timer();
    Stage window;
    Scene scene1;
    Scene scene2;
    Scene scene3;
    int dogs = 1;
    int cats = 1;
    int mice = 1;
    int birds = 1;
    int seconds = 1;
    
    @Override
    public void start(Stage primaryStage) {
        //----------------------| Scene 1 |-------------------------------------//
        VBox root = new VBox();
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER); 
        Button btn1 = new Button();
        btn1.setText("Start simulator");
        btn1.setStyle("-fx-font-weight: bold;");
        btn1.setFont(new Font(15));
        Button btnclose = new Button();
        btnclose.setText("Quit");
        btnclose.setStyle("-fx-font-weight: bold;");
        btnclose.setCenterShape(true);
        btnclose.setFont(new Font(15));
        btn1.setOnAction(e -> primaryStage.setScene(scene2)); //On click change scene (lambda expression)
        btnclose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
        root.getChildren().addAll(btn1,btnclose);
        scene1 = new Scene(root, 300, 300);
        
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(final WindowEvent e){
               System.exit(0);
            }
        });
        //----------------------| Scene 2 |-------------------------------------//
        GridPane root2 = new GridPane();
        root2.setHgap(10);
        root2.setVgap(5);
        root2.setAlignment(Pos.CENTER); 
        //Dogs Buttons
        Button btnDog1 = new Button();
        btnDog1.setText("-");
        btnDog1.setFont(new Font(15));
        GridPane.setConstraints(btnDog1, 1, 0);
        
        Label lblDogs = new Label("Dogs = " + dogs);
        lblDogs.setFont(new Font(15));
        lblDogs.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(lblDogs, HPos.CENTER);
        GridPane.setConstraints(lblDogs, 2, 0);
        
        Button btnDog2 = new Button();
        btnDog2.setText("+");
        btnDog2.setStyle("-fx-font-weight: bold;");
        btnDog2.setFont(new Font(15));
        GridPane.setConstraints(btnDog2, 3, 0);
        
        //Cats Buttons
        Button btnCat1 = new Button();
        btnCat1.setText("-");
        btnCat1.setFont(new Font(15));
        GridPane.setConstraints(btnCat1, 1, 1);
        
        Label lblCats = new Label("Cats = " + dogs);
        lblCats.setFont(new Font(15));
        lblCats.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(lblCats, HPos.CENTER);
        GridPane.setConstraints(lblCats, 2, 1);
        
        Button btnCat2 = new Button();
        btnCat2.setText("+");
        btnCat2.setStyle("-fx-font-weight: bold;");
        btnCat2.setFont(new Font(15));
        GridPane.setConstraints(btnCat2, 3, 1);
        
        //Mice  Buttons
        Button btnMouse1 = new Button();
        btnMouse1.setText("-");
        btnMouse1.setFont(new Font(15));
        GridPane.setConstraints(btnMouse1, 1, 2);
        
        Label lblMouses = new Label("Mouses = " + mice);
        lblMouses.setFont(new Font(15));
        lblMouses.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(lblMouses, HPos.CENTER); 
        GridPane.setConstraints(lblMouses, 2, 2);
        
        Button btnMouse2 = new Button();
        btnMouse2.setText("+");
        btnMouse2.setStyle("-fx-font-weight: bold;");
        btnMouse2.setFont(new Font(15));
        GridPane.setConstraints(btnMouse2, 3, 2);
        
        //Birds Buttons
        Button btnBird1 = new Button();
        btnBird1.setText("-");
        btnBird1.setFont(new Font(15));
        GridPane.setConstraints(btnBird1, 1, 3);
        
        Label lblBirds = new Label("Birds = " + birds);
        lblBirds.setStyle("-fx-font-weight: bold;");
        lblBirds.setFont(new Font(15));
        GridPane.setHalignment(lblBirds, HPos.CENTER);
        GridPane.setConstraints(lblBirds, 2, 3);
        
        Button btnBird2 = new Button();
        btnBird2.setText("+");
        btnBird2.setStyle("-fx-font-weight: bold;");
        btnBird2.setFont(new Font(15));
        GridPane.setConstraints(btnBird2, 3, 3);
        
        //Start Button
        Button btnStart = new Button();
        btnStart.setText("Start Simulator");
        btnStart.setStyle("-fx-font-weight: bold;");
        btnStart.setFont(new Font(15));
        GridPane.setConstraints(btnStart, 2, 6);
        
        //Button Actions
        btnDog2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dogs++;
                lblDogs.setText("Dogs = " + dogs);
            }
        });
        btnDog1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(dogs > 1){
                    dogs--;
                    lblDogs.setText("Dogs = " + dogs);
                }
            }
        });
        btnCat2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cats++;
                lblCats.setText("Cats = " + cats);
            }
        });
        btnCat1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(cats > 1){
                    cats--;
                    lblCats.setText("Cats = " + cats);
                }
            }
        });
        btnMouse2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mice++;
                lblMouses.setText("Mouses = " + mice);
            }
        });
        btnMouse1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(mice > 1){
                    mice--;
                    lblMouses.setText("Mouses = " + mice);
                }
            }
        });
        btnBird2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                birds++;
                lblBirds.setText("Birds = " + birds);
            }
        });
        btnBird1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(birds > 1){
                    birds--;
                    lblBirds.setText("Birds = " + birds);
                }
            }
        });
        
        root2.getChildren().addAll(btnDog1,lblDogs,btnDog2,btnCat1,lblCats,btnCat2,btnMouse1,lblMouses,btnMouse2,btnBird1,lblBirds,btnBird2,btnStart);
        scene2 = new Scene(root2, 300, 300);
        //----------------------| Scene 3 |-------------------------------------//
        BorderPane border = new BorderPane();
        HBox top = new HBox();
        border.setTop(top);
        
        Group group = new Group();
        Label textArea = new Label();
        textArea.prefWidth(700);
        textArea.prefHeight(400);
        textArea.setWrapText(true);
        
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(textArea);
        scrollPane.setPrefWidth(700);
        scrollPane.setPrefHeight(400);

        VBox vBox = new VBox();
        vBox.getChildren().add(scrollPane);
        group.getChildren().add(vBox);
        border.setCenter(group);
        
        Label lblAliveDogs = new Label("Alive Dogs = " + dogs);
        lblAliveDogs.setTextFill(Color.TEAL);
        lblAliveDogs.setFont(new Font(20));
        lblAliveDogs.setPadding(new Insets(5.0, 40.0, 5.0, 20.0));//(TOP|Direita|Baixo|Esquerda)
        Label lblAliveCats = new Label("Alive Cats = " + cats);
        lblAliveCats.setTextFill(Color.TEAL);
        lblAliveCats.setFont(new Font(20));
        lblAliveCats.setPadding(new Insets(5.0, 40.0, 5.0, 40.0));
        Label lblAliveMice = new Label("Alive Mice = " + mice);
        lblAliveMice.setTextFill(Color.TEAL);
        lblAliveMice.setFont(new Font(20));
        lblAliveMice.setPadding(new Insets(5.0, 40.0, 5.0, 40.0));
        Label lblAliveBirds = new Label("Alive Birds = " + birds);
        lblAliveBirds.setTextFill(Color.TEAL);
        lblAliveBirds.setFont(new Font(20));
        lblAliveBirds.setPadding(new Insets(5.0, 20.0, 5.0, 40.0));
        top.getChildren().addAll(lblAliveDogs,lblAliveCats,lblAliveMice,lblAliveBirds);
        
        HBox bot = new HBox();
        border.setBottom(bot);
        bot.setPadding(new Insets(5, 20, 20, 20));
        bot.setSpacing(10);
        
        Button addDog = new Button();
        addDog.setText("Add Dog");
        addDog.setTextFill(Color.GREEN);
        addDog.setFont(new Font(18));
        
        Button addCat = new Button();
        addCat.setText("Add Cat");
        addCat.setTextFill(Color.GREEN);
        addCat.setFont(new Font(18));
        
        Button addMouse = new Button();
        addMouse.setText("Add Mouse");
        addMouse.setTextFill(Color.GREEN);
        addMouse.setFont(new Font(18));
        
        Button addBird = new Button();
        addBird.setText("Add Bird");
        addBird.setTextFill(Color.GREEN);
        addBird.setFont(new Font(18));
        
        Button stop = new Button();
        stop.setText("Stop Simulator");
        stop.setTextFill(Color.RED);
        stop.setFont(new Font(18));
        
        Button showStats = new Button();
        showStats.setText("Statistics");
        showStats.setTextFill(Color.BLUE);
        showStats.setFont(new Font(18));
        
        Button animalInfo = new Button();
        animalInfo.setText("Animals Info");
        animalInfo.setTextFill(Color.BLUE);
        animalInfo.setFont(new Font(18));
        
        bot.getChildren().addAll(addDog,addCat,addMouse,addBird,stop,showStats,animalInfo);
        scene3 = new Scene(border, 900, 600);
        
        btnStart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(scene3);
                Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
                primaryStage.setX((primScreenBounds.getWidth() - scene3.getWidth()) / 2); 
                primaryStage.setY((primScreenBounds.getHeight() - scene3.getHeight()) / 4); 
                simulator = new Simulator(dogs,cats,mice,birds);
                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        javafx.application.Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                String msg = simulator.randomEvent();
                                textArea.setText(textArea.getText() + msg);
                                lblAliveDogs.setText("Alive Dogs = " + simulator.aliveAnimals("Dog"));
                                lblAliveCats.setText("Alive Cats = " + simulator.aliveAnimals("Cat"));
                                lblAliveMice.setText("Alive Mice = " + simulator.aliveAnimals("Mouse"));
                                lblAliveBirds.setText("Alive Birds = " + simulator.aliveAnimals("Bird"));
                                scrollPane.setVvalue(1.0); 
                            }
                        });
                    }
                }, 0, 1000);      
            }
        });
        
        showStats.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String stats;
                stats = simulator.showStats();
                textArea.setText(textArea.getText() + stats);
                scrollPane.setVvalue(1.0); 
            }
        });
        
        animalInfo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String info;
                info = simulator.showInfo();
                textArea.setText(textArea.getText() + info);
                scrollPane.setVvalue(1.0); 
            }
        });
        
        addDog.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                simulator.newAnimal("Dog",1);
            }
        });
        
        addCat.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                simulator.newAnimal("Cat",1);
            }
        });
        
        addMouse.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                simulator.newAnimal("Mouse",1);
            }
        });
        
        addBird.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                simulator.newAnimal("Bird",1);
            }
        });
    
    
        stop.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(stop.getText().equals("Stop Simulator")){
                    timer.cancel();
                    stop.setTextFill(Color.GREEN);
                    stop.setText("Restart Simulator");
                }else{
                    stop.setTextFill(Color.RED);
                    stop.setText("Stop Simulator");
                    timer = new Timer();
                    timer.scheduleAtFixedRate(new TimerTask() {
                        @Override
                        public void run() {
                            javafx.application.Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    String msg = simulator.randomEvent();
                                    textArea.setText(textArea.getText() + msg);
                                    lblAliveDogs.setText("Alive Dogs = " + simulator.aliveAnimals("Dog"));
                                    lblAliveCats.setText("Alive Cats = " + simulator.aliveAnimals("Cat"));
                                    lblAliveMice.setText("Alive Mice = " + simulator.aliveAnimals("Mouse"));
                                    lblAliveBirds.setText("Alive Birds = " + simulator.aliveAnimals("Bird"));
                                    scrollPane.setVvalue(1.0); 
                                    
                                }
                            });
                        }
                    }, 0, 1000);
                }
            }
        });
        
        //----------------------stage---------------------------------------
        primaryStage.setTitle("Life In the Farm");
        primaryStage.setScene(scene1);
        primaryStage.show();
        
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setX((primScreenBounds.getWidth() - scene1.getWidth()) / 2); 
        primaryStage.setY((primScreenBounds.getHeight() - scene1.getHeight()) / 4); 
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
