package bcit.comp2601.assignment2.unitTesting;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class: PersonTest
 * This test class will test all the followings below:
 *  - getters and setters (getDateOfBirth, getDateOfDeath, getName, isAlive, die)
 *  - compareTo()
 *  - ToString()
 *  - all expected exceptions that may happen in Person, Name, and Date class
 * @author Nattanicha Nilsriphaiwan.
 * @version 1.0.
 */
public class PersonTest
{
    Name name1;
    Name name2;
    Name name3;

    Date born1;
    Date born2;
    Date born3;

    Date died1;
    Date died2;
    Date died3;

    Person person1;
    Person person2;
    Person person3;

    /**
     * Called before the test.
     */
    @BeforeEach
    public void setUp()
    {
        name1 = new Name("NaTTaniCha", "nilsriPHaiwan");
        name2 = new Name("jAsOn", "WilDer");
        name3 = new Name("pABlo", "picaSSo");

        born1 = new Date(18,7,2002);
        born2 = new Date(1, 2, 1985);
        born3 = new Date(25, 10, 1881);

        died1 = null;
        died2 = null;
        died3 = new Date(8, 4, 1973);

        person1 = new Person(born1, name1);
        person2 = new Person(born2, name2);
        person3 = new Person(born3, name3);

        person1.die(died1);
        person2.die(died2);
        person3.die(died3);
    }

    /**
     * Called after the test.
     */
    @AfterEach
    public void tearDown()
    {
        person1 = null;
        person2 = null;
        person3 = null;
    }

    /**
     * Test getDateOfBirth() by checking if the return types are matched and equal.
     */
    @Test
    public void testGetDateOfBirth()
    {
        assertEquals(born1, person1.getDateOfBirth());
        assertEquals("1985-02-01", person2.getDateOfBirth().toString());
        assertEquals(born3.toString(), person3.getDateOfBirth().getYyyyMmDd());
    }

    /**
     * Test die() setter by
     * - returning null if the person is alive
     * - updated date of death if the person is dead.
     */
    @Test
    public void testDie()
    {
        // the person is alive, date of death is null
        person3.die(null);
        assertNull(person3.getDateOfDeath());

        // the person is dead, date of death is updated
        person3.die(died3);
        assertEquals(died3, person3.getDateOfDeath());
    }

    /**
     * Test GetDateOfDeath() by checking if the return types are matched and equal.
     */
    @Test
    public void testGetDateOfDeath()
    {
        assertEquals(null, person1.getDateOfDeath());
        assertNull(person2.getDateOfDeath());
        assertEquals(died3, person3.getDateOfDeath());
    }

    /**
     * Test getName() by checking if the return types are matched and equal.
     */
    @Test
    public void testGetName()
    {
        assertEquals(name1, person1.getName());
        assertEquals("Jason Wilder", person2.getName().toString());
        assertEquals(name3.toString(), person3.getName().getPrettyName());
    }

    /**
     * Test isAlive() by
     * - returning true if the person's is alive
     * - false if the person's dead.
     */
    @Test
    public void testIsAlive()
    {
        assertTrue(person1.isAlive());
        assertTrue(person2.isAlive());
        assertFalse(person3.isAlive());
    }

    /**
     * Test compareTo() by
     * - checking the different years apart from 2 people
     * - the list of people that starts from younger to older after sorted.
     * CompareTo() will return younger person.
     */
    @Test
    public void testCompareTo()
    {
        // person1 is 17 years younger than person2
        assertEquals(17 , person1.compareTo(person2));
        assertEquals(-17, person2.compareTo(person1));

        // the list of people that starts from younger to older after sorted
        List<Person> people = new ArrayList<>();
        people.add(person1);
        people.add(person2);
        people.add(person3);

        List<Person> sorted = new ArrayList<>();
        sorted.add(person3);
        sorted.add(person2);
        sorted.add(person1);

        Collections.sort(people);

        assertEquals(sorted, people);
    }

    /**
     * Test toString() by checking the expected string with the toString().
     */
    @Test
    public void testToString()
    {
        assertEquals("Nattanicha Nilsriphaiwan was born 2002-07-18 and is still alive", person1.toString());
        assertEquals("Jason Wilder was born 1985-02-01 and is still alive", person2.toString());
        assertEquals("Pablo Picasso was born 1881-10-25 and died 1973-04-08", person3.toString());
    }

