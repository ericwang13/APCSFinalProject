import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

public class App {
  public static void main(String[] args) throws Exception {
    // System.out.println("Hi Stella");
    System.load("C:/Users/Eric Wang/Desktop/APCSFinalProject/src/dll/opencv_java452.dll");
    Mat mat = Mat.eye(3, 3, CvType.CV_8UC1);
    System.out.println("mat = " + mat.dump());
  }
}
