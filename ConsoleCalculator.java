package project3;

import java.io.*;

/**
 * Driver Class for the ExpressionTools Class
 * Converts infix expression input file into post-fix expressions and
 * outputs the conversion and post-fix evaluation into a designated 
 * output file.
 * 
 * @author Monica Martinez
 * @version November 16, 2014
 *
 */
public class ConsoleCalculator {

	public static void main(String[] args) {
		
		PrintWriter outputFile = null;
		File inputFile = null;
		BufferedReader reader;
		String line;
		Integer value;
		
		try 
		{
//UPDATED: Accounts for too few and too many arguments
			if (args.length == 0 || args.length > 2)
				throw new Exception();
			try 
			{
				//Read Command line arguments 
//NO loop				
				for (int i=0; i < args.length; i++) {
					inputFile = new File(args[0]);
					outputFile = new PrintWriter(args[1]);
				}
			} 
			catch (FileNotFoundException e) 
			{
				System.err.println("File Not Found");
				
			} 
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
				try 
				{	
					//reads each line in the input file
					reader = new BufferedReader(new FileReader(inputFile));
			
					while ((line = reader.readLine()) != null) { 
						try
						{
						
							//	String expression = "2 + 3 + 2 + 32 + 32 + 32 + 32 + 32 + 32 + 32 + 32 + 32 + 32 + 3";
							String expression = "+ 2 2";
							//	String expression = line;
							//	outputFile.println(expression);
							ExpressionTools.isValidInfix(expression);
						
							//Conversion
							String convExp = ExpressionTools.postFixConverter(expression);
							//	outputFile.println(convExp);
							System.out.println(convExp);
							//Evaluation
						
							value = ExpressionTools.postFixEvaluator(convExp);
							//	outputFile.println(value);
							System.out.println(value);
							//	outputFile.println();
					
										
							
						}
						catch (PostFixException e) 
						{
							//	outputFile.println("INVALID: " + e.getMessage());
							System.out.println("INVALID: " + e.getMessage());
							//	outputFile.println();
						}
						catch (ArithmeticException e)
						{
							//	outputFile.println("INVALID: " + e.getMessage());	
							//	outputFile.println();
							System.out.println("INVALID: " + e.getMessage());
						}
						catch (Exception e)
						{
							//	outputFile.println("ERROR: " + e.getMessage());	
							//	outputFile.println();
							System.out.println("ERROR: " + e.getMessage());	
						}
					} 
	
				}
				catch (IOException e) 
				{
					System.err.println("I/O Error");
				}
				finally
				{
					outputFile.close();
				//	System.out.println(new File(".").getAbsolutePath());
					System.out.println();
				}		
		} 
		catch (Exception e1) 
		{
			System.out.println("ERROR: Invalid Arguement Length");
			System.exit(0);
		}	
	} 	
}
