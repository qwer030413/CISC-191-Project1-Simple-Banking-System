import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Lead Author(s):
 * @author Joshua Edralin
 * @author Chris Park
 * <<add additional lead authors here, with a full first and last name>>
 * 
 * 
 * References: just a normal banking system
 * 
 *  
 * Version/date: 10/21/2022
 * 
 * Responsibilities of class: To create a project that uses all the materials we covered in modules 1~6
 * 
 */

//The Account class is a parent class to the SimpleBank
//the SimpleBank class can use all the methods in the Account class.
public class SimpleBank extends Account
{
	//create a new scanner object named cmd
    Scanner cmd = new Scanner(System.in);

    //constructor for SimpleBank that calls the super class constructor
    public SimpleBank(String name, int balance)
    {
    	super(name,balance);
    }
    
    /**
	 * Purpose: to run the SimpleBank
	 * (prompt the user for commands and executing accordingly)
	 * 
	 */
    public void run() throws IOException
    {
    	boolean quit = false;									//if quit = true, exit out of the do while loop
    	String command;											//The command that the user types in
    	File file = new File("/src/AccountList.txt");			//File to put all the account lists 
        FileWriter writer;										//FileWriter to write in file
    	System.out.println("Starting simple bank...");
    	
    	
    	//do while loop, when quit = true, quit the do while loop
    	do
    	{
    		
    		System.out.println("");
    		//prompt the user for a command and read it with the scanner
    		System.out.print("Enter command(press h for help): ");
    		command = cmd.nextLine();
    		System.out.println("command recieved: " + command);
    		System.out.println("");
    		
    		//if the user types h, show all commands possible
    		if(command .compareTo("h") == 0)
    		{
    			System.out.println("h: Shows all commands");
    			System.out.println("a: Shows all accounts and their information");
    			System.out.println("d: Deposit money in account");
    			System.out.println("w: Withdraw money from account");
    			System.out.println("n: Make new account");
    			System.out.println("q: Quit program");
    			System.out.println("f: Create file with all account information and updates information");
    			System.out.println("i: to see your account information");
    		}
    		//if the user types q, quit = true, exit do while loop and close simple bank
    		else if(command.compareTo("q") == 0)
    		{
    			quit = true;
    			System.out.println("closing simple bank....");
    		}
    		//if the user types n, create a new account
    		else if(command.compareTo("n") == 0)
    		{
    			System.out.println("Creating new account.."); 
    			//promt user for a name and create an account with the name given
    			System.out.print("Enter name for account: ");
    			String name = cmd.nextLine();
    			createAcc(name);
    		}

    		//if the user types d, deposit money
            else if(command.compareTo("d") == 0)
            {
            	int amount = 0;
            	//prompt user for the amount they want to deposit
                System.out.print("Name of account: ");
                String name = cmd.nextLine();
                System.out.print("Deposit Amount: ");
                //use try and catch so that we know if the user deposited a invalid amount(example: a string)
                try 
                {
                	amount = Integer.parseInt(cmd.nextLine().trim());
                }
                //catch the NumberFormatException and print error message
                catch (Exception NumberFormatException)
                {
                	System.out.println("Invalid Deposit amount, deposit failed.");
                	System.out.println("Please enter a valid amount next time :)");
                }
                
                deposit(name,amount);

               
            }
    		
    		//if the user types w, withdraw money
            else if(command.compareTo("w") == 0)
            {
            	int amount = 0;
            	//prompt user for the amount they want to withdraw
            	System.out.print("Name of account: ");
                String name = cmd.nextLine();
                System.out.print("Withdraw Amount: ");
                //use try and catch so that we know if the user withdraw a invalid amount(example: a string)
                try 
                {
                    amount = Integer.parseInt(cmd.nextLine().trim());
                }
                //catch the NumberFormatException and print error message
				catch (Exception NumberFormatException) 
                {
					System.out.println("Invalid Deposit amount, deposit failed.");
					System.out.println("Please enter a valid amount next time :)");
				}
                withdraw(name,amount);
            }

    		
    		//if the user types a, prompt them for the password(only chris and josh knows the password)
    		//if they type the right password, print all the existing accounts and their info
            else if(command.compareTo("a") == 0)				
            {
            	//password is BestBankEver
                String password = "BestBankEver";
                System.out.print("Password for manager: ");
                String pw = cmd.nextLine();
                //check if password is correct and pring error message otherwise
                if (pw.compareTo(password)!= 0 ) 
                {
                	System.out.println("Access Denied");
                }
                //if password is correct, print all the existing accounts and their inro
                else
                {
                    for(int i = 0; i < getSize(); i++)
                    {
                        System.out.println("Name: " + getName(i) + ", Balance: " + getBalance(i) + ", Account Number: " + getAccountNum(i));   //Format 
                    } 
                }
            }
    		
    		
           
    		//if the user types i, ask them for their account name and print the account info of the given accout name
            else if(command.compareTo("i") == 0)
            {
            	System.out.print("Account Name:");
            	String name = cmd.nextLine();
            	accountInfo(name);
            	
            }
    		
    		//if the user types f, update the file and write all the existing accounts and their info 
    		//this is for information and records
            else if(command.compareTo("f") == 0)
            {
            	writer = new FileWriter("C:/Users/Seojin Park/Desktop/CISC-191-Project1-Simple-Banking-System/Simple Banking Project/src/AccountList.txt");
            	//write all accounts and their info on the file
            	for (int i = 0; i < getSize(); i++)
                {
            		writer.write("Name: " + getName(i) + ", Balance: " + "$" + getBalance(i) + ", Account Number: " + getAccountNum(i) + "\n");
            		
                }
            	System.out.println("updated file :) ");
                writer.close();
            }
    		//if the user does not type a recognized command, print error message
            else 
            {
            	System.out.println("Command not recognized, try again!");
            }
    	}while(quit != true);		//run as long as quit does not equal true
    }
    
}