package bcit.comp2601.assignment2.unitTesting;

/**
 * Class: Date implements Orderable, Comparable<Date>
 * This class has final instance variables, constructor arguments, and accessor methods for int day, int month, and int year.
 * It has the following methods:
 *  - public Date(int day, int month, int year)
 *  - public String getYyyyMmDd()
 *  - This class overrides the public String toString() method
 *  - public Date previous() and public Date next()
 *  - public int compareTo(Date d)
 *  - public String getDayOfTheWeek()
 *  - private int getNumberOfDaysPerMonth(int month, int year)
 *  - private boolean isLeapYear()
 * @author Nattanicha Nilsriphaiwan
 * @version 1.0
 */
public class Date implements Orderable, Comparable<Date>
{
    private final int day;
    private final int month;
    private final int year;

    private static final int CENTURY;
    private static final int TWELVE;
    private static final int FOUR;
    private static final int YEARS_SIXTEEN_PREFIX_START;    // for years in 1600-1699
    private static final int YEARS_SEVENTEEN_PREFIX_START;  // for years in 1700-1799
    private static final int YEARS_EIGHTEEN_PREFIX_START;   // for years in 1800-1899
    private static final int YEARS_TWENTY_PREFIX_START;     // for years in 1900-1999
    private static final int YEARS_TWENTY_ONE_PREFIX_START; // for years in 2100-2199
    private static final int SPECIAL_OFFSETS_SIX;
    private static final int SPECIAL_OFFSETS_FOUR;
    private static final int SPECIAL_OFFSETS_TWO;
    private static final int DAYS_IN_A_WEEK;

    private static final int JANUARY;
    private static final int FEBRUARY;
    private static final int MARCH;
    private static final int APRIL;
    private static final int MAY;
    private static final int JUNE;
    private static final int JULY;
    private static final int AUGUST;
    private static final int SEPTEMBER;
    private static final int OCTOBER;
    private static final int NOVEMBER;
    private static final int DECEMBER;

    private static final int SATURDAY_CODE;
    private static final int SUNDAY_CODE;
    private static final int MONDAY_CODE;
    private static final int TUESDAY_CODE;
    private static final int WEDNESDAY_CODE;
    private static final int THURSDAY_CODE;
    private static final int FRIDAY_CODE;

    private static final int MONTH_CODE_ZERO;
    private static final int MONTH_CODE_ONE;
    private static final int MONTH_CODE_TWO;
    private static final int MONTH_CODE_THREE;
    private static final int MONTH_CODE_fOUR;
    private static final int MONTH_CODE_FIVE;
    private static final int MONTH_CODE_SIX;

    private static final int FOUR_HUNDRED;
    private static final int ZERO;
    private static final int HUNDRED;

    private static final int NEXT_ONE_DAY;
    private static final int PREVIOUS_ONE_DAY;
    private static final int FIRST_DAY_IN_MONTH;

    private static final int DAYS_IN_JANUARY;
    private static final int DAYS_IN_FEBRUARY;
    private static final int DAYS_IN_FEBRUARY_IN_LEAP_YEAR;
    private static final int DAYS_IN_MARCH;
    private static final int DAYS_IN_APRIL;
    private static final int DAYS_IN_MAY;
    private static final int DAYS_IN_JUNE;
    private static final int DAYS_IN_JULY;
    private static final int DAYS_IN_AUGUST;
    private static final int DAYS_IN_SEPTEMBER;
    private static final int DAYS_IN_OCTOBER;
    private static final int DAYS_IN_NOVEMBER;
    private static final int DAYS_IN_DECEMBER;
    private static final int PREVIOUS_ONE_INDEX;

    private static final int MINIMUM_DAY;
    private static final int MAXIMUM_DAY;
    private static final int MINIMUM_MONTH;
    private static final int MAXIMUM_MONTH;
    private static final int MINIMUM_YEAR;

