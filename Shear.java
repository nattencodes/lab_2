package com.example.ass_1;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Shear {
    public Stage displayShear(Stage primaryStage) {
        // Making  the panes, scenes, and changing scenes
        VBox mainBox = new VBox();
        HBox hbox = new HBox();
        StackPane rectPane = new StackPane();
        Scene mainScene = primaryStage.getScene();
        Scene shearScene = new Scene(mainBox, 600, 400);
        primaryStage.setScene(shearScene);
        primaryStage.setTitle("Assignment 1 - Shear Transform");

        // Make rectangles
        Rectangle rect = new Rectangle(200, 100, Color.PINK);
        Rectangle rect2 = new Rectangle(200, 100, new Color(1, 0, 0, 0.3));

        // Shear transform
        javafx.scene.transform.Shear shear = new javafx.scene.transform.Shear(0.5, 0.5);
        rect.getTransforms().add(shear);


        Button viewCode = new Button("View Code");
        viewCode.setOnAction(evt -> {
            Alert codeDialog = new Alert(Alert.AlertType.INFORMATION);
            codeDialog.setTitle("View Code");
            codeDialog.setHeight(300);
            codeDialog.setWidth(500);
            codeDialog.setHeaderText("Code for the shear transform:");
            codeDialog.setContentText("""
                     Rectangle rect = new Rectangle(200, 100, Color.PINK);
                     Rectangle rect2 = new Rectangle(200, 100, new Color(1, 0, 0, 0.3));
                    
                     Shear shear = new Shear(0.5, 0.5);
                     rect.getTransforms().add(shear);
                    """);
            codeDialog.show();

        });

        Button back = new Button("Back");
        back.setOnAction(evt -> {
            Alert confirmDialog = new Alert(Alert.AlertType.CONFIRMATION);
            confirmDialog.setTitle("Go Back?");
            confirmDialog.setHeaderText("Go back?");
            confirmDialog.setContentText("This will take you back to the main page.");
            confirmDialog.showAndWait();
            if (confirmDialog.getResult() == ButtonType.OK) {
                primaryStage.setScene(mainScene);
                primaryStage.setTitle("Assignment 1 - Main");
            }
        });

        rectPane.getChildren().addAll(rect, rect2);

        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(40);
        hbox.getChildren().addAll(viewCode, back);

        mainBox.setAlignment(Pos.CENTER);
        mainBox.setSpacing(100);
        mainBox.getChildren().addAll(rectPane, hbox);

        return primaryStage;
    }
}
