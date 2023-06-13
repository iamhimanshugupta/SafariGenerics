package simplegeneric;

public class Pair<E> {
  /*private */E left;
  /*private */E right;

  public Pair(E left, E right) {
    this.left = left;
    this.right = right;
  }

  public static <F> Pair<F> of(F left, F right) {
    return new Pair(left, right);
  }

  public <F> void setRight(E obj) {
    this.right = obj;
  }

  public void setLeft(E left) {
    this.left = left;
  }

  public E getLeft() {
    return left;
  }

  public E getRight() {
    return right;
  }

  @Override
  public String toString() {
    return "Pair{" +
        "left=" + left +
        ", right=" + right +
        '}';
  }
}
