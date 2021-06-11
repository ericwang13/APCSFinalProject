package application;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

import java.util.Scanner;

public class Controller {
    private final VideoCapture capture = new VideoCapture(0);;
    @FXML
    private ImageView view;
    @FXML
    private TextField field;
    @FXML
    private Button update;

    private int filter = 0;

    public void updateView() {
        new AnimationTimer() {
            @Override public void handle(long l) {
                Mat frame = new Mat();
                capture.read(frame);

                switch (filter) {
                    case 1:
                        frame = Detect.detectFace(frame);
                        break;
                    case 2:
                        frame = Detect.blurFace(frame, 100);
                        break;
                    case 3:
                        frame = Filter.edge(frame);
                        break;
                    case 4:
                        frame = Filter.greyscale(frame);
                        break;
                    default:
                        break;
                }

                view.setImage(Util.matToImg(frame));
            }
        }.start();
    }

    public void updateEffect(ActionEvent actionEvent) {
        String input = field.getText();
        Scanner scan = new Scanner(input);
        if (scan.hasNextInt()) {
            filter = scan.nextInt();
        }
    }
}
