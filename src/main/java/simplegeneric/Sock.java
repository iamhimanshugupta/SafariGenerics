package simplegeneric;

public class Sock implements Colored {
  private String color;

  public Sock(String color) {
    this.color = color;
  }

  @Override
  public String getColor() {
    return color;
  }
}
