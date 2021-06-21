import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import org.opencv.core.*;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;

public class Util {
  public static Image matToImg(Mat frame) {
    try {
      return SwingFXUtils.toFXImage(matToBufferedImage(frame), null);
    } catch (Exception e) {
      System.err.println("Cannot convert the Mat object: " + e);
      return null;
    }
  }

  private static BufferedImage matToBufferedImage(Mat original) {
    BufferedImage image = null;
    int width = original.width(), height = original.height(), channels = original.channels();
    byte[] sourcePixels = new byte[width * height * channels];
    original.get(0, 0, sourcePixels);

    if (original.channels() > 1) {
      image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
    } else {
      image = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
    }

    final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
    System.arraycopy(sourcePixels, 0, targetPixels, 0, sourcePixels.length);

    return image;
  }

  public static String getClassifierPath() {
    File f = new File("src/haarcascade_frontalface_alt.xml");
    return f.getAbsolutePath();
  }

  public static Mat chooseFilter(Mat frame, int filter, int blur) {
    switch (filter) {
      case 1: return Detect.detectFace(frame);
      case 2: return Detect.blurFace(frame, blur);
      case 3: return Filter.edge(frame);
      case 4: return Filter.greyscale(frame);
      case 5: return Filter.sepia(frame);
      case 6: return Filter.blur(frame, blur);
      case 7: return Filter.noise(frame);
      default: return frame;
    }
  }
}
