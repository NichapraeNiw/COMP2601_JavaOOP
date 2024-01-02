package bcit.comp2601.assignment2.streamsAndFilters;

import bcit.comp2601.assignment2.gui.CountryList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Class: CountryProcessor
 * This class has methods named processCountries() and displayCountryProcessorMenu().
 * Use the data from the countries-and-capitals.txt file.
 * Create a HashMap instance variable with country name as key, and its capital city name as value (e.g. "Canada": "Ottawa").
 * Use streams and filters to create the following functions which do exactly what they say.
 * In all cases, before printing, collect the result into a java collection or local variable (e.g. List, String, Integer, etc…):
 *  1. printLongestCapitalCity()
 *  2. printShortestCountryName()
 *  3. printAllCountriesStartingWith(String substring)
 *  4. printLongestCombination()            // longest combination of country name plus capital city name
 *  5. printHowManyCharactersInCountries()  // total number of characters in all the country names put together
 *  6. printCapitalsWithThisManyLetters(int min, int max) // e.g. all capitals between 5 and 8 letters inclusive
 *  7. printAllCountriesThatDoNotEndWith(char letter)
 *  8. printAllCountriesThatContainLetterIntoASingleStringNoSpaces(char letter) // e.g. containing 'a': "CanadaChadArgentinaNewZealandAustralia…"
 * This class has static variables which are:
 *  - LENGTH_WITH_COUNTRY_AND_CAPITAL = 2
 *  - FIRST_LETTER = 0
 * @author Nattanicha Nilsriphaiwan
 * @version 1.0
 */
public class CountryProcessor
{
    private final Map<String, String> countryCapitalMap;

    private static final int LENGTH_WITH_COUNTRY_AND_CAPITAL;
    private static final int FIRST_LETTER;

    static
    {
        LENGTH_WITH_COUNTRY_AND_CAPITAL = 2;
        FIRST_LETTER = 0;
    }

    public CountryProcessor()
    {
        countryCapitalMap = new HashMap<>();
    }

