# maze-game
A maze game with customizable maze dimensions.

# How to Play Maze Game:
When the game runs, a maze will be randomly created for you.
In the top left corner, a light pink square will be displayed, representing the 
start square, where the player starts the game. In the bottom right corner, 
a dark pink square will be displayed, representing the end square.  

To win, the player must use their arrow keys (left, right, up, down)
to navigate through the maze and reach the end square. There are horizontal
and vertical lines throughout the maze, called walls, which will block the player
from moving past. The player must reach the end square by finding a path that is not
blocked by a wall.

# Game options:
"up" - When the up arrow key is pressed, the player will move up if there is no wall in
the way and it is within the bounds of the game

"down" -  When the down arrow key is pressed, the player will move down if there is no wall in the way and it is within the bounds of the game

"left" - When the left arrow key is pressed, the player will move left if there is no wall in the way and it is within the bounds of the game

"right" -  When the right arrow key is pressed, the player will move right if there is no wall in the way and it is within the bounds of the game

"r" - When the r key is pressed, the game will reset and a new maze will be randomly created

"b" - When the b key is pressed, the path found by breadth first search will be displayed

"d" - When the d key is pressed, the path found by depth first search will be displayed
