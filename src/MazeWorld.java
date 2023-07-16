import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

import javalib.impworld.World;
import javalib.impworld.WorldScene;
import javalib.worldimages.TextImage;

// represents the maze
class MazeWorld extends World {
  // represents vertex size
  // DESIGN NOTE: we chose to have a field representing vertex size created based
  // on the
  // maze dimensions so it would be easier to update the game if needed to make
  // room for larger mazes
  int vertexSize;
  // length of the game board
  int length;
  // width of the game board
  int width;
  // represents the background scene of the game we are rendering on
  WorldScene background;
  // the 2d array of vertices representing the game board
  ArrayList<ArrayList<Vertex>> vertexArray;
  // a random to assign random costs to walls
  Random randomCost;
  // a map of vertex pairs
  HashMap<Vertex, Vertex> vertexMap = new HashMap<Vertex, Vertex>();
  // a list of walls
  ArrayList<Wall> walls = new ArrayList<Wall>();
  // represents the player
  Player player;

  MazeWorld(int length, int width) {
    // throws exception if either game dimension is 0
    if (length == 0 || width == 0) {
      throw new IllegalArgumentException("Dimensions of the maze game cannot be 0!");
    }
    // throws exception if game dimensions are greater than 100x60
    if (length > 100 || width > 60) {
      throw new IllegalArgumentException(
          "Dimensions of the maze game cannot be greater than 100x60!");
    }
    // sets the vertex size according to the larger dimension of the game board
    if (length > width) {
      this.vertexSize = 450 / length + 5;
    }
    else {
      this.vertexSize = 450 / width + 5;
    }
    this.length = length;
    this.width = width;
    // creates a background with dimensions proportional to the given length and
    // width
    this.background = new WorldScene(length * this.vertexSize, width * this.vertexSize);
    this.randomCost = new Random();
    this.player = new Player(this.vertexSize);
    // start the world scene by drawing the game
    this.drawGame();
  }

  // constructor for testing
  // does not call drawGame automatically
  MazeWorld(int length, int width, Random rand) {
    // throws exception if either game dimension is 0
    if (length == 0 || width == 0) {
      throw new IllegalArgumentException("Dimensions of the maze game cannot be 0!");
    }
    // throws exception if game dimensions are greater than 100x60
    if (length > 100 || width > 60) {
      throw new IllegalArgumentException(
          "Dimensions of the maze game cannot be greater than 100x60!");
    }
    // sets the vertex size according to the larger dimension of the game board
    if (length > width) {
      this.vertexSize = 450 / length + 5;
    }
    else {
      this.vertexSize = 450 / width + 5;
    }
    this.length = length;
    this.width = width;
    // creates a background with dimensions proportional to the given length and
    // width
    this.background = new WorldScene(length * this.vertexSize, width * this.vertexSize);
    this.randomCost = rand;
    this.player = new Player(this.vertexSize);
  }

  // renders the world scene
  public WorldScene makeScene() {
    // goes through each vertex in the array and checks if the right and bottom wall
    // should be displayed; if they should be, renders them on the scene
    for (ArrayList<Vertex> list : this.vertexArray) {
      for (Vertex v : list) {
        if (v.displayRightWall) {
          this.background.placeImageXY(v.drawRightWall(), v.x * this.vertexSize + this.vertexSize,
              v.y * this.vertexSize + this.vertexSize / 2);
        }
        if (v.displayBottomWall) {
          this.background.placeImageXY(v.drawBottomWall(),
              v.x * this.vertexSize + this.vertexSize / 2, v.y * this.vertexSize + this.vertexSize);
        }
      }
    }
    return this.background;
  }

  // draws the game by creating the squares at the start and end of the game and
  // drawing the maze
  // EFFECT: renders the start square, end square, and maze board on the screen
  public void drawGame() {
    this.drawPlayer();
    this.drawFirstSquare();
    this.drawLastSquare();
    this.createBoard();
  }

  // draws the first square at the start of the maze
  // EFFECT: renders a very light pink start square at the top left corner of the
  // scene
  void drawFirstSquare() {
    this.background.placeImageXY(
        new Vertex(0, 0, this.vertexSize, new Color(240, 209, 220)).drawVertex(), 0, 0);
  }

  // draws the last square at the end of the maze
  // EFFECT: renders a very dark pink end square at the bottom right corner of the
  // scene
  void drawLastSquare() {
    this.background
        .placeImageXY(
            new Vertex(this.length - 1, this.width - 1, this.vertexSize, new Color(194, 101, 136))
                .drawVertex(),
            (this.length - 1) * this.vertexSize, (this.width - 1) * this.vertexSize);
  }

