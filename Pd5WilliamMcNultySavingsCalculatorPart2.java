/**********************************************************************************************************************************************
Name (Full Name): William McNulty   Period:   5
Name of the Lab/Assignment:  Savings Calculator
Purpose of the program: 
   -The program is used to calculate the savings of someone who invests in the stock market for an amount of time
    and also for the case in which that amount is invested in a bank account compounded quarterly on 1% interest. 
    Using the formulas A=Pe^(0.07t) for the stock market, where A is amount, P is principal amount invested, 
    and t is time. Then also using the formula A=P(1.0025)^(4t) for the savings account, where A is amount, 
    P is principal amount, and t is time. This program also finds the difference between the two amounts to see if 
    one type of investment/savings is better.
   
Date: 9/25/2021         
What I Learned:  
   -I learned how to use Math methods to do more complex math in a program
   -I learned how to use methods to eliminate or handle program complexity and create a more readable program
   -I learned how to use the different types of methods to get desired returns and outputs
   -I learned that investments are very profitable and that the stock market under the given conditions is a favorable investment
   -I learned the components of a method and how they're applied
   --I feel that it is also important to learn when using methods is important as sometimes it may create extra program components
     that are unecessary instead of eliminating complexity. In this lab I feel like the methods are useful but would be better used if
     there were recurring code segments in the program.

What I Wonder:
   -I wonder if there are more applications of methods and different kinds for more uses
   -I wonder if creating methods is always useful
   -I wonder if there are other types of methods like the Math class that can be used to enhance program capablities.
   -I wonder how we can use methods to create program flexibility by using them in conditional calls, running different methods depending
    on the case. For example, maybe having conditions for different stocks or bonds that have greater time requirements, or having 
    conditions for different stocks that have different interest rates.

The credits: Mr. Lau -taught me in class-
Students (names) you helped and to what extent:  
**********************************************************************************************************************************************/

import java.util.Scanner;
import java.text.DecimalFormat;

public class Pd5WilliamMcNultySavingsCalculatorPart2
{
   public static void main (String [] args)
   {
      double principal = getPrincipal();
      double time = getTime();
      double savingsReturn = calcSavingsAccount(time, principal);
      double marketReturn = calcMarketReturn(time, principal);
      calcDifference(savingsReturn,marketReturn);
   } //main
   
   //getPrincipal - gets input for principal variable
   public static double getPrincipal()
   {
      double P; //Principal value assigned by user input and to be returned
      Scanner input = new Scanner (System.in);
      System.out.print("Enter the amount of money saved: "); //prompt for savings double "P"
      P = input.nextDouble();
      return P;
   } //getPrincipal
   
   //getTime - gets input for time variable
   public static double getTime()
   {
      int t; //Time value assigned by user input and to be returned
      Scanner input = new Scanner (System.in);
      System.out.print("Enter the number of years the money will be invested: "); //prompt for years int
      t = input.nextInt();
      return t;
   } //getTime
  
   //calcSavingsAccount - finds amount saved in account
   public static double calcSavingsAccount(double t, double P)
   {
      double A; //Amount value assigned by math calculated to savings account and to be returned
      DecimalFormat d = new DecimalFormat ("0.00"); //create a decimal format to two spaces local to the method
      A = (P*Math.pow(1.0025, (4*t)));
      System.out.println("In a savings account with 1% annual interest for " + (int)t + " years, you will save: $" + (d.format(A)));
      return A;
   } //calcSavingsAccount
   
   //calcMarketReturn - finds the amount saved in stock market
   public static double calcMarketReturn(double t, double P)
   {
      double A; //Amount value assigned by math calculated to stockmarket account and to be returned
      DecimalFormat d = new DecimalFormat ("0.00"); //decimal format to two spaces local to the method
      A = (P*Math.exp(0.07*t));
      System.out.println("If you invest this money in the stock market for " + (int)t + " years, you can expect to save: $" + d.format(A));
      return A;
   } //calcMarketReturn
   
   //calcDifference - finds difference between marketReturn and savingsReturn to see how much more would be saved
   public static void calcDifference(double savingsReturn, double marketReturn)
   {
      DecimalFormat de = new DecimalFormat ("0.00000000"); //decimal format to more spaces local to the method
      System.out.print("You can expect to save $" + de.format(marketReturn - savingsReturn) + " more by investing in the stock market."); //differnce output statement
   } //calcDifference



} //Pd5WilliamMcNultySavingsCalculatorPart2

/*********************************************************************************************************

-Outputs-

----jGRASP exec: java Pd5WilliamMcNultySavingsCalculatorPart2
Enter the amount of money saved: 10000
Enter the number of years the money will be invested: 10
In a savings account with 1% annual interest for 10 years, you will save: $11050.33
If you invest this money in the stock market for 10 years, you can expect to save: $20137.53
You can expect to save $9087.19697341 more by investing in the stock market.
----jGRASP: operation complete.

----jGRASP exec: java Pd5WilliamMcNultySavingsCalculatorPart2
Enter the amount of money saved: 0
Enter the number of years the money will be invested: 10
In a savings account with 1% annual interest for 10 years, you will save: $0.00
If you invest this money in the stock market for 10 years, you can expect to save: $0.00
You can expect to save $0.00000000 more by investing in the stock market.
----jGRASP: operation complete.

----jGRASP exec: java Pd5WilliamMcNultySavingsCalculatorPart2
Enter the amount of money saved: 10000
Enter the number of years the money will be invested: 0
In a savings account with 1% annual interest for 0 years, you will save: $10000.00
If you invest this money in the stock market for 0 years, you can expect to save: $10000.00
You can expect to save $0.00000000 more by investing in the stock market.
----jGRASP: operation complete.

----jGRASP exec: java Pd5WilliamMcNultySavingsCalculatorPart2
Enter the amount of money saved: 0
Enter the number of years the money will be invested: 0
In a savings account with 1% annual interest for 0 years, you will save: $0.00
If you invest this money in the stock market for 0 years, you can expect to save: $0.00
You can expect to save $0.00000000 more by investing in the stock market.
----jGRASP: operation complete.
  
*********************************************************************************************************/