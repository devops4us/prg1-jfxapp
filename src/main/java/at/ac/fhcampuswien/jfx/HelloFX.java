package at.ac.fhcampuswien.jfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;

/**
 * HelloFX application class. run the main method to start the application.
 */

public class HelloFX extends Application {

    private HelloFXController controller;

    @Override
    public void start(Stage stage) throws Exception {
        URL location = getClass().getResource("/hellofx.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Pane root = (Pane)fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        this.controller = fxmlLoader.getController();
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        controller.stop();
    }

    public static void main(String[] args) {
        try {
            launch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}