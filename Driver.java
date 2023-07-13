package Assignment10_June29th;

import java.util.Scanner;

public class Driver
{
	public static Computer[] inventory;

	public static void main(String[] args) 
	{
		//display welcome message
		System.out.print("\t\t  =========================================================");
		System.out.print("\n\t\t        =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.print("\n\t\t        =                WELCOME TO                 =");
		System.out.print("\n\t\t        =                 COMPUTER                  =");
		System.out.print("\n\t\t        =             MANAGEMENT SYSTEM             =");
		System.out.print("\n\t\t        =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.print("\n\t\t  =========================================================\n");
		System.out.println("\t\t         Please see our Main Menu for more options");
		System.out.println();
		
		//Prompt the store owner for the maximum number of computers (maxComputers) his/her computer store can contain
		System.out.println("Please enter the maximum number of computer that could be created: ");
		Scanner kb = new Scanner(System.in);
		int maxComputers = kb.nextInt();
		
		while(maxComputers <= 0)
		{
			System.out.println("Error: Invalid number. Please enter a number greater than zero.");
			System.out.println("Please enter the maximum number of computer that could be created: ");
			maxComputers = kb.nextInt();
		}
				
		//Create an empty array, called inventory, that will have the potential of keeping track of the created Computer objects.	
		inventory = new Computer[maxComputers];
		MainMenu();
	}
	
	public static void MainMenu() 
	{
		System.out.print("\n==================================================================");
		System.out.print("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("\nChoose your option from the Main Menu: "
				+ "\n    1.\tInput new computers (password required) "
				+ "\n    2.\tChange information of a computer (password required) "
				+ "\n    3.\tDisplay all computers by a specific brand "
				+ "\n    4.\tDisplay all computers under a certain price. "
				+ "\n    5.\tQuit"); // you can enter -1 to go back to main menu at any time"
		System.out.print("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.print("\n==================================================================");
		System.out.print("\nPlease enter your option --> "); 
		Scanner kb = new Scanner(System.in);
		int option = kb.nextInt();
		
		//while if not 1 to 5 - and keep prompting the user until they enter a number between 1 and 5 inclusive: 
		while (option < 1 || option > 5) 
		{
			System.out.print("\nPlease enter an option between 1 and 5 --> "); 	
		}
		
		switch(option) 
		{
		case 1:
			PasswordValidate();
			MenuOption1();
			break;
		case 2:
			PasswordValidate();
			MenuOption2();
			break;
		case 3:
			MenuOption3();
			break;
		case 4:
			MenuOption4();
			break;
		case 5:
			MenuOption5();
			break;
		}
	
	}
	
	public static void PasswordValidate() 
	{
		String password = "password"; //constant variable containing the password “password” 
		System.out.println("Please enter your password: ");
		Scanner kb = new Scanner(System.in);
		String passwordInput = kb.next();
		
		if(!passwordInput.equals(password))
		{
			System.out.println("Error: Invalid password. You have two tries left. Please enter your password: ");
			passwordInput = kb.next();
				
				if(!passwordInput.equals(password))
				{
					System.out.println("Error: Invalid password. You have one tries left. Please enter your password: ");
					passwordInput = kb.next();
					
					if(!passwordInput.equals(password))
					{
						System.out.println("Error: Invalid password. You have zero tries left.");
						MainMenu();
					}
				}
			}
	}
	
	public static void MenuOption1() 
	{		
		//Check that there is enough space in inventory.
		//Considering that when a computer is sold, the unit to be removed will be the one on the last index of the array(inventory)
		Scanner kb = new Scanner(System.in);
		int availableSpace = 0;
		
		for (int i = 0; i < inventory.length; i++) {
			if (inventory[i] == null) 
			{
				availableSpace++;
			}
		}
		
		System.out.println("\n    1.\tInput new computers ");
		System.out.println("Please enter how many computers do you want to add: ");
		System.out.println("There are " + availableSpace + " empty slots available");
		//kb = new Scanner(System.in);
		int NumOfComputerToAdd = kb.nextInt();
		int counter = 1;
		
		while (NumOfComputerToAdd > availableSpace) {
			System.out.println("Error: There are only " + availableSpace + " empty slots available ");
			System.out.println("Please re-enter the number of computers you want to add: ");
			//kb = new Scanner(System.in);
			NumOfComputerToAdd = kb.nextInt();
		}
		
		while (NumOfComputerToAdd > 0) {
			Computer computer = new Computer();
			System.out.println("Please enter the information of Computer number " + counter);
			System.out.println("Computer Brand: ");			
			//kb = new Scanner(System.in);
			computer.setBrand(kb.next());
			System.out.println("Computer Model: ");			
			//kb = new Scanner(System.in);
			computer.setModel(kb.next());
			System.out.println("Computer Price: ");			
			//kb = new Scanner(System.in);
			computer.setPrice(kb.nextDouble());
			
			inventory[inventory.length - availableSpace] = computer;
			availableSpace--;
			NumOfComputerToAdd--;
			counter++;
			
			if (NumOfComputerToAdd != 0) {
				System.out.println("*** Next computer info ***");	
			}
			
			computer = null;	
			
		}		
		
		System.out.println("Successfully added " + (counter - 1) + " computers. ");
		MainMenu();
	}
	
	public static void MenuOption2() 
	{
		System.out.println("\n    2.\tChange information of a computer");
		System.out.print("Please enter the number of the computer you would like to update: "); 
		System.out.println("(Enter a number from 0 to " + (inventory.length - 1) + " or enter -1 to go back to main menu.");
		Scanner kb = new Scanner(System.in);
		int computerNumberToUpdate = kb.nextInt();
		
		
		
		if (computerNumberToUpdate == -1)// TERNARIO: boolean x = computerNumberToUpdate == -1 ? true : false;
		{
			MainMenu();
		}
		
		if (inventory[computerNumberToUpdate] == null)
		{
			System.out.println("Slot " + computerNumberToUpdate +  " is empty. Would you like to enter another computer slot number? [Y,N]");
			String responseYN = kb.next();
				
			if (responseYN.equalsIgnoreCase("Y"))
			{
				MenuOption2();
			}
			else // considering user will follow instructions correctly and input only Y or N
			{
				MainMenu();
			}		
		}
		
		System.out.println();
		System.out.println("Here is Computer " + computerNumberToUpdate + " information:");
		System.out.println("\nBrand: " + inventory[computerNumberToUpdate].getBrand()
				+ "\nModel: " + inventory[computerNumberToUpdate].getModel()
				+ "\nSN: " + inventory[computerNumberToUpdate].getSN()
				+ "\nPrice: " + inventory[computerNumberToUpdate].getPrice() + "\n ");
		
		System.out.println();
		System.out.println("Wich information would you like to update? ");
		System.out.println(
				  "\n    1.\tBrand "
				+ "\n    2.\tModel "
				+ "\n    3.\tSN "
				+ "\n    4.\tPrice "
				+ "\n    5.\tGo back to Main Menu");
		System.out.print("\nPlease enter your option --> ");
		int optionSubMenu = kb.nextInt();
		System.out.println();
		while (optionSubMenu < 1 || optionSubMenu > 5) 
		{
			System.out.print("\nPlease enter an option between 1 and 5 --> "); 	
		}
		
		if (optionSubMenu == 5)
		{
			MainMenu();
		}
		
		UpdateInformation(optionSubMenu, computerNumberToUpdate);
		
		System.out.println();
		System.out.println("Here is Computer " + computerNumberToUpdate + " with updated information:");
		System.out.println("\nBrand: " + inventory[computerNumberToUpdate].getBrand()
				+ "\nModel: " + inventory[computerNumberToUpdate].getModel()
				+ "\nSN: " + inventory[computerNumberToUpdate].getSN()
				+ "\nPrice: " + inventory[computerNumberToUpdate].getPrice() + "\n ");
		System.out.println();	
		
		MenuOption2();		
	}	
	
	public static void UpdateInformation(int optionSubMenu, int computerNumberToUpdate)
	{
		Scanner kb = new Scanner(System.in);
		System.out.print("\nPlease enter the new information: ");
		
		switch(optionSubMenu)
		{
			case 1: 			
				String newBrand = kb.next();
				inventory[computerNumberToUpdate].setBrand(newBrand);	
				break;
			case 2: 			
				String newModel = kb.next();
				inventory[computerNumberToUpdate].setModel(newModel);	
				break;
			case 3: 			
				long newSN = kb.nextLong();
				inventory[computerNumberToUpdate].setSN(newSN);	
				break;
			case 4: 			
				double newPrice = kb.nextLong();
				inventory[computerNumberToUpdate].setPrice(newPrice);	
				break;
		}
		
	}
	
	public static void MenuOption3() 
	{		
		
		
/*prompt the user to enter a brand name. You then need to display the information of all computers that have that brand.
(Hint: You may use a static method, for instance called findComputersBy ,
 which accepts a string for a brand name then performs the needed search)*/
		
	}
	
	public static void MenuOption4() 
	{
/* promtp the user to enter a value (representing a price). You then need to display all computers that have a vlaue smaller than that entered value. 
 * (Hint: You may use a static method, for instance called findCheaperThan, which accepts a double value, for a price, then performs the needed search). */		
		
		
	}
	
	public static void MenuOption5() //display a closing message and end the driver.	
	{		
		System.out.print("\n================================================================================================================");
		System.out.print("\n\t\t    =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.print("\n\t\t    =       THANK YOU FOR USING MANAGEMENT SYSTEM       =");
		System.out.print("\n\t\t    =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.print("\n================================================================================================================\n");
		
	}
	
}
