package Assignment10_June29th;
//-------------------------------
//Assignment: Assignment10% from June 29th 2023
//Written by: Karina de Vargas Pereira
//JAC ID: 2300594
//------------------------------- 

public class Computer 
{

	//Creating the attributes for the object "Computer" 
	private String brand;
	private String  model;
	private long SN; //SN indicates the serial number of the computer
	private static int snGenerator = 101;
	private double price;
	private static int count = 0; //variable created to keep track of created objects  
	
	
	//initializing attributes with valid values using constructor - by default constructor
	public Computer()
	{
		System.out.println("Computer created by default constructor.");
		this.brand = "Microsoft";
		this.model = "235Surface";
		this.SN = snGenerator;
		this.price = 15413.33;
		count++;
		snGenerator++;
	}
	
	//initializing attributes with valid values using constructor - by parameter constructor
	public Computer(String br, String mo, double pr)
	{
		System.out.println("Computer created by parameter constructor.");
		this.brand = br;
		this.model = mo;
		this.SN = snGenerator;
		this.price = pr;
		count++;
		snGenerator++;
	}
	
	//initializing attributes with valid values using constructor - by copy constructor
	public Computer(Computer c) 
	{
		System.out.println("Computer created by copy constructor.");
		this.brand = c.brand;
		this.model = c.model;
		this.SN = snGenerator;
		this.price = c.price;
		count++;
		snGenerator++;
	}
	
	public String getBrand()
	{
		return this.brand;
	}

	public void setBrand(String brand)
	{
		this.brand = brand;
	}
	
	public String getModel()
	{
		return this.model;
	}
	
	public void setModel(String model)
	{
		this.model = model;
	}
	
	public long getSN()
	{
		return SN;
	}
	
	public void setSN(long SN)
	{
		this.SN = SN;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public void setPrice(double price)
	{
		this.price = price;
	}
	
	//comparing compare two Computer objects for equality - Using equals() method
	public boolean equals(Computer c) 
	{		
		if (this.brand == c.brand && this.model == c.model && this.price == c.price) 
		{
			return true;
		} 
		else 
		{
			return false;
		}
	}
	
		
	@Override
	public String toString() 
	{
		return "Computer information brand: " + brand + ", model: " + model + ", SN: " + SN + ", price: " + price + "$. ";
	} 
	
	public static void findNumberOfCreatedComputers()
	{
		System.out.println("Number of computers created so far: " + count + " computers");
	}
	
	
	
}
