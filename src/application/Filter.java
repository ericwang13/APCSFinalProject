package application;

import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;

public class Filter {
  public static Mat greyscale(Mat frame) {
    Imgproc.cvtColor(frame, frame, Imgproc.COLOR_BGR2GRAY);
    return frame;
  }
}
