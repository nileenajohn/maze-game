import java.awt.Color;

import javalib.worldimages.OutlineMode;
import javalib.worldimages.RectangleImage;
import javalib.worldimages.WorldImage;

// represents a single vertex in the maze
class Vertex {
  // constant representing vertex size
  // DESIGN NOTE: we chose to have a constant vertex size passed in from maze
  // world so it would be easier to update the game if needed to make room for
  // larger mazes
  int size;
  // represents vertex's position on the board
  int x;
  int y;
  // adjacent vertices on the board
  Vertex top;
  Vertex bottom;
  Vertex left;
  Vertex right;
  // whether or not the right wall should be displayed
  // DESIGN NOTE: we chose to have a boolean representing whether or not the walls
  // should be displayed so we could keep track of which walls of each vertex to
  // render
  boolean displayRightWall;
  // whether or not the bottom wall should be displayed
  boolean displayBottomWall;
  // whether or not the vertex has been visited
  boolean visited;
  // the color of the vertex
  Color color;

  Vertex(int x, int y, int size, Color color) {
    this.size = size;
    this.x = x;
    this.y = y;
    this.displayRightWall = true;
    this.displayBottomWall = true;
    this.visited = false;
    this.color = color;
  }

  // draws a vertex
  WorldImage drawVertex() {
    return new RectangleImage(this.size, this.size, OutlineMode.SOLID, this.color)
        .movePinhole(this.size / -2, this.size / -2);
  }

  // draws the right wall of a vertex
  WorldImage drawRightWall() {
    return new RectangleImage(1, this.size, OutlineMode.SOLID, Color.BLACK);
  }

  // draws the bottom wall of a vertex
  WorldImage drawBottomWall() {
    return new RectangleImage(this.size, 1, OutlineMode.SOLID, Color.BLACK);
  }

  // updates the color of the vertex
  // EFFECT: changes the color field of this vertex
  void updateColor(Color c) {
    this.color = c;
  }

  // checks if the vertex's x and y is the given x and y
  boolean checkPosition(int x, int y) {
    return this.x == x && this.y == y;
  }
}