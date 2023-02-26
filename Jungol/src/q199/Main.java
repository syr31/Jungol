package q199;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Person implements Comparable<Person> {
   private String name;
   private int score1, score2, score3;
   private int sum;

   public Person(String name, int score1, int score2, int score3) {
      this.name = name;
      this.score1 = score1;
      this.score2 = score2;
      this.score3 = score3;
      sum = score1 + score2 + score3;
   }

   public void print() {
      System.out.println(name + " " + score1 + " " + score2 + " " + score3);
   }

   public void printSum() {
      System.out.println(name + " " + score1 + " " + score2 + " " + score3 + " " + sum);
   }

   public int getSum() {
      return sum;
   }

   @Override
   public int compareTo(Person o) {
      // TODO Auto-generated method stub
      return o.getSum() - getSum();
   }
}

public class Main {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      Person[] p = new Person[n];
      for (int i = 0; i < n; i++) {
         String name = sc.next();
         int score1 = sc.nextInt();
         int score2 = sc.nextInt();
         int score3 = sc.nextInt();

         p[i] = new Person(name, score1, score2, score3);
      }
      sc.close();

//      for (int i = 0; i < n; i++) {
//         p[i].printSum();
//      }

      Comparator<Person> comparator = new Comparator<Person>() {
         @Override
         public int compare(Person o1, Person o2) {
            return o2.getSum() - o1.getSum();
         }
      };
//      Arrays.sort(p);
      Arrays.sort(p, comparator);

      for (int i = 0; i < n; i++) {
         p[i].printSum();
      }
   }
}