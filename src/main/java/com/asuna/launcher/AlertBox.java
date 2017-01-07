package com.asuna.launcher;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

class AlertBox {

    static void display(String title, String message){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label(message);
        label.getStyleClass().add("headlineText");
        Button closeButton = new Button("OK");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        label.setAlignment(Pos.CENTER);

        window.setResizable(false);
        window.initStyle(StageStyle.UTILITY);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

}
