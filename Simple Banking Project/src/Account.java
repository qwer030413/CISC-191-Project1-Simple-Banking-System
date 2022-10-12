import java.util.ArrayList; // import the ArrayList class
import java.util.Scanner;
/*
 * improvements: only chris and josh can see all the accounts
 * exception for negative balance
 * exception for negatve deposit amount
 * exception for invalid account number
 * do the file I/O
 * make it so input doesn't matter if its lower or upper case
 * fix the bug thing in deposit and withdraw
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
    	boolean depositStatus = false;
    	try
    	{
    		if(checkName(name) == true)
        	{
        		throw new ArithmeticException(); 
        		
        	}
    	}
    	catch(Exception e)
    	{
    		System.out.println("What is your Account number?");
    		int num = cmd.nextInt();
            accountList.get(num - 1).balance += amount;
            depositStatus = true;
            
    	}
        
        if (depositStatus == false)
        {
            for (int i = 0; i < accountList.size(); i++)
            {
                if (accountList.get(i).name.compareTo(name) == 0)
                {
                    accountList.get(i).balance += amount;
                }
            }
        }
    }
    public void withdraw(String name, int amount)
    {
        // add way to deal with negative withdraw
    	boolean withdrawStatus = false;
    	try
    	{
    		if(checkName(name) == true)
        	{
        		throw new ArithmeticException(); 
        		
        	}
    	}
    	catch(Exception e)
    	{
    		System.out.println("What is your Account number?");
    		int num = cmd.nextInt();
            accountList.get(num - 1).balance -= amount;
            withdrawStatus = true;
            
    	}
        
        if (withdrawStatus == false)
        {
            for (int i = 0; i < accountList.size(); i++)
            {
                if (accountList.get(i).name.compareTo(name) == 0)
                {
                    accountList.get(i).balance -= amount;
                }
            }
        }
    }
    
    public boolean checkName(String name)
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
        	return true;
        }
        return false;
    }
}