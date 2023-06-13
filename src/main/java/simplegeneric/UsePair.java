package simplegeneric;

import java.time.LocalDate;

public class UsePair {
  public static void main(String[] args) {
//    Pair<String> p = new Pair<>("John", LocalDate.now());
    Pair<String> p = new Pair<>("John", "Smith");
    var n1 = p.getLeft();

    Pair<LocalDate> pd = new Pair<>(LocalDate.now(), LocalDate.now());

//    var somePair = Pair.<Integer>of(Integer.valueOf(1), Integer.valueOf(2));
    Pair<Integer> somePair = Pair.of(Integer.valueOf(1), Integer.valueOf(2));

//    ClothingPair<Sock> cps;
  }
}
