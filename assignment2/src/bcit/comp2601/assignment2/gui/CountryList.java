package bcit.comp2601.assignment2.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Class: CountryList extends JFrame
 * Displays all countries and their capitals in a JList (e.g. Canada: Ottawa), in alphabetical order by country name.
 * Use the data from the countries-and-capitals.txt file.
 * When the user closes the window, show the Main.main() menu.
 * This class has static variables which are:
 * - CAPITAL_INDEX = 1
 * - COUNTRY_INDEX = 0
 * @author Nattanicha Nilsriphaiwan
 * @version 1.0
 */
public class CountryList extends JFrame
{
    private final JList<String> countryList;

    public static final int CAPITAL_INDEX;
    public static final int COUNTRY_INDEX;

    static
    {
        CAPITAL_INDEX = 1;
        COUNTRY_INDEX = 0;
    }

    public CountryList()
    {
        setTitle("Country List");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        // Read data from file
        ArrayList<String> countryData = readCountryDataFromFile();
        Collections.sort(countryData);

        // Create JList and add it to the JFrame
        countryList = new JList<>(countryData.toArray(new String[0]));
        add(new JScrollPane(countryList), BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                dispose();
            }
        });
    }

    /**
     * readCountryDataFromFile()
     * @return ArrayList<String> countryData
     */
    private ArrayList<String> readCountryDataFromFile()
    {
        ArrayList<String> countryData = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("countries-and-capitals.txt")))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] parts = line.split(",");
                String  output = parts[COUNTRY_INDEX] + ": " + parts[CAPITAL_INDEX];
                countryData.add(output);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return countryData;
    }
}