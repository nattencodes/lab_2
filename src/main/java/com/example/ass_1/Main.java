package com.example.ass_1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {
    public void start(Stage primaryStage) {
        // Stage, scene and main pane
        primaryStage.setTitle("Assignment 1 - Main");
        HBox hbox = new HBox();
        Scene mainScene = new Scene(hbox, 600, 400);
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(20);
        primaryStage.setScene(mainScene);
        primaryStage.show();

        // SVG Button
        Button pathButton = new Button("View Path Shape");
        hbox.getChildren().add(pathButton);
        pathButton.setOnAction(ect ->{
            Sheep sheep = new Sheep();
            sheep.displaySheep(primaryStage).show();
        });


        // Shear Button
        Button shearButton = new Button("View Shear Transform");
        hbox.getChildren().add(shearButton);
        shearButton.setOnAction(evt -> {
            Shear shear = new Shear();
            shear.displayShear(primaryStage).show();
        });
    }
}
