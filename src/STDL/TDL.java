package STDL;

import java.util.Scanner;
import java.util.ArrayList;

public class TDL {
	public static void main(String[] args) {
		// initialize array list and scanner
		Scanner input = new Scanner(System.in);
		ArrayList<String> userTDAL = new ArrayList<String>();
		// initialize variables
		String userADD, userRetry, uSearch;
		int uStart;
		
		
		// using do while to repeat the code
		outer_layer:
		do {
			tdlIntro();
			// instructions
			System.out.printf("%nYour choice is (1-4): ");
			uStart = input.nextInt();
			// use switch for better layout
			switch(uStart) {
			// case 1 - adding a product
				case 1:
					while (true) {
						// list of product
						PTDL(userTDAL);
						// instructions
						System.out.printf("%nInput your products here (input 'exit' to stop): ");
						userADD = input.nextLine();
						
						// To exit inputing products
						if (userADD.equalsIgnoreCase("exit")) break;
						// remove the spaces entry
						userTDAL.removeIf(inputs -> inputs.trim().isEmpty());
						// adding the user input into array list named userTDAL
						userTDAL.add(userADD);
					}
					// SAVED ONLY WHEN LOOPING "Yes" (RESET IF QUITTING "No"/FRESH START)
					System.out.printf("%nProduct/s are saved!%n");
					break;
					
			// case 2 - let the user know he/she saved something in product list
				case 2:
					PTDL(userTDAL);
					break;
					
			// case 3 - search a products
				case 3:
					while(true) {
						// instructions
						System.out.printf("%n%nIf you want to search a product input their names.");
						System.out.printf("%nInput 'exit' if nothing/stop: ");
						uSearch = input.nextLine();
						
						// they want to exit
						if (uSearch.equalsIgnoreCase("exit")) break;
						
						// search logic using "contains" attribute
						if (userTDAL.contains(uSearch)) {
							System.out.printf("%nThe product %s is listed!", uSearch);
						}
						
						// if not yet listed
						if (!userTDAL.contains(uSearch)) {
							System.out.printf("%nThe product %s is not listed!", uSearch);						}
					}
					break;
					
			// case 4 - Exiting the from the choices
				case 4:
					System.out.printf("%n%nExiting...");
					// exit quickly
					break outer_layer;
					
			// default - when the user input beyond (1-4)
				default:
					System.out.println("Invalid option");
					
			}
			// to ask the user if they want to try again the program
			while (true) {
				System.out.printf("%nBack to Menu? (Yes/No): ");
				userRetry = input.next();
				// if the user don't choose from (Yes/No)
				if (!userRetry.equalsIgnoreCase("Yes") && !userRetry.equalsIgnoreCase("No")) {
					System.out.printf("Please choose from (Yes/No) only!%n");
				}
				// break the while loop when choose between Yes or No
				if (userRetry.equalsIgnoreCase("No") || userRetry.equalsIgnoreCase("Yes")) break;
				
			}
		// To loop the program again if they input Yes
		} while (!userRetry.equalsIgnoreCase("No"));
		
		input.close();
	}
	// introduction/guide
	public static void tdlIntro() {
		System.out.printf("%nWelcome to Inventory System!%n%n");
		System.out.println("Choose from the options!");
		System.out.println("1. Add a Product");
		System.out.println("2. Products List");
		System.out.println("3. Search Products");
		System.out.println("4. Exit");
	}
	
	// printing the output
	public static void PTDL(ArrayList<String> userTDAL) {
		System.out.printf("%nPRODUCT/S LIST:%n");
		// print the object inside of userTDAL Array List
		for (int i=0; i<userTDAL.size(); i++) {
			System.out.println((i+1) + ". " + userTDAL.get(i));
		}
	}
	
}
