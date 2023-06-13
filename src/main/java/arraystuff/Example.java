package arraystuff;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Example {

//  public static void doStuff(List<? super Object> lWeird) {}

  // array of object isn't array of E!!!
//  public static <E> E[] getAsArray(List<E> input) {
////    E[] result = new E[input.size()]; // nope, E does not exist at runtime!
//    E[] result = (E[])(new Object[input.size()]);
//    for (int idx = 0; idx < result.length; idx++) {
//      result[idx] = input.get(idx++);
//    }
//    return result;
//  }
  public static <F, E extends F> F[] getAsArray(List<E> input, Class<F> cl) {
    E[] result = (E[])(Array.newInstance(cl, input.size()));
    for (int idx = 0; idx < result.length; idx++) {
      result[idx] = input.get(idx);
    }
    return result;
  }

  public static void main(String[] args) {
    List<String> names = List.of("Fred", "Jim", "Sheila");

//    System.out.println(Arrays.toString(getAsArray(names)));
//    String [] namesArray = getAsArray(names);
//    String [] namesArray = getAsArray(names, String.class);

    Object [] namesArray = getAsArray(names, Object.class);
    namesArray[0] = new StringBuilder("This is a StringBuilder");

//    String [] namesArray = getAsArray(names, LocalDate.class);

    System.out.println(namesArray.getClass().getName());
    System.out.println(Arrays.toString(namesArray));

  }
}
