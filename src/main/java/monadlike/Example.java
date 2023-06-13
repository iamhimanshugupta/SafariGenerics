package monadlike;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

class Student {
  private String name;
  private int grade;

  public Student(String name, int grade) {
    this.name = name;
    this.grade = grade;
  }

  public String getName() {
    return name;
  }

  public int getGrade() {
    return grade;
  }

  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        ", grade=" + grade +
        '}';
  }
}
public class Example {

//  public static List<Student> getSmart(List<Student> in, int grade) {
//    List<Student> out = new ArrayList<>();
//    for (Student s : in) {
//      if (s.getGrade() > grade) {
//        out.add(s);
//      }
//    }
//    return out;
//  }

//  public static <E, F> List<F> map(List<E> data, Function<E, F> op) {
  public static <E, F> List<F> map(
      List<E> data, Function<? super E, ? extends F> op) {
    List<F> res = new ArrayList<>();
    for (E e : data) {
      res.add(op.apply(e));
    }
    return res;
  }

  public static <E> List<E> filter(
      List<E> in, Predicate<? super E> crit) {
    List<E> out = new ArrayList<>();
    for (E s : in) {
      if (crit.test(s)) {
        out.add(s);
      }
    }
    return out;
  }

  public static void main(String[] args) {
    List<Student> roster = List.of(
        new Student("Fred", 80),
        new Student("Jim", 45),
        new Student("Sheila", 95)
    );

    System.out.println(filter(roster, s -> s.getGrade() > 75));
    System.out.println("---------------");
    System.out.println(filter(roster, s -> s.getName().length() > 4));
    System.out.println("---------------");
    Predicate<CharSequence> longString = s -> s.length() > 6;
    System.out.println(filter(List.of("short", "very Long"), longString));

    var sbl = List.of(new StringBuilder("Short"), new StringBuilder("Very Long"));

    System.out.println("---------------");
    System.out.println(filter(sbl, longString));

    System.out.println("---------------");
    List<Number> li = map(List.<CharSequence>of("short", "very Long"), s -> s.length());
    System.out.println(li);
  }
}
