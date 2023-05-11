# Specification Document

In this program, you can play a popular table tennis-like multiplayer game called Pong. The application is programmed in Java using JavaFX.

The program allows for local multiplayer gameplay using keyboard. As default, the game ends when either side reaches ten points. The ball bounces logically according to its position and the position of the players. 

The program includes settings such as adjusting the size of the ball and changing the difficulty level. The program also has a SQLite database to save the settings.

The game opens to the main menu view, from where users can navigate to the game view, settings view, or exit the game.

## Menu View

* Displays the game logo
* Allows navigating to the game view, settings view, or exiting the program

## Game View

* In the game, two players use two keys to control their respective characters, moving them up or down 
* The game ball starts from the center in a random direction, either left or right 
* When the ball hits the left or right edge of the screen, the opponent on the other side scores a point 
* When a player hits the ball with their character, the ball speeds up in the opposite direction towards the opponent 
* Points are recorded at the top of the screen 
* The game is won at a certain score threshold 
* The game has separate views for starting, scoring points, and winning 
* The ball bounces logically based on the ball's and player's positions 
* Players can return to the main menu by pressing the ESC button

## Settings View

* Players can change the size of the ball 
* Players can adjust the game difficulty level, which determines the ball's speed 
* Players can modify the width of the player's character 
Players can return to the main menu by pressing a button 
Settings are saved to the database, ensuring they persist for the next gameplay session 