package bcit.comp2601.assignment2.designPatterns;

import bcit.comp2601.assignment2.designPatterns.adapter.*;
import bcit.comp2601.assignment2.designPatterns.command.TextFile;
import bcit.comp2601.assignment2.designPatterns.command.TextFileOperationExecutor;
import bcit.comp2601.assignment2.designPatterns.observer.NewsAgency;
import bcit.comp2601.assignment2.designPatterns.observer.NewsChannel;
import bcit.comp2601.assignment2.designPatterns.singleton.PrimeMinister;

import java.util.Scanner;

/**
 * Class: Tester
 * This class has methods named test() and displayTesterMenu().
 * a) Singleton
 *  - Tester.test() method must try to create four PrimeMinister objects, yet the Singleton will create only one; the others will simply be references to the first.
 *  - Tester.test() must print all four objects to show they all actually reside at the same memory address.
 * b) Adapter (<a href="https://web.archive.org/web/20220525012446/https://www.baeldung.com/java-adapter-pattern">...</a>)
 *  - Tester.test() method will show that your BugattiVeyron converts MPH to KMPH by calling its getSpeed() method.
 *  - The getSpeed() will return it's within 0.00001 of 431.30312 KMPH when its speed is set to 268 MPH.
 * c) Command (<a href="https://www.baeldung.com/java-command-pattern">...</a>)
 *  - Tester.test() will run the code listed on this website's main() method.
 * d) Observer (<a href="https://www.baeldung.com/java-observer-pattern">...</a>)
 *  - Tester.test() will run the code at the end of step 2 in the website.
 * @author Nattanicha Nilsriphaiwan
 * @version 1.0
 */
public class Tester
{
    public static void test()
    {
        Scanner scanner = new Scanner(System.in);

        while(true)
        {
            displayTesterMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice)
            {
                case 1 ->
                {
                    PrimeMinister pm1 = PrimeMinister.getInstance();
                    PrimeMinister pm2 = PrimeMinister.getInstance();
                    PrimeMinister pm3 = PrimeMinister.getInstance();
                    PrimeMinister pm4 = PrimeMinister.getInstance();

                    System.out.println(pm1);
                    System.out.println(pm2);
                    System.out.println(pm3);
                    System.out.println(pm4);
                }
                case 2 ->
                {
                    Movable bugattiVeyron = new BugattiVeyron();
                    MovableAdapter bugattiVeyronAdapter = new MovableAdapterImpl(bugattiVeyron);

                    System.out.println(bugattiVeyronAdapter.getSpeed() + " KMPH");
                }
                case 3 ->
                {
                    TextFileOperationExecutor textFileOperationExecutor = new TextFileOperationExecutor();
                    TextFile textFile = new TextFile("file1.txt");
                    textFileOperationExecutor.executeOperation(textFile::open);
                    System.out.println("file1.txt has been opened");
                    textFileOperationExecutor.executeOperation(textFile::save);
                    System.out.println("file1.txt has been saved");
                }
                case 4 ->
                {
                    NewsAgency observable = new NewsAgency();
                    NewsChannel observer = new NewsChannel();

                    observable.addObserver(observer);
                    observable.setNews("news");
                    System.out.println("Observer's new is " + observer.getNews());
                }
                case 5 ->
                {
                    return;
                }

                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * displayTesterMenu()
     * show all 5 options in the main menu:
     * - Type 1 for Singleton
     * - Type 2 for Adapter
     * - Type 3 for Command
     * - Type 4 for Observer
     * - Type 5 for Main Menu
     */
    public static void displayTesterMenu()
    {
        System.out.println("===== Design Patterns =====");
        System.out.println("Type 1 for Singleton");
        System.out.println("Type 2 for Adapter");
        System.out.println("Type 3 for Command");
        System.out.println("Type 4 for Observer");
        System.out.println("Type 5 for Main Menu");
        System.out.print("Enter your choice: ");
    }
}
