package autocomplete;

import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class IMTester {
	String[] mainList;
	String[][] containsCheck, prefixCheck, matchesCheck;
	Trie trie;
	
	//The constructor loads the file and initializes the trie
	public IMTester(String filename) {
		loadInfo(filename);
		
		trie = new Trie();
		trie.loadKeys(new java.util.ArrayList<String>(Arrays.asList(mainList)));
		System.out.println("The trie should now contain " + mainList.length + " words.");
	}
	
	//Loading initializes and assigns values to all 4 arrays
	private void loadInfo(String filename) {
		Scanner sc = null;
		try {
			sc = new Scanner(new File(filename));
		} catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		//Start by getting the Trie list
		mainList = new String[Integer.parseInt(sc.nextLine())];
		for(int i = 0; i<mainList.length; i++) mainList[i] = sc.nextLine();
		//Then, get the contains check split up
		containsCheck = new String[Integer.parseInt(sc.nextLine())][2];
		for(int i = 0; i<containsCheck.length; i++) containsCheck[i] = sc.nextLine().split(" ");
		//Then, get the getPrefix check split up
		prefixCheck = new String[Integer.parseInt(sc.nextLine())][2];
		for(int i = 0; i<prefixCheck.length; i++) prefixCheck[i] = sc.nextLine().split(" ");
		//Then, get the getAllPrefixMatches check split up
		matchesCheck = new String[Integer.parseInt(sc.nextLine())][2];
		for(int i = 0; i<matchesCheck.length; i++) matchesCheck[i] = sc.nextLine().split(" ");
		
	}
	
	public void testContains() {
		System.out.println("\nTime to test the contains() method! The correct answer is shown in parentheses. "); 
		for(String[] row : containsCheck)
			System.out.printf("The trie contains '%s' = %b (%s)%n", row[0], this.trie.contains(row[0]), row[1]);
	}
	
	public void testPrefix() {
		System.out.println("\nTime to test the getPrefix() method! The correct answer is shown in parentheses. "); 
		for(String[] row : prefixCheck)
			System.out.printf("The longest prefix of '%s' = %s (%s)%n", row[0], this.trie.getPrefix(row[0]), (row.length == 1 ? "" : row[1]));
	}
	
	public void testMatches() {
		System.out.println("\nTime to test the getAllPrefixMatches() method! The correct answer is shown in parentheses. "); 
		for(String[] row : matchesCheck)
			System.out.printf("Autocomplete '%s' = %s (%s)%n", row[0], this.trie.getAllPrefixMatches(row[0]).toString(), matchesList(row));
	}
	
	//For the testMatches block, need to print row[1:]
	private String matchesList(String[] row) {
		String result = "";
		for(int i=1; i<row.length-1; i++) result+=row[i] + ", ";
		if(row.length>1) result+=row[row.length-1];
		return result;
	}

	public static void main(String[] args) {
		//Insert the needed filename here; to be sure it works, write the whole path with double backslashes (because escape characters)
		//If you place it inside your src folder (ex: if you just drag the file onto your a3posted package), this link should work
		String filename = "./firstHundred.txt";
		IMTester test = new IMTester(filename);
		
		test.testContains();
		test.testPrefix();
		test.testMatches();
	}

}
