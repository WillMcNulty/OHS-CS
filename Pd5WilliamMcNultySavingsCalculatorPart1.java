/********************************

Name: William McNulty 
Class: Pd5 APCSA
Lab: Savings Calculator (Part 1)

********************************/

import java.util.Scanner;
import java.text.DecimalFormat;

public class Pd5WilliamMcNultySavingsCalculatorPart1
{
   public static void main (String [] args)
   {
      //declare variables savings (amount deposited) and years (the time it is deposited)
      double savings;
      int years; 
      
      //create a scanner to accept inputs and assign values to variables
      Scanner input = new Scanner (System.in);
      System.out.print("Enter the amount of money saved: "); //prompt for savings double
      savings = input.nextDouble();
      System.out.print("Enter the number of years the money will be invested: "); //prompt for years double
      years = input.nextInt();
      
      DecimalFormat d = new DecimalFormat ("0.00"); //decimal format two spaces
      
      //Print statements for output
      System.out.println("In a savings account with 1% annual interest for " + years + " years, you will save: $" + (d.format(savings*Math.pow(1.0025, (4*years)))));
      System.out.println("If you invest this money in the stock market for " + years + " years, you can expect to save: $" + (d.format(savings*Math.exp(0.07*years))));
      DecimalFormat de = new DecimalFormat ("0.00000000"); //decimal format for more spaces
      System.out.print("You can expect to save $" + (de.format((savings*Math.exp(0.07*years)) - (savings*Math.pow(1.0025, (4*years))))) + " more by investing in the stock market.");
      
   } //main
} //Pd5WilliamMcNultySavingsCalculatorPart1

/*****************************************************************************************************

----jGRASP exec: java Pd5WilliamMcNultySavingsCalculatorPart1
Enter the amount of money saved: 10000
Enter the number of years the money will be invested: 10
In a savings account with 1& annual interest for 10 years, you will save: $11050.33
If you invest this money in the stock market for 10 years, you can expect to save: $20137.53
You can expect to save $9087.19697341 more by investing in the stock market.
----jGRASP: operation complete.

----jGRASP exec: java Pd5WilliamMcNultySavingsCalculatorPart1
Enter the amount of money saved: 10000
Enter the number of years the money will be invested: 0
In a savings account with 1% annual interest for 0 years, you will save: $10000.00
If you invest this money in the stock market for 0 years, you can expect to save: $10000.00
You can expect to save $0.00000000 more by investing in the stock market.
----jGRASP: operation complete.

----jGRASP exec: java Pd5WilliamMcNultySavingsCalculatorPart1
Enter the amount of money saved: 0
Enter the number of years the money will be invested: 10
In a savings account with 1% annual interest for 10 years, you will save: $0.00
If you invest this money in the stock market for 10 years, you can expect to save: $0.00
You can expect to save $0.00000000 more by investing in the stock market.
----jGRASP: operation complete.
  
----jGRASP exec: java Pd5WilliamMcNultySavingsCalculatorPart1
Enter the amount of money saved: 0
Enter the number of years the money will be invested: 0
In a savings account with 1% annual interest for 0 years, you will save: $0.00
If you invest this money in the stock market for 0 years, you can expect to save: $0.00
You can expect to save $0.00000000 more by investing in the stock market.
----jGRASP: operation complete.
*****************************************************************************************************/