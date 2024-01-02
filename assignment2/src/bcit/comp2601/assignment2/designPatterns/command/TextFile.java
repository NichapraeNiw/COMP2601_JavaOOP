package bcit.comp2601.assignment2.designPatterns.command;

/**
 * Class: TextFile
 * d) Command
 *  1. A news agency can notify channels when it receives news.
 *  2. Receiving news is what changes the state of the news agency, and it causes the channels to be notified.
 *  3. NewsAgency is observable, and when news gets updated, the state of NewsAgency changes.
 *  4. When the change happens, NewsAgency notifies the observers about it by calling their update() method.
 *  5. To be able to do that, the observable object needs to keep references to the observers. In our case, it's the channel variable.
 *  6. It should have the update() method, which is invoked when the state of NewsAgency changes, the instance of NewsChannel will be updated.
 *  More details on (<a href="https://www.baeldung.com/java-command-pattern">...</a>)
 * @author Nattanicha Nilsriphaiwan
 * @version 1.0
 */
public class TextFile
{
    private final String name;

    public TextFile(final String name)
    {
        this.name = name;
    }

    public String open()
    {
        return "Opening file " + name;
    }

    public String save()
    {
        return "Saving file " + name;
    }

    // additional text file methods (editing, writing, copying, pasting)
}
