package application;

import javafx.application.Application;
import javafx.stage.Stage;

import org.opencv.core.*;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
  }

  public static void main(String[] args) {
    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    launch(args);
  }
}
