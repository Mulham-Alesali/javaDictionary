package Dic.dictionary;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Dictionary d = Dictionary.readFile();
    	if(d == null)
    		d = new Dictionary();
    	Scanner sc = new Scanner(System.in);
    	
    	
    	boolean run = true;
    	while(run) {
    		System.out.println("press 1 to insert word in the Dictionary"
    				+ "\npress 2 to search for a Word"
    				+ "\npress 3 to delete a Word from the Dictionary"
    				+ "\npress 4 to exit");
    		int eingabe = sc.nextInt();
        	switch(eingabe) {
        	case 1:
        		System.out.println("Insert the word");
        		String word = sc.next();
        		
        		System.out.println("Insert the meaning of the Word");
        		String meaning = sc.next();
      
        		d.add(word, meaning);
        		break;
        	case 2:
        			System.out.println("Enter a word to search");
        			String searchWord = sc.next();
    			try {
    				String result = d.search(searchWord);
    				System.out.println("the result is " + result);
    			} catch (Exception e) {
    				System.out.println("the word is not in the dictionary!");
    			}
        			
        		break;
        	case 3:
        			System.out.println("Enter the word to Delete");
        			String deleteWord = sc.next();
        			d.delete(deleteWord);
        		break;
        	case 4:
        		run = false;
        		Dictionary.save(d);
        		break;
        		default:
        			System.out.println("not Correct Input");
        	}
        	
    	}
    	
    }
}
