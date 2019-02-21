/*
There is a file containing a word and its possible meanings (like a Dictionary). 
The contents of the file look like this:

Apple – a fruit, a tech firm
Table – an object, contains rows and columns when used in context of computers
Orange – a fruit

Given a path to the file, do the following:
a) Create a method called doesFileExist(String path) which takes the path of 
   the file and tells the user if the file exists at that path or not. Assume 
   all paths are relative to your project structure. If the file does not exist, 
   catch the requisite exception.
   
b) Read each word and its possible meanings and print them out. Your output 
   should look like this:

Word1
Meaning 1
Meaning 2
Word2
Meaning1
Meaning2

Use appropriate data structures wherever necessary.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Question1 
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		//Declarations
		String  FilePath  = "Depth1/Depth2/Dictionary.txt";
		boolean FileExist = doesFileExist(FilePath);
		
		if(FileExist)
		{
			ProcessDictionary(FilePath);
		}
		else
		{
			System.out.println("FILE NOT FOUND!");
		}
    }
	
	private static boolean doesFileExist(String path)
	{
		boolean FileExists = false;
		Path filePath = Paths.get(path);
		FileExists = Files.exists(filePath);
		return FileExists;
	}
	
	private static void ProcessDictionary(String DictionaryFile) throws FileNotFoundException
	{
		File file = new File(DictionaryFile);
		Scanner sc = new Scanner(file);
		String WholeLine = "";
        while ( sc.hasNextLine() )
        {
        	//Get the line
        	WholeLine = sc.nextLine();
        	
        	//Get the Word that's being defined
        	int Seek = 0;
        	for( int i = 0; i < WholeLine.length(); i++ )
        	{
        		if( WholeLine.charAt(i) == '-' )
        		{
        			Seek = i;
        			break;  //We found the limit
        		}
        	}
        	
        	//Output the Word
        	System.out.println(WholeLine.substring(0, Seek - 1));
        	Seek += 2;
        	
        	//Print the definitions
        	int Edge = 0;
        	for( int i = Seek; i < WholeLine.length(); i++ )
        	{
        		//Definitions before and between commas
        		if( WholeLine.charAt(i) == ',' )
        		{
        			Edge = i;
        			System.out.println( WholeLine.substring(Seek, Edge) );
        			Seek = Edge + 2;
        		}
        		//Single definitions or the last definition
        		else if( i == WholeLine.length() - 1 )
        		{
        			System.out.println( WholeLine.substring(Seek, WholeLine.length()) );
        		}
        	}
        }

        //Close the resources
        sc.close();
	}
}