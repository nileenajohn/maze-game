// represents a wall between two vertices in the maze
class Wall {
  // the first vertex connected by the wall
  Vertex v1;
  // the second vertex connected by the wall
  Vertex v2;
  // the cost associated with the wall
  // DESIGN NOTE: we created a cost field so each wall is associated with a weight
  // to be used for sorting in kruskal's algorithm
  int cost;

  Wall(Vertex v1, Vertex v2, int cost) {
    this.v1 = v1;
    this.v2 = v2;
    this.cost = cost;
  }
}
