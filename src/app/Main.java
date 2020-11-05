package app;

import java.util.Scanner;

public class Main {
  private static Scanner input;


  public static void main(String[] args) {

    input = new Scanner(System.in);

    System.out.print("What weight would you like to use: ");
    double targetWeight = input.nextInt();
    System.out.print("What is the weight of barbell: ");
    double barbellWeight = input.nextInt();
    System.out.print("What plates do you have? Enter a number: ");
    System.out.print("45kg: ");
    int available45 = input.nextInt();
    System.out.print("35kg: ");
    int available35 = input.nextInt();
    System.out.print("25kg: ");
    int available25 = input.nextInt();
    System.out.print("20kg: ");
    int available20 = input.nextInt();
    System.out.print("10kg: ");
    int available10 = input.nextInt();
    System.out.print("5kg: ");
    int available5 = input.nextInt();
    System.out.print("2,5kg: ");
    int available2half = input.nextInt();

    targetWeight -= barbellWeight;

    int use45 = 0;
    int use35 = 0;
    int use25 = 0;
    int use20 = 0;
    int use10 = 0;
    int use5 = 0;
    int use2half = 0;

    while(targetWeight >  0) {

      if((targetWeight - 90 >= 0) && (available45 > 0)) {
        targetWeight -= 90;
        use45++;
        available45--;
      }
      else if((targetWeight - 70 >= 0) && (available35 > 0)) {
        targetWeight -= 70;
        use35++;
        available35--;
      }
      else if((targetWeight - 50 >= 0) && (available25 > 0)) {
        targetWeight -= 50;
        use25++;
        available25--;
      }
      else if((targetWeight - 40 >= 0) && (available20 > 0)) {
        targetWeight -= 40;
        use20++;
        available20--;
      }
      else if((targetWeight - 20 >= 0) && (available10 > 0)) {
        targetWeight -= 20;
        use10++;
        available10--;
      }
      else if((targetWeight - 10 >= 0) && (available5 > 0)) {
        targetWeight -= 10;
        use5++;
        available5--;
      }
      else if((targetWeight - 5 >= 0) && (available2half > 0)) {
        targetWeight -= 5;
        use2half++;
        available2half--;
      }
      else {
        System.out.println("You cannot achieve desired weight with this plate setup!");
        System.out.println("This is the closest you can get:");
        break;
      }

    }

    System.out.println("Put this on each side of bar: ");
    System.out.println("45: " + use45);
    System.out.println("35: " + use35);
    System.out.println("25: " + use25);
    System.out.println("20: " + use20);
    System.out.println("10: " + use10);
    System.out.println("5: " + use5);
    System.out.println("2.5: " + use2half);
  }

}
