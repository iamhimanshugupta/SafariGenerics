package simplegeneric;

//public class ClothingPair<E extends Colored/*, String*/> extends Pair<E> {
// any class type constraint (as distinct from interface constraint)
// must come first
public class ClothingPair<E extends Object & Colored & Sized> extends Pair<E> {
//public class ClothingPair<E extends Colored & Sized> extends Pair<E> {
//  /*java.lang.*/ String s = "Hello";
  public ClothingPair(E left, E right) {
    super(left, right);
  }

  public boolean isMatched() {
    return left.getColor().equals(right.getColor())
        && left.getSize() == right.getSize()
        ;
  }

}