  // covers the player's trail with a light color
  // EFFECT: renders a light pink square on the player's previous location when it
  // moves on
  void drawPrevVertex() {
    this.player.updatePrevColor(new Color(235, 183, 203));
    if (!(this.player.checkPrevPosition())) {
      this.background.placeImageXY(this.player.drawPrevVertex(),
          this.player.prevVertex.x * this.vertexSize, this.player.prevVertex.y * this.vertexSize);
    }
  }

  // draws the player's trail as it moves through the board
  // EFFECT: renders a dark pink square on the player's new location as it moves
  void drawPlayer() {
    if (!(this.player.checkCurrPosition())) {
      this.background.placeImageXY(this.player.drawCurrVertex(),
          this.player.currVertex.x * this.vertexSize, this.player.currVertex.y * this.vertexSize);
    }
  }

  // creates and draws the board of vertices
  // EFFECT: resets vertexArray to a new 2d array list and adds the correct number
  // of vertices, each with correct x and y parameters to the 2d array;
  // changes each vertex's top, left, right, and bottom fields to be the correct
  // adjacent vertex;
  // changes walls to be the list of walls between all vertices;
  // changes vertexMap to be an initial map where each vertex in mapped to itself;
  // performs kruskal's algorithm to change walls to reflect the minimum spanning
  // tree;
  // update the displayRightWall and displayBottomWall fields for vertex;
  // renders the walls of each vertex in the vertexArray onto background based on
  // whether they should be displayed or not;
  void createBoard() {
    // creates the array of all vertices
    this.createVertexArray();
    // links the adjacent vertices in the 2d array
    this.linkVertices();
    // creates the list of walls between all vertices
    this.createWalls();
    // creates initial mapping of each vertex
    this.createMap();
    // constructs the minimum spanning tree
    this.kruskalAlgo();
    // updates whether or not the right and bottom walls of each vertex should be
    // displayed
    this.updateDisplayWall();
  }

  // creates the array of all vertices
  // EFFECT: changes vertexArray so that there is a vertex added according to the
  // dimensions of the board
  void createVertexArray() {
    // resets vertexArray to a new 2d array list
    this.vertexArray = new ArrayList<ArrayList<Vertex>>();
    // creates a 2d array list of vertices
    // for the size of the width
    for (int i = 0; i < this.width; i++) {
      // adds a row to the 2d array
      this.vertexArray.add(new ArrayList<Vertex>());
      // for the size of the length
      for (int j = 0; j < this.length; j++) {
        // adds the a new vertex with correct x and y parameters to 2d array
        this.vertexArray.get(i).add(new Vertex(j, i, this.vertexSize, Color.white));
      }
    }
  }

  // links the adjacent vertices in the board
  // EFFECT: changes vertexArray so each vertex is linked with the correct left,
  // right, top, and bottom vertex
  void linkVertices() {
    for (int w = 0; w < this.width; w++) {
      for (int l = 0; l < this.length; l++) {
        if (w > 0) {
          this.vertexArray.get(w).get(l).top = this.vertexArray.get(w - 1).get(l);
        }
        if (w < this.width - 1) {
          this.vertexArray.get(w).get(l).bottom = this.vertexArray.get(w + 1).get(l);
        }
        if (l > 0) {
          this.vertexArray.get(w).get(l).left = this.vertexArray.get(w).get(l - 1);
        }
        if (l < this.length - 1) {
          this.vertexArray.get(w).get(l).right = this.vertexArray.get(w).get(l + 1);
        }
      }
    }
  }

  // creates the list of walls between all vertices sorted by their costs
  // EFFECT: updates walls to be a sorted list of walls between all vertices
  // sorted by their costs
  void createWalls() {
    // goes through every element in the 2d array list of vertices
    // except the last column and adds a wall between all vertices and their right
    for (int i = 0; i < this.width; i++) {
      for (int j = 0; j < this.length - 1; j++) {
        Vertex curr = this.vertexArray.get(i).get(j);
        this.walls.add(new Wall(curr, curr.right, this.randomCost.nextInt(100)));
      }
    }
    // goes through every element in the 2d array list of vertices
    // except the last row and adds a wall between all vertices and their bottom
    for (int i = 0; i < this.width - 1; i++) {
      for (int j = 0; j < this.length; j++) {
        Vertex curr = this.vertexArray.get(i).get(j);
        this.walls.add(new Wall(curr, curr.bottom, randomCost.nextInt(100)));
      }
    }
    // sorts the walls by their costs
    Collections.sort(this.walls, new WeightComparator());
  }

  // initializes the vertices hashmap by setting each node as the value to itself
  void createMap() {
    for (ArrayList<Vertex> list : this.vertexArray) {
      for (Vertex v : list) {
        this.vertexMap.put(v, v);
      }
    }
  }

