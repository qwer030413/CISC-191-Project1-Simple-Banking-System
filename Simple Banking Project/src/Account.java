
import java.util.ArrayList; // import the ArrayList class
import java.util.Scanner;
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
public class Account
{
	private String name;
	private double balance;            //Change to double with two decimals
	private int accountNum = 0;
	static int nextAccountNum = 0;
    private ArrayList<Account> accountList = new ArrayList<Account>();
    Scanner cmd = new Scanner(System.in);


    /**
	 * Purpose: we will use this constructor to create an Array List that has a type Account
	 * @param name for name of the account
	 * @param balance for the initial balance of the account
	 * 
	 */
   
	public Account(String name, int balance)
	{
		this.name = name;
		this.balance = balance;
		accountNum = nextAccountNum;
		nextAccountNum++;
	}
	/**
	 * Purpose: To get the name of the account in the given index in the array list
	 * @param index for the index of the name we are trying to get
	 * @return The name in the given index
	 */
	public String getName(int index)
	{
		return accountList.get(index).name;
	}
	
	/**
	 * Purpose: To get the balance of the account in the given index in the array list
	 * @param index for the index of the account that we need to get the balance from
	 * @return The balance in the given index
	 */
    public double getBalance(int index)
    {
        return Math.round(accountList.get(index).balance);
    }
    /**
	 * Purpose: To get the size of the accountList which is the number of existing accounts
	 * @return The size of the accountList
	 */
    public int getSize()
    {
    	return accountList.size();
    }
    /**
	 * Purpose: to get an account number in the given index in the array list
	 * @param index for the index of the account that we need to get the account Number from
	 * @return The account Number of the account in the given index
	 */
    public int getAccountNum(int index)
    {
    	return accountList.get(index).accountNum;
    }
    /**
	 * Purpose: to create a new account by adding the account info to the array list
	 * @param name for the name of the account
	 * 
	 */
    public void createAcc(String name)
    {
    	accountList.add(new Account(name,0));
    	
    }
    /**
	 * Purpose: to deposit money in the given account
	 * @param name for the account name to deposit
	 * @param amount to deposit to the account
	 * 
	 */
    public void deposit(String name, int amount)
    {
    	//if there is more than one account with the name given
    	//print error messages and prompt the user for their account number
    	
    	if(checkName(name) > 1)
    	{
    		System.out.println("There are more than one accounts with that name");
    		System.out.print("Enter your Account Number: ");   
    		
    		//use try, catch to catch the IndexOutOfBoundsException error just incase the person does not enter a int variable
        	//for the account number    	
    		try 
    		{
    			int num = cmd.nextInt();
    	    	//make sure the account number exists and print error message otherwise
    			if(accountList.get(num - 1).name.compareTo(name) == 0)
    			{
    				
                    accountList.get(num - 1).balance += amount;

    			}
    			else 
    			{
    				System.out.println("no account with that name and account number");
    			}

    		}
    		catch(Exception IndexOutOfBounds)
    		{
    			System.out.println("Invalid account number");
    		}
        }
    	
    	//if there are no accounts at all with that name, let the user know
    	else if(checkName(name) == 0)
    	{
    		System.out.println("There are no accounts with that name, try a different account name");
    	}
    	//if the amount of deposit is negative, print out error message
    	else if(amount < 0)
    	{
    		System.out.println("Amount should be greater than 0!");
    	}
    	//if everything is ok, deposit the amount in the account
    	else
        {

            accountList.get(getIndex(name)).balance += amount;

        }
    }
    /**
	 * Purpose: to withdraw money from the given account
	 * @param name for the account name to withdraw
	 * @param amount to deposit to the withdraw
	 * 
	 */
    
    public void withdraw(String name, int amount) 
    {
    	//same structure as deposit, only difference is that withdraw substracts money from original balance
    	
    	//if there is more than one account with the name given
    	//print error messages and prompt the user for their account number
    	if(checkName(name) > 1)													
    	{
    		System.out.println("There are more than one accounts with that name");
    		System.out.print("Enter your Account Number: ");   
    		
    		//use try, catch to catch the IndexOutOfBoundsException error just incase the person does not enter a int variable
        	//for the account number 
    		try 
    		{
    			int num = cmd.nextInt();
    	    	//make sure the account number exists and print error message otherwise
    			if(accountList.get(num - 1).name.compareTo(name) == 0)
    			{
                    accountList.get(num - 1).balance -= amount;

    			}
    			else 
    			{
    				System.out.println("no account with that name and account number");
    			}

    		}
    		catch(Exception IndexOutOfBounds)
    		{
    			System.out.println("Invalid account number");
    		}
        }        
    	//if there are no accounts at all with that name, let the user know
    	else if(checkName(name) == 0)	//there is no name at all
    	{
    		System.out.println("There are no accounts with that name, try a different account name");
    	}
    	//if the amount of withdraw  is greater than the balance, print out error message
    	else if(amount >  accountList.get(getIndex(name)).balance)
    	{
    		System.out.println("You dont have enough money");
    	}
    	
    	//if everything is ok, withdraw the amount in the account
    	else
        {
            accountList.get(getIndex(name)).balance -= amount;
        }
    }
    
    
    /**
   	 * Purpose: helper method to check how many accounts there are with the given name
   	 * @param name for the account name to test
   	 * @return number of accounts with the given name
   	 * 
   	 */
    public int checkName(String name)
    {
    	//number of accounts with the given name
        int nameCount = 0;
        //for loop to run though all the accounts
        for(int i = 0; i < accountList.size(); i++)
        {
        	//add 1 to namecount each time the name shows up
        	if(accountList.get(i).name.compareTo(name) == 0)
        	{
        		nameCount++;
        	}
        }
        //return nameCount
       
        return nameCount;
    }
    
    /**
   	 * Purpose: method to return the information of the account with the given name
   	 * @param name for the account name to get info from
   	 * 
   	 * 
   	 */
    public void accountInfo(String name)
    {
    	int num = 0;
    	//if there are more than 1 accounts with the given name
    	//ask for their account number so we know which one it is
    	if(checkName(name) > 1)						
    	{
    		System.out.println("There are more than one accounts with that name");
    		System.out.print("Enter your Account Number: ");   
    		num = cmd.nextInt();
            System.out.println("Name: " + accountList.get(num - 1).name + " Balance: " + "$" + accountList.get(num - 1).balance +  " Account Numner: " + accountList.get(num - 1).accountNum);
        }
    	//if there are no accounts with the given name, print out error message
    	else if(checkName(name) == 0)
    	{
    		System.out.println("There are no accounts with that name, try a different account name");
    	}
    	//if there is one account with the given account name, print out the info of the account
    	else
    	{
    		
            System.out.println("Name: " + accountList.get(getIndex(name)).name + " Balance: " + accountList.get(getIndex(name)).balance + "$ " + " Account Numner: " + accountList.get(getIndex(name)).accountNum);

    	}
    	
    }
    
    /**
   	 * Purpose: helper method to get the index of the account of the given account name
   	 * @param name for the account name to search
   	 * @return the index of the account with the given name
   	 * 
   	 */
    public int getIndex(String name)
    {
    	for(int i = 0; i < accountList.size(); i++)
    	{
    		if(accountList.get(i).name.compareTo(name) == 0)
    		{
    			return i;
    		}
    	}
    	return 0;
    }
}