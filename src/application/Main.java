package application;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import org.opencv.core.*;
import org.opencv.videoio.VideoCapture;

public class Main extends Application {
    private VideoCapture capture;

    @Override
    public void start(Stage primaryStage) throws Exception {
        capture = new VideoCapture(0);

        BorderPane pane = new BorderPane();
        ImageView view = new ImageView();
        TextField field = new TextField();
        Button submit = new Button();
        submit.setText("Click here to update process");
        submit.setMaxWidth(Double.MAX_VALUE);

        pane.setCenter(view);
        pane.setTop(field);
        pane.setBottom(submit);

        Scene scene = new Scene(pane, 1000, 800);
        primaryStage.setScene(scene);
        primaryStage.show();

        final int[] i = {0};
        new AnimationTimer() {
            @Override public void handle(long l) {
                view.setImage(chooseEffect(i[0]));
                submit.setOnAction(actionEvent -> i[0] = Integer.parseInt(field.getText()));
            }
        }.start();
    }

    public Image chooseEffect(int i) {
        switch (i) {
            case 0:
                return getCapture();
            case 1:
                return getFaceDetection();
            case 2:
                return getFaceBlur(30);
            case 3:
                return getGreyscale();
            case 4:
                return getSepia();
            case 5:
                return getBlur(30);
            default: getCapture();
        }
        return getCapture();
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

    public Image getGreyscale() {
        Mat mat = new Mat();
        capture.read(mat);
        return Util.matToImg(Filter.greyscale(mat));
    }

    public Image getSepia() {
        Mat mat = new Mat();
        capture.read(mat);
        return Util.matToImg(Filter.sepia(mat));
    }

    public Image getBlur(int size) {
        Mat mat = new Mat();
        capture.read(mat);
        return Util.matToImg(Filter.blur(mat, size));
    }

    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        launch(args);
    }
}
