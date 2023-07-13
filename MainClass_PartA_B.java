package Assignment10_June29th;
//-------------------------------
// Assignment: Assignment10% from June 29th 2023
// Written by: Karina de Vargas Pereira
// JAC ID: 2300594
//-------------------------------   

public class MainClass_PartA_B 
{

	public static void main(String[] args) 
	{

		System.out.println("=====================================");
		Computer c1 = new Computer();
		System.out.println(c1);
		System.out.println("=====================================");
		Computer c2 = new Computer("Apple", "AE4567", 8552.22);
		System.out.println(c2);
		System.out.println("=====================================");
		Computer c3 = new Computer(c1);
		System.out.println(c3);
		System.out.println("=====================================");
		
		//equals		
		compareTwoComp(c1, c2);
		compareTwoComp(c1, c3);
		compareTwoComp(c2, c3);
		
		System.out.println("=====================================");
		c1.findNumberOfCreatedComputers();
		System.out.println("=====================================");
		
		
	}
	//2.11.26 create the array 
	
	
	public static void compareTwoComp(Computer computer1, Computer computer2)
	{
		if(computer1.equals(computer2) == true) 
		{
			System.out.println("Computador " + computer1.getSN() + " and Computador " + computer2.getSN() + " are equals");
		}
		else 
		{
			System.out.println("Computador " + computer1.getSN() + " and Computador " + computer2.getSN() + " are NOT equals");
		}
	}
	
	
	
	
}
