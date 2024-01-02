package bcit.comp2601.assignment2.designPatterns.singleton;

/**
 * Class: PrimeMinister
 * a) Singleton
 * 1. There can only be one Prime Minister object at a time, so it must implement the Singleton design pattern.
 * 2. The Tester.test() method must try to create four PrimeMinister objects, yet the Singleton will create only one; the others will simply be references to the first.
 * 3. Tester.test() must print all four objects to show they all actually reside at the same memory address.
 * @author Nattanicha Nilsriphaiwan
 * @version 1.0
 */
public class PrimeMinister
{
    private static PrimeMinister instance;

    // Private constructor to prevent instantiation from outside the class
    private PrimeMinister() {}

    public static PrimeMinister getInstance()
    {
        if (instance == null)
        {
            instance = new PrimeMinister();
        }
        return instance;
    }
}