  // constructs the minimum spanning tree using kruskal's algorithm
  // EFFECT: updates walls to reflect the minimum spanning tree
  // that only includes walls that do not create a cycle
  void kruskalAlgo() {
    ArrayList<Wall> wallsToKeep = new ArrayList<Wall>();
    for (Wall w : this.walls) {
      // if the wall doesn't create a cycle
      if (!(this.find(w.v1).equals(this.find(w.v2)))) {
        wallsToKeep.add(w); // add it to the wallsToKeep
        this.union(w.v1, w.v2); // union the vertices connected by the wall
      }
    }
    this.walls = wallsToKeep; // update walls to only include the walls that don't create a cycle
  }

  // connects the given vertices in the map
  // EFFECT: changes the value of the given vertex's representative element in
  // vertexMap
  // to be the value of the second given vertex's representative element
  void union(Vertex v1, Vertex v2) {
    this.vertexMap.put(this.find(v1), this.find(v2));
  }

  // finds the representative element of this vertex
  Vertex find(Vertex item) {
    if (item.equals(this.vertexMap.get(item))) {
      return item;
    }
    else {
      return this.find(this.vertexMap.get(item));
    }
  }

  // changes whether the bottom and right wall associated with each vertex should
  // be displayed based on kruskals algorithm
  // EFFECT: changes the displayBottomWall and displayRightWall fields of each
  // wall in walls
  void updateDisplayWall() {
    // goes through all the walls that have been kept after kruskal's algo
    for (Wall w : this.walls) {
      if (w.v2.x == w.v1.x) {
        w.v1.displayBottomWall = false;
      }
      if (w.v2.y == w.v1.y) {
        w.v1.displayRightWall = false;
      }
    }
  }

  // checks if a player has reached the end square
  // if they have, displays the win screen
  // EFFECT: renders a "You Win!" message onto the world scene
  void checkWin() {
    if ((this.player.currVertex.x == this.length - 1)
        && (this.player.currVertex.y == this.width - 1)) {
      this.background.placeImageXY(
          new TextImage("You Win!", this.length * this.width / 80 + 30, Color.black),
          this.length * this.vertexSize / 2, this.width * this.vertexSize / 2);
    }
  }

  // changes the world when a key is pressed
  // EFFECT: when r is pressed, clears the world scene and renders a new maze
  // when right, left, down, or up is pressed, moves the player on the board
  // accordingly
  public void onKeyEvent(String key) {
    Color darkPink = new Color(227, 154, 182);
    if (key.equals("r")) {
      this.background = new WorldScene(length * this.vertexSize, width * this.vertexSize);
      this.player.currVertex = new Vertex(0, 0, this.vertexSize, new Color(227, 154, 182));
      this.drawGame();
    }
    if (key.equals("right") && this.player.currVertex.x < length - 1 && !(this.vertexArray
        .get(this.player.currVertex.y).get(this.player.currVertex.x).displayRightWall)) {
      this.player.prevVertex = this.player.currVertex;
      this.drawPrevVertex();
      this.player.currVertex = new Vertex(this.player.currVertex.x + 1, this.player.currVertex.y,
          this.vertexSize, darkPink);
      this.drawPlayer();
    }
    else if (key.equals("left") && this.player.currVertex.x > 0 && !(this.vertexArray
        .get(this.player.currVertex.y).get(this.player.currVertex.x - 1).displayRightWall)) {
      this.player.prevVertex = this.player.currVertex;
      this.drawPrevVertex();
      this.player.currVertex = new Vertex(this.player.currVertex.x - 1, this.player.currVertex.y,
          this.vertexSize, darkPink);
      this.drawPlayer();
    }
    else if (key.equals("up") && this.player.currVertex.y > 0 && !(this.vertexArray
        .get(this.player.currVertex.y - 1).get(this.player.currVertex.x).displayBottomWall)) {
      this.player.prevVertex = this.player.currVertex;
      this.drawPrevVertex();
      this.player.currVertex = new Vertex(this.player.currVertex.x, this.player.currVertex.y - 1,
          this.vertexSize, darkPink);
      this.drawPlayer();
    }
    else if (key.equals("down") && this.player.currVertex.y < width - 1 && !(this.vertexArray
        .get(this.player.currVertex.y).get(this.player.currVertex.x).displayBottomWall)) {
      this.player.prevVertex = this.player.currVertex;
      this.drawPrevVertex();
      this.player.currVertex = new Vertex(this.player.currVertex.x, this.player.currVertex.y + 1,
          this.vertexSize, darkPink);
      this.drawPlayer();
    }
    this.checkWin();
  }
}
