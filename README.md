# APCSFinalProject

**Prototype Link**
https://docs.google.com/document/d/1XL-Z_4QGvfV4LoHfya_3lUnh3ud2iYfJE0QIXefAPtg/edit?usp=sharing

---

**Run Instructions**
1. Start by cloning the repository with
```
git clone https://github.com/ericwang13/APCSFinalProject.git
```
2. cd into the repository where you should a file called "ImageProcessing.jar" among other source files and build files

3. From here all you have to do is run the jar file. In order to do so you use java -jar [name-of-file.jar] except you also must add the opencv dynamic-link library file with the -Djava.library.path JVM argument.

The format for how to run the executable is as follows
```
java -Djava.library.path="[path-to-repository]/APCSFinalProject/lib/opencv" -jar ImageProcessing.jar
```

For example, on my machine it would be
```
java -Djava.library.path="/C/Users/Eric Wang/Desktop/APCSFinalProject/lib/opencv" -jar ImageProcessing.jar
```
Because I cloned the repository to my Desktop

---

**How To Use**

The application is pretty easy to use, there is only a text field and a update button. You enter the filter you wish to apply into the text field, and in order to apply you either click the return key while in the text field or click the button.

The filters are as follows:

|Number|Filter|
|---|---|
|1|Detect Face|
|2|Blur Face|
|3|Detect Edges|
|4|Greyscale|
|5|Sepia|
|6|Blur|
|7|Noise|
|Anything Other Number|No Filter|

Simply enter the number corresponding with the filter you want to apply

---

**Development Log**

1. Initialized IntelliJ JavaFX Project. Mostly boilerplate code so far, excluding some small formatting changes and FXML update via SceneBuilder

2. Added JavaFX SDK and OpenCV jar/dll dependancies. This was a particularly hard step becuase there is pretty limited documentation on loading DLLs into java.library.path, eventually figured it out with jvm arguments

3. Prepared for more image processing functions with auxiliary/utility methods. Methods include turning a OpenCV matrix into a JavaFX image.

4. Downloaded pre trained Haar classifiers from OpenCV docs for facial recognition uses.

5. Set up Main function to create JavaFX scene with image view in the top. Set up with simple function that will display live video feed from default camera without any processing or filtering.

6. Implemented haar cascade classifier into Detect.java. This creates a box around faces that are detected in the video stream (AKA face detection, although it is fairly limited in terms of accuracy, angles, etc).
Should be noted that I did not personally train any of the classifiers with machine learning, these are pre sets from OpenCV.

7. Implemented face blurring. Uses the same cascade classifier as face detection, but instead of drawing a rectangle around the face it blurs the rectangle over the face

8. Started working on various filters. I have some plans for the following filters: greyscale, box blur, gaussian blur, sepia, emboss, contours, duo tone, static, and tiling. I started with a super simple greyscale filter.

9. Completed sepia and box blur filters, made some plans for more filters and some JavaFX designs.

10. Worked on JavaFX frontend. Created a input field and submit button to change which filter/effect you want to use on the fly. Invalid numbers default to the capture stream without any effects. Pretty ugly, but functional.

11. Fixed the bug that would occur if anything was inputed besides an integer into the filter field

12. Improved JavaFX related stuff. Frontend difference is minimal, but on the backend code is much more organized. I reworked the JavaFX stuff to all be in the Controller class which is linked with the application.fxml file.

13. Added a new effect, the noise effect. This filter basically just makes the stream look bad, oversaturated and grainy/noisy

14. Added a blur slider that only appears when one of the slider effects are selected (blur face or box blur). For everything else it will hide.

15. Compiled everything into one packaged jar executable that can be easily run