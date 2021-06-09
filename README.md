# APCSFinalProject

**Prototype Link**
https://docs.google.com/document/d/1XL-Z_4QGvfV4LoHfya_3lUnh3ud2iYfJE0QIXefAPtg/edit?usp=sharing

**Development Log**

1. Initialized IntelliJ JavaFX Project. Mostly boilerplate code so far, excluding some small formatting changes and FXML update via SceneBuilder

2. Added JavaFX SDK and OpenCV jar/dll dependancies. This was a particularly hard step becuase there is pretty limited documentation on loading DLLs into java.library.path, eventually figured it out with jvm arguments

3. Prepared for more image processing functions with auxiliary/utility methods. Methods include turning a OpenCV matrix into a JavaFX image.

4. Downloaded pre trained Haar classifiers from OpenCV docs for facial recognition uses.

5. Set up Main function to create JavaFX scene with image view in the top. Set up with simple function that will display live video feed from default camera without any processing or filtering.

6. Implemented haar cascade classifier into Detect.java. This creates a box around faces that are detected in the video stream (AKA face detection, although it is fairly limited in terms of accuracy, angles, etc).
Should be noted that I did not personally train any of the classifiers with machine learning, these are pre sets from OpenCV.