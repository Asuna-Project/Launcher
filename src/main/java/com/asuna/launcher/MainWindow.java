package com.asuna.launcher;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;


class MainWindow {

    static void display(){
        try {
            Parent root;
            FXMLLoader loader = new FXMLLoader(Main.class.getClass().getResource("/scenes/Main.fxml"));
            Controller controller = new Controller();
            loader.setController(controller);
            root = loader.load();

            Stage window = new Stage();
            window.setResizable(false);
            window.initStyle(StageStyle.UTILITY);
            window.setOnCloseRequest(e -> {
                e.consume();
                closeProperly();
            });
            window.setTitle("SBT");
            window.setScene(new Scene(root, 762, 513));
            window.show();
        }catch(IOException ex){
            System.out.println("IOException in Main: " + ex);
            ex.printStackTrace();
        }

    }

    static private void closeProperly(){
        Boolean answer = ConfirmBox.display("Close", "Are you sure you want to exit?");
        if(answer)
            Platform.exit();
    }
}
