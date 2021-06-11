package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import org.opencv.core.*;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("application.fxml"));
        BorderPane root = (BorderPane) loader.load();
        primaryStage.setTitle("Image Processing");
        primaryStage.setScene(new Scene(root, 1200, 1000));
        primaryStage.show();

        Controller controller = loader.getController();
        controller.updateView();
    }

    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        launch(args);
    }
}
