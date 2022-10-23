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
public class Main
{
	//main method
	public static void main(String[] args) throws IOException
	{
		//create SimpleBank object named bank
		//initialize it with no a blank name and 0 balance
		SimpleBank bank = new SimpleBank("",0);
		//run the bank
		bank.run();
	}
}