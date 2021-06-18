import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application {
  @Override
  public void start(Stage primaryStage) throws Exception {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("app.fxml"));
    BorderPane root = (BorderPane) loader.load();
    primaryStage.setTitle("Image Processing");
    primaryStage.setScene(new Scene(root, 800, 600));
    primaryStage.show();

    Controller controller = loader.getController();
    controller.updateView();
  }

  public static void main(String[] args) {
    System.loadLibrary("opencv_java452");
    launch(args);
  }
}
