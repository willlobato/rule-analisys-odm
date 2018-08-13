package net.pupunha.rule.analisys.odm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/download_dsar.fxml"));

        Scene scene = new Scene(root);

//        scene.getStylesheets().add(DownloadDSRController.class.getResource("/css/jfoenix-components.css").toExternalForm());


        primaryStage.setTitle("FXML Welcome");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
