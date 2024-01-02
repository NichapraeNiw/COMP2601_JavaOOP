package bcit.comp2601.assignment2.unitTesting;

/**
 * Class: IllegalPersonException extends RuntimeException
 * It satisfies its parent's constructor and does nothing else.
 * @author Nattanicha Nilsriphaiwan
 * @version 1.0
 */
public class IllegalPersonException extends RuntimeException
{
    public IllegalPersonException(final String message)
    {
        super(message);
    }
}
