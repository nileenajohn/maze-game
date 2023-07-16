import java.awt.Color;

import javalib.worldimages.WorldImage;

// represents a player and their trail
class Player {
  // constant representing player size
  int size;
  // the current vertex the player is on
  Vertex currVertex;
  // the vertices the player has visited
  Vertex prevVertex;

  Player(int size) {
    this.size = size;
    // initializes the player to be on the top left vertex of board
    this.currVertex = new Vertex(0, 0, size, new Color(227, 154, 182));
    this.prevVertex = new Vertex(0, 0, size, new Color(235, 183, 203));
  }

  // draws the previous vertex
  WorldImage drawPrevVertex() {
    return this.prevVertex.drawVertex();
  }

  // draws the current vertex
  WorldImage drawCurrVertex() {
    return this.currVertex.drawVertex();
  }

  void updatePrevColor(Color c) {
    this.prevVertex.updateColor(c);
  }

  // checks if the player's current position is 0, 0
  boolean checkCurrPosition() {
    return this.currVertex.checkPosition(0, 0);
  }

  // checks if the player's previous position is 0, 0
  boolean checkPrevPosition() {
    return this.prevVertex.checkPosition(0, 0);
  }
}