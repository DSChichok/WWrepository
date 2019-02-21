/*
Write an automated test for this scenario using WebDriver.
The following exercise does not require user login. Please 
use ID or class as selectors.

Steps:
1. Navigate to https://www.weightwatchers.com/us/
2. Verify loaded page title matches “WW (Weight Watchers): Weight Loss & Wellness Help”
3. On the right corner of the page, click on “Find a Studio”
4. Verify loaded page title contains "Find a Studio & Meeting Near You | WW USA"
5. In the search field, search for studios for zip code: 10011
6. Print the title of the first result and the distance
7. Click on the first search result and you should see names of the person 
   conducting the meeting on the scheduled time right under time for each day. 
   Create a method that would take a weekday as parameter e.g. Sun, Mon, Tue....Sat and 
   the method should print out the names(s) and the number of times each person(s) is 
   conducting the meeting that particular day.

e.g.
getScheduleSummary(Sun)

output should be:
Name: <XXXXX> Total: <XX> times
Name: <YYYYY> Total: <YY> times
*/

import java.net.URL;
import java.util.Random;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;

public class Question2 
{
	//Declarations
	static String[] Days = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
	static Random   r    = new Random();
	static int      Zip  = 10011;
	
	public static void main(String[] args) throws IOException 
	{
		URL url = new URL("https://www.weightwatchers.com/us/find-a-meeting/search?search=10011");

        // Get the input stream through URL Connection
        URLConnection  con  = url.openConnection();
        InputStream    is   = con.getInputStream(); 
        BufferedReader br   = new BufferedReader(new InputStreamReader(is));
        String         line = null;

        // read each line and write to System.out
        while ((line = br.readLine()) != null) 
        {
            System.out.println(line);
        }

		getScheduleSummary(Days[r.nextInt(7)]);
    }
	
	private static void getScheduleSummary(String Day)
	{
		System.out.println("Results for " + Day);
	}
}