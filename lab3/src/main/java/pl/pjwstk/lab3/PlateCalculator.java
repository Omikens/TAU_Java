package pl.pjwstk.lab3;

import java.util.Scanner;

public class PlateCalculator {

    private static Scanner input;

    public int available45;
    public int available35;
    public int available25;
    public int available20;
    public int available10;
    public int available5;
    public int available2half;
    double barbellWeight;
    static double targetWeight;

    public static void main(String[] args) {
        System.out.print("What weight would you like to use: ");
        input = new Scanner(System.in);
        targetWeight = input.nextDouble();
        new PlateCalculator().calculate(targetWeight);
    }

    public int calculate(double targetWeight) {
        input = new Scanner(System.in);

        if(targetWeight < 0) { throw new IllegalArgumentException(); }


        System.out.print("What is the weight of barbell: ");
        barbellWeight = input.nextInt();
        System.out.println("You will need total weigh of: " + needWeight() + " to reach desired barbell weight");
        System.out.println("What plates do you have? Enter a number: ");
        System.out.print("45kg: ");
        available45 = input.nextInt();
        System.out.print("35kg: ");
        available35 = input.nextInt();
        System.out.print("25kg: ");
        available25 = input.nextInt();
        System.out.print("20kg: ");
        available20 = input.nextInt();
        System.out.print("10kg: ");
        available10 = input.nextInt();
        System.out.print("5kg: ");
        available5 = input.nextInt();
        System.out.print("2,5kg: ");
        available2half = input.nextInt();

        targetWeight -= barbellWeight;

        int use45 = 0;
        int use35 = 0;
        int use25 = 0;
        int use20 = 0;
        int use10 = 0;
        int use5 = 0;
        int use2half = 0;

        while (targetWeight > 0) {

            if ((targetWeight - 90 >= 0) && (available45 > 1)) {
                targetWeight -= 90;
                use45++;
                available45--;
            } else if ((targetWeight - 70 >= 0) && (available35 > 1)) {
                targetWeight -= 70;
                use35++;
                available35--;
            } else if ((targetWeight - 50 >= 0) && (available25 > 1)) {
                targetWeight -= 50;
                use25++;
                available25--;
            } else if ((targetWeight - 40 >= 0) && (available20 > 1)) {
                targetWeight -= 40;
                use20++;
                available20--;
            } else if ((targetWeight - 20 >= 0) && (available10 > 1)) {
                targetWeight -= 20;
                use10++;
                available10--;
            } else if ((targetWeight - 10 >= 0) && (available5 > 1)) {
                targetWeight -= 10;
                use5++;
                available5--;
            } else if ((targetWeight - 5 >= 0) && (available2half > 1)) {
                targetWeight -= 5;
                use2half++;
                available2half--;
            } else {
                System.out.print("You cannot achieve desired weight with this plate setup!");
                System.out.print("This is the closest you can get:");
                break;
            }

        }

        System.out.print("Put this on each side of bar: ");
        System.out.print("45: " + use45);
        System.out.print(" 35: " + use35);
        System.out.print(" 25: " + use25);
        System.out.print(" 20: " + use20);
        System.out.print(" 10: " + use10);
        System.out.print(" 5: " + use5);
        System.out.print(" 2.5: " + use2half);

        System.out.println("\nSome useless data:");
        need45();
        need35();
        need25();
        need20();
        need10();
        need5();
        need2half();
        return use45; // returning number of 45kg plates only for testing purposes
    }

    public int availableHeavy(int available45, int available35){
        return available45 + available35;
    }
    public double needWeight(){ return targetWeight - barbellWeight; }
    public int need45(){
        if ((needWeight() % 45) == 0){
            System.out.println("You can build this weight entirely using only: "+(int)needWeight()/45+" of 45kg plates");
            return (int) (needWeight()/45);
        }
        else {return 0;}
    }
    public int need35(){
        if (needWeight() % 35 == 0){
            System.out.println("You can build this weight entirely using only: "+(int)needWeight()/35+" of 35kg plates");
            return (int) (needWeight()/35);
        }
        else {return 0;}
    }
    public int need25(){
        if (needWeight() % 25 == 0){
            System.out.println("You can build this weight entirely using only: "+(int)needWeight()/25+" of 25kg plates");
            return (int) (needWeight()/25);
        }
        else {return 0;}
    }
    public int need20(){
        if (needWeight() % 20 == 0){
            System.out.println("You can build this weight entirely using only: "+(int)needWeight()/20+" of 20kg plates");
            return (int) (needWeight()/20);
        }
        else {return 0;}
    }
    public int need10(){
        if (needWeight() % 10 == 0){
            System.out.println("You can build this weight entirely using only: "+(int)needWeight()/10+" of 10kg plates");
            return (int) (needWeight()/10);
        }
        else {return 0;}
    }
    public int need5(){
        if (needWeight() % 5 == 0){
            System.out.println("You can build this weight entirely using only: "+(int)needWeight()/5+" of 5kg plates");
            return (int) (needWeight()/5);
        }
        else {return 0;}
    }
    public double need2half(){
        if (needWeight() % 2.5 == 0){
            double count = needWeight()/2.5;
            System.out.println("You can build this weight entirely using only: "+(int)count+" of 2,5kg plates");
            return (needWeight()/2.5);
        }
        else {return 0;}
    }
}
