# Testing Document

The program is tested using automated unit and integration tests utilizing the JUnit library. The tests are not dependent on JavaFX.

## Unit and Integration Testing

The tests are organized into packages and classes that correspond to the program's structure.

The integration tests GameLogicTest and BallTest cover the game logic extensively. These test cases examine various aspects of the logic, such as player movement, scoring points, and ball behavior upon hitting the edges.

The SettingsLogicTest tests the settings logic and also indirectly tests the functionality of the database, eliminating the need for separate database tests.

## Test Coverage

All classes that are independent of JavaFX have been tested, meaning all classes excluding the user interface. The test coverage for the code is about 81%.

## System Testing

The game has been tested on Windows 11, macOS, and Ubuntu, and the program functions correctly on all operating systems. During testing, an issue was encountered with playing mp3 -files on macOS, specifically Cubbli, which seems to lack the necessary codecs required by the JavaFX media player. Attempts to update the JavaFX version did not resolve the issue, and eventually, the decision was made to remove the media player functionality.

## Known Quality Issues

The program functions flawlessly on Windows, but when running on Cubbli and Ubuntu, there is a minor bug in the program where the last label of the slider in the settings menu is missing.