    /**
     * Test getExpectedExceptionName() by
     * - get IllegalPersonException and error message (invalid name) if person's name is null
     * - get IllegalArgumentException and error message (invalid first name) if first name is null or blank
     * - get IllegalArgumentException and error message (invalid last name) if last name is null or blank
     */
    @Test
    public void getExpectedExceptionName()
    {
        // person's name is null
        IllegalPersonException exceptionPersonName = assertThrows(IllegalPersonException.class, ()->
        {
            person1 = new Person(born1, null);
        });
        assertEquals("invalid name", exceptionPersonName.getMessage());

        // first name is null
        IllegalArgumentException exceptionFirstName1 = assertThrows(IllegalArgumentException.class, ()->
        {
            name1 = new Name(null, "Nilsriphaiwan");
        });
        assertEquals("invalid first name", exceptionFirstName1.getMessage());

        // first name is blank
        IllegalArgumentException exceptionFirstName2 = assertThrows(IllegalArgumentException.class, ()->
        {
            name1 = new Name(" ", "Nilsriphaiwan");
        });
        assertEquals("invalid first name", exceptionFirstName2.getMessage());

        // last name is null
        IllegalArgumentException exceptionLastName1 = assertThrows(IllegalArgumentException.class, ()->
        {
            name1 = new Name("Nattanicha", null);
        });
        assertEquals("invalid last name", exceptionLastName1.getMessage());

        // last name is blank
        IllegalArgumentException exceptionLastName2 = assertThrows(IllegalArgumentException.class, ()->
        {
            name1 = new Name("Nattanicha", " ");
        });
        assertEquals("invalid last name", exceptionLastName2.getMessage());
    }

    /**
     * Test getExpectedExceptionDate() by
     * - get IllegalPersonException and error message (invalid date of birth) if person's date of birth is null
     * - get IllegalPersonException and error message (invalid date of death) if person's date of death is sooner or equal to date of birth
     * - get IllegalArgumentException and error message (invalid day of the month) if day is over or lower than month range
     * - get IllegalArgumentException and error message (invalid month) if month is over maximum or lower than minimum
     * - get IllegalArgumentException and error message (invalid year) if year is lower minimum
     */
    @Test
    public void getExpectedExceptionDate()
    {
        // person's date of birth is null
        IllegalPersonException exceptionPersonDateOfBirth = assertThrows(IllegalPersonException.class, ()->
        {
            person1 = new Person(null, name1);
        });
        assertEquals("invalid date of birth", exceptionPersonDateOfBirth.getMessage());

        // date of death is sooner than date of birth
        IllegalPersonException exceptionPersonDateOfDeath1 = assertThrows(IllegalPersonException.class, ()->
        {
            person1.die(born3);
        });
        assertEquals("invalid date of death", exceptionPersonDateOfDeath1.getMessage());

        // date of death is equal to date of birth
        IllegalPersonException exceptionPersonDateOfDeath2 = assertThrows(IllegalPersonException.class, ()->
        {
            person3.die(born3);
        });
        assertEquals("invalid date of death", exceptionPersonDateOfDeath2.getMessage());

        // day is over month range
        IllegalArgumentException exceptionDateDay1 = assertThrows(IllegalArgumentException.class, () ->
        {
            born1 = new Date(29, 2, 1987);
        });
        assertEquals("invalid day of the month", exceptionDateDay1.getMessage());

        // day is lower than minimum
        IllegalArgumentException exceptionDateDay2 = assertThrows(IllegalArgumentException.class, () ->
        {
            born1 = new Date(0, 2, 1987);
        });
        assertEquals("invalid day of the month", exceptionDateDay2.getMessage());

        // month is over maximum
        IllegalArgumentException exceptionDateDay3 = assertThrows(IllegalArgumentException.class, () ->
        {
           born1 = new Date(15, 13, 1987);
        });
        assertEquals("invalid month", exceptionDateDay3.getMessage());

        // month is lower than minimum
        IllegalArgumentException exceptionDateDay4 = assertThrows(IllegalArgumentException.class, () ->
        {
            born1 = new Date(15, 0, 1987);
        });
        assertEquals("invalid month", exceptionDateDay4.getMessage());

        // year is lower than minimum
        IllegalArgumentException exceptionDateDay5 = assertThrows(IllegalArgumentException.class, () ->
        {
            born1 = new Date(15, 2, 0);
        });
        assertEquals("invalid year", exceptionDateDay5.getMessage());
    }
}