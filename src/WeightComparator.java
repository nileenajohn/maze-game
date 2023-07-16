import java.util.Comparator;

// represents a comparator that compares the costs of walls
class WeightComparator implements Comparator<Wall> {
  public int compare(Wall w1, Wall w2) {
    return w1.cost - w2.cost;
  }
}