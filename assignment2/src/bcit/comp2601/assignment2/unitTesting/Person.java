package bcit.comp2601.assignment2.unitTesting;

/**
 * Class: Person implements Comparable<Person>
 * This class has instance variables and accessor methods for Date born, Date died, and Name name.
 * It has the following methods:
 * - public Person (Date born, Name name).
 * - public void die(Date dateOfDeath).
 * - public boolean isAlive(): this method returns true if the Person is alive; otherwise returns false.
 * - public int compareTo(Person p): this method satisfies the requirements from implementing the Comparable
 * interface. Younger people are "larger". Note: this method must use its born variable's compareTo(Date d) method.
 * - This class overrides the public String toString() method, which returns a String in one of these two exact formats:
 * a) Alive people example: "Tiger Woods was born 1975-12-30 and is still alive"
 * b) Dead people example: "Albert Einstein was born 1879-03-14 and died 1955-04-18"
 * Use the name variable's getPrettyName() method, and the born/died getYyyyMmDd() method.
 * @author Nattanicha Nilsriphaiwan
 * @version 1.0
 */
public class Person implements Comparable<Person>
{
    private final Date born;
    private Date died;
    private final Name name;

    /**
     * Constructors
     * @param born - Date date of birth
     * @param name - Name name
     * @throws IllegalPersonException if either born or name is null
     */
    public Person(final Date born,
                  final Name name)
            throws IllegalPersonException
    {
        validatePerson(born, name);
        this.born = born;
        this.name = name;
    }

    /**
     * validatePerson()
     * @param born - Date date of birth
     * @param name - Name name
     * @throws IllegalPersonException if either born or name is null
     */
    private static void validatePerson(final Date born,
                                       final Name name)
            throws IllegalPersonException
    {
        if(name == null)
        {
            throw new IllegalPersonException("invalid name");
        }
        else if(born == null)
        {
            throw new IllegalPersonException("invalid date of birth");
        }
    }

    private static void validateDateOfDeath(final Date died,
                                            final Date born)
            throws IllegalPersonException
    {
        if(died != null && died.compareTo(born) <= born.compareTo(died))
        {
            throw new IllegalPersonException("invalid date of death");
        }
    }

    /**
     * getDateOfBirth()
     * @return Date of date of birth
     */
    public Date getDateOfBirth()
    {
        return born;
    }

    /**
     * getDateOfDeath()
     * @return Date of date of death
     */
    public Date getDateOfDeath()
    {
        return died;
    }

    /**
     * getName()
     * @return Name name
     */
    public Name getName()
    {
        return name;
    }

    /**
     * die()
     * this method sets the died instance variable to the dateOfDeath provided.
     * @param dateOfDeath Date of dateOfDeath
     */
    public void die(final Date dateOfDeath)
            throws IllegalPersonException
    {
        validateDateOfDeath(dateOfDeath, born);
        died = dateOfDeath;
    }

    public boolean isAlive()
    {
        return died == null;
    }

    /**
     * override compareTo()
     * Younger people are "larger"
     * @param otherPerson the object to be compared.
     * @return Younger Person
     */
    @Override
    public int compareTo(final Person otherPerson)
    {
        return born.compareTo(otherPerson.born);
    }

    /**
     * override toString()
     * This method uses getPrettyName() and the born/died getYyyyMmDd().
     * This method returns a String in one of these two exact formats:
     *      a) Alive people example: "Tiger Woods was born 1975-12-30 and is still alive"
     *      b) Dead people example: "Albert Einstein was born 1879-03-14 and died 1955-04-18"
     * @return formatted String
     */
    @Override
    public String toString()
    {
        StringBuilder stringFormat = new StringBuilder();
        stringFormat.append(name.getPrettyName()).append(" was born ").append(born.getYyyyMmDd());
        if(isAlive())
        {
            stringFormat.append(" and is still alive");
        }
        else
        {
            stringFormat.append(" and died ").append(died.getYyyyMmDd());
        }
        return stringFormat.toString();
    }
}
