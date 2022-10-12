import java.util.ArrayList; // import the ArrayList class
import java.util.Scanner;
/*
 * improvements: only chris and josh can see all the accounts
 * exception for negative balance	-done
 * exception for negatve deposit amount		-done
 * exception for invalid account number		-done
 * do the file I/O
 * make it so input doesn't matter if its lower or upper case
 * fix the bug thing in deposit and withdraw - done!
 * Change int to different data type like double
 * add dollar signs
 * format the a command
 * 
 */
public class Account
{
	private String name;
	private int balance;            //Change to double with two decimals
	private int accountNum = 0;
	static int nextAccountNum = 0;
    ArrayList<Account> accountList = new ArrayList<Account>();
    Scanner cmd = new Scanner(System.in);


	public Account(String name, int balance)
	{
		this.name = name;
		this.balance = balance;
		accountNum = nextAccountNum;
		nextAccountNum++;
	}
	public String getName(int index)
	{
		return accountList.get(index).name;
	}
	
    public int getBalance(int index)
    {
        return accountList.get(index).balance;
    }
    public int getAccountNum(int index)
    {
    	return accountList.get(index).accountNum;
    }
    public void createAcc(String name)
    {
    	accountList.add(new Account(name,0));
    }
    public void deposit(String name, int amount)
    {
        // Add way to deal with negative deposit
    	if(checkName(name) > 1)
    	{
    		System.out.println("There are more than one accounts with that name");
    		System.out.print("Enter your Account Number: ");   
    		int num = cmd.nextInt();
    		try 
    		{
    			if(accountList.get(num - 1).name.compareTo(name) == 0)
    			{
                    accountList.get(num - 1).balance += amount;

    			}
    			else 
    			{
    				System.out.println("no account with that name and account number");
    			}

    		}
    		catch(Exception IndexOutOfBoundsException)
    		{
    			System.out.println("Invalid account numer");
    		}
        }
    	
    	else if(checkName(name) == 0)
    	{
    		System.out.println("There are no accounts with that name, try a different account name");
    	}
    	else if(amount <= 0)
    	{
    		System.out.println("Amount should be greater than 0!");
    	}
    	
    	else
        {
            accountList.get(getIndex(name)).balance -= amount;

        }
    }
    public void withdraw(String name, int amount)
    {
        // add way to deal with negative withdraw
    	if(checkName(name) > 1)
    	{
    		System.out.println("There are more than one accounts with that name");
    		System.out.print("Enter your Account Number: ");   
    		int num = cmd.nextInt();
    		try 
    		{
    			if(accountList.get(num - 1).name.compareTo(name) == 0)
    			{
                    accountList.get(num - 1).balance += amount;

    			}
    			else 
    			{
    				System.out.println("no account with that name and account number");
    			}

    		}
    		catch(Exception IndexOutOfBoundsException)
    		{
    			System.out.println("Invalid account numer");
    		}
        }        
    	
    	else if(checkName(name) == 0)
    	{
    		System.out.println("There are no accounts with that name, try a different account name");
    	}
    	else if(amount > balance)
    	{
    		System.out.println("You dont have enough money");
    	}
    	
    	else
        {
            accountList.get(getIndex(name)).balance += amount;
        }
    }
    
    public int checkName(String name)
    {
        int nameCount = 0;
        for(int i = 0; i < accountList.size(); i++)
        {
        	if(accountList.get(i).name.compareTo(name) == 0)
        	{
        		nameCount++;
        	}
        }
        if(nameCount > 1)
        {
        	return nameCount;
        }
        return nameCount;
    }
    
    public void accountInfo(String name)
    {
    	int num = 0;
    	if(checkName(name) > 1)
    	{
    		System.out.println("There are more than one accounts with that name");
    		System.out.print("Enter your Account Number: ");   
    		num = cmd.nextInt();
            System.out.println("Name: " + accountList.get(num - 1).name + " Balance: " + accountList.get(num - 1).balance + " Account Numner: " + accountList.get(num - 1).accountNum);
        }
    	
    	else if(checkName(name) == 0)
    	{
    		System.out.println("There are no accounts with that name, try a different account name");
    	}
    	else
    	{
    		
            System.out.println("Name: " + accountList.get(getIndex(name)).name + " Balance: " + accountList.get(getIndex(name)).balance + " Account Numner: " + accountList.get(getIndex(name)).accountNum);

    	}
    	
    }
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