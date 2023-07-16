import java.util.*;
import tester.*;
import javalib.impworld.*;
import java.awt.Color;
import javalib.worldimages.*;

// examples and tests
class ExamplesMaze {
  // examples of MazeWorld
  MazeWorld world1;
  MazeWorld world2;
  MazeWorld world3;
  MazeWorld world4;

  // examples of Vertices
  Vertex v1;
  Vertex v2;
  Vertex v3;
  Vertex v4;
  Vertex v5;
  Vertex v6;

  // examples of Players
  Player p1;
  Player p2;
  Player p3;

  // initializes vertex examples
  void initVertex() {
    v1 = new Vertex(1, 1, 20, Color.white);
    v2 = new Vertex(14, 11, 10, Color.white);
    v3 = new Vertex(0, 0, 0, Color.white);
    v4 = new Vertex(2, 32, 50, Color.white);
    v5 = new Vertex(60, 100, 25, Color.white);
    v6 = new Vertex(57, 84, 17, Color.white);
  }

  // initializes the MazeWorld examples
  void initWorld() {
    this.world1 = new MazeWorld(13, 20, new Random(5));
    this.world2 = new MazeWorld(50, 50, new Random(1));
    this.world3 = new MazeWorld(100, 60, new Random(21));
    this.world4 = new MazeWorld(3, 3, new Random(100));
  }

  // initializes the Player examples
  void initPlayer() {
    this.p1 = new Player(10);
    this.p2 = new Player(25);
    this.p3 = new Player(34);
  }

  // runs the game by calling big bang on the world of dimensions 10x20
  void testBigBang1(Tester t) {
    MazeWorld world = new MazeWorld(10, 20);
    world.bigBang(1000, 800);
  }

  // runs the game by calling big bang on the world of dimensions 50x50
  void testBigBang2(Tester t) {
    MazeWorld world = new MazeWorld(50, 50);
    world.bigBang(1000, 800);
  }

  // runs the game by calling big bang on the world of dimensions 100x60
  void testBigBang3(Tester t) {
    MazeWorld world = new MazeWorld(100, 60);
    world.bigBang(1000, 800);
  }

  // runs the game by calling big bang on the world of dimensions 3x3
  void testBigBang4(Tester t) {
    MazeWorld world = new MazeWorld(3, 3);
    world.bigBang(1000, 800);
  }

  // test for exceptions
  void testExceptions(Tester t) {
    t.checkConstructorException(
        new IllegalArgumentException("Dimensions of the maze game cannot be 0!"), "MazeWorld", 20,
        0, new Random(100));
    t.checkConstructorException(
        new IllegalArgumentException("Dimensions of the maze game cannot be 0!"), "MazeWorld", 0,
        61, new Random(100));
    t.checkConstructorException(
        new IllegalArgumentException("Dimensions of the maze game cannot be 0!"), "MazeWorld", 0, 0,
        new Random(100));
    t.checkConstructorException(
        new IllegalArgumentException("Dimensions of the maze game cannot be greater than 100x60!"),
        "MazeWorld", 100, 61, new Random(100));
    t.checkConstructorException(
        new IllegalArgumentException("Dimensions of the maze game cannot be greater than 100x60!"),
        "MazeWorld", 101, 60, new Random(100));
    t.checkConstructorException(
        new IllegalArgumentException("Dimensions of the maze game cannot be greater than 100x60!"),
        "MazeWorld", 101, 61, new Random(100));
    t.checkConstructorException(
        new IllegalArgumentException("Dimensions of the maze game cannot be greater than 100x60!"),
        "MazeWorld", 20, 321, new Random(100));
    t.checkConstructorException(
        new IllegalArgumentException("Dimensions of the maze game cannot be greater than 100x60!"),
        "MazeWorld", 494, 61, new Random(100));
  }

  // test for the method drawVertex
  void testDrawVertex(Tester t) {
    initVertex();
    t.checkExpect(this.v1.drawVertex(),
        new RectangleImage(20, 20, OutlineMode.SOLID, Color.white).movePinhole(-10, -10));
    t.checkExpect(this.v2.drawVertex(),
        new RectangleImage(10, 10, OutlineMode.SOLID, Color.white).movePinhole(-5, -5));
    t.checkExpect(this.v3.drawVertex(),
        new RectangleImage(0, 0, OutlineMode.SOLID, Color.white).movePinhole(0, 0));
    t.checkExpect(this.v4.drawVertex(),
        new RectangleImage(50, 50, OutlineMode.SOLID, Color.white).movePinhole(-25, -25));
    t.checkExpect(this.v5.drawVertex(),
        new RectangleImage(25, 25, OutlineMode.SOLID, Color.white).movePinhole(-12, -12));
    t.checkExpect(this.v6.drawVertex(),
        new RectangleImage(17, 17, OutlineMode.SOLID, Color.white).movePinhole(-8, -8));
  }

  // test for the method drawRightWall
  void testDrawRightWall(Tester t) {
    initVertex();
    t.checkExpect(this.v1.drawRightWall(),
        new RectangleImage(1, 20, OutlineMode.SOLID, Color.BLACK));
    t.checkExpect(this.v2.drawRightWall(),
        new RectangleImage(1, 10, OutlineMode.SOLID, Color.BLACK));
    t.checkExpect(this.v3.drawRightWall(),
        new RectangleImage(1, 0, OutlineMode.SOLID, Color.BLACK));
    t.checkExpect(this.v4.drawRightWall(),
        new RectangleImage(1, 50, OutlineMode.SOLID, Color.BLACK));
    t.checkExpect(this.v5.drawRightWall(),
        new RectangleImage(1, 25, OutlineMode.SOLID, Color.BLACK));
    t.checkExpect(this.v6.drawRightWall(),
        new RectangleImage(1, 17, OutlineMode.SOLID, Color.BLACK));
  }

  // test for the method drawBottomWall
  void testDrawBottomWall(Tester t) {
    initVertex();
    t.checkExpect(this.v1.drawBottomWall(),
        new RectangleImage(20, 1, OutlineMode.SOLID, Color.BLACK));
    t.checkExpect(this.v2.drawBottomWall(),
        new RectangleImage(10, 1, OutlineMode.SOLID, Color.BLACK));
    t.checkExpect(this.v3.drawBottomWall(),
        new RectangleImage(0, 1, OutlineMode.SOLID, Color.BLACK));
    t.checkExpect(this.v4.drawBottomWall(),
        new RectangleImage(50, 1, OutlineMode.SOLID, Color.BLACK));
    t.checkExpect(this.v5.drawBottomWall(),
        new RectangleImage(25, 1, OutlineMode.SOLID, Color.BLACK));
    t.checkExpect(this.v6.drawBottomWall(),
        new RectangleImage(17, 1, OutlineMode.SOLID, Color.BLACK));
  }

  void testUpdateColor(Tester t) {
    initVertex();
    t.checkExpect(v1.color, Color.white);
    v1.updateColor(Color.pink);
    t.checkExpect(v1.color, Color.pink);
    t.checkExpect(v2.color, Color.white);
    v2.updateColor(Color.blue);
    t.checkExpect(v2.color, Color.blue);
    t.checkExpect(v3.color, Color.white);
    v3.updateColor(Color.red);
    t.checkExpect(v3.color, Color.red);
    t.checkExpect(v4.color, Color.white);
    v4.updateColor(Color.yellow);
    t.checkExpect(v4.color, Color.yellow);
    t.checkExpect(v5.color, Color.white);
    v5.updateColor(Color.green);
    t.checkExpect(v5.color, Color.green);
    t.checkExpect(v6.color, Color.white);
    v6.updateColor(Color.gray);
    t.checkExpect(v6.color, Color.gray);
  }

  // test for the method checkPosition
  void testCheckPosition(Tester t) {
    t.checkExpect(v1.checkPosition(1, 1), true);
    t.checkExpect(v1.checkPosition(0, 0), false);
    t.checkExpect(v1.checkPosition(4, 7), false);

    t.checkExpect(v2.checkPosition(14, 11), true);
    t.checkExpect(v2.checkPosition(14, 10), false);

    t.checkExpect(v3.checkPosition(0, 0), true);
    t.checkExpect(v3.checkPosition(0, 1), false);

    t.checkExpect(v4.checkPosition(2, 32), true);
    t.checkExpect(v4.checkPosition(2, 31), false);

    t.checkExpect(v5.checkPosition(60, 100), true);
    t.checkExpect(v5.checkPosition(39, 27), false);

    t.checkExpect(v6.checkPosition(57, 84), true);
    t.checkExpect(v6.checkPosition(0, 0), false);
  }

  // test for the method drawPrevVertex in the Player class
  void testDrawPrevVertexPlayer(Tester t) {
    initPlayer();
    t.checkExpect(this.p1.drawPrevVertex(),
        new RectangleImage(10, 10, OutlineMode.SOLID, new Color(235, 183, 203)).movePinhole(-5,
            -5));
    t.checkExpect(this.p2.drawPrevVertex(),
        new RectangleImage(25, 25, OutlineMode.SOLID, new Color(235, 183, 203)).movePinhole(-12,
            -12));
    t.checkExpect(this.p3.drawPrevVertex(),
        new RectangleImage(34, 34, OutlineMode.SOLID, new Color(235, 183, 203)).movePinhole(-17,
            -17));
  }

  // test for the method drawCurrVertex in the Player class
  void testDrawCurrVertexPlayer(Tester t) {
    initPlayer();
    t.checkExpect(this.p1.drawCurrVertex(),
        new RectangleImage(10, 10, OutlineMode.SOLID, new Color(227, 154, 182)).movePinhole(-5,
            -5));
    t.checkExpect(this.p2.drawCurrVertex(),
        new RectangleImage(25, 25, OutlineMode.SOLID, new Color(227, 154, 182)).movePinhole(-12,
            -12));
    t.checkExpect(this.p3.drawCurrVertex(),
        new RectangleImage(34, 34, OutlineMode.SOLID, new Color(227, 154, 182)).movePinhole(-17,
            -17));
  }

  // test for the method updatePrevColor
  void testUpdatePrevColor(Tester t) {
    t.checkExpect(this.p1.prevVertex.color, new Color(235, 183, 203));
    this.p1.updatePrevColor(Color.pink);
    t.checkExpect(this.p1.prevVertex.color, Color.pink);
    this.p1.updatePrevColor(Color.blue);
    t.checkExpect(this.p1.prevVertex.color, Color.blue);
    t.checkExpect(this.p2.prevVertex.color, new Color(235, 183, 203));
    this.p2.updatePrevColor(Color.green);
    t.checkExpect(this.p2.prevVertex.color, Color.green);
    t.checkExpect(this.p3.prevVertex.color, new Color(235, 183, 203));
    this.p3.updatePrevColor(Color.gray);
    t.checkExpect(this.p3.prevVertex.color, Color.gray);
    this.p3.updatePrevColor(new Color(235, 183, 203));
    t.checkExpect(this.p3.prevVertex.color, new Color(235, 183, 203));
  }

  // test for the method checkCurrPosition
  void testCheckCurrPosition(Tester t) {
    initPlayer();
    t.checkExpect(this.p1.checkCurrPosition(), true);
    this.p1.currVertex.x = 2;
    t.checkExpect(this.p1.checkCurrPosition(), false);
    this.p1.currVertex.x = 0;
    this.p1.currVertex.y = 9;
    t.checkExpect(this.p1.checkCurrPosition(), false);

    t.checkExpect(this.p2.checkCurrPosition(), true);
    this.p1.currVertex.y = 81;
    t.checkExpect(this.p1.checkCurrPosition(), false);
    this.p1.currVertex.x = 12;
    this.p1.currVertex.y = 37;
    t.checkExpect(this.p1.checkCurrPosition(), false);

    t.checkExpect(this.p3.checkCurrPosition(), true);
    this.p1.currVertex.x = 5;
    this.p1.currVertex.y = 23;
    t.checkExpect(this.p1.checkCurrPosition(), false);
  }

  // test for the method checkPrevPosition
  void testCheckPrevPosition(Tester t) {
    initPlayer();
    t.checkExpect(this.p1.checkPrevPosition(), true);
    this.p1.prevVertex.x = 2;
    t.checkExpect(this.p1.checkPrevPosition(), false);
    this.p1.prevVertex.x = 0;
    this.p1.prevVertex.y = 9;
    t.checkExpect(this.p1.checkPrevPosition(), false);

    t.checkExpect(this.p2.checkPrevPosition(), true);
    this.p1.prevVertex.y = 81;
    t.checkExpect(this.p1.checkPrevPosition(), false);
    this.p1.prevVertex.x = 12;
    this.p1.prevVertex.y = 37;
    t.checkExpect(this.p1.checkPrevPosition(), false);

    t.checkExpect(this.p3.checkPrevPosition(), true);
    this.p1.prevVertex.x = 5;
    this.p1.prevVertex.y = 23;
    t.checkExpect(this.p1.checkPrevPosition(), false);
  }

