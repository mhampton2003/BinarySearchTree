package project6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner fin = new Scanner(new File("txt.in"));
		Scanner scnr = new Scanner(System.in);
		
		BST bst = new BST();
		
		//inserts data into tree
		while (fin.hasNext()) {
			bst.newInsert(fin.next());
		}
		
		//prints out data in tree
		bst.displayInOrder();
		
		System.out.println("Enter 1 to search for a word, enter 0 to remove a word, or enter -1 to quit");
		
		String input = scnr.next();
		Boolean isInput = true;
		
		while (isInput) {
			//quits program
			if (input.equals("-1")) {
				System.out.println("Quitting");
				break;
			}
			
			//removes word
			else if (input.equals("0")) {
				System.out.println("Enter word to remove: ");
				input = scnr.next();
				
				//if word was found it removes the word and prints out the new tree
				if (bst.returnSearch(input)) {
					bst.returnDelete(input);
					System.out.println(input + " was successfully removed");
					System.out.println("");
					bst.displayInOrder();
				}
				
				//if the word was not found this is stated and nothing is removed
				else {
					System.out.println(input + " was not found to be removed");
					System.out.println("");
				}
				
				System.out.println("Enter 1 to search for a word, enter 0 to remove a word, or enter -1 to quit");
				
				input = scnr.next();
			}
			
			//searches for word
			else if (input.equals("1")){
				
				System.out.println("Enter the word you would like to find: ");
				input = scnr.next();
				
				//if word is found print out that it was found and the number of elements searched through
				if (bst.returnSearch(input)) {
					System.out.println("Inspected " + bst.counter + " elements");
					System.out.println(input + " was found");
					System.out.println("");
					
					System.out.println("Enter 1 to search for a word, enter 0 to remove a word, or enter -1 to quit");
					
					input = scnr.next();
				}
				
				//if the word is not found print this out and the number elements it searched through
				else {
					System.out.println("Inspected " + bst.counter + " elements");
					System.out.println(input + " was not found");
					System.out.println("");
					
					System.out.println("Enter 1 to search for a word, enter 0 to remove a word, or enter -1 to quit");
					
					input = scnr.next();
					
				}
			}
		}
	}
}
