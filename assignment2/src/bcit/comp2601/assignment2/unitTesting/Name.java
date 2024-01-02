package bcit.comp2601.assignment2.unitTesting;

/**
 * Class: Name
 * This class has final instance variables, constructor arguments, and accessor methods for String first and String last.
 * It has the following methods:
 * - public Name(String first, String last)
 * - public String getPrettyName()
 * - public String getInitials()
 * @author Nattanicha Nilsriphaiwan
 * @version 1.0
 */
public class Name
{
    private final String first;
    private final String last;

    private static final int FIRST_CHAR_IN_NAME;
    private static final int SECOND_CHAR_IN_NAME;

    static
    {
        FIRST_CHAR_IN_NAME  = 0;
        SECOND_CHAR_IN_NAME = 1;
    }

    /**
     * Constructors
     * @param first - String firstname
     * @param last  - String lastname
     */
    public Name(final String first,
                final String last)
    {
        validateFirstName(first);
        validateLastName(last);
        this.first = first;
        this.last = last;
    }

    /**
     * validateFirstName()
     * @param first - String firstname
     * @throws IllegalArgumentException if firstname is null or blank
     */
    private static void validateFirstName(final String first)
    {
        if(first == null || first.isBlank())
        {
            throw new IllegalArgumentException("invalid first name");
        }
    }

    /**
     * validateLastName()
     * @param last - String lastname
     * @throws IllegalArgumentException if lastname is null or blank
     */
    private static void validateLastName(final String last)
    {
        if(last == null || last.isBlank())
        {
            throw new IllegalArgumentException("invalid last name");
        }
    }

    /**
     * getFirst()
     * @return String firstname
     */
    public String getFirst()
    {
        return first;
    }

    /**
     * getLast()
     * @return String lastname
     */
    public String getLast()
    {
        return last;
    }

    /**
     * getPrettyName()
     * This method formats version of the full name; e.g. if first is "tiGEr" and last is "woODs", this method returns "Tiger Woods".
     * @return String of formatted version of full name
     */
    public String getPrettyName()
    {
        return capitalize(first) + " " + capitalize(last);
    }

    /**
     * getInitials()
     * This method creates initials of the full name; e.g. if first is "tiGEr" and last is "woODs", this method returns "T.W."
     * @return String of initials of the full name
     */
    public String getInitials()
    {
        return Character.toUpperCase(first.charAt(FIRST_CHAR_IN_NAME)) + "." + Character.toUpperCase(last.charAt(FIRST_CHAR_IN_NAME)) + ".";
    }

    /**
     * capitalize()
     * This method capitalizes the first char in the string
     * @param str - String str
     * @return String of capitalizes the first char in the string
     */
    private String capitalize(final String str)
    {
        return str.substring(FIRST_CHAR_IN_NAME, SECOND_CHAR_IN_NAME).toUpperCase() + str.substring(SECOND_CHAR_IN_NAME).toLowerCase();
    }

    /**
     * Override toString()
     * @return getPrettyName()
     */
    @Override
    public String toString()
    {
        return getPrettyName();
    }
}
