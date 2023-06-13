package simple;


import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UseAList {
  // Could be "legacy" code
  public static void breakAList(List l) {
    l.add(0, LocalDate.now());
  }

  public static void main(String[] args) {
//    List<String> names = new ArrayList(); // BAD
//    List<String> names = new ArrayList(List.of(/*LocalDate.now()*/));
//    List<String> names = new ArrayList<String>(List.of(LocalDate.now()));
//    List<String> names = new ArrayList<String>();
//    List<String> names = new ArrayList<>(List.of(LocalDate.now()));
    List<String> names = new ArrayList<>(List.of("Alice"));
//    names = Collections.checkedList(names, String.class);
    names.add("Fred");
    names.add("Jim");
    System.out.println(names);
    names.add("Sheila");
//    names.add(LocalDate.now());
    System.out.println(names);
//    breakAList(names);
    System.out.println(names.get(0));
    String n1 = /*(String)*/names.get(0);
    System.out.println("name length is " + n1.length());

    System.out.println("type of names is " + names.getClass().getName());
    List<LocalDate> ald = new ArrayList<LocalDate>();
    System.out.println("type of ald is " + ald.getClass().getName());
    System.out.println("types the same? " + (ald.getClass() == names.getClass())) ;

    String[] sa = new String[0];
    LocalDate[] lda = new LocalDate[0];
    System.out.println("sa type is " + sa.getClass().getName());
    System.out.println("lda type is " + lda.getClass().getName());

    int[] ia = {};
//    List<int> li;
    List<Integer> li = new ArrayList<>();
    li.add(1); // autoboxing
    System.out.println(li.get(0).getClass().getName());
  }
}