  // test for the method makeScene
  void testMakeScene(Tester t) {
    initWorld();
    this.world1.createVertexArray();
    this.world1.createBoard();
    this.world1.createMap();
    WorldScene world1Scene = new WorldScene(351, 540);
    for (ArrayList<Vertex> list : this.world1.vertexArray) {
      for (Vertex v : list) {
        if (v.displayRightWall) {
          world1Scene.placeImageXY(v.drawRightWall(),
              v.x * this.world1.vertexSize + this.world1.vertexSize,
              v.y * this.world1.vertexSize + this.world1.vertexSize / 2);
        }
        if (v.displayBottomWall) {
          world1Scene.placeImageXY(v.drawBottomWall(),
              v.x * this.world1.vertexSize + this.world1.vertexSize / 2,
              v.y * this.world1.vertexSize + this.world1.vertexSize);
        }
      }
    }
    t.checkExpect(this.world1.makeScene(), world1Scene);

    this.world4.createVertexArray();
    this.world4.createBoard();
    this.world4.createMap();
    WorldScene world4Scene = new WorldScene(465, 465);
    world4Scene.placeImageXY(this.world4.vertexArray.get(0).get(1).drawBottomWall(), 232, 155);
    world4Scene.placeImageXY(this.world4.vertexArray.get(0).get(2).drawRightWall(), 465, 77);
    world4Scene.placeImageXY(this.world4.vertexArray.get(1).get(0).drawRightWall(), 155, 232);
    world4Scene.placeImageXY(this.world4.vertexArray.get(1).get(1).drawRightWall(), 310, 232);
    world4Scene.placeImageXY(this.world4.vertexArray.get(1).get(2).drawRightWall(), 465, 232);
    world4Scene.placeImageXY(this.world4.vertexArray.get(2).get(0).drawRightWall(), 155, 387);
    world4Scene.placeImageXY(this.world4.vertexArray.get(2).get(0).drawBottomWall(), 77, 465);
    world4Scene.placeImageXY(this.world4.vertexArray.get(2).get(1).drawBottomWall(), 232, 465);
    world4Scene.placeImageXY(this.world4.vertexArray.get(2).get(2).drawRightWall(), 465, 387);
    world4Scene.placeImageXY(this.world4.vertexArray.get(2).get(1).drawBottomWall(), 387, 465);

    t.checkExpect(this.world4.makeScene(), world4Scene);
  }

  // test for the method drawGame
  void testDrawGame(Tester t) {
    initWorld();

    WorldScene world1Scene = new WorldScene(351, 540);
    t.checkExpect(this.world1.background, world1Scene);

    this.world1.drawGame();
    world1Scene.placeImageXY(new RectangleImage(27, 27, OutlineMode.SOLID, new Color(240, 209, 220))
        .movePinhole(-13, -13), 0, 0);
    world1Scene.placeImageXY(new RectangleImage(27, 27, OutlineMode.SOLID, new Color(194, 101, 136))
        .movePinhole(-13, -13), 324, 513);
    t.checkExpect(this.world1.background, world1Scene);

    WorldScene world4Scene = new WorldScene(465, 465);
    t.checkExpect(this.world4.background, world4Scene);

    this.world4.drawGame();
    world4Scene
        .placeImageXY(new RectangleImage(155, 155, OutlineMode.SOLID, new Color(240, 209, 220))
            .movePinhole(-77, -77), 0, 0);
    world4Scene
        .placeImageXY(new RectangleImage(155, 155, OutlineMode.SOLID, new Color(194, 101, 136))
            .movePinhole(-77, -77), 310, 310);
    t.checkExpect(this.world4.background, world4Scene);

    this.world4.makeScene();
    world4Scene.placeImageXY(this.world4.vertexArray.get(0).get(1).drawBottomWall(), 232, 155);
    world4Scene.placeImageXY(this.world4.vertexArray.get(0).get(2).drawRightWall(), 465, 77);
    world4Scene.placeImageXY(this.world4.vertexArray.get(1).get(0).drawRightWall(), 155, 232);
    world4Scene.placeImageXY(this.world4.vertexArray.get(1).get(1).drawRightWall(), 310, 232);
    world4Scene.placeImageXY(this.world4.vertexArray.get(1).get(2).drawRightWall(), 465, 232);
    world4Scene.placeImageXY(this.world4.vertexArray.get(2).get(0).drawRightWall(), 155, 387);
    world4Scene.placeImageXY(this.world4.vertexArray.get(2).get(0).drawBottomWall(), 77, 465);
    world4Scene.placeImageXY(this.world4.vertexArray.get(2).get(1).drawBottomWall(), 232, 465);
    world4Scene.placeImageXY(this.world4.vertexArray.get(2).get(2).drawRightWall(), 465, 387);
    world4Scene.placeImageXY(this.world4.vertexArray.get(2).get(2).drawBottomWall(), 387, 465);
    t.checkExpect(this.world4.background, world4Scene);
  }

  // test for the method drawFirstSquare
  void testDrawFirstSquare(Tester t) {
    initWorld();
    WorldScene newBg1 = new WorldScene(351, 540);
    t.checkExpect(this.world1.background, newBg1);
    this.world1.drawFirstSquare();
    newBg1.placeImageXY(new RectangleImage(27, 27, OutlineMode.SOLID, new Color(240, 209, 220))
        .movePinhole(-13, -13), 0, 0);
    t.checkExpect(this.world1.background, newBg1);

    WorldScene newBg2 = new WorldScene(700, 700);
    t.checkExpect(this.world2.background, newBg2);
    this.world2.drawFirstSquare();
    newBg2.placeImageXY(
        new RectangleImage(14, 14, OutlineMode.SOLID, new Color(240, 209, 220)).movePinhole(-7, -7),
        0, 0);
    t.checkExpect(this.world2.background, newBg2);

    WorldScene newBg3 = new WorldScene(900, 540);
    t.checkExpect(this.world3.background, newBg3);
    this.world3.drawFirstSquare();
    newBg3.placeImageXY(
        new RectangleImage(9, 9, OutlineMode.SOLID, new Color(240, 209, 220)).movePinhole(-4, -4),
        0, 0);
    t.checkExpect(this.world3.background, newBg3);

    WorldScene newBg4 = new WorldScene(465, 465);
    t.checkExpect(this.world4.background, newBg4);
    this.world4.drawFirstSquare();
    newBg4.placeImageXY(new RectangleImage(155, 155, OutlineMode.SOLID, new Color(240, 209, 220))
        .movePinhole(-77, -77), 0, 0);
    t.checkExpect(this.world4.background, newBg4);
  }

  // test for the method drawLastSquare
  void testDrawLastSquare(Tester t) {
    initWorld();
    WorldScene newBg1 = new WorldScene(351, 540);
    t.checkExpect(this.world1.background, newBg1);
    this.world1.drawLastSquare();
    newBg1.placeImageXY(new RectangleImage(27, 27, OutlineMode.SOLID, new Color(194, 101, 136))
        .movePinhole(-13, -13), 324, 513);
    t.checkExpect(this.world1.background, newBg1);

    WorldScene newBg2 = new WorldScene(700, 700);
    t.checkExpect(this.world2.background, newBg2);
    this.world2.drawLastSquare();
    newBg2.placeImageXY(
        new RectangleImage(14, 14, OutlineMode.SOLID, new Color(194, 101, 136)).movePinhole(-7, -7),
        686, 686);
    t.checkExpect(this.world2.background, newBg2);

    WorldScene newBg3 = new WorldScene(900, 540);
    t.checkExpect(this.world3.background, newBg3);
    this.world3.drawLastSquare();
    newBg3.placeImageXY(
        new RectangleImage(9, 9, OutlineMode.SOLID, new Color(194, 101, 136)).movePinhole(-4, -4),
        891, 531);
    t.checkExpect(this.world3.background, newBg3);

    WorldScene newBg5 = new WorldScene(465, 465);
    t.checkExpect(this.world4.background, newBg5);
    this.world4.drawLastSquare();
    newBg5.placeImageXY(new RectangleImage(155, 155, OutlineMode.SOLID, new Color(194, 101, 136))
        .movePinhole(-77, -77), 310, 310);
    t.checkExpect(this.world4.background, newBg5);
  }

  // test for the method drawPrevVertex
  void testDrawPrevVertex(Tester t) {
    initWorld();
    this.world1.createVertexArray();
    this.world1.drawPrevVertex();

    WorldScene world1Scene = new WorldScene(351, 540);

    // no change because the vertex position is 0, 0
    this.world1.drawPrevVertex();
    t.checkExpect(this.world1.background, world1Scene);

    this.world1.player.prevVertex.x = 12;
    this.world1.player.prevVertex.y = 8;

    this.world1.drawPrevVertex();
    world1Scene.placeImageXY(new RectangleImage(27, 27, OutlineMode.SOLID, new Color(235, 183, 203))
        .movePinhole(-13, -13), 324, 216);
    t.checkExpect(this.world1.background, world1Scene);

    this.world1.player.prevVertex.x = 13;
    this.world1.player.prevVertex.y = 20;

    this.world1.drawPrevVertex();
    world1Scene.placeImageXY(new RectangleImage(27, 27, OutlineMode.SOLID, new Color(235, 183, 203))
        .movePinhole(-13, -13), 351, 540);
    t.checkExpect(this.world1.background, world1Scene);

    this.world1.createVertexArray();
    this.world1.drawPrevVertex();

    WorldScene world4Scene = new WorldScene(465, 465);

    // no change because the vertex position is 0, 0
    this.world4.drawPrevVertex();
    t.checkExpect(this.world4.background, world4Scene);

    this.world4.player.prevVertex.x = 1;
    this.world4.player.prevVertex.y = 1;

    this.world4.drawPrevVertex();
    world4Scene
        .placeImageXY(new RectangleImage(155, 155, OutlineMode.SOLID, new Color(235, 183, 203))
            .movePinhole(-77, -77), 155, 155);
    t.checkExpect(this.world4.background, world4Scene);

    this.world4.player.prevVertex.x = 3;
    this.world4.player.prevVertex.y = 2;

    this.world4.drawPrevVertex();
    world4Scene
        .placeImageXY(new RectangleImage(155, 155, OutlineMode.SOLID, new Color(235, 183, 203))
            .movePinhole(-77, -77), 465, 310);
    t.checkExpect(this.world4.background, world4Scene);
  }

  // test for the method drawPlayer
  void testDrawPlayer(Tester t) {
    initWorld();
    this.world4.createVertexArray();
    WorldScene world4Scene = new WorldScene(465, 465);

    // player doesn't show up on screen because position is 0, 0
    this.world4.drawPlayer();
    t.checkExpect(this.world4.background, world4Scene);

    // changes position to 1, 1
    this.world4.player.currVertex = this.world4.vertexArray.get(1).get(1);

    this.world4.drawPlayer();
    world4Scene
        .placeImageXY(new RectangleImage(155, 155, OutlineMode.SOLID, new Color(255, 255, 255))
            .movePinhole(-77, -77), 155, 155);
    t.checkExpect(this.world4.background, world4Scene);

    // changes position to 2, 1
    this.world4.player.currVertex = this.world4.vertexArray.get(2).get(1);

    this.world4.drawPlayer();
    world4Scene
        .placeImageXY(new RectangleImage(155, 155, OutlineMode.SOLID, new Color(255, 255, 255))
            .movePinhole(-77, -77), 155, 310);
    t.checkExpect(this.world4.background, world4Scene);
  }

