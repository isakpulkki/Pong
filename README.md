# Pong

In this program, you can play a popular table tennis-like multiplayer game called Pong. The application is programmed in Java using JavaFX.

The program allows for local multiplayer gameplay using keyboard. As default, the game ends when either side reaches ten points. The ball bounces logically according to its position and the position of the players. 

The program includes settings such as adjusting the size of the ball and changing the difficulty level. The program also has a SQLite database to save the settings.

## Instructions

Download the source code and follow the instructions below. Tested with Java JDK 11.

```bash
# Run the program
mvn compile exec:java -Dexec.mainClass=pong.Main

# Run the tests
mvn test

# Run test coverage report 
mvn jacoco:report

# Create JAR-file
mvn package

# Run Checkstyle
 mvn jxr:jxr checkstyle:checkstyle
 
# Generate JavaDoc
mvn javadoc:javadoc
```

You can modify some of the games configuration in [config.properties](https://github.com/isakpulkki/Pong/blob/main/src/main/resources/config.properties) -file.

## Documentation

* [Specification](https://github.com/isakpulkki/Pong/blob/main/docs/specification.md)

* [Testing](https://github.com/isakpulkki/Pong/blob/main/docs/testing.md)


