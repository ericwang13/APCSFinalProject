package application;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import org.opencv.core.*;
import org.opencv.videoio.VideoCapture;

public class Main extends Application {
  private VideoCapture capture;

  @Override
  public void start(Stage primaryStage) throws Exception {
    capture = new VideoCapture(0);
    ImageView imageView = new ImageView();
    HBox hbox = new HBox(imageView);
    Scene scene = new Scene(hbox);
    primaryStage.setScene(scene);
    primaryStage.show();
    new AnimationTimer() {
      @Override
      public void handle(long l) {
        imageView.setImage(getCapture());
      }
    }.start();
  }

  public Image getCapture() {
    Mat mat = new Mat();
    capture.read(mat);
    return Util.matToImg(mat);
  }

  public Image getFaceDetection() {
    Mat mat = new Mat();
    capture.read(mat);
    Mat haarClassifiedImg = Detect.detectFace(mat);
    return Util.matToImg(haarClassifiedImg);
  }

  public Image getFaceBlur(int size) {
    Mat mat = new Mat();
    capture.read(mat);
    Mat haarClassifiedImg = Detect.blurFace(mat, size);
    return Util.matToImg(haarClassifiedImg);
  }

  public static void main(String[] args) {
    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    launch(args);
  }
}
