package application;

import javafx.scene.image.Image;
import org.opencv.core.Mat;

public class Filter {
    public static Image applyFilter(Mat frame) {
        return Util.matToImg(frame);
    }
}
