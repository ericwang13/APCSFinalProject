package application;

import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.objdetect.Objdetect;

public class Detect {
  public static Mat detectFace(Mat frame) {
    MatOfRect facesDetected = new MatOfRect();
    CascadeClassifier cascadeClassifier = new CascadeClassifier();
    int minFaceSize = Math.round(frame.rows() * 0.1f);
    cascadeClassifier.load("C:/Users/Eric Wang/IdeaProjects/ImageProcessing/res/haar/haarcascade_frontalface_alt.xml");
    cascadeClassifier.detectMultiScale(frame, facesDetected, 1.1, 3, Objdetect.CASCADE_SCALE_IMAGE,
        new Size(minFaceSize, minFaceSize), new Size());
    Rect[] facesArray = facesDetected.toArray();
    for (Rect face : facesArray) {
      Imgproc.rectangle(frame, face.tl(), face.br(), new Scalar(0, 0, 255), 3);
    }
    return frame;
  }
}
