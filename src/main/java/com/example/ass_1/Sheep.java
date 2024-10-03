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
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Sheep {
    public Stage displaySheep(Stage primaryStage) {
        VBox mainBox = new VBox();
        HBox hbox = new HBox();
        StackPane rectPane = new StackPane();
        Scene mainScene = primaryStage.getScene();
        Scene shearScene = new Scene(mainBox, 600, 400);
        primaryStage.setScene(shearScene);

        Path path = new Path();
        path.getElements().add(new MoveTo(100, 100));
        path.getElements().add(new LineTo(200, 100));
        path.getElements().add(new LineTo(200, 200));

        path.getElements().add(new ArcTo(50, 50, 0, 150, 200, false, true)); // Upward arc
        path.getElements().add(new ArcTo(50, 50, 0, 100, 200, false, false)); // Downward arc

        path.getElements().add(new LineTo(100, 100));
        path.getElements().add(new ClosePath());
        path.setFill(Color.TRANSPARENT);
        path.setStroke(Color.BLACK);

        Button viewCode = new Button("View Code");
        viewCode.setOnAction(evt -> {
            Alert codeDialog = new Alert(Alert.AlertType.INFORMATION);
            codeDialog.setTitle("View Code");
            codeDialog.setHeight(300);
            codeDialog.setWidth(500);
            codeDialog.setHeaderText("Code for the shear transform:");
            codeDialog.setContentText(
                    """
                            Path path = new Path();
                            path.getElements().add(new MoveTo(100, 100));
                            path.getElements().add(new LineTo(200, 100));
                            path.getElements().add(new LineTo(200, 200));
                            path.getElements().add(new ArcTo(50, 50, 0, 150, 200, false, true));
                            path.getElements().add(new ArcTo(50, 50, 0, 100, 200, false, false));
                            path.getElements().add(new LineTo(100, 100));
                            path.getElements().add(new ClosePath());
                            path.setFill(Color.TRANSPARENT);
                            path.setStroke(Color.BLACK);"""
            );
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
            }
        });

        rectPane.getChildren().addAll(path);

        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(40);
        hbox.getChildren().addAll(viewCode, back);

        mainBox.setAlignment(Pos.CENTER);
        mainBox.setSpacing(100);
        mainBox.getChildren().addAll(rectPane, hbox);

        return primaryStage;
    }
}
