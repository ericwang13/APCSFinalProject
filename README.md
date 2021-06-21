**VERY IMPORTANT**

In order for the app to work at all, you need to add the OpenCV DLL to java.library.path

There are many ways to do this, one of the easiest is just by taking the opencv_java452.dll file in APCSFinalProject/lib/opencv and copying it to the location of your JDK. For me, this is C:\Program Files\AdoptOpenJDK\jdk-11.0.11.9-hotspot\bin

Once you do this, the library can be loaded properly and everything should work well.

# COMPILE/RUN Instructions

First clone and CD into the repository

## Compile

```
javac --module-path ./lib/openjfx/javafx-sdk-16/lib --add-modules javafx.controls,javafx.fxml,javafx.swing -cp ./lib/opencv/opencv-452.jar src/*.java
```

## Run

```
java --module-path "./lib/openjfx/javafx-sdk-16/lib" --add-modules javafx.controls,javafx.fxml --enable-preview -classpath "./src;./lib/opencv/opencv-452.jar;./lib/openjfx/javafx-sdk-16/lib/javafx.swing.jar;./lib/openjfx/javafx-sdk-16/lib/javafx.fxml.jar;./lib/openjfx/javafx-sdk-16/lib/javafx.controls.jar;./lib/openjfx/javafx-sdk-16/lib/javafx.graphics.jar;./lib/openjfx/javafx-sdk-16/lib/javafx.web.jar;./lib/openjfx/javafx-sdk-16/lib/javafx.base.jar;./lib/openjfx/javafx-sdk-16/lib/javafx-swt.jar;./lib/openjfx/javafx-sdk-16/lib/javafx.media.jar" App
```
