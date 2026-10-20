
/*Step 2
Create a Java application named rental-car-calculator that estimates the cost
of reserving a rental car. Prompt the user for the following information:

Exercises – Rental Car Company
Step 3
Calculate and display:
a. basic car rental
b. options cost
c. underage driver surcharge
d. total cost
The basic car rental is $29.99 per day. There is a 30% surcharge on the basic car rental
for drivers under 25. All taxes have already been incorporated into the fees shown.
Step 4
1. Ensure all your changes are committed and pushed to GitHub
2. Send your repository URL to your Instructor
*/

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String pickupDate;
        int rentalDays;
        double electronicToll = 0;
        double GPS = 0;
        double roadsideAssistance = 0;
        int age;

        // INPUT
        System.out.print("What is the pickup date? ");
        pickupDate = sc.nextLine();

        System.out.print("How many days would you like to rent? ");
        rentalDays = sc.nextInt();

        System.out.print("Would you like an electronic toll tag for $3.95/day? (yes/no) ");
        switch (sc.next().toLowerCase(Locale.ROOT)) {
            case "yes":
                electronicToll = 3.95 * rentalDays;
                break;
            case "no":
                break;
            default:
                System.out.println("Invalid toll tag option. Please enter yes or no.");
                sc.close();
                return;
        }

        System.out.print("Would you like a GPS for $2.95/day? (yes/no) ");
        switch (sc.next().toLowerCase(Locale.ROOT)) {
            case "yes":
                GPS = 2.95 * rentalDays;
                break;
            case "no":
                break;
            default:
                System.out.println("Invalid GPS option. Please enter yes or no.");
                sc.close();
                return;
        }

        System.out.print("Would you like roadside assistance for $3.95/day? (yes/no) ");
        switch (sc.next().toLowerCase(Locale.ROOT)) {
            case "yes":
                roadsideAssistance = 3.95 * rentalDays;
                break;
            case "no":
                break;
            default:
                System.out.println("Invalid roadside assistance option. Please enter yes or no.");
                sc.close();
                return;
        }

        System.out.print("Enter your age: ");
        age = sc.nextInt();

        // CALCULATIONS
        double basicRental = calculateBasicRental(rentalDays);

        double optionsCost = calculateOptionsCost(
                electronicToll, GPS, roadsideAssistance
        );

        double surcharge = calculateUnderageSurcharge(age, basicRental);

        double totalCost = calculateTotalCost(
                basicRental, optionsCost, surcharge
        );

        // OUTPUT
        System.out.println("\n===== RENTAL CAR SUMMARY =====");
        System.out.println("Pickup Date: " + pickupDate);
        System.out.println("Rental Days: " + rentalDays);

        System.out.printf("Basic Rental: $%.2f%n", basicRental);
        System.out.printf("Options Cost: $%.2f%n", optionsCost);
        System.out.printf("Underage Driver Surcharge: $%.2f%n", surcharge);
        System.out.printf("Total Cost: $%.2f%n", totalCost);

        sc.close();
    }

    public static double calculateBasicRental(int days) {
        return days * 29.99;
    }

    public static double calculateOptionsCost( double electronicToll, double GPS, double roadsideAssistance) {
        return electronicToll + GPS + roadsideAssistance;
    }

    public static double calculateUnderageSurcharge(int age, double basicRental) {
        if (age < 25) {
            return basicRental * 0.30;
        }

        return 0;
    }

    public static double calculateTotalCost(double basicRental, double optionsCost, double surcharge) {
        return basicRental + optionsCost + surcharge;
    }
}
