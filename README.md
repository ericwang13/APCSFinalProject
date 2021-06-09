# APCSFinalProject

**Prototype Link**
https://docs.google.com/document/d/1XL-Z_4QGvfV4LoHfya_3lUnh3ud2iYfJE0QIXefAPtg/edit?usp=sharing

**Development Log**

1. Initialized IntelliJ JavaFX Project. Mostly boilerplate code so far, excluding some small formatting changes and FXML update via SceneBuilder

2. Added JavaFX SDK and OpenCV jar/dll dependancies. This was a particularly hard step becuase there is pretty limited documentation on loading DLLs into java.library.path, eventually figured it out with jvm arguments

3. Prepared for more image processing functions with auxiliary/utility methods. Methods include turning a OpenCV matrix into a JavaFX image.

4. Downloaded pre trained Haar classifiers from OpenCV docs for facial recognition uses.