    static
    {
        CENTURY = 100;
        TWELVE  = 12;
        FOUR    = 4;

        YEARS_SIXTEEN_PREFIX_START    = 16;
        YEARS_SEVENTEEN_PREFIX_START  = 17;
        YEARS_EIGHTEEN_PREFIX_START   = 18;
        YEARS_TWENTY_PREFIX_START     = 20;
        YEARS_TWENTY_ONE_PREFIX_START = 21;

        SPECIAL_OFFSETS_SIX  = 6;
        SPECIAL_OFFSETS_FOUR = 4;
        SPECIAL_OFFSETS_TWO  = 2;
        DAYS_IN_A_WEEK       = 7;

        JANUARY   = 1;
        FEBRUARY  = 2;
        MARCH     = 3;
        APRIL     = 4;
        MAY       = 5;
        JUNE      = 6;
        JULY      = 7;
        AUGUST    = 8;
        SEPTEMBER = 9;
        OCTOBER   = 10;
        NOVEMBER  = 11;
        DECEMBER  = 12;

        SATURDAY_CODE  = 0;
        SUNDAY_CODE    = 1;
        MONDAY_CODE    = 2;
        TUESDAY_CODE   = 3;
        WEDNESDAY_CODE = 4;
        THURSDAY_CODE  = 5;
        FRIDAY_CODE    = 6;

        MONTH_CODE_ZERO  = 0;
        MONTH_CODE_ONE   = 1;
        MONTH_CODE_TWO   = 2;
        MONTH_CODE_THREE = 3;
        MONTH_CODE_fOUR  = 4;
        MONTH_CODE_FIVE  = 5;
        MONTH_CODE_SIX   = 6;

        FOUR_HUNDRED = 400;
        HUNDRED      = 100;
        ZERO         = 0;

        NEXT_ONE_DAY       = 1;
        PREVIOUS_ONE_DAY   = 1;
        FIRST_DAY_IN_MONTH = 1;

        DAYS_IN_JANUARY  = 31;
        DAYS_IN_FEBRUARY = 28;
        DAYS_IN_FEBRUARY_IN_LEAP_YEAR = 29;
        DAYS_IN_MARCH = 31;
        DAYS_IN_APRIL = 30;
        DAYS_IN_MAY   = 31;
        DAYS_IN_JUNE  = 30;
        DAYS_IN_JULY  = 31;
        DAYS_IN_AUGUST     = 31;
        DAYS_IN_SEPTEMBER  = 30;
        DAYS_IN_OCTOBER    = 31;
        DAYS_IN_NOVEMBER   = 30;
        DAYS_IN_DECEMBER   = 31;
        PREVIOUS_ONE_INDEX = 1;

        MINIMUM_DAY   = 1;
        MAXIMUM_DAY   = 31;
        MINIMUM_MONTH = 1;
        MAXIMUM_MONTH = 12;
        MINIMUM_YEAR  = 1;
    }

    /**
     * Constructors
     * @param day   - inr day   (1 - 31)
     * @param month - int month (1 - 12)
     * @param year  - int year  (year > 1)
     */
    public Date(final int day,
                final int month,
                final int year)
    {
        validateDay(day, month, year);
        validateMonth(month);
        validateYear(year);
        this.day   = day;
        this.month = month;
        this.year  = year;
    }

    /**
     * getDay()
     * @return int day
     */
    public int getDay()
    {
        return day;
    }

    /**
     * getMonth()
     * @return int month
     */
    public int getMonth()
    {
        return month;
    }

    /**
     * getYear()
     * @return int year
     */
    public int getYear()
    {
        return year;
    }

