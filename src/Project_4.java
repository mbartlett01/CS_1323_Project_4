/** This is a program that plays the game hangman
 *  @author Michael Bartlett
 *  @version 1.0
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Project_4 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		final String DICTIONARY_NAME = "dictionary.txt";
		String[] test = readFile(DICTIONARY_NAME);
	}
	
	/** This method returns an array that contains all the words in a file
	 * @param 	filename the name of the file that contains the words
	 * @return 	a string array containing all the words in the file
	 */
	static String[] readFile(String filename) throws FileNotFoundException
	{
		//Create a Scanner to read the file
		Scanner file = new Scanner(new File(filename));
		
		//Find the number of lines in the file
		int numLines = 0;
		while(file.hasNextLine())
		{
			file.nextLine();
			numLines += 1;
		}
		
		//Close and reopen the Scanner to reset it to the start of the file
		file.close();
		file = new Scanner(new File(filename));
		
		//Fill an array with all the words
		String[] wordArray = new String[numLines];
		for(int i = 0; i < wordArray.length; i++)
		{
			wordArray[i] = file.nextLine();
		}
		
		//Close the scanner to prevent errors and return the result
		file.close();
		return wordArray;
	}
	
	/** This method creates an array full of pound symbols representing unguessed
	 * 	letters in the word
	 * @param word	the word to replace with pound symbols
	 * @return		a string array containing all words in the file
	 */
	String createPound(String word)
	{
		return "";
	}
	
	/** This method takes a guess and checks to see if it is in the word. If it is
	 *  then the letters are filled in and the pound string is returned
	 * @param 	guess	the letter that the user guessed
	 * @param 	word	the word the user is trying to guess
	 * @param 	pound	a string containing pound symbols representing unguessed letters
	 * @return	the updated pound string
	 */
	String guessWord(String guess, String word, String pound)
	{
		return "";
	}
	
	/** This method chooses a random word from an array of words
	 * @param 	words	the array containing the words to be chosen from
	 * @return	a word from the array chosen at random
	 */
	String chooseRandomWord(String[] words)
	{
		return "";
	}
}
