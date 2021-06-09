package application;

import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;

public class Filter {
  public static Mat greyscale(Mat frame) {
    Imgproc.cvtColor(frame, frame, Imgproc.COLOR_BGR2GRAY);
    return frame;
  }

  public static Mat sepia(Mat frame) {
    Imgproc.cvtColor(frame, frame, Imgproc.COLOR_BGR2RGB);

    Mat sepia = new Mat(3, 3, CvType.CV_64FC1);
    int row = 0, col = 0;
    sepia.put(row, col, 0.393, 0.769, 0.189, 0.349, 0.686, 0.168, 0.272, 0.534, 0.131);
    Core.transform(frame, frame, sepia);

    Imgproc.cvtColor(frame, frame, Imgproc.COLOR_RGB2BGR);
    return frame;
  }

  public static Mat blur(Mat frame, int size) {
    Imgproc.blur(frame, frame, new Size(size, size), new Point(-1, -1));
    return frame;
  }

  public static Mat staticTV(Mat frame) {
    return null;
  }

  public static Mat duoTone(Mat frame) {
    return null;
  }

  public static Mat emboss(Mat frame) {
    return null;
  }

  public static Mat contours(Mat frame) {
    return null;
  }
}
