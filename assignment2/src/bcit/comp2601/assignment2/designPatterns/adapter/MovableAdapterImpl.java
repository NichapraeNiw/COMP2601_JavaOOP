package bcit.comp2601.assignment2.designPatterns.adapter;

/**
 * Class: MovableAdapterImpl implements MovableAdapter
 * b) Adapter
 *  1. We'll create the original interface Movable which is supposed to return the speed of some luxury cars in miles per hour.
 *  2. We'll now create one concrete implementation of this interface.
 *  3. Now we'll create an adapter interface MovableAdapter that will be based on the same Movable class.
 *     It may be slightly modified to yield different results in different scenarios
 *  4. The implementation of this interface will consist of a private method convertMPHtoKMPH() that will be used for the conversion.
 *  5. we'll only use the methods defined in our Adapter, and we'll get the converted speeds
 *     that shows it's within 0.00001 of 431.30312 KMPH when its speed is set to 268 MPH.
 *  More details on (<a href="https://www.baeldung.com/java-command-pattern">...</a>)
 * @author Nattanicha Nilsriphaiwan
 * @version 1.0
 */
public class MovableAdapterImpl implements MovableAdapter
{
    private final Movable luxuryCars;
    private static final double MPH_TO_KMPH;

    static
    {
        MPH_TO_KMPH = 1.60934;
    }

    public MovableAdapterImpl(final Movable luxuryCars)
    {
        this.luxuryCars = luxuryCars;
    }

    @Override
    public double getSpeed()
    {
        return convertMPHtoKMPH(luxuryCars.getSpeed());
    }

    private double convertMPHtoKMPH(double mph)
    {
        return mph * MPH_TO_KMPH;
    }
}