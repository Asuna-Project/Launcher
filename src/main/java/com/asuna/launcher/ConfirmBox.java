package com.asuna.launcher;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

class ConfirmBox {

    private static boolean answer;

    static boolean display(String title, String message){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label(message);
        label.getStyleClass().add("headlineText");
        Button trueButton = new Button("Yes");
        Button falseButton = new Button("No");

        trueButton.setOnAction(e -> {
            answer = true;
            window.close();
        });
        falseButton.setOnAction(e -> {
            answer = false;
            window.close();
        });

        VBox topMessage = new VBox();
        topMessage.getChildren().addAll(label);
        topMessage.setAlignment(Pos.CENTER);
        HBox botButtons = new HBox(10);
        botButtons.getChildren().addAll(trueButton, falseButton);
        botButtons.setAlignment(Pos.CENTER);
        botButtons.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topMessage);
        borderPane.setBottom(botButtons);
        borderPane.setPadding(new Insets(10, 10, 10 , 10));

        Scene scene = new Scene(borderPane);
        scene.getStylesheets().add("/css/Main.css");

        window.setResizable(false);
        window.initStyle(StageStyle.UTILITY);

        window.setScene(scene);
        window.showAndWait();

        return answer;
    }
}
