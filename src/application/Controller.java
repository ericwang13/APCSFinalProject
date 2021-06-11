package application;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

import java.awt.*;

public class Controller {
    private final VideoCapture capture = new VideoCapture(0);;
    @FXML
    private ImageView view;
    @FXML
    private TextField field;
    @FXML
    private Button update;

    public void updateView() {
        new AnimationTimer() {
            @Override public void handle(long l) {
                Mat frame = new Mat();
                capture.read(frame);
                view.setImage(Util.matToImg(frame));
            }
        }.start();
    }
}
