/** This is a program that plays the game Hangman
 *  @author Michael Bartlett
 *  @version 1.0
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.Math;

public class Project_4 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		//Initialize variables
		final String DICTIONARY_NAME = "dictionary.txt";
		int numWrongGuesses;
		String answerWord;
		String hiddenWord;
		String userGuess;
		boolean playing = true;
		String[] wordArray = readFile(DICTIONARY_NAME);
		Scanner keyboard = new Scanner(System.in);
		
		//Start the main game loop
		while(playing)
		{
			//Generate a word from the word array
			answerWord = chooseRandomWord(wordArray);
			hiddenWord = createPound(answerWord);
			numWrongGuesses = 0;
			
			//Ask for guesses while the word is unguessed and the user still has chances
			while((numWrongGuesses < 7) && hiddenWord.contains("#"))
			{
				//Get the user input
				System.out.println("Guess any letter in the word");
				System.out.println(hiddenWord);
				userGuess = keyboard.nextLine();
				
				//Update the word if the player guessed correctly
				if(answerWord.contains(userGuess))
				{
					hiddenWord = guessWord(userGuess, answerWord, hiddenWord);
				}
				else
				{
					System.out.println("Wrong guess, try again");
					numWrongGuesses += 1;
					printHangman(numWrongGuesses);
				}
				
			}
			
			//Print the end message
			if(!hiddenWord.contains("#"))
			{
				System.out.println("Correct! you have won this game. The word is: " + answerWord);
			}
			else
			{
				System.out.println("GAME OVER! The word was " + answerWord);
			}
			
			//Ask the user of they want to play again
			System.out.println("Do you still want to play?");
			playing = ((keyboard.nextLine()).equals("yes"));
		}
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
	static String createPound(String word)
	{
		String poundString = "";
		
		//Add a pound symbol for each letter in the word
		for(int i = 0; i < word.length(); i++)
		{
			poundString += "#";
		}
		return poundString;
	}
	
	/** This method takes a guess and checks to see if it is in the word. If it is
	 *  then the letters are filled in and the pound string is returned
	 * @param 	guess	the letter that the user guessed
	 * @param 	word	the word the user is trying to guess
	 * @param 	pound	a string containing pound symbols representing unguessed letters
	 * @return	the updated pound string
	 */
	static String guessWord(String guess, String word, String pound)
	{
		String newPoundString = "";
		
		//Loop through each letter in the word
		for(int i = 0; i < word.length(); i++)
		{
			//See if the letter matches the guess
			if(word.charAt(i) == guess.charAt(0))
			{
				newPoundString += guess.charAt(0);
			}
			else
			{
				newPoundString += pound.charAt(i);
			}
		}
		return newPoundString;
	}
	
	/** This method chooses a random word from an array of words
	 * @param 	words	the array containing the words to be chosen from
	 * @return	a word from the array chosen at random
	 */
	static String chooseRandomWord(String[] words)
	{
		//Get a random number and scale it to the size of the dictionary
		int randomIndex = (int)(Math.random() * words.length);
		
		//Return the chosen word
		return words[randomIndex];
	}
	
	/** This method prints out the hangman when a wrong guess is given
	 * 
	 * @param numWrongGuesses	the number of times the player has been wrong
	 */
	static void printHangman(int numWrongGuesses)
	{
		switch(numWrongGuesses)
		{
		case 1:
			System.out.println("\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"___|___");
			break;
		case 2:
			System.out.println("   |\r\n" + 
					"   |\r\n" + 
					"   |\r\n" + 
					"   |\r\n" + 
					"   |\r\n" + 
					"   |\r\n" + 
					"   |\r\n" + 
					"___|___");
			break;
		case 3:
			System.out.println("   ____________\r\n" + 
					"   |\r\n" + 
					"   |\r\n" + 
					"   |\r\n" + 
					"   |\r\n" + 
					"   |\r\n" + 
					"   |\r\n" + 
					"   | \r\n" + 
					"___|___");
			break;
		case 4:
			System.out.println("   ____________\r\n" + 
					"   |          _|_\r\n" + 
					"   |         /   \\\r\n" + 
					"   |        |     |\r\n" + 
					"   |         \\_ _/\r\n" + 
					"   |\r\n" + 
					"   |\r\n" + 
					"   |\r\n" + 
					"___|___");
			break;
		case 5:
			System.out.println("   ____________\r\n" + 
					"   |          _|_\r\n" + 
					"   |         /   \\\r\n" + 
					"   |        |     |\r\n" + 
					"   |         \\_ _/\r\n" + 
					"   |           |\r\n" + 
					"   |           |\r\n" + 
					"   |\r\n" + 
					"___|___");
			break;
		case 6:
			System.out.println("   ____________\r\n" + 
					"   |          _|_\r\n" + 
					"   |         /   \\\r\n" + 
					"   |        |     |\r\n" + 
					"   |         \\_ _/\r\n" + 
					"   |           |\r\n" + 
					"   |           |\r\n" + 
					"   |          / \\ \r\n" + 
					"___|___      /   \\");
			break;
		case 7:
			System.out.println("GAME OVER!\r\n" + 
					"   ____________\r\n" + 
					"   |          _|_\r\n" + 
					"   |         /   \\\r\n" + 
					"   |        |     |\r\n" + 
					"   |         \\_ _/\r\n" + 
					"   |          _|_\r\n" + 
					"   |         / | \\\r\n" + 
					"   |          / \\ \r\n" + 
					"___|___      /   \\");
			break;
		default:
			System.out.println("guess number error");
			break;
		
		}
	}
}
