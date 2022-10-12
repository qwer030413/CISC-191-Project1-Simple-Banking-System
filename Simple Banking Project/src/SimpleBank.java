import java.util.Scanner;
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
    
    public void run()
    {
    	boolean quit = false;
    	System.out.println("Starting simple bank...");
    	
    	do
    	{
    		System.out.println("");
    		System.out.print("Enter command(press h for help): ");
    		String command = cmd.nextLine();
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
                System.out.print("Name of account: ");
                String name = cmd.nextLine();
                System.out.print("Deposit Amount: ");
                int amount = cmd.nextInt();
                deposit(name,amount);
            }
            else if(command.compareTo("w") == 0)
            {
            	System.out.print("Name of account: ");
                String name = cmd.nextLine();
                System.out.print("Withdraw Amount: ");
                int amount = cmd.nextInt();
                withdraw(name,amount);
            }

            else if(command.compareTo("a") == 0)				//make it so that only chris and josh can see it
            {
                for(int i = 0; i < accountList.size(); i++)
                {
                	System.out.println("Name: " + getName(i) + ", Balance: " + getBalance(i) + ", Account Number: " + getAccountNum(i));   //Format 
                }
            }
            else if (command.compareTo("t") == 0)
            {
            	System.out.print("name to test: ");
                String name = cmd.nextLine();
                System.out.println(checkName(name));

            }
    	}while(quit != true);
    }
    
}