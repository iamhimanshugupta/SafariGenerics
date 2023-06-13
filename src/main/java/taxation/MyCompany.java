package taxation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyCompany {

  /*
  AT ALL TIMES IN GENERICS
  extends means "is assignable TO" (nothing to do with class vs interface)
  super means "is assignable FROM"
   */

//  public static void collectJoesClients(List<Individual> li) {
  // Feels like this, but NO NO NO, not valid!!!
//  public static void collectJoesClients(List<Individual extends ?> li) {
  public static void collectJoesClients(List<? super Individual> li) {
    li.add(new Individual());
    li.add(new Individual());
    li.add(new Individual());
//    li.add(new Corporation());

    // I don't need/want to do this here!
//    Individual first = li.get(0); // this would break with List<Taxable>
  }

  public static void calculateTaxes(Taxable t) {}

  // Note that <? extends Object> can be shortened to <?>

//  public static void calculateBulkTaxes(List<Taxable> lt) {
//  public static <E extends Taxable> void calculateBulkTaxes(List<E> lt/*, E item*/) {
    public static void calculateBulkTaxes(List<? extends Taxable> lt) {
//    lt.add(new Taxable());
//    lt.add(new Corporation());
//    lt.add(new Individual());
    // DON'T do this! use enhanced for to iterate List etc.
    for (int idx = 0; idx < lt.size(); idx++) {
      Taxable t = lt.get(idx);
      calculateTaxes(t);
    }
  }

  public static void main(String[] args) {
    List<Taxable> clients = new ArrayList<>();
    clients.add(new Corporation());
    clients.add(new Corporation());
    clients.add(new Individual());

    collectJoesClients(clients);

    calculateBulkTaxes(clients);

    List<Individual> joesClients = new ArrayList<>();
    joesClients.add(new Individual());
    joesClients.add(new Individual());

    // failure of "Liskov substitution"
    calculateBulkTaxes(joesClients);

    Object obj = joesClients;
    // Never allowed
//    if (obj instanceof List<Individual>) {
    // Has always been allowed
//    if (obj instanceof List<?>) {

    Collection<Individual> ci = joesClients;
    // OK in Java 17, not in 11! -- NOTE have not changed the generic part
//    if (ci instanceof List<Individual>) {
    if (ci instanceof List<Individual> li) {
      System.out.println("It's a List");
      Individual i = li.get(0);
    }
  }
}