  // test for the method createBoard
  void testCreateBoard(Tester t) {
    initWorld();
    t.checkExpect(this.world4.vertexArray, null);
    t.checkExpect(this.world4.walls, new ArrayList<Wall>());
    this.world4.createVertexArray();
    // checks that all the vertex's displayBottomWall and displayRightWall fields
    // have not yet been changed
    for (ArrayList<Vertex> list : this.world4.vertexArray) {
      for (Vertex v : list) {
        t.checkExpect(v.displayBottomWall, true);
        t.checkExpect(v.displayRightWall, true);
      }
    }
    WorldScene world4Scene = new WorldScene(465, 465);
    t.checkExpect(this.world4.background, world4Scene);
    this.world4.createBoard();
    // checks the vertices' displayBottomWall and displayRightWall fields have been
    // changed
    boolean unchanged = true;
    for (ArrayList<Vertex> list : this.world4.vertexArray) {
      for (Vertex v : list) {
        if (!(v.displayBottomWall) || !(v.displayRightWall)) {
          unchanged = false;
        }
      }
    }
    t.checkExpect(unchanged, false);
    t.checkExpect(this.world4.background, world4Scene);
  }

  // test for the method createVertexArray
  void testCreateVertexArray(Tester t) {
    initWorld();
    t.checkExpect(this.world1.vertexArray, null);
    t.checkExpect(this.world2.vertexArray, null);
    t.checkExpect(this.world3.vertexArray, null);
    t.checkExpect(this.world4.vertexArray, null);

    this.world1.createVertexArray();
    t.checkExpect(this.world1.vertexArray.size(), 20);
    for (ArrayList<Vertex> list : this.world1.vertexArray) {
      t.checkExpect(list.size(), 13);
    }
    this.world2.createVertexArray();
    t.checkExpect(this.world2.vertexArray.size(), 50);
    for (ArrayList<Vertex> list : this.world2.vertexArray) {
      t.checkExpect(list.size(), 50);
    }
    this.world3.createVertexArray();
    t.checkExpect(this.world3.vertexArray.size(), 60);
    for (ArrayList<Vertex> list : this.world3.vertexArray) {
      t.checkExpect(list.size(), 100);
    }
    this.world4.createVertexArray();
    t.checkExpect(this.world4.vertexArray.size(), 3);
    for (ArrayList<Vertex> list : this.world4.vertexArray) {
      t.checkExpect(list.size(), 3);
    }

    for (int i = 0; i < 20; i++) {
      for (int j = 0; j < 13; j++) {
        t.checkExpect(this.world1.vertexArray.get(i).get(j), new Vertex(j, i, 27, Color.white));
      }
    }
    for (int i = 0; i < 50; i++) {
      for (int j = 0; j < 50; j++) {
        t.checkExpect(this.world2.vertexArray.get(i).get(j), new Vertex(j, i, 14, Color.white));
      }
    }
    for (int i = 0; i < 60; i++) {
      for (int j = 0; j < 100; j++) {
        t.checkExpect(this.world3.vertexArray.get(i).get(j), new Vertex(j, i, 9, Color.white));
      }
    }
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        t.checkExpect(this.world4.vertexArray.get(i).get(j), new Vertex(j, i, 155, Color.white));
      }
    }
  }

  // test for the method linkVertices
  void testLinkVertices(Tester t) {
    initWorld();

    this.world1.createVertexArray();
    this.world1.linkVertices();
    Vertex world1v1 = this.world1.vertexArray.get(0).get(0);
    Vertex world1v2 = this.world1.vertexArray.get(0).get(1);
    Vertex world1v3 = this.world1.vertexArray.get(0).get(2);
    Vertex world1v4 = this.world1.vertexArray.get(0).get(3);
    Vertex world1v5 = this.world1.vertexArray.get(0).get(4);
    Vertex world1v6 = this.world1.vertexArray.get(0).get(5);
    Vertex world1v7 = this.world1.vertexArray.get(0).get(6);
    Vertex world1v8 = this.world1.vertexArray.get(0).get(7);
    Vertex world1v9 = this.world1.vertexArray.get(0).get(8);
    Vertex world1v10 = this.world1.vertexArray.get(0).get(9);
    Vertex world1v11 = this.world1.vertexArray.get(0).get(10);
    Vertex world1v12 = this.world1.vertexArray.get(0).get(11);
    Vertex world1v13 = this.world1.vertexArray.get(0).get(12);

    Vertex world1v14 = this.world1.vertexArray.get(1).get(0);
    Vertex world1v15 = this.world1.vertexArray.get(1).get(1);
    Vertex world1v16 = this.world1.vertexArray.get(1).get(2);
    Vertex world1v17 = this.world1.vertexArray.get(1).get(3);
    Vertex world1v18 = this.world1.vertexArray.get(1).get(4);
    Vertex world1v19 = this.world1.vertexArray.get(1).get(5);
    Vertex world1v20 = this.world1.vertexArray.get(1).get(6);
    Vertex world1v21 = this.world1.vertexArray.get(1).get(7);
    Vertex world1v22 = this.world1.vertexArray.get(1).get(8);
    Vertex world1v23 = this.world1.vertexArray.get(1).get(9);
    Vertex world1v24 = this.world1.vertexArray.get(1).get(10);
    Vertex world1v25 = this.world1.vertexArray.get(1).get(11);
    Vertex world1v26 = this.world1.vertexArray.get(1).get(12);

    Vertex world1v27 = this.world1.vertexArray.get(2).get(0);
    Vertex world1v28 = this.world1.vertexArray.get(2).get(1);
    Vertex world1v29 = this.world1.vertexArray.get(2).get(2);
    Vertex world1v30 = this.world1.vertexArray.get(2).get(3);
    Vertex world1v31 = this.world1.vertexArray.get(2).get(4);
    Vertex world1v32 = this.world1.vertexArray.get(2).get(5);
    Vertex world1v33 = this.world1.vertexArray.get(2).get(6);
    Vertex world1v34 = this.world1.vertexArray.get(2).get(7);
    Vertex world1v35 = this.world1.vertexArray.get(2).get(8);
    Vertex world1v36 = this.world1.vertexArray.get(2).get(9);
    Vertex world1v37 = this.world1.vertexArray.get(2).get(10);
    Vertex world1v38 = this.world1.vertexArray.get(2).get(11);
    Vertex world1v39 = this.world1.vertexArray.get(2).get(12);

    Vertex world1v40 = this.world1.vertexArray.get(3).get(0);
    Vertex world1v41 = this.world1.vertexArray.get(3).get(1);
    Vertex world1v42 = this.world1.vertexArray.get(3).get(2);
    Vertex world1v43 = this.world1.vertexArray.get(3).get(3);
    Vertex world1v44 = this.world1.vertexArray.get(3).get(4);
    Vertex world1v45 = this.world1.vertexArray.get(3).get(5);
    Vertex world1v46 = this.world1.vertexArray.get(3).get(6);
    Vertex world1v47 = this.world1.vertexArray.get(3).get(7);
    Vertex world1v48 = this.world1.vertexArray.get(3).get(8);
    Vertex world1v49 = this.world1.vertexArray.get(3).get(9);
    Vertex world1v50 = this.world1.vertexArray.get(3).get(10);
    Vertex world1v51 = this.world1.vertexArray.get(3).get(11);
    Vertex world1v52 = this.world1.vertexArray.get(3).get(12);

    Vertex world1v53 = this.world1.vertexArray.get(4).get(0);
    Vertex world1v54 = this.world1.vertexArray.get(4).get(1);
    Vertex world1v55 = this.world1.vertexArray.get(4).get(2);
    Vertex world1v56 = this.world1.vertexArray.get(4).get(3);
    Vertex world1v57 = this.world1.vertexArray.get(4).get(4);
    Vertex world1v58 = this.world1.vertexArray.get(4).get(5);
    Vertex world1v59 = this.world1.vertexArray.get(4).get(6);
    Vertex world1v60 = this.world1.vertexArray.get(4).get(7);
    Vertex world1v61 = this.world1.vertexArray.get(4).get(8);
    Vertex world1v62 = this.world1.vertexArray.get(4).get(9);
    Vertex world1v63 = this.world1.vertexArray.get(4).get(10);
    Vertex world1v64 = this.world1.vertexArray.get(4).get(11);
    Vertex world1v65 = this.world1.vertexArray.get(4).get(12);

    Vertex world1v66 = this.world1.vertexArray.get(5).get(0);
    Vertex world1v67 = this.world1.vertexArray.get(5).get(1);
    Vertex world1v68 = this.world1.vertexArray.get(5).get(2);
    Vertex world1v69 = this.world1.vertexArray.get(5).get(3);
    Vertex world1v70 = this.world1.vertexArray.get(5).get(4);
    Vertex world1v71 = this.world1.vertexArray.get(5).get(5);
    Vertex world1v72 = this.world1.vertexArray.get(5).get(6);
    Vertex world1v73 = this.world1.vertexArray.get(5).get(7);
    Vertex world1v74 = this.world1.vertexArray.get(5).get(8);
    Vertex world1v75 = this.world1.vertexArray.get(5).get(9);
    Vertex world1v76 = this.world1.vertexArray.get(5).get(10);
    Vertex world1v77 = this.world1.vertexArray.get(5).get(11);
    Vertex world1v78 = this.world1.vertexArray.get(5).get(12);

    Vertex world1v79 = this.world1.vertexArray.get(6).get(0);
    Vertex world1v80 = this.world1.vertexArray.get(6).get(1);
    Vertex world1v81 = this.world1.vertexArray.get(6).get(2);
    Vertex world1v82 = this.world1.vertexArray.get(6).get(3);
    Vertex world1v83 = this.world1.vertexArray.get(6).get(4);
    Vertex world1v84 = this.world1.vertexArray.get(6).get(5);
    Vertex world1v85 = this.world1.vertexArray.get(6).get(6);
    Vertex world1v86 = this.world1.vertexArray.get(6).get(7);
    Vertex world1v87 = this.world1.vertexArray.get(6).get(8);
    Vertex world1v88 = this.world1.vertexArray.get(6).get(9);
    Vertex world1v89 = this.world1.vertexArray.get(6).get(10);
    Vertex world1v90 = this.world1.vertexArray.get(6).get(11);
    Vertex world1v91 = this.world1.vertexArray.get(6).get(12);

    Vertex world1v92 = this.world1.vertexArray.get(7).get(0);
    Vertex world1v93 = this.world1.vertexArray.get(7).get(1);
    Vertex world1v94 = this.world1.vertexArray.get(7).get(2);
    Vertex world1v95 = this.world1.vertexArray.get(7).get(3);
    Vertex world1v96 = this.world1.vertexArray.get(7).get(4);
    Vertex world1v97 = this.world1.vertexArray.get(7).get(5);
    Vertex world1v98 = this.world1.vertexArray.get(7).get(6);
    Vertex world1v99 = this.world1.vertexArray.get(7).get(7);
    Vertex world1v100 = this.world1.vertexArray.get(7).get(8);
    Vertex world1v101 = this.world1.vertexArray.get(7).get(9);
    Vertex world1v102 = this.world1.vertexArray.get(7).get(10);
    Vertex world1v103 = this.world1.vertexArray.get(7).get(11);
    Vertex world1v104 = this.world1.vertexArray.get(7).get(12);

    Vertex world1v105 = this.world1.vertexArray.get(8).get(0);
    Vertex world1v106 = this.world1.vertexArray.get(8).get(1);
    Vertex world1v107 = this.world1.vertexArray.get(8).get(2);
    Vertex world1v108 = this.world1.vertexArray.get(8).get(3);
    Vertex world1v109 = this.world1.vertexArray.get(8).get(4);
    Vertex world1v110 = this.world1.vertexArray.get(8).get(5);
    Vertex world1v111 = this.world1.vertexArray.get(8).get(6);
    Vertex world1v112 = this.world1.vertexArray.get(8).get(7);
    Vertex world1v113 = this.world1.vertexArray.get(8).get(8);
    Vertex world1v114 = this.world1.vertexArray.get(8).get(9);
    Vertex world1v115 = this.world1.vertexArray.get(8).get(10);
    Vertex world1v116 = this.world1.vertexArray.get(8).get(11);
    Vertex world1v117 = this.world1.vertexArray.get(8).get(12);

    Vertex world1v118 = this.world1.vertexArray.get(9).get(0);
    Vertex world1v119 = this.world1.vertexArray.get(9).get(1);
    Vertex world1v120 = this.world1.vertexArray.get(9).get(2);
    Vertex world1v121 = this.world1.vertexArray.get(9).get(3);
    Vertex world1v122 = this.world1.vertexArray.get(9).get(4);
    Vertex world1v123 = this.world1.vertexArray.get(9).get(5);
    Vertex world1v124 = this.world1.vertexArray.get(9).get(6);
    Vertex world1v125 = this.world1.vertexArray.get(9).get(7);
    Vertex world1v126 = this.world1.vertexArray.get(9).get(8);
    Vertex world1v127 = this.world1.vertexArray.get(9).get(9);
    Vertex world1v128 = this.world1.vertexArray.get(9).get(10);
    Vertex world1v129 = this.world1.vertexArray.get(9).get(11);
    Vertex world1v130 = this.world1.vertexArray.get(9).get(12);

    Vertex world1v131 = this.world1.vertexArray.get(10).get(0);
    Vertex world1v132 = this.world1.vertexArray.get(10).get(1);
    Vertex world1v133 = this.world1.vertexArray.get(10).get(2);
    Vertex world1v134 = this.world1.vertexArray.get(10).get(3);
    Vertex world1v135 = this.world1.vertexArray.get(10).get(4);
    Vertex world1v136 = this.world1.vertexArray.get(10).get(5);
    Vertex world1v137 = this.world1.vertexArray.get(10).get(6);
    Vertex world1v138 = this.world1.vertexArray.get(10).get(7);
    Vertex world1v139 = this.world1.vertexArray.get(10).get(8);
    Vertex world1v140 = this.world1.vertexArray.get(10).get(9);
    Vertex world1v141 = this.world1.vertexArray.get(10).get(10);
    Vertex world1v142 = this.world1.vertexArray.get(10).get(11);
    Vertex world1v143 = this.world1.vertexArray.get(10).get(12);

    Vertex world1v144 = this.world1.vertexArray.get(11).get(0);
    Vertex world1v145 = this.world1.vertexArray.get(11).get(1);
    Vertex world1v146 = this.world1.vertexArray.get(11).get(2);
    Vertex world1v147 = this.world1.vertexArray.get(11).get(3);
    Vertex world1v148 = this.world1.vertexArray.get(11).get(4);
    Vertex world1v149 = this.world1.vertexArray.get(11).get(5);
    Vertex world1v150 = this.world1.vertexArray.get(11).get(6);
    Vertex world1v151 = this.world1.vertexArray.get(11).get(7);
    Vertex world1v152 = this.world1.vertexArray.get(11).get(8);
    Vertex world1v153 = this.world1.vertexArray.get(11).get(9);
    Vertex world1v154 = this.world1.vertexArray.get(11).get(10);
    Vertex world1v155 = this.world1.vertexArray.get(11).get(11);
    Vertex world1v156 = this.world1.vertexArray.get(11).get(12);

    Vertex world1v157 = this.world1.vertexArray.get(12).get(0);
    Vertex world1v158 = this.world1.vertexArray.get(12).get(1);
    Vertex world1v159 = this.world1.vertexArray.get(12).get(2);
    Vertex world1v160 = this.world1.vertexArray.get(12).get(3);
    Vertex world1v161 = this.world1.vertexArray.get(12).get(4);
    Vertex world1v162 = this.world1.vertexArray.get(12).get(5);
    Vertex world1v163 = this.world1.vertexArray.get(12).get(6);
    Vertex world1v164 = this.world1.vertexArray.get(12).get(7);
    Vertex world1v165 = this.world1.vertexArray.get(12).get(8);
    Vertex world1v166 = this.world1.vertexArray.get(12).get(9);
    Vertex world1v167 = this.world1.vertexArray.get(12).get(10);
    Vertex world1v168 = this.world1.vertexArray.get(12).get(11);
    Vertex world1v169 = this.world1.vertexArray.get(12).get(12);

    Vertex world1v170 = this.world1.vertexArray.get(13).get(0);
    Vertex world1v171 = this.world1.vertexArray.get(13).get(1);
    Vertex world1v172 = this.world1.vertexArray.get(13).get(2);
    Vertex world1v173 = this.world1.vertexArray.get(13).get(3);
    Vertex world1v174 = this.world1.vertexArray.get(13).get(4);
    Vertex world1v175 = this.world1.vertexArray.get(13).get(5);
    Vertex world1v176 = this.world1.vertexArray.get(13).get(6);
    Vertex world1v177 = this.world1.vertexArray.get(13).get(7);
    Vertex world1v178 = this.world1.vertexArray.get(13).get(8);
    Vertex world1v179 = this.world1.vertexArray.get(13).get(9);
    Vertex world1v180 = this.world1.vertexArray.get(13).get(10);
    Vertex world1v181 = this.world1.vertexArray.get(13).get(11);
    Vertex world1v182 = this.world1.vertexArray.get(13).get(12);

    Vertex world1v183 = this.world1.vertexArray.get(14).get(0);
    Vertex world1v184 = this.world1.vertexArray.get(14).get(1);
    Vertex world1v185 = this.world1.vertexArray.get(14).get(2);
    Vertex world1v186 = this.world1.vertexArray.get(14).get(3);
    Vertex world1v187 = this.world1.vertexArray.get(14).get(4);
    Vertex world1v188 = this.world1.vertexArray.get(14).get(5);
    Vertex world1v189 = this.world1.vertexArray.get(14).get(6);
    Vertex world1v190 = this.world1.vertexArray.get(14).get(7);
    Vertex world1v191 = this.world1.vertexArray.get(14).get(8);
    Vertex world1v192 = this.world1.vertexArray.get(14).get(9);
    Vertex world1v193 = this.world1.vertexArray.get(14).get(10);
    Vertex world1v194 = this.world1.vertexArray.get(14).get(11);
    Vertex world1v195 = this.world1.vertexArray.get(14).get(12);

    Vertex world1v196 = this.world1.vertexArray.get(15).get(0);
    Vertex world1v197 = this.world1.vertexArray.get(15).get(1);
    Vertex world1v198 = this.world1.vertexArray.get(15).get(2);
    Vertex world1v199 = this.world1.vertexArray.get(15).get(3);
    Vertex world1v200 = this.world1.vertexArray.get(15).get(4);
    Vertex world1v201 = this.world1.vertexArray.get(15).get(5);
    Vertex world1v202 = this.world1.vertexArray.get(15).get(6);
    Vertex world1v203 = this.world1.vertexArray.get(15).get(7);
    Vertex world1v204 = this.world1.vertexArray.get(15).get(8);
    Vertex world1v205 = this.world1.vertexArray.get(15).get(9);
    Vertex world1v206 = this.world1.vertexArray.get(15).get(10);
    Vertex world1v207 = this.world1.vertexArray.get(15).get(11);
    Vertex world1v208 = this.world1.vertexArray.get(15).get(12);

    Vertex world1v209 = this.world1.vertexArray.get(16).get(0);
    Vertex world1v210 = this.world1.vertexArray.get(16).get(1);
    Vertex world1v211 = this.world1.vertexArray.get(16).get(2);
    Vertex world1v212 = this.world1.vertexArray.get(16).get(3);
    Vertex world1v213 = this.world1.vertexArray.get(16).get(4);
    Vertex world1v214 = this.world1.vertexArray.get(16).get(5);
    Vertex world1v215 = this.world1.vertexArray.get(16).get(6);
    Vertex world1v216 = this.world1.vertexArray.get(16).get(7);
    Vertex world1v217 = this.world1.vertexArray.get(16).get(8);
    Vertex world1v218 = this.world1.vertexArray.get(16).get(9);
    Vertex world1v219 = this.world1.vertexArray.get(16).get(10);
    Vertex world1v220 = this.world1.vertexArray.get(16).get(11);
    Vertex world1v221 = this.world1.vertexArray.get(16).get(12);

    Vertex world1v222 = this.world1.vertexArray.get(17).get(0);
    Vertex world1v223 = this.world1.vertexArray.get(17).get(1);
    Vertex world1v224 = this.world1.vertexArray.get(17).get(2);
    Vertex world1v225 = this.world1.vertexArray.get(17).get(3);
    Vertex world1v226 = this.world1.vertexArray.get(17).get(4);
    Vertex world1v227 = this.world1.vertexArray.get(17).get(5);
    Vertex world1v228 = this.world1.vertexArray.get(17).get(6);
    Vertex world1v229 = this.world1.vertexArray.get(17).get(7);
    Vertex world1v230 = this.world1.vertexArray.get(17).get(8);
    Vertex world1v231 = this.world1.vertexArray.get(17).get(9);
    Vertex world1v232 = this.world1.vertexArray.get(17).get(10);
    Vertex world1v233 = this.world1.vertexArray.get(17).get(11);
    Vertex world1v234 = this.world1.vertexArray.get(17).get(12);

    Vertex world1v235 = this.world1.vertexArray.get(18).get(0);
    Vertex world1v236 = this.world1.vertexArray.get(18).get(1);
    Vertex world1v237 = this.world1.vertexArray.get(18).get(2);
    Vertex world1v238 = this.world1.vertexArray.get(18).get(3);
    Vertex world1v239 = this.world1.vertexArray.get(18).get(4);
    Vertex world1v240 = this.world1.vertexArray.get(18).get(5);
    Vertex world1v241 = this.world1.vertexArray.get(18).get(6);
    Vertex world1v242 = this.world1.vertexArray.get(18).get(7);
    Vertex world1v243 = this.world1.vertexArray.get(18).get(8);
    Vertex world1v244 = this.world1.vertexArray.get(18).get(9);
    Vertex world1v245 = this.world1.vertexArray.get(18).get(10);
    Vertex world1v246 = this.world1.vertexArray.get(18).get(11);
    Vertex world1v247 = this.world1.vertexArray.get(18).get(12);

    Vertex world1v248 = this.world1.vertexArray.get(19).get(0);
    Vertex world1v249 = this.world1.vertexArray.get(19).get(1);
    Vertex world1v250 = this.world1.vertexArray.get(19).get(2);
    Vertex world1v251 = this.world1.vertexArray.get(19).get(3);
    Vertex world1v252 = this.world1.vertexArray.get(19).get(4);
    Vertex world1v253 = this.world1.vertexArray.get(19).get(5);
    Vertex world1v254 = this.world1.vertexArray.get(19).get(6);
    Vertex world1v255 = this.world1.vertexArray.get(19).get(7);
    Vertex world1v256 = this.world1.vertexArray.get(19).get(8);
    Vertex world1v257 = this.world1.vertexArray.get(19).get(9);
    Vertex world1v258 = this.world1.vertexArray.get(19).get(10);
    Vertex world1v259 = this.world1.vertexArray.get(19).get(11);
    Vertex world1v260 = this.world1.vertexArray.get(19).get(12);

    t.checkExpect(world1v1.left, null);
    t.checkExpect(world1v1.top, null);
    t.checkExpect(world1v1.right, world1v2);
    t.checkExpect(world1v1.bottom, world1v14);

    t.checkExpect(world1v2.left, world1v1);
    t.checkExpect(world1v2.top, null);
    t.checkExpect(world1v2.right, world1v3);
    t.checkExpect(world1v2.bottom, world1v15);

    t.checkExpect(world1v3.left, world1v2);
    t.checkExpect(world1v3.top, null);
    t.checkExpect(world1v3.right, world1v4);
    t.checkExpect(world1v3.bottom, world1v16);

    t.checkExpect(world1v4.left, world1v3);
    t.checkExpect(world1v4.top, null);
    t.checkExpect(world1v4.right, world1v5);
    t.checkExpect(world1v4.bottom, world1v17);

    t.checkExpect(world1v5.left, world1v4);
    t.checkExpect(world1v5.top, null);
    t.checkExpect(world1v5.right, world1v6);
    t.checkExpect(world1v5.bottom, world1v18);

    t.checkExpect(world1v6.left, world1v5);
    t.checkExpect(world1v6.top, null);
    t.checkExpect(world1v6.right, world1v7);
    t.checkExpect(world1v6.bottom, world1v19);

    t.checkExpect(world1v7.left, world1v6);
    t.checkExpect(world1v7.top, null);
    t.checkExpect(world1v7.right, world1v8);
    t.checkExpect(world1v7.bottom, world1v20);

    t.checkExpect(world1v8.left, world1v7);
    t.checkExpect(world1v8.top, null);
    t.checkExpect(world1v8.right, world1v9);
    t.checkExpect(world1v8.bottom, world1v21);

    t.checkExpect(world1v9.left, world1v8);
    t.checkExpect(world1v9.top, null);
    t.checkExpect(world1v9.right, world1v10);
    t.checkExpect(world1v9.bottom, world1v22);

    t.checkExpect(world1v10.left, world1v9);
    t.checkExpect(world1v10.top, null);
    t.checkExpect(world1v10.right, world1v11);
    t.checkExpect(world1v10.bottom, world1v23);

    t.checkExpect(world1v11.left, world1v10);
    t.checkExpect(world1v11.top, null);
    t.checkExpect(world1v11.right, world1v12);
    t.checkExpect(world1v11.bottom, world1v24);

    t.checkExpect(world1v12.left, world1v11);
    t.checkExpect(world1v12.top, null);
    t.checkExpect(world1v12.right, world1v13);
    t.checkExpect(world1v12.bottom, world1v25);

    t.checkExpect(world1v13.left, world1v12);
    t.checkExpect(world1v13.top, null);
    t.checkExpect(world1v13.right, null);
    t.checkExpect(world1v13.bottom, world1v26);

    t.checkExpect(world1v14.left, null);
    t.checkExpect(world1v14.top, world1v1);
    t.checkExpect(world1v14.right, world1v15);
    t.checkExpect(world1v14.bottom, world1v27);

    t.checkExpect(world1v15.left, world1v14);
    t.checkExpect(world1v15.top, world1v2);
    t.checkExpect(world1v15.right, world1v16);
    t.checkExpect(world1v15.bottom, world1v28);

    t.checkExpect(world1v16.left, world1v15);
    t.checkExpect(world1v16.top, world1v3);
    t.checkExpect(world1v16.right, world1v17);
    t.checkExpect(world1v16.bottom, world1v29);

    t.checkExpect(world1v17.left, world1v16);
    t.checkExpect(world1v17.top, world1v4);
    t.checkExpect(world1v17.right, world1v18);
    t.checkExpect(world1v17.bottom, world1v30);

    t.checkExpect(world1v18.left, world1v17);
    t.checkExpect(world1v18.top, world1v5);
    t.checkExpect(world1v18.right, world1v19);
    t.checkExpect(world1v18.bottom, world1v31);

    t.checkExpect(world1v19.left, world1v18);
    t.checkExpect(world1v19.top, world1v6);
    t.checkExpect(world1v19.right, world1v20);
    t.checkExpect(world1v19.bottom, world1v32);

    t.checkExpect(world1v20.left, world1v19);
    t.checkExpect(world1v20.top, world1v7);
    t.checkExpect(world1v20.right, world1v21);
    t.checkExpect(world1v20.bottom, world1v33);

    t.checkExpect(world1v21.left, world1v20);
    t.checkExpect(world1v21.top, world1v8);
    t.checkExpect(world1v21.right, world1v22);
    t.checkExpect(world1v21.bottom, world1v34);

    t.checkExpect(world1v22.left, world1v21);
    t.checkExpect(world1v22.top, world1v9);
    t.checkExpect(world1v22.right, world1v23);
    t.checkExpect(world1v22.bottom, world1v35);

    t.checkExpect(world1v23.left, world1v22);
    t.checkExpect(world1v23.top, world1v10);
    t.checkExpect(world1v23.right, world1v24);
    t.checkExpect(world1v23.bottom, world1v36);

    t.checkExpect(world1v24.left, world1v23);
    t.checkExpect(world1v24.top, world1v11);
    t.checkExpect(world1v24.right, world1v25);
    t.checkExpect(world1v24.bottom, world1v37);

    t.checkExpect(world1v25.left, world1v24);
    t.checkExpect(world1v25.top, world1v12);
    t.checkExpect(world1v25.right, world1v26);
    t.checkExpect(world1v25.bottom, world1v38);

    t.checkExpect(world1v26.left, world1v25);
    t.checkExpect(world1v26.top, world1v13);
    t.checkExpect(world1v26.right, null);
    t.checkExpect(world1v26.bottom, world1v39);

    t.checkExpect(world1v27.left, null);
    t.checkExpect(world1v27.top, world1v14);
    t.checkExpect(world1v27.right, world1v28);
    t.checkExpect(world1v27.bottom, world1v40);

    t.checkExpect(world1v28.left, world1v27);
    t.checkExpect(world1v28.top, world1v15);
    t.checkExpect(world1v28.right, world1v29);
    t.checkExpect(world1v28.bottom, world1v41);

    t.checkExpect(world1v29.left, world1v28);
    t.checkExpect(world1v29.top, world1v16);
    t.checkExpect(world1v29.right, world1v30);
    t.checkExpect(world1v29.bottom, world1v42);

    t.checkExpect(world1v30.left, world1v29);
    t.checkExpect(world1v30.top, world1v17);
    t.checkExpect(world1v30.right, world1v31);
    t.checkExpect(world1v30.bottom, world1v43);

    t.checkExpect(world1v31.left, world1v30);
    t.checkExpect(world1v31.top, world1v18);
    t.checkExpect(world1v31.right, world1v32);
    t.checkExpect(world1v31.bottom, world1v44);

    t.checkExpect(world1v32.left, world1v31);
    t.checkExpect(world1v32.top, world1v19);
    t.checkExpect(world1v32.right, world1v33);
    t.checkExpect(world1v32.bottom, world1v45);

    t.checkExpect(world1v33.left, world1v32);
    t.checkExpect(world1v33.top, world1v20);
    t.checkExpect(world1v33.right, world1v34);
    t.checkExpect(world1v33.bottom, world1v46);

    t.checkExpect(world1v34.left, world1v33);
    t.checkExpect(world1v34.top, world1v21);
    t.checkExpect(world1v34.right, world1v35);
    t.checkExpect(world1v34.bottom, world1v47);

    t.checkExpect(world1v35.left, world1v34);
    t.checkExpect(world1v35.top, world1v22);
    t.checkExpect(world1v35.right, world1v36);
    t.checkExpect(world1v35.bottom, world1v48);

    t.checkExpect(world1v36.left, world1v35);
    t.checkExpect(world1v36.top, world1v23);
    t.checkExpect(world1v36.right, world1v37);
    t.checkExpect(world1v36.bottom, world1v49);

    t.checkExpect(world1v37.left, world1v36);
    t.checkExpect(world1v37.top, world1v24);
    t.checkExpect(world1v37.right, world1v38);
    t.checkExpect(world1v37.bottom, world1v50);

    t.checkExpect(world1v38.left, world1v37);
    t.checkExpect(world1v38.top, world1v25);
    t.checkExpect(world1v38.right, world1v39);
    t.checkExpect(world1v38.bottom, world1v51);

    t.checkExpect(world1v39.left, world1v38);
    t.checkExpect(world1v39.top, world1v26);
    t.checkExpect(world1v39.right, null);
    t.checkExpect(world1v39.bottom, world1v52);

    t.checkExpect(world1v40.left, null);
    t.checkExpect(world1v40.top, world1v27);
    t.checkExpect(world1v40.right, world1v41);
    t.checkExpect(world1v40.bottom, world1v53);

    t.checkExpect(world1v41.left, world1v40);
    t.checkExpect(world1v41.top, world1v28);
    t.checkExpect(world1v41.right, world1v42);
    t.checkExpect(world1v41.bottom, world1v54);

    t.checkExpect(world1v42.left, world1v41);
    t.checkExpect(world1v42.top, world1v29);
    t.checkExpect(world1v42.right, world1v43);
    t.checkExpect(world1v42.bottom, world1v55);

    t.checkExpect(world1v43.left, world1v42);
    t.checkExpect(world1v43.top, world1v30);
    t.checkExpect(world1v43.right, world1v44);
    t.checkExpect(world1v43.bottom, world1v56);

    t.checkExpect(world1v44.left, world1v43);
    t.checkExpect(world1v44.top, world1v31);
    t.checkExpect(world1v44.right, world1v45);
    t.checkExpect(world1v44.bottom, world1v57);

    t.checkExpect(world1v45.left, world1v44);
    t.checkExpect(world1v45.top, world1v32);
    t.checkExpect(world1v45.right, world1v46);
    t.checkExpect(world1v45.bottom, world1v58);

    t.checkExpect(world1v46.left, world1v45);
    t.checkExpect(world1v46.top, world1v33);
    t.checkExpect(world1v46.right, world1v47);
    t.checkExpect(world1v46.bottom, world1v59);

    t.checkExpect(world1v47.left, world1v46);
    t.checkExpect(world1v47.top, world1v34);
    t.checkExpect(world1v47.right, world1v48);
    t.checkExpect(world1v47.bottom, world1v60);

    t.checkExpect(world1v48.left, world1v47);
    t.checkExpect(world1v48.top, world1v35);
    t.checkExpect(world1v48.right, world1v49);
    t.checkExpect(world1v48.bottom, world1v61);

    t.checkExpect(world1v49.left, world1v48);
    t.checkExpect(world1v49.top, world1v36);
    t.checkExpect(world1v49.right, world1v50);
    t.checkExpect(world1v49.bottom, world1v62);

    t.checkExpect(world1v50.left, world1v49);
    t.checkExpect(world1v50.top, world1v37);
    t.checkExpect(world1v50.right, world1v51);
    t.checkExpect(world1v50.bottom, world1v63);

    t.checkExpect(world1v51.left, world1v50);
    t.checkExpect(world1v51.top, world1v38);
    t.checkExpect(world1v51.right, world1v52);
    t.checkExpect(world1v51.bottom, world1v64);

    t.checkExpect(world1v52.left, world1v51);
    t.checkExpect(world1v52.top, world1v39);
    t.checkExpect(world1v52.right, null);
    t.checkExpect(world1v52.bottom, world1v65);

    t.checkExpect(world1v53.left, null);
    t.checkExpect(world1v53.top, world1v40);
    t.checkExpect(world1v53.right, world1v54);
    t.checkExpect(world1v53.bottom, world1v66);

    t.checkExpect(world1v54.left, world1v53);
    t.checkExpect(world1v54.top, world1v41);
    t.checkExpect(world1v54.right, world1v55);
    t.checkExpect(world1v54.bottom, world1v67);

    t.checkExpect(world1v55.left, world1v54);
    t.checkExpect(world1v55.top, world1v42);
    t.checkExpect(world1v55.right, world1v56);
    t.checkExpect(world1v55.bottom, world1v68);

    t.checkExpect(world1v56.left, world1v55);
    t.checkExpect(world1v56.top, world1v43);
    t.checkExpect(world1v56.right, world1v57);
    t.checkExpect(world1v56.bottom, world1v69);

    t.checkExpect(world1v248.left, null);
    t.checkExpect(world1v248.top, world1v235);
    t.checkExpect(world1v248.right, world1v249);
    t.checkExpect(world1v248.bottom, null);

    t.checkExpect(world1v249.left, world1v248);
    t.checkExpect(world1v249.top, world1v236);
    t.checkExpect(world1v249.right, world1v250);
    t.checkExpect(world1v249.bottom, null);

    t.checkExpect(world1v250.left, world1v249);
    t.checkExpect(world1v250.top, world1v237);
    t.checkExpect(world1v250.right, world1v251);
    t.checkExpect(world1v250.bottom, null);

    t.checkExpect(world1v251.left, world1v250);
    t.checkExpect(world1v251.top, world1v238);
    t.checkExpect(world1v251.right, world1v252);
    t.checkExpect(world1v251.bottom, null);

    t.checkExpect(world1v252.left, world1v251);
    t.checkExpect(world1v252.top, world1v239);
    t.checkExpect(world1v252.right, world1v253);
    t.checkExpect(world1v252.bottom, null);

    t.checkExpect(world1v253.left, world1v252);
    t.checkExpect(world1v253.top, world1v240);
    t.checkExpect(world1v253.right, world1v254);
    t.checkExpect(world1v253.bottom, null);

    t.checkExpect(world1v254.left, world1v253);
    t.checkExpect(world1v254.top, world1v241);
    t.checkExpect(world1v254.right, world1v255);
    t.checkExpect(world1v254.bottom, null);

    t.checkExpect(world1v255.left, world1v254);
    t.checkExpect(world1v255.top, world1v242);
    t.checkExpect(world1v255.right, world1v256);
    t.checkExpect(world1v255.bottom, null);

    t.checkExpect(world1v256.left, world1v255);
    t.checkExpect(world1v256.top, world1v243);
    t.checkExpect(world1v256.right, world1v257);
    t.checkExpect(world1v256.bottom, null);

    t.checkExpect(world1v257.left, world1v256);
    t.checkExpect(world1v257.top, world1v244);
    t.checkExpect(world1v257.right, world1v258);
    t.checkExpect(world1v257.bottom, null);

    t.checkExpect(world1v258.left, world1v257);
    t.checkExpect(world1v258.top, world1v245);
    t.checkExpect(world1v258.right, world1v259);
    t.checkExpect(world1v258.bottom, null);

    t.checkExpect(world1v259.left, world1v258);
    t.checkExpect(world1v259.top, world1v246);
    t.checkExpect(world1v259.right, world1v260);
    t.checkExpect(world1v259.bottom, null);

    t.checkExpect(world1v260.left, world1v259);
    t.checkExpect(world1v260.top, world1v247);
    t.checkExpect(world1v260.right, null);
    t.checkExpect(world1v260.bottom, null);

    this.world4.createVertexArray();
    this.world4.linkVertices();
    Vertex world4v1 = this.world4.vertexArray.get(0).get(0);
    Vertex world4v2 = this.world4.vertexArray.get(0).get(1);
    Vertex world4v3 = this.world4.vertexArray.get(0).get(2);
    Vertex world4v4 = this.world4.vertexArray.get(1).get(0);
    Vertex world4v5 = this.world4.vertexArray.get(1).get(1);
    Vertex world4v6 = this.world4.vertexArray.get(1).get(2);
    Vertex world4v7 = this.world4.vertexArray.get(2).get(0);
    Vertex world4v8 = this.world4.vertexArray.get(2).get(1);
    Vertex world4v9 = this.world4.vertexArray.get(2).get(2);
    this.world4 = new MazeWorld(3, 3, new Random(100));

    t.checkExpect(world4v1.left, null);
    t.checkExpect(world4v1.top, null);
    t.checkExpect(world4v1.right, world4v2);
    t.checkExpect(world4v1.bottom, world4v4);

    t.checkExpect(world4v2.left, world4v1);
    t.checkExpect(world4v2.top, null);
    t.checkExpect(world4v2.right, world4v3);
    t.checkExpect(world4v2.bottom, world4v5);

    t.checkExpect(world4v3.left, world4v2);
    t.checkExpect(world4v3.top, null);
    t.checkExpect(world4v3.right, null);
    t.checkExpect(world4v3.bottom, world4v6);

    t.checkExpect(world4v4.left, null);
    t.checkExpect(world4v4.top, world4v1);
    t.checkExpect(world4v4.right, world4v5);
    t.checkExpect(world4v4.bottom, world4v7);

    t.checkExpect(world4v5.left, world4v4);
    t.checkExpect(world4v5.top, world4v2);
    t.checkExpect(world4v5.right, world4v6);
    t.checkExpect(world4v5.bottom, world4v8);

    t.checkExpect(world4v6.left, world4v5);
    t.checkExpect(world4v6.top, world4v3);
    t.checkExpect(world4v6.right, null);
    t.checkExpect(world4v6.bottom, world4v9);

    t.checkExpect(world4v7.left, null);
    t.checkExpect(world4v7.top, world4v4);
    t.checkExpect(world4v7.right, world4v8);
    t.checkExpect(world4v7.bottom, null);

    t.checkExpect(world4v8.left, world4v7);
    t.checkExpect(world4v8.top, world4v5);
    t.checkExpect(world4v8.right, world4v9);
    t.checkExpect(world4v8.bottom, null);

    t.checkExpect(world4v9.left, world4v8);
    t.checkExpect(world4v9.top, world4v6);
    t.checkExpect(world4v9.right, null);
    t.checkExpect(world4v9.bottom, null);
  }

  // test for the method createWalls
  void testCreateWalls(Tester t) {
    this.initWorld();

    this.world4.createVertexArray();
    this.world4.linkVertices();
    this.world4.createWalls();
    ArrayList<Wall> world4Walls = new ArrayList<Wall>();

    world4Walls.add(
        new Wall(this.world4.vertexArray.get(1).get(0), this.world4.vertexArray.get(2).get(0), 13));
    world4Walls.add(
        new Wall(this.world4.vertexArray.get(0).get(0), this.world4.vertexArray.get(0).get(1), 15));
    world4Walls.add(
        new Wall(this.world4.vertexArray.get(1).get(2), this.world4.vertexArray.get(2).get(2), 17));
    world4Walls.add(
        new Wall(this.world4.vertexArray.get(1).get(1), this.world4.vertexArray.get(2).get(1), 22));
    world4Walls.add(
        new Wall(this.world4.vertexArray.get(0).get(2), this.world4.vertexArray.get(1).get(2), 23));
    world4Walls.add(
        new Wall(this.world4.vertexArray.get(0).get(0), this.world4.vertexArray.get(1).get(0), 36));
    world4Walls.add(
        new Wall(this.world4.vertexArray.get(0).get(1), this.world4.vertexArray.get(0).get(2), 50));
    world4Walls.add(
        new Wall(this.world4.vertexArray.get(2).get(1), this.world4.vertexArray.get(2).get(2), 66));
    world4Walls.add(
        new Wall(this.world4.vertexArray.get(1).get(0), this.world4.vertexArray.get(1).get(1), 74));
    world4Walls.add(
        new Wall(this.world4.vertexArray.get(1).get(1), this.world4.vertexArray.get(1).get(2), 88));
    world4Walls.add(
        new Wall(this.world4.vertexArray.get(0).get(1), this.world4.vertexArray.get(1).get(1), 88));
    world4Walls.add(
        new Wall(this.world4.vertexArray.get(2).get(0), this.world4.vertexArray.get(2).get(1), 91));

    t.checkExpect(this.world4.walls.size(), world4Walls.size());

    // check that world4Walls and world4.walls are equal according to their fields
    for (int i = 0; i < world4Walls.size(); i++) {
      t.checkExpect(this.world4.walls.get(i).v1.x == world4Walls.get(i).v1.x, true);
      t.checkExpect(this.world4.walls.get(i).v1.y == world4Walls.get(i).v1.y, true);
      t.checkExpect(this.world4.walls.get(i).v2.x == world4Walls.get(i).v2.x, true);
      t.checkExpect(this.world4.walls.get(i).v2.y == world4Walls.get(i).v2.y, true);
      t.checkExpect(this.world4.walls.get(i).cost == world4Walls.get(i).cost, true);
    }
  }

  // test for the method createMap
  void testCreateMap(Tester t) {
    initWorld();
    this.world1.createVertexArray();
    this.world1.linkVertices();
    this.world1.createWalls();

    t.checkExpect(this.world1.vertexMap, new HashMap<Vertex, Vertex>());
    this.world1.createMap();
    t.checkExpect(this.world1.vertexMap.size(), 260);
    // checks that the map includes each vertex in vertexArray and each vertex is
    // mapped to itself
    for (ArrayList<Vertex> list : this.world1.vertexArray) {
      for (Vertex v : list) {
        t.checkExpect(this.world1.vertexMap.get(v), v);
      }
    }

    this.world4.createVertexArray();
    this.world4.linkVertices();
    this.world4.createWalls();

    t.checkExpect(this.world4.vertexMap, new HashMap<Vertex, Vertex>());
    this.world4.createMap();
    t.checkExpect(this.world4.vertexMap.size(), 9);
    // checks that the map includes each vertex in vertexArray and each vertex is
    // mapped to itself
    for (ArrayList<Vertex> list : this.world4.vertexArray) {
      for (Vertex v : list) {
        t.checkExpect(this.world4.vertexMap.get(v), v);
      }
    }
  }

  // test for the method kruskalAlgo
  void testKruskalAlgo(Tester t) {
    initWorld();
    this.world4.createVertexArray();
    this.world4.linkVertices();
    this.world4.createWalls();
    this.world4.createMap();

    ArrayList<Wall> world4Walls = new ArrayList<Wall>();

    // initial walls before kruskals is called
    world4Walls.add(
        new Wall(this.world4.vertexArray.get(1).get(0), this.world4.vertexArray.get(2).get(0), 13));
    world4Walls.add(
        new Wall(this.world4.vertexArray.get(0).get(0), this.world4.vertexArray.get(0).get(1), 15));
    world4Walls.add(
        new Wall(this.world4.vertexArray.get(1).get(2), this.world4.vertexArray.get(2).get(2), 17));
    world4Walls.add(
        new Wall(this.world4.vertexArray.get(1).get(1), this.world4.vertexArray.get(2).get(1), 22));
    world4Walls.add(
        new Wall(this.world4.vertexArray.get(0).get(2), this.world4.vertexArray.get(1).get(2), 23));
    world4Walls.add(
        new Wall(this.world4.vertexArray.get(0).get(0), this.world4.vertexArray.get(1).get(0), 36));
    world4Walls.add(
        new Wall(this.world4.vertexArray.get(0).get(1), this.world4.vertexArray.get(0).get(2), 50));
    world4Walls.add(
        new Wall(this.world4.vertexArray.get(2).get(1), this.world4.vertexArray.get(2).get(2), 66));
    world4Walls.add(
        new Wall(this.world4.vertexArray.get(1).get(0), this.world4.vertexArray.get(1).get(1), 74));
    world4Walls.add(
        new Wall(this.world4.vertexArray.get(1).get(1), this.world4.vertexArray.get(1).get(2), 88));
    world4Walls.add(
        new Wall(this.world4.vertexArray.get(0).get(1), this.world4.vertexArray.get(1).get(1), 88));
    world4Walls.add(
        new Wall(this.world4.vertexArray.get(2).get(0), this.world4.vertexArray.get(2).get(1), 91));

    t.checkExpect(this.world4.walls.size(), world4Walls.size());

    // check that world4Walls and world4.walls are equal according to their fields
    for (int i = 0; i < world4Walls.size(); i++) {
      t.checkExpect(this.world4.walls.get(i).v1.x == world4Walls.get(i).v1.x, true);
      t.checkExpect(this.world4.walls.get(i).v1.y == world4Walls.get(i).v1.y, true);
      t.checkExpect(this.world4.walls.get(i).v2.x == world4Walls.get(i).v2.x, true);
      t.checkExpect(this.world4.walls.get(i).v2.y == world4Walls.get(i).v2.y, true);
      t.checkExpect(this.world4.walls.get(i).cost == world4Walls.get(i).cost, true);
    }

    this.world4.kruskalAlgo();

    t.checkExpect(this.world4.walls.get(0),
        new Wall(this.world4.walls.get(0).v1, this.world4.walls.get(0).v2, 13));
    t.checkExpect(this.world4.walls.get(1),
        new Wall(this.world4.walls.get(1).v1, this.world4.walls.get(1).v2, 15));
    t.checkExpect(this.world4.walls.get(2),
        new Wall(this.world4.walls.get(2).v1, this.world4.walls.get(2).v2, 17));
    t.checkExpect(this.world4.walls.get(3),
        new Wall(this.world4.walls.get(3).v1, this.world4.walls.get(3).v2, 22));
    t.checkExpect(this.world4.walls.get(4),
        new Wall(this.world4.walls.get(4).v1, this.world4.walls.get(4).v2, 23));
    t.checkExpect(this.world4.walls.get(5),
        new Wall(this.world4.walls.get(5).v1, this.world4.walls.get(5).v2, 36));
    t.checkExpect(this.world4.walls.get(6),
        new Wall(this.world4.walls.get(6).v1, this.world4.walls.get(6).v2, 50));
    t.checkExpect(this.world4.walls.get(7),
        new Wall(this.world4.walls.get(7).v1, this.world4.walls.get(7).v2, 66));
  }

  // test for the method union
  void testUnion(Tester t) {
    initWorld();
    this.world1.createVertexArray();
    this.world1.linkVertices();
    this.world1.createMap();

    this.world1.union(this.world1.vertexArray.get(3).get(3), this.world1.vertexArray.get(3).get(1));
    t.checkExpect(this.world1.find(this.world1.vertexArray.get(3).get(3)),
        this.world1.vertexArray.get(3).get(1));
    this.world1.union(this.world1.vertexArray.get(3).get(1), this.world1.vertexArray.get(1).get(1));
    t.checkExpect(this.world1.find(this.world1.vertexArray.get(3).get(1)),
        this.world1.vertexArray.get(1).get(1));
    this.world1.union(this.world1.vertexArray.get(2).get(3), this.world1.vertexArray.get(3).get(1));
    t.checkExpect(this.world1.find(this.world1.vertexArray.get(3).get(3)),
        this.world1.vertexArray.get(1).get(1));

    this.world4.createVertexArray();
    this.world4.linkVertices();
    this.world4.createMap();

    this.world4.union(this.world4.vertexArray.get(0).get(0), this.world4.vertexArray.get(0).get(2));
    t.checkExpect(this.world4.find(this.world4.vertexArray.get(0).get(0)),
        this.world4.vertexArray.get(0).get(2));
    this.world4.union(this.world4.vertexArray.get(0).get(2), this.world4.vertexArray.get(2).get(2));
    t.checkExpect(this.world4.find(this.world4.vertexArray.get(0).get(2)),
        this.world4.vertexArray.get(2).get(2));
    this.world4.union(this.world4.vertexArray.get(2).get(0), this.world4.vertexArray.get(0).get(2));
    t.checkExpect(this.world4.find(this.world4.vertexArray.get(0).get(0)),
        this.world4.vertexArray.get(2).get(2));
  }

  // test for the method find
  void testFind(Tester t) {
    initWorld();
    this.world1.createVertexArray();
    this.world1.linkVertices();
    this.world1.createMap();

    t.checkExpect(this.world1.find(this.world1.vertexArray.get(0).get(0)),
        this.world1.vertexArray.get(0).get(0));
    t.checkExpect(this.world1.find(this.world1.vertexArray.get(1).get(1)),
        this.world1.vertexArray.get(1).get(1));
    t.checkExpect(this.world1.find(this.world1.vertexArray.get(19).get(0)),
        this.world1.vertexArray.get(19).get(0));
    t.checkExpect(this.world1.find(this.world1.vertexArray.get(2).get(12)),
        this.world1.vertexArray.get(2).get(12));
    t.checkExpect(this.world1.find(this.world1.vertexArray.get(2).get(0)),
        this.world1.vertexArray.get(2).get(0));

    this.world3.createVertexArray();
    this.world3.linkVertices();
    this.world3.createMap();

    t.checkExpect(this.world3.find(this.world3.vertexArray.get(0).get(99)),
        this.world3.vertexArray.get(0).get(99));
    t.checkExpect(this.world3.find(this.world3.vertexArray.get(59).get(0)),
        this.world3.vertexArray.get(59).get(0));

    this.world4.createVertexArray();
    this.world4.linkVertices();
    this.world4.createMap();

    t.checkExpect(this.world4.find(this.world4.vertexArray.get(0).get(0)),
        this.world4.vertexArray.get(0).get(0));
    t.checkExpect(this.world4.find(this.world4.vertexArray.get(0).get(1)),
        this.world4.vertexArray.get(0).get(1));
    t.checkExpect(this.world4.find(this.world4.vertexArray.get(0).get(2)),
        this.world4.vertexArray.get(0).get(2));
    t.checkExpect(this.world4.find(this.world4.vertexArray.get(1).get(0)),
        this.world4.vertexArray.get(1).get(0));
    t.checkExpect(this.world4.find(this.world4.vertexArray.get(1).get(1)),
        this.world4.vertexArray.get(1).get(1));
    t.checkExpect(this.world4.find(this.world4.vertexArray.get(1).get(2)),
        this.world4.vertexArray.get(1).get(2));
    t.checkExpect(this.world4.find(this.world4.vertexArray.get(2).get(0)),
        this.world4.vertexArray.get(2).get(0));
    t.checkExpect(this.world4.find(this.world4.vertexArray.get(2).get(1)),
        this.world4.vertexArray.get(2).get(1));
    t.checkExpect(this.world4.find(this.world4.vertexArray.get(2).get(2)),
        this.world4.vertexArray.get(2).get(2));
  }

  // test for the method updateDisplayWall
  void testUpdateDisplayWall(Tester t) {
    initWorld();

    this.world1.createVertexArray();
    this.world1.linkVertices();
    this.world1.createWalls();
    this.world1.createMap();
    this.world1.kruskalAlgo();
    this.world1.updateDisplayWall();

    t.checkExpect(this.world1.vertexArray.get(0).get(0).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(0).get(0).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(0).get(1).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(0).get(1).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(0).get(2).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(0).get(2).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(0).get(3).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(0).get(3).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(0).get(4).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(0).get(4).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(0).get(5).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(0).get(5).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(0).get(6).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(0).get(6).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(0).get(7).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(0).get(7).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(0).get(8).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(0).get(8).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(0).get(9).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(0).get(9).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(0).get(10).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(0).get(10).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(0).get(11).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(0).get(11).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(0).get(12).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(0).get(11).displayBottomWall, true);

    t.checkExpect(this.world1.vertexArray.get(1).get(0).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(1).get(0).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(1).get(1).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(1).get(1).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(1).get(2).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(1).get(2).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(1).get(3).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(1).get(3).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(1).get(4).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(1).get(4).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(1).get(5).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(1).get(5).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(1).get(6).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(1).get(6).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(1).get(7).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(1).get(7).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(1).get(8).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(1).get(8).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(1).get(9).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(1).get(9).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(1).get(10).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(1).get(10).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(1).get(11).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(1).get(11).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(1).get(12).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(1).get(11).displayBottomWall, true);

    t.checkExpect(this.world1.vertexArray.get(2).get(0).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(2).get(0).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(2).get(1).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(2).get(1).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(2).get(2).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(2).get(2).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(2).get(3).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(2).get(3).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(2).get(4).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(2).get(4).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(2).get(5).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(2).get(5).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(2).get(6).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(2).get(6).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(2).get(7).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(2).get(7).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(2).get(8).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(2).get(8).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(2).get(9).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(2).get(9).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(2).get(10).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(2).get(10).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(2).get(11).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(2).get(11).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(2).get(12).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(2).get(11).displayBottomWall, true);

    t.checkExpect(this.world1.vertexArray.get(3).get(0).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(3).get(0).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(3).get(1).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(3).get(1).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(3).get(2).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(3).get(2).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(3).get(3).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(3).get(3).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(3).get(4).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(3).get(4).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(3).get(5).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(3).get(5).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(3).get(6).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(3).get(6).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(3).get(7).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(3).get(7).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(3).get(8).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(3).get(8).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(3).get(9).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(3).get(9).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(3).get(10).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(3).get(10).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(3).get(11).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(3).get(11).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(3).get(12).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(3).get(11).displayBottomWall, true);

    t.checkExpect(this.world1.vertexArray.get(4).get(0).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(4).get(0).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(4).get(1).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(4).get(1).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(4).get(2).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(4).get(2).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(4).get(3).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(4).get(3).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(4).get(4).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(4).get(4).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(4).get(5).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(4).get(5).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(4).get(6).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(4).get(6).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(4).get(7).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(4).get(7).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(4).get(8).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(4).get(8).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(4).get(9).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(4).get(9).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(4).get(10).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(4).get(10).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(4).get(11).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(4).get(11).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(4).get(12).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(4).get(11).displayBottomWall, false);

    t.checkExpect(this.world1.vertexArray.get(5).get(0).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(5).get(0).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(5).get(1).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(5).get(1).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(5).get(2).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(5).get(2).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(5).get(3).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(5).get(3).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(5).get(4).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(5).get(4).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(5).get(5).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(5).get(5).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(5).get(6).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(5).get(6).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(5).get(7).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(5).get(7).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(5).get(8).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(5).get(8).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(5).get(9).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(5).get(9).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(5).get(10).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(5).get(10).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(5).get(11).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(5).get(11).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(5).get(12).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(5).get(11).displayBottomWall, false);

    t.checkExpect(this.world1.vertexArray.get(6).get(0).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(6).get(0).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(6).get(1).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(6).get(1).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(6).get(2).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(6).get(2).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(6).get(3).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(6).get(3).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(6).get(4).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(6).get(4).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(6).get(5).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(6).get(5).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(6).get(6).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(6).get(6).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(6).get(7).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(6).get(7).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(6).get(8).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(6).get(8).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(6).get(9).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(6).get(9).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(6).get(10).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(6).get(10).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(6).get(11).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(6).get(11).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(6).get(12).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(6).get(11).displayBottomWall, true);

    t.checkExpect(this.world1.vertexArray.get(7).get(0).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(7).get(0).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(7).get(1).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(7).get(1).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(7).get(2).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(7).get(2).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(7).get(3).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(7).get(3).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(7).get(4).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(7).get(4).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(7).get(5).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(7).get(5).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(7).get(6).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(7).get(6).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(7).get(7).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(7).get(7).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(7).get(8).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(7).get(8).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(7).get(9).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(7).get(9).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(7).get(10).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(7).get(10).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(7).get(11).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(7).get(11).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(7).get(12).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(7).get(11).displayBottomWall, true);

    t.checkExpect(this.world1.vertexArray.get(8).get(0).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(8).get(0).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(8).get(1).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(8).get(1).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(8).get(2).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(8).get(2).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(8).get(3).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(8).get(3).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(8).get(4).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(8).get(4).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(8).get(5).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(8).get(5).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(8).get(6).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(8).get(6).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(8).get(7).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(8).get(7).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(8).get(8).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(8).get(8).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(8).get(9).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(8).get(9).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(8).get(10).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(8).get(10).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(8).get(11).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(8).get(11).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(8).get(12).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(8).get(11).displayBottomWall, false);

    t.checkExpect(this.world1.vertexArray.get(9).get(0).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(9).get(0).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(9).get(1).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(9).get(1).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(9).get(2).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(9).get(2).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(9).get(3).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(9).get(3).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(9).get(4).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(9).get(4).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(9).get(5).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(9).get(5).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(9).get(6).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(9).get(6).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(9).get(7).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(9).get(7).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(9).get(8).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(9).get(8).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(9).get(9).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(9).get(9).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(9).get(10).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(9).get(10).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(9).get(11).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(9).get(11).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(9).get(12).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(9).get(11).displayBottomWall, false);

    t.checkExpect(this.world1.vertexArray.get(10).get(0).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(10).get(0).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(10).get(1).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(10).get(1).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(10).get(2).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(10).get(2).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(10).get(3).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(10).get(3).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(10).get(4).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(10).get(4).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(10).get(5).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(10).get(5).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(10).get(6).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(10).get(6).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(10).get(7).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(10).get(7).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(10).get(8).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(10).get(8).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(10).get(9).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(10).get(9).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(10).get(10).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(10).get(10).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(10).get(11).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(10).get(11).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(10).get(12).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(10).get(11).displayBottomWall, true);

    t.checkExpect(this.world1.vertexArray.get(11).get(0).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(11).get(0).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(11).get(1).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(11).get(1).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(11).get(2).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(11).get(2).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(11).get(3).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(11).get(3).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(11).get(4).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(11).get(4).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(11).get(5).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(11).get(5).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(11).get(6).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(11).get(6).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(11).get(7).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(11).get(7).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(11).get(8).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(11).get(8).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(11).get(9).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(11).get(9).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(11).get(10).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(11).get(10).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(11).get(11).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(11).get(11).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(11).get(12).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(11).get(11).displayBottomWall, false);

    t.checkExpect(this.world1.vertexArray.get(12).get(0).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(12).get(0).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(12).get(1).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(12).get(1).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(12).get(2).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(12).get(2).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(12).get(3).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(12).get(3).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(12).get(4).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(12).get(4).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(12).get(5).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(12).get(5).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(12).get(6).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(12).get(6).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(12).get(7).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(12).get(7).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(12).get(8).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(12).get(8).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(12).get(9).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(12).get(9).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(12).get(10).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(12).get(10).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(12).get(11).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(12).get(11).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(12).get(12).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(12).get(11).displayBottomWall, false);

    t.checkExpect(this.world1.vertexArray.get(13).get(0).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(13).get(0).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(13).get(1).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(13).get(1).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(13).get(2).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(13).get(2).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(13).get(3).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(13).get(3).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(13).get(4).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(13).get(4).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(13).get(5).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(13).get(5).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(13).get(6).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(13).get(6).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(13).get(7).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(13).get(7).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(13).get(8).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(13).get(8).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(13).get(9).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(13).get(9).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(13).get(10).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(13).get(10).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(13).get(11).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(13).get(11).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(13).get(12).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(13).get(11).displayBottomWall, true);

    t.checkExpect(this.world1.vertexArray.get(14).get(0).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(14).get(0).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(14).get(1).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(14).get(1).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(14).get(2).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(14).get(2).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(14).get(3).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(14).get(3).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(14).get(4).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(14).get(4).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(14).get(5).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(14).get(5).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(14).get(6).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(14).get(6).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(14).get(7).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(14).get(7).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(14).get(8).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(14).get(8).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(14).get(9).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(14).get(9).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(14).get(10).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(14).get(10).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(14).get(11).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(14).get(11).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(14).get(12).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(14).get(11).displayBottomWall, false);

    t.checkExpect(this.world1.vertexArray.get(15).get(0).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(15).get(0).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(15).get(1).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(15).get(1).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(15).get(2).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(15).get(2).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(15).get(3).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(15).get(3).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(15).get(4).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(15).get(4).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(15).get(5).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(15).get(5).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(15).get(6).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(15).get(6).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(15).get(7).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(15).get(7).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(15).get(8).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(15).get(8).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(15).get(9).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(15).get(9).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(15).get(10).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(15).get(10).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(15).get(11).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(15).get(11).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(15).get(12).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(15).get(11).displayBottomWall, false);

    t.checkExpect(this.world1.vertexArray.get(16).get(0).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(16).get(0).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(16).get(1).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(16).get(1).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(16).get(2).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(16).get(2).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(16).get(3).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(16).get(3).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(16).get(4).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(16).get(4).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(16).get(5).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(16).get(5).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(16).get(6).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(16).get(6).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(16).get(7).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(16).get(7).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(16).get(8).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(16).get(8).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(16).get(9).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(16).get(9).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(16).get(10).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(16).get(10).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(16).get(11).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(16).get(11).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(16).get(12).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(16).get(11).displayBottomWall, false);

    t.checkExpect(this.world1.vertexArray.get(17).get(0).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(17).get(0).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(17).get(1).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(17).get(1).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(17).get(2).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(17).get(2).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(17).get(3).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(17).get(3).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(17).get(4).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(17).get(4).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(17).get(5).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(17).get(5).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(17).get(6).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(17).get(6).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(17).get(7).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(17).get(7).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(17).get(8).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(17).get(8).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(17).get(9).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(17).get(9).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(17).get(10).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(17).get(10).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(17).get(11).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(17).get(11).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(17).get(12).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(17).get(11).displayBottomWall, true);

    t.checkExpect(this.world1.vertexArray.get(18).get(0).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(18).get(0).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(18).get(1).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(18).get(1).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(18).get(2).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(18).get(2).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(18).get(3).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(18).get(3).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(18).get(4).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(18).get(4).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(18).get(5).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(18).get(5).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(18).get(6).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(18).get(6).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(18).get(7).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(18).get(7).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(18).get(8).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(18).get(8).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(18).get(9).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(18).get(9).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(18).get(10).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(18).get(10).displayBottomWall, false);
    t.checkExpect(this.world1.vertexArray.get(18).get(11).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(18).get(11).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(18).get(12).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(18).get(11).displayBottomWall, true);

    t.checkExpect(this.world1.vertexArray.get(19).get(0).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(19).get(0).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(19).get(1).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(19).get(1).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(19).get(2).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(19).get(2).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(19).get(3).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(19).get(3).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(19).get(4).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(19).get(4).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(19).get(5).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(19).get(5).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(19).get(6).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(19).get(6).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(19).get(7).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(19).get(7).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(19).get(8).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(19).get(8).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(19).get(9).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(19).get(9).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(19).get(10).displayRightWall, false);
    t.checkExpect(this.world1.vertexArray.get(19).get(10).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(19).get(11).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(19).get(11).displayBottomWall, true);
    t.checkExpect(this.world1.vertexArray.get(19).get(12).displayRightWall, true);
    t.checkExpect(this.world1.vertexArray.get(19).get(11).displayBottomWall, true);

    this.world4.createVertexArray();
    this.world4.linkVertices();
    this.world4.createWalls();
    this.world4.createMap();
    this.world4.kruskalAlgo();
    this.world4.updateDisplayWall();

    t.checkExpect(this.world4.vertexArray.get(0).get(0).displayRightWall, false);
    t.checkExpect(this.world4.vertexArray.get(0).get(0).displayBottomWall, false);
    t.checkExpect(this.world4.vertexArray.get(0).get(1).displayRightWall, false);
    t.checkExpect(this.world4.vertexArray.get(0).get(1).displayBottomWall, true);
    t.checkExpect(this.world4.vertexArray.get(0).get(2).displayRightWall, true);
    t.checkExpect(this.world4.vertexArray.get(0).get(2).displayBottomWall, false);

    t.checkExpect(this.world4.vertexArray.get(1).get(0).displayRightWall, true);
    t.checkExpect(this.world4.vertexArray.get(1).get(0).displayBottomWall, false);
    t.checkExpect(this.world4.vertexArray.get(1).get(1).displayRightWall, true);
    t.checkExpect(this.world4.vertexArray.get(1).get(1).displayBottomWall, false);
    t.checkExpect(this.world4.vertexArray.get(1).get(2).displayRightWall, true);
    t.checkExpect(this.world4.vertexArray.get(1).get(2).displayBottomWall, false);

    t.checkExpect(this.world4.vertexArray.get(2).get(0).displayRightWall, true);
    t.checkExpect(this.world4.vertexArray.get(2).get(0).displayBottomWall, true);
    t.checkExpect(this.world4.vertexArray.get(2).get(1).displayRightWall, false);
    t.checkExpect(this.world4.vertexArray.get(2).get(1).displayBottomWall, true);
    t.checkExpect(this.world4.vertexArray.get(2).get(2).displayRightWall, true);
    t.checkExpect(this.world4.vertexArray.get(2).get(2).displayBottomWall, true);
  }

  // test for the method checkWin
  void testCheckWin(Tester t) {
    initWorld();

    WorldScene world4Scene = new WorldScene(465, 465);
    t.checkExpect(this.world4.background, world4Scene);

    this.world4.drawGame();
    world4Scene
        .placeImageXY(new RectangleImage(155, 155, OutlineMode.SOLID, new Color(240, 209, 220))
            .movePinhole(-77, -77), 0, 0);
    world4Scene
        .placeImageXY(new RectangleImage(155, 155, OutlineMode.SOLID, new Color(194, 101, 136))
            .movePinhole(-77, -77), 310, 310);

    this.world4.makeScene();

    world4Scene.placeImageXY(this.world4.vertexArray.get(0).get(1).drawBottomWall(), 232, 155);
    world4Scene.placeImageXY(this.world4.vertexArray.get(0).get(2).drawRightWall(), 465, 77);
    world4Scene.placeImageXY(this.world4.vertexArray.get(1).get(0).drawRightWall(), 155, 232);
    world4Scene.placeImageXY(this.world4.vertexArray.get(1).get(1).drawRightWall(), 310, 232);
    world4Scene.placeImageXY(this.world4.vertexArray.get(1).get(2).drawRightWall(), 465, 232);
    world4Scene.placeImageXY(this.world4.vertexArray.get(2).get(0).drawRightWall(), 155, 387);
    world4Scene.placeImageXY(this.world4.vertexArray.get(2).get(0).drawBottomWall(), 77, 465);
    world4Scene.placeImageXY(this.world4.vertexArray.get(2).get(1).drawBottomWall(), 232, 465);
    world4Scene.placeImageXY(this.world4.vertexArray.get(2).get(2).drawRightWall(), 465, 387);
    world4Scene.placeImageXY(this.world4.vertexArray.get(2).get(2).drawBottomWall(), 387, 465);
    t.checkExpect(this.world4.background, world4Scene);

    // changes position to 2, 2 - end square
    this.world4.player.currVertex = this.world4.vertexArray.get(2).get(2);
    this.world4.drawPlayer();
    world4Scene
        .placeImageXY(new RectangleImage(155, 155, OutlineMode.SOLID, new Color(255, 255, 255))
            .movePinhole(-77, -77), 310, 310);
    t.checkExpect(this.world4.background, world4Scene);

    this.world4.checkWin();
    world4Scene.placeImageXY(new TextImage("You Win!", 30, Color.black), 232, 232);
    t.checkExpect(this.world4.background, world4Scene);
  }

  // test for the method onKeyEvent
  void testOnKeyEvent(Tester t) {
    initWorld();
    this.world1.createVertexArray();
    this.world1.linkVertices();
    this.world1.createWalls();
    this.world1.createMap();
    this.world1.kruskalAlgo();
    this.world1.updateDisplayWall();

    t.checkExpect(this.world1.background.width, 351);
    t.checkExpect(this.world1.background.height, 540);
    t.checkExpect(this.world1.length, 13);
    t.checkExpect(this.world1.width, 20);
    t.checkExpect(this.world1.vertexSize, 27);
    t.checkExpect(this.world1.vertexArray.size(), 20);
    t.checkExpect(this.world1.vertexMap.size(), 260);
    t.checkExpect(this.world1.walls.size(), 259);
    ArrayList<ArrayList<Vertex>> vertexArrayFirst = new ArrayList<ArrayList<Vertex>>(
        this.world1.vertexArray);
    ArrayList<Wall> wallsFirst = new ArrayList<Wall>(this.world1.walls);

    // press the "r" key to generate a new maze
    this.world1.onKeyEvent("r");

    // checks that the this.world is cleared and a new maze is generated
    // checks that the dimensions of this.world game are the same
    // checks that the length, width, and vertexSize remain constant
    t.checkExpect(this.world1.background.width, 351);
    t.checkExpect(this.world1.background.height, 540);
    t.checkExpect(this.world1.length, 13);
    t.checkExpect(this.world1.width, 20);
    t.checkExpect(this.world1.vertexSize, 27);

    // check that the vertexArray field has stayed the same
    t.checkExpect(this.world1.vertexArray.size(), 20);
    ArrayList<ArrayList<Vertex>> vertexArraySecond = new ArrayList<ArrayList<Vertex>>(
        this.world1.vertexArray);

    for (int i = 0; i < vertexArrayFirst.size(); i++) {
      for (int j = 0; j < vertexArrayFirst.get(i).size(); j++) {
        t.checkExpect((vertexArrayFirst.get(i).get(j).x), (vertexArraySecond.get(i).get(j).x));
      }
    }

    // check that the walls field has changed but the size has stayed the same
    t.checkExpect(this.world1.walls.size(), 259);
    ArrayList<Wall> wallsSecond = new ArrayList<Wall>(this.world1.walls);

    boolean isAllSame = true;
    for (int i = 0; i < wallsFirst.size(); i++) {
      if (!(wallsFirst.get(i).equals(wallsSecond.get(i)))) {
        isAllSame = false;
      }
    }
    t.checkExpect(isAllSame, false);

    t.checkExpect(this.world1.player.currVertex.x, 0);
    t.checkExpect(this.world1.player.currVertex.y, 0);
    // no change - invalid move
    this.world1.onKeyEvent("up");
    t.checkExpect(this.world1.player.currVertex.x, 0);
    t.checkExpect(this.world1.player.currVertex.y, 0);
    // no change - wall in the way
    this.world1.onKeyEvent("right");
    t.checkExpect(this.world1.player.currVertex.x, 0);
    t.checkExpect(this.world1.player.currVertex.y, 0);
    this.world1.onKeyEvent("down");
    t.checkExpect(this.world1.player.currVertex.x, 0);
    t.checkExpect(this.world1.player.currVertex.y, 1);
    this.world1.onKeyEvent("right");
    t.checkExpect(this.world1.player.currVertex.x, 1);
    t.checkExpect(this.world1.player.currVertex.y, 1);
    this.world1.onKeyEvent("right");
    t.checkExpect(this.world1.player.currVertex.x, 2);
    t.checkExpect(this.world1.player.currVertex.y, 1);
    this.world1.onKeyEvent("right");
    t.checkExpect(this.world1.player.currVertex.x, 2);
    t.checkExpect(this.world1.player.currVertex.y, 1);
    this.world1.onKeyEvent("up");
    t.checkExpect(this.world1.player.currVertex.x, 2);
    t.checkExpect(this.world1.player.currVertex.y, 0);
    this.world1.onKeyEvent("right");
    t.checkExpect(this.world1.player.currVertex.x, 3);
    t.checkExpect(this.world1.player.currVertex.y, 0);
    this.world1.onKeyEvent("left");
    t.checkExpect(this.world1.player.currVertex.x, 2);
    t.checkExpect(this.world1.player.currVertex.y, 0);
  }

  // test for the method compare
  void testCompare(Tester t) {
    Wall wall1 = new Wall(this.v1, this.v2, 10);
    Wall wall2 = new Wall(this.v3, this.v4, 20);
    WeightComparator comparator = new WeightComparator();
    int result = comparator.compare(wall1, wall2);
    t.checkExpect(result, -10);
    Wall wall3 = new Wall(this.v5, this.v6, 30);
    Wall wall4 = new Wall(this.v1, this.v2, 20);
    result = comparator.compare(wall3, wall4);
    t.checkExpect(result, 10);
    Wall wall5 = new Wall(this.v4, this.v5, 20);
    Wall wall6 = new Wall(this.v2, this.v3, 20);
    result = comparator.compare(wall5, wall6);
    t.checkExpect(result, 0);
  }
}