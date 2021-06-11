package application;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

import java.util.Scanner;

public class Controller {
    private final VideoCapture capture = new VideoCapture(0);;
    @FXML
    private VBox vbox;
    @FXML
    private ImageView view;
    @FXML
    private TextField field;
    @FXML
    private Button update;
    @FXML
    private Slider slider;

    private int filter = 0;

    public void updateView() {
        new AnimationTimer() {
            @Override public void handle(long l) {
                Mat frame = new Mat();
                capture.read(frame);

                view.setImage(Util.matToImg(Util.chooseFilter(frame, filter, (int) slider.getValue())));
            }
        }.start();
    }

    public void updateEffect(ActionEvent actionEvent) {
        String input = field.getText();
        Scanner scan = new Scanner(input);
        if (scan.hasNextInt()) {
            filter = scan.nextInt();
        }

        slider.setVisible(filter == 2 || filter == 6);
    }
}
