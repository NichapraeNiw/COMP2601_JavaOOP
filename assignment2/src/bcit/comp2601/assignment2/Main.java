package bcit.comp2601.assignment2;

import bcit.comp2601.assignment2.concurrency.DivideAndConquerSum;
import bcit.comp2601.assignment2.designPatterns.Tester;
import bcit.comp2601.assignment2.gui.CountryList;
import bcit.comp2601.assignment2.streamsAndFilters.CountryProcessor;

import java.util.Scanner;

/**
 * Class: Main
 * This class has methods named main() and displayMenu().
 * It shows the following screen and calls the chosen method as listed; then the menu appears again and repeat until the user types 5 to quit:
 * Type 1 for GUI                   // displays CountryList's window
 * Type 2 for Streams and Filters   // calls CountryProcessor class's processCountries() method
 * Type 3 for Design Patterns       // calls Tester class's test() method
 * Type 4 for Concurrency           // calls concurrentMain()
 * Type 5 to Quit                   // ends the program (do not call System.exit(); just end the menu loop)
 * @author Nattanicha Nilsriphaiwan
 * @version 1.0
 */
public class Main
{
    public static void main(final String[] args)
    {
        try(Scanner scanner = new Scanner(System.in))
        {
            while(true)
            {
                displayMenu();
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch(choice)
                {
                    case 1 ->
                    {
                        CountryList countryList = new CountryList();
                    }
                    case 2 ->
                    {
                        CountryProcessor countryProcessor = new CountryProcessor();
                        countryProcessor.processCountries();
                    }
                    case 3 -> Tester.test();
                    case 4 -> DivideAndConquerSum.concurrentMain();
                    case 5 ->
                    {
                        return;
                    }

                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * displayMenu()
     * show all 5 options in the main menu:
     * - type 1 for GUI
     * - type 2 for Streams and Filters
     * - type 3 for Design Patterns
     * - type 4 for Concurrency
     * - type 5 to Quit
     */
    public static void displayMenu()
    {
        System.out.println("===== Main Menu =====");
        System.out.println("Type 1 for GUI");
        System.out.println("Type 2 for Streams and Filters");
        System.out.println("Type 3 for Design Patterns");
        System.out.println("Type 4 for Concurrency");
        System.out.println("Type 5 to Quit");
        System.out.print("Enter your choice: ");
    }
}
