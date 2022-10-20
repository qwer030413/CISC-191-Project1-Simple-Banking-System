import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
h for help
a for all account info
d for deposit
w for withdraw
n for making new account
q for quitting program
depositing has a little error
*/ 
public class SimpleBank extends Account
{
    Scanner cmd = new Scanner(System.in);

    public SimpleBank(String name, int balance)
    {
    	super(name,balance);
    }
    
    
    public void run() throws IOException
    {
    	boolean quit = false;
    	String command;
    	File file = new File("/src/AccountList.txt");
        FileWriter writer;
    	System.out.println("Starting simple bank...");
    	
    	do
    	{
    		
    		System.out.println("");
    		System.out.print("Enter command(press h for help): ");
    		command = cmd.nextLine();
    		
    		System.out.println("command recieved: " + command);
    		System.out.println("");
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
    		else if(command.compareTo("q") == 0)
    		{
    			quit = true;
    			System.out.println("closing simple bank....");
    		}
    		else if(command.compareTo("n") == 0)
    		{
    			System.out.println("Creating new account.."); 
    			System.out.print("Enter name for account: ");
    			String name = cmd.nextLine();
    			createAcc(name);
    		}

            else if(command.compareTo("d") == 0)
            {
            	int amount = 0;
                System.out.print("Name of account: ");
                String name = cmd.nextLine();
                System.out.print("Deposit Amount: ");
                try 
                {
                	amount = Integer.parseInt(cmd.nextLine().trim());
                }
                catch (Exception NumberFormatException)
                {
                	System.out.println("Invalid Deposit amount, deposit failed.");
                	System.out.println("Please enter a valid amount next time :)");
                }
                //
                deposit(name,amount);

               
            }
            else if(command.compareTo("w") == 0)
            {
            	int amount = 0;
            	System.out.print("Name of account: ");
                String name = cmd.nextLine();
                System.out.print("Withdraw Amount: ");
                try 
                {
                    amount = Integer.parseInt(cmd.nextLine().trim());
                }
                    catch (Exception NumberFormatException)
                    {
                    	System.out.println("Invalid Deposit amount, deposit failed.");
                    	System.out.println("Please enter a valid amount next time :)");
                    }
                withdraw(name,amount);
            }

            else if(command.compareTo("a") == 0)				//make it so that only chris and josh can see it
            {
                String password = "BestBankEver";
                System.out.print("Password for manager: ");
                String pw = cmd.nextLine();
                if (pw.compareTo(password)!= 0 ) 
                {
                	System.out.println("Access Denied");
                }
                else
                {
                    for(int i = 0; i < accountList.size(); i++)
                    {
                        System.out.println("Name: " + getName(i) + ", Balance: " + getBalance(i) + ", Account Number: " + getAccountNum(i));   //Format 
                    } 
                }
            }
            else if (command.compareTo("t") == 0)
            {
            	System.out.print("name to test: ");
                String name = cmd.nextLine();
                System.out.println(checkName(name));

            }
            else if(command.compareTo("i") == 0)
            {
            	System.out.print("Account Name:");
            	String name = cmd.nextLine();
            	accountInfo(name);
            	
            }
            else if(command.compareTo("f") == 0)
            {
            	writer = new FileWriter("C:/Users/Seojin Park/Desktop/CISC-191-Project1-Simple-Banking-System/Simple Banking Project/src/AccountList.txt");
            	for (int i = 0; i < accountList.size(); i++)
                {
            		writer.write("Name: " + getName(i) + ", Balance: " + getBalance(i) + ", Account Number: " + getAccountNum(i) + "\n");
            		
                }
            	System.out.println("updated file :) ");
                writer.close();
            }
            else 
            {
            	System.out.println("Command not recognized, try again!");
            }
    	}while(quit != true);
    }
    
}