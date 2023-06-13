package simplegeneric;

public class Shop {
  public static void main(String[] args) {
//    Pair<Shoe> psBad = new Pair<>(new Shoe("Brown", 10), "Broken");
    ClothingPair<Shoe> ps =
        new ClothingPair<>(new Shoe("Black", 9), new Shoe("Black", 10));
    System.out.println(ps);
    String leftColor = ps.getLeft().getColor();
    System.out.println("color of left shoe is " + leftColor);
    Pair<String> pString;

    System.out.println("shoes match? " + ps.isMatched());
  }
}
