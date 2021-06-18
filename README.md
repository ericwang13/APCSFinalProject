COMPILE/RUN Instructions
First clone and CD into the repository

To compile use this:

javac --module-path ./lib/openjfx/javafx-sdk-16/lib --add-modules javafx.controls,javafx.fxml,javafx.swing -cp ./lib/opencv/opencv-452.jar src/*.java

To run use this:

java --module-path "./lib/openjfx/javafx-sdk-16/lib" --add-modules javafx.controls,javafx.fxml --enable-preview -XX:+ShowCodeDetailsInExceptionMessages -Dfile.encoding=UTF-8 -classpath "./src;./lib/opencv/opencv-452.jar;./lib/openjfx/javafx-sdk-16/lib/javafx.swing.jar;./lib/openjfx/javafx-sdk-16/lib/javafx.fxml.jar;./lib/openjfx/javafx-sdk-16/lib/javafx.controls.jar;./lib/openjfx/javafx-sdk-16/lib/javafx.graphics.jar;./lib/openjfx/javafx-sdk-16/lib/javafx.web.jar;./lib/openjfx/javafx-sdk-16/lib/javafx.base.jar;./lib/openjfx/javafx-sdk-16/lib/javafx-swt.jar;./lib/openjfx/javafx-sdk-16/lib/javafx.media.jar" App