    /**
     * processCountries()
     * Calls all 9 of the following functions:
     * 1. printLongestCapitalCity()
     * 2. printShortestCountryName()
     * 3. printAllCountriesStartingWith(String substring)
     * 4. printLongestCombination()
     * 5. printHowManyCharactersInCountries()
     * 6. printCapitalsWithThisManyLetters(int min, int max)
     * 7. printAllCountriesThatDoNotEndWith(char letter)
     * 8. printAllCountriesThatContainLetterIntoASingleStringNoSpaces(char letter)
     * 9. Main menu
     */
    public void processCountries()
    {
        readCountryDataFromFile();
        Scanner scanner = new Scanner(System.in);

        while(true)
        {
            displayCountryProcessorMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice)
            {
                case 1 -> printLongestCapitalCity();
                case 2 -> printShortestCountryName();
                case 3 ->
                {
                    System.out.print("Enter substring to search for countries starting with: ");
                    String substring = new Scanner(System.in).nextLine();
                    printAllCountriesStartingWith(substring);
                }
                case 4 -> printLongestCombination();
                case 5 -> printHowManyCharactersInCountries();
                case 6 ->
                {
                    int min, max;
                    do
                    {
                        System.out.print("Enter minimum number of letters: ");
                        min = new Scanner(System.in).nextInt();
                        System.out.print("Enter maximum number of letters: ");
                        max = new Scanner(System.in).nextInt();

                        if(min > max)
                        {
                            System.out.println("Warning: minimum number should lower than maximum number.");
                        }
                    }
                    while(min > max);

                    printCapitalsWithThisManyLetters(min, max);
                }
                case 7 ->
                {
                    System.out.print("Enter a letter to exclude countries ending with: ");
                    char letter = new Scanner(System.in).nextLine().charAt(FIRST_LETTER);
                    printAllCountriesThatDoNotEndWith(letter);
                }
                case 8 ->
                {
                    System.out.print("Enter a letter to search for countries (joined without spaces): ");
                    char searchLetter = new Scanner(System.in).nextLine().charAt(FIRST_LETTER);
                    printAllCountriesThatContainLetterIntoASingleStringNoSpaces(searchLetter);
                }
                case 9 ->
                {
                    return;
                }

                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * displayCountryProcessorMenu()
     * show all 9 options in the main menu:
     * - Type 1 for printLongestCapitalCity()"
     * - Type 2 for printShortestCountryName()"
     * - Type 3 for printAllCountriesStartingWith(String substring)"
     * - Type 4 for printLongestCombination()"
     * - Type 5 for printHowManyCharactersInCountries()"
     * - Type 6 for printCapitalsWithThisManyLetters(int min, int max)"
     * - Type 7 for printAllCountriesThatDoNotEndWith(char letter)"
     * - Type 8 for printAllCountriesThatContainLetterIntoASingleStringNoSpaces(char letter)
     * - Type 9 for Main Menu
     */
    public static void displayCountryProcessorMenu()
    {
        System.out.println("===== Country Processor =====");
        System.out.println("Type 1 for printLongestCapitalCity()");
        System.out.println("Type 2 for printShortestCountryName()");
        System.out.println("Type 3 for printAllCountriesStartingWith(String substring)");
        System.out.println("Type 4 for printLongestCombination()");
        System.out.println("Type 5 for printHowManyCharactersInCountries()");
        System.out.println("Type 6 for printCapitalsWithThisManyLetters(int min, int max)");
        System.out.println("Type 7 for printAllCountriesThatDoNotEndWith(char letter)");
        System.out.println("Type 8 for printAllCountriesThatContainLetterIntoASingleStringNoSpaces(char letter)");
        System.out.println("Type 9 for Main Menu");
        System.out.print("Enter your choice: ");
    }

    /**
     * readCountryDataFromFile()
     * Use the data from the countries-and-capitals.txt file.
     * Create a HashMap instance variable with country name as key, and its capital city name as value (e.g. "Canada": "Ottawa").
     */
    private void readCountryDataFromFile()
    {
        try(BufferedReader reader = new BufferedReader(new FileReader("countries-and-capitals.txt")))
        {
            String line;
            while((line = reader.readLine()) != null)
            {
                String[] parts = line.split(",");
                if(parts.length == LENGTH_WITH_COUNTRY_AND_CAPITAL)
                {
                    String country = parts[CountryList.COUNTRY_INDEX];
                    String capital = parts[CountryList.CAPITAL_INDEX];
                    countryCapitalMap.put(country, capital);
                }
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * printLongestCapitalCity()
     */
    private void printLongestCapitalCity()
    {
        String longestCapitalCity = countryCapitalMap.values()
                .stream()
                .max(Comparator.comparingInt(String::length))
                .orElse("");
        System.out.println("Longest Capital City: " + longestCapitalCity);
    }

    /**
     * printShortestCountryName()
     */
    private void printShortestCountryName()
    {
        String shortestCountryName = countryCapitalMap.keySet()
                .stream()
                .min(Comparator.comparingInt(String::length))
                .orElse("");
        System.out.println("Shortest Country Name: " + shortestCountryName);
    }

    /**
     * printAllCountriesStartingWith(String substring)
     * @param substring - String substring
     */
    private void printAllCountriesStartingWith(final String substring)
    {
        List<String> countriesStartingWith = countryCapitalMap.keySet()
                .stream()
                .filter(country -> country.toLowerCase().startsWith(substring.toLowerCase()))
                .toList();

        countriesStartingWith.stream()
                .findFirst()
                .ifPresentOrElse
                        (
                                country -> System.out.println("Countries starting with '" + substring + "': " + countriesStartingWith),
                                () -> System.out.println("Not found")
                        );
    }

    /**
     * printLongestCombination()
     * The longest combination of country name plus capital city name.
     */
    private void printLongestCombination()
    {
        String longestCombination = countryCapitalMap.entrySet()
                .stream()
                .map(entry -> entry.getKey() + entry.getValue())
                .max(Comparator.comparingInt(String::length))
                .orElse("");
        System.out.println("Longest Combination: " + longestCombination);
    }

    /**
     * printHowManyCharactersInCountries()
     * Total number of characters in all the country names put together.
     */
    private void printHowManyCharactersInCountries()
    {
        int totalCharacters = countryCapitalMap.keySet()
                .stream()
                .mapToInt(String::length)
                .sum();
        System.out.println("Total number of characters in all country names: " + totalCharacters);
    }

    /**
     * printCapitalsWithThisManyLetters(int min, int max)
     * For example, all capitals between 5 and 8 letters inclusive.
     * @param min - integer minimum amount of letters
     * @param max - integer maximum amount of letters
     */
    private void printCapitalsWithThisManyLetters(final int min, final int max)
    {
        List<String> capitalsInRange = countryCapitalMap.values()
                .stream()
                .filter(capital -> capital.length() >= min && capital.length() <= max)
                .toList();

        capitalsInRange.stream()
                .findFirst()
                .ifPresentOrElse
                        (
                                capital -> System.out.println("Capitals with " + min + " to " + max + " letters: " + capitalsInRange),
                                () -> System.out.println("Not found")
                        );
    }

    /**
     * printAllCountriesThatDoNotEndWith(char letter)
     * @param letter - char of a letter
     */
    private void printAllCountriesThatDoNotEndWith(final char letter)
    {
        List<String> countriesNotEndingWith = countryCapitalMap.keySet()
                .stream()
                .filter(country -> !country.toLowerCase().endsWith(String.valueOf(Character.toLowerCase(letter))))
                .toList();
        System.out.println("Countries not ending with '" + letter + "': " + countriesNotEndingWith);
    }

    /**
     * printAllCountriesThatContainLetterIntoASingleStringNoSpaces(char letter)
     * For example, containing 'a': "CanadaChadArgentinaNewZealandAustralia…".
     * @param letter - char of a letter
     */
    private void printAllCountriesThatContainLetterIntoASingleStringNoSpaces(final char letter)
    {
        String countriesWithLetter = countryCapitalMap.keySet()
                .stream()
                .filter(country -> country.toLowerCase().contains(String.valueOf(Character.toLowerCase(letter))))
                .map(country -> country.replaceAll("\\s+", ""))
                .collect(Collectors.joining());
        System.out.println("Countries containing '" + letter + "': " + countriesWithLetter);
    }
}
