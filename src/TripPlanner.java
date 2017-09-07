/*
  Created by arthurhasoro on 7/11/17.
  First Module Project Microsoft Java Course
 */

import java.util.Scanner;
import java.lang.Math;

public class TripPlanner {
    public static final double KM_MILES_RATIO = 0.38610216;
    public static final int EARTH_RADIUS_KM = 6371;

    public static void main(String[] args) {

       //Prints a blank line
       System.out.print("\n");

       //Call Greeting Method
       Greeting();
       //Call Travel Time and Budget Method
       TravelTimeAndBudget();
       //Call Time Difference Method
       TimeDifference();
       //Call Country Area Method
       CountryArea();
       //Call Distance to Destination Method
       DestinationDistance();
    }

    //Greeting the user
    public static void Greeting() {
        //New Scanner
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Vacation Planner!");
        System.out.print("What is your name? ");
        //Waits for user input name
        String name = input.next();

        //ends the line waiting for input
        input.nextLine();

        System.out.print("Nice to meet you " + name + ", where are you travelling to? ");
        String country = input.nextLine();
        System.out.println("Great! " + country + " sounds like a great trip");
        System.out.println("***********************\n\n");
    }

    //Calculate daily budget
    public static void TravelTimeAndBudget() {
        //New Scanner
        Scanner input = new Scanner(System.in);

        //Get info from user
        System.out.print("How many days are you going to spend travelling? ");
        int vacDays = input.nextInt();
        System.out.print("How much money, in USD, are you planning to spend on your trip? ");
        int money = input.nextInt();
        System.out.print("What is the three letter currency symbol for your travel destination? ");
        String currency = input.next();
        System.out.print("How many " + currency + " are ther in 1 USD? ");
        double exchangeRate = input.nextDouble();

        //Calculate info input by user
        int hours = vacDays * 24;
        int minutes = hours * 60;
        double dailySpend = money/vacDays;
        double moneyEquiv = exchangeRate * money;
        double moneyEquivDaily = dailySpend * exchangeRate * 100;
        //Round daily money available
        int round = (int)moneyEquivDaily;
        double round2 = round/100.0;


        //Deliver info to user
        System.out.println("\n\nIf you are traveling for " + vacDays + " days that is the same as " + hours + " hours or " + minutes + " minutes");
        System.out.println("If you are going to spend $" + money + " USD that means per day you can spend up to $" + dailySpend + " USD");
        System.out.println("Your total budget in " + currency + " is " + moneyEquiv + " " + currency + ", which per day is " + round2 + " " + currency);
        System.out.println("***********************\n\n");
    }

    public static void TimeDifference() {
        //New Scanner
        Scanner input = new Scanner(System.in);

        System.out.print("What is the time difference, in hours, between your home and your destination? ");
        //Prevents input numbers greater than 24
        int timeDiff = (input.nextInt()) % 24;

        //time difference calculation for midnight
        int timeAM = 24;
        timeAM = (timeAM + timeDiff) % 24;

        System.out.println("Tha means that when it is midnight at home it will be " + timeAM + ":00 in your travel destination");

        //time difference calculation for noon
        int timePM = 12;
        timePM = (timePM + timeDiff) % 24;

        System.out.println("and when it is noon at home it will be " + timePM + ":00 ");
        System.out.println("***********************\n\n");
    }

    public static void CountryArea() {
        //New Scanner
        Scanner input = new Scanner(System.in);

        System.out.print("What is the square area of your destination country in km2? ");
        int area = input.nextInt();

        double areaToMiles = area * KM_MILES_RATIO * 100;
        //round number of miles
        int round = (int)areaToMiles;
        double round2 = round/100.0;

        System.out.println("In miles2 that is " + round2);
        System.out.println("***********************\n\n");
    }

    //Calculate distance between destination and hometown (use of haversine function)
    public static void DestinationDistance() {
        //New Scanner
        Scanner input = new Scanner(System.in);

        //Ask for home latitude and longitude
        System.out.print("Enter the longitude of your Hometown: ");
        double homeLongitude = Math.toRadians(input.nextDouble());
        System.out.print("Enter the latitude of your Hometown: ");
        double homeLatitude = Math.toRadians(input.nextDouble());

        //Ask for destination latitude and longitude
        System.out.print("Enter the longitude of your destination: ");
        double destLongitude = Math.toRadians(input.nextDouble());
        System.out.print("Enter the latitude of your destination: ");
        double destLatitude = Math.toRadians(input.nextDouble());

        double hav1 = ((1 - Math.cos(destLatitude - homeLatitude)) / 2);
        double hav2 = (Math.cos(homeLatitude)) * (Math.cos(destLatitude));
        double hav3 = ((1 - Math.cos(destLongitude - homeLongitude)) / 2);
        double finalHav = hav1 + (hav2 * hav3);
        double distance = 2 * EARTH_RADIUS_KM * Math.asin(Math.sqrt(finalHav)) * 100;

        int round = (int)distance;
        double distanceFin = round/100.0;

        double miles = distance * 0.621;

        int roundMiles = (int)miles;
        double distanceMiles = roundMiles/100.0;

        System.out.println("\nThe distance from your hometown to your travel destination is " + distanceFin + " km or " + distanceMiles + " miles");

        System.out.println("***********************\n\n");
    }
}
