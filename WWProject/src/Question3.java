/*
Generate 500 random numbers and print the nth smallest number in 
a programming language of your choice.

NOTE: The directions never specified whole numbers or decimal, going with int
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Question3 
{
	//Declarations
	static Random        random;
	static int           NumberProductions;
	static List<Integer> list;
	static int           SmallestNumber;
	static int           CurrentNumber;
	
	public static void main(String[] args) 
	{
		//Initialization
		random            = new Random(); 
		NumberProductions = 500;
		list              = new ArrayList<>();

		//Creating the 500 random numbers
		for( int i = 0; i < NumberProductions; i++ )
		{
			list.add(random.nextInt());
		}
		
		//Get the first number in the list
		SmallestNumber = list.get(0);
		
		//Find the lowest number in that list
		for( int i = 1; i < NumberProductions; i++ )
		{
			CurrentNumber = list.get(i);
			if( SmallestNumber > CurrentNumber )
			{
				SmallestNumber = CurrentNumber;
			}
		}
		
		//Showcase the smallest number
		System.out.println( "Smallest number is: " + SmallestNumber );
    }
}