    /**
     * getYyyyMmDd()
     * @return returns a String representation of the Date in "yyyy-mm-dd" format
     */
    public String getYyyyMmDd()
    {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    /**
     * Override toString()
     * @return getYyyyMmDd()
     */
    @Override
    public String toString()
    {
        return getYyyyMmDd();
    }

    /**
     * previous()
     * If the current date were January 1, 2000, then previous() must return December 31, 1999
     * @return Date of the previous one day
     */
    @Override
    public Date previous()
    {
        int previousDay   = day - PREVIOUS_ONE_DAY;
        int previousMonth = month;
        int previousYear  = year;

        if(previousDay < FIRST_DAY_IN_MONTH)
        {
            previousMonth--;
            if(previousMonth < JANUARY)
            {
                previousYear--;
                previousMonth = DECEMBER;
            }
            previousDay = getNumberOfDaysPerMonth(previousMonth, previousYear);
        }

        return new Date(previousDay, previousMonth, previousYear);
    }

    /**
     * next()
     * If the current date were January 1, 2000, then next() must return January 2, 2000
     * @return Date of the previous one day
     */
    @Override
    public Date next()
    {
        int nextDay   = day + NEXT_ONE_DAY;
        int nextMonth = month;
        int nextYear  = year;

        if(nextDay > getNumberOfDaysPerMonth(nextMonth, nextYear))
        {
            nextDay = FIRST_DAY_IN_MONTH;
            nextMonth++;
            if(nextMonth > DECEMBER)
            {
                nextMonth = JANUARY;
                nextYear++;
            }
        }

        return new Date(nextDay, nextMonth, nextYear);
    }

    /**
     * override compareTo()
     * This method satisfies the requirements from implementing the Comparable interface.
     * Later dates are "larger".
     * @param otherDate - the object to be compared.
     * @return later Date
     */
    @Override
    public int compareTo(final Date otherDate)
    {
        validateDay(otherDate.getDay(), otherDate.getMonth(), otherDate.getYear());
        validateMonth(otherDate.getMonth());
        validateYear(otherDate.getYear());
        if(year != otherDate.year)
        {
            return year - otherDate.year;
        }
        else if(month != otherDate.month)
        {
            return month - otherDate.month;
        }
        else
        {
            return day - otherDate.day;
        }
    }

    /**
     * getDayOfTheWeek()
     * This method determines and returns the day of the week for a given date.
     * This method uses isLeapYear(), getDayOfWeekFromDayCode(), and getCodeForMonth().
     * Here is the algorithm of this method:
     *      step1: Only look at the last two digits of the year and determine how many twelves fit in it.
     *      step2: Determine the remainder of step 1's result.
     *      step3: Determine how many fours fit into the remainder (step 2's result).
     *      step4: Add the day of the month.
     *      step5: Add the month code from getCodeForMonth().
     *      step6: Add all of the above highlighted numbers, and then mod by 7.
     *      Finally, step6 will return a day code to find the day of week in getDayOfWeekFromDayCode().
     * NOTE: some dates require special offsets to add after step 5:
     * January and February dates in leap years: add 6 to step 5 (use isLeapYear())
     * All dates in the 1600s: add 6 to step 5
     * All dates in the 1700s: add 4 to step 5
     * All dates in the 1800s: add 2 to step 5
     * All dates in the 2000s: add 6 to step 5
     * All dates in the 2100s: add 4 to step 5
     * @return getDayOfWeekFromDayCode()
     */
    public String getDayOfTheWeek()
    {
        int step1;
        int step2;
        int step3;
        int step4;
        int step5;
        int step6;
        int dayCode;

        int firstTwoDigitsOfYear = year / CENTURY;
        int lastTwoDigitsOfYear  = year % CENTURY;

        step1 = (lastTwoDigitsOfYear) / TWELVE;
        step2 = (lastTwoDigitsOfYear) % TWELVE;
        step3 = step2 / FOUR;
        step4 = day;
        step5 = getCodeForMonth(month);
        step6 = step1 + step2 + step3 + step4 + step5;

        if(isLeapYear(year) && month == JANUARY || month == FEBRUARY)
        {
            step6 += SPECIAL_OFFSETS_SIX;

        }

        if(firstTwoDigitsOfYear == YEARS_SEVENTEEN_PREFIX_START ||
                firstTwoDigitsOfYear == YEARS_TWENTY_ONE_PREFIX_START)
        {
            step6 += SPECIAL_OFFSETS_FOUR;
        }
        else if(firstTwoDigitsOfYear == YEARS_EIGHTEEN_PREFIX_START)
        {
            step6 += SPECIAL_OFFSETS_TWO;
        }
        else if(firstTwoDigitsOfYear == YEARS_SIXTEEN_PREFIX_START ||
                firstTwoDigitsOfYear == YEARS_TWENTY_PREFIX_START)
        {
            step6 += SPECIAL_OFFSETS_SIX;
        }

        dayCode = step6 % DAYS_IN_A_WEEK;
        return getDayOfWeekFromDayCode(dayCode);
    }

    /**
     * getDayOfWeekFromDayCode()
     * @param dayCode - the day code we get from getDayOfTheWeek()
     * @return String day of week
     */
    private String getDayOfWeekFromDayCode(final int dayCode)
    {
        if(dayCode == SATURDAY_CODE)
        {
            return "Saturday";
        }
        else if(dayCode == SUNDAY_CODE)
        {
            return "Sunday";
        }
        else if(dayCode == MONDAY_CODE)
        {
            return "Monday";
        }
        else if(dayCode == TUESDAY_CODE)
        {
            return "Tuesday";
        }
        else if(dayCode == WEDNESDAY_CODE)
        {
            return "Wednesday";
        }
        else if(dayCode == THURSDAY_CODE)
        {
            return "Thursday";
        }
        else if(dayCode == FRIDAY_CODE)
        {
            return "Friday";
        }
        else
        {
            return "No day of week was found.";
        }
    }

    /**
     * getCodeForMonth()
     * @param month - int month
     * @return int monthCode from the input month
     */
    private int getCodeForMonth(final int month)
    {
        if(month == JANUARY || month == OCTOBER)
        {
            return MONTH_CODE_ONE;
        }
        else if(month == MAY)
        {
            return MONTH_CODE_TWO;
        }
        else if(month == AUGUST)
        {
            return MONTH_CODE_THREE;
        }
        else if(month == FEBRUARY || month == MARCH || month == NOVEMBER)
        {
            return MONTH_CODE_fOUR;
        }
        else if(month == JUNE)
        {
            return MONTH_CODE_FIVE;
        }
        else if(month == SEPTEMBER || month == DECEMBER)
        {
            return MONTH_CODE_SIX;
        }
        else
        {
            return MONTH_CODE_ZERO;
        }
    }

    /**
     * isLeapYear()
     * @param year - int year
     * @return true if leap year; otherwise, false
     */
    private boolean isLeapYear(final int year)
    {
        return (year % FOUR == ZERO && year % HUNDRED != ZERO) || (year % FOUR_HUNDRED == ZERO);
    }

    /**
     * getNumberOfDaysPerMonth()
     * @param month - int month
     * @param year  - int year
     * @return int number of days in the month
     */
    private int getNumberOfDaysPerMonth(final int month,
                                        final int year)
    {
        int[] daysPerMonth = {DAYS_IN_JANUARY, isLeapYear(year) ? DAYS_IN_FEBRUARY_IN_LEAP_YEAR : DAYS_IN_FEBRUARY,
                              DAYS_IN_MARCH, DAYS_IN_APRIL, DAYS_IN_MAY, DAYS_IN_JUNE, DAYS_IN_JULY, DAYS_IN_AUGUST,
                              DAYS_IN_SEPTEMBER, DAYS_IN_OCTOBER, DAYS_IN_NOVEMBER, DAYS_IN_DECEMBER};
        return daysPerMonth[month - PREVIOUS_ONE_INDEX];
    }

    /**
     * validateDay()
     * Day must be integer of 1 - 31
     * Day must match the current month and year (e.g. February in leap year has 29 days, and February in normal year has 30 days)
     * @param day   - int day
     * @param month - int month
     * @param year  - int year
     * @throws IllegalArgumentException if day is invalid
     */
    private static void validateDay(final int day,
                                    final int month,
                                    final int year)
    {
        validateYear(year);
        validateMonth(month);
        boolean isLeapYear;
        isLeapYear = (year % FOUR == ZERO && year % HUNDRED != ZERO) || (year % FOUR_HUNDRED == ZERO);

        int[] daysPerMonth;
        int   daysInTheMonth;

        daysPerMonth = new int[]{DAYS_IN_JANUARY, isLeapYear ? DAYS_IN_FEBRUARY_IN_LEAP_YEAR : DAYS_IN_FEBRUARY,
                                 DAYS_IN_MARCH, DAYS_IN_APRIL, DAYS_IN_MAY, DAYS_IN_JUNE, DAYS_IN_JULY, DAYS_IN_AUGUST,
                                 DAYS_IN_SEPTEMBER, DAYS_IN_OCTOBER, DAYS_IN_NOVEMBER, DAYS_IN_DECEMBER};
        daysInTheMonth = daysPerMonth[month - PREVIOUS_ONE_INDEX];

        if(day < MINIMUM_DAY || day > MAXIMUM_DAY || day > daysInTheMonth) // min day, max day
        {
            throw new IllegalArgumentException("invalid day of the month");
        }
    }

    /**
     * validateMonth()
     * Month must be integer of 1 - 12
     * @param month - int month
     * @throws IllegalArgumentException if month is invalid
     */
    private static void validateMonth(final int month)
    {
        if(month < MINIMUM_MONTH || month > MAXIMUM_MONTH)
        {
            throw new IllegalArgumentException("invalid month");
        }
    }

    /**
     * validateYear()
     * Year must be more than 1
     * @param year - int year
     */
    private static void validateYear(final int year)
    {
        if(year < MINIMUM_YEAR)
        {
            throw new IllegalArgumentException("invalid year");
        }
    }
}
