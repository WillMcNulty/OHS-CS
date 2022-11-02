/*******************************************
Name (Full Name): William McNulty   Period:   5
Name of the Lab/Assignment:  Dispenser
Purpose of the program: 
   Determine the change to be outputted from a vending machine in coin amounts (quarters, dimes, nickels, pennies), 
   when a price between 1 and 100 cents (inclusive) is inputted and it is assumed that one dollar is paid to the machine.
   -Learn about Mod and Division operators, and practice creating/writing an algorithim with said operators-
   
Date: 9/10/2021         
What I Learned:  
   -I learned the use of Modulo and Division operators.
   -I Learned how to properly use/apply print and println statements and associated escape key sequences and concation operators to
   combine variables with strings in a print statement.

What I Wonder:
   -I wonder how we could introduce program flexibility to also have the user insert a payment amount rather than an assumed 1 dollar payment.
   -I wonder how I would prevent users from inputting the wrong kinds of input like strings when prompted for an integer, possibly using a
   combination of if/if-else statements.

The credits: Mr. Lau -taught me in class-
Students (names) you helped and to what extent:  
****************************************************/


import java.util.Scanner;

public class Pd5WilliamMcNultyDispenser
{
   public static void main (String[] args)
   {
    Scanner console = new Scanner (System.in);
    System.out.print("Enter price of item (in cents): ");
    int price = console.nextInt(); //prompt the user for cost of item to get price int
    int change = 100 - price; //calculate change var initial
    
    int quarters = change/25;  //quarters -quarter calculation
    int dimes = change%25/10; //dimes -dime calculation
    int nickels = change%25%10/5; //nickels -nickel calculation
    int pennies =change%25%10%5; //penny -penny calculation
    
    //format of output
    System.out.println("You bought an item for " + price + " cent(s) and gave me a dollar, so your change is: "); //SOP output -State price and amount paid
    System.out.println(); //SOP output -blank line
    System.out.print(quarters + " quarter(s), " + dimes + " dime(s), " + nickels + " nickel(s), " + pennies + " penny(ies) "); //SOP output -Declare change
   
   }//main
}//Pd5WilliamMcNultyDispenser

/******************************************* outputs
   -Output 1-
   Enter price of item (in cents): 1
   You bought an item for 1 cent(s) and gave me a dollar, so your change is: 

   3 quarter(s), 2 dime(s), 0 nickel(s), 4 penny(ies) 
   -Output 2-
   Enter price of item (in cents): 22
   You bought an item for 22 cent(s) and gave me a dollar, so your change is: 

   3 quarter(s), 0 dime(s), 0 nickel(s), 3 penny(ies) 
   -Output 3-
   Enter price of item (in cents): 75
   You bought an item for 75 cent(s) and gave me a dollar, so your change is: 

   1 quarter(s), 0 dime(s), 0 nickel(s), 0 penny(ies) 
   -Output 4-
   Enter price of item (in cents): 80
   You bought an item for 80 cent(s) and gave me a dollar, so your change is: 

   0 quarter(s), 2 dime(s), 0 nickel(s), 0 penny(ies) 
   -Output 5-
   Enter price of item (in cents): 95
   You bought an item for 95 cent(s) and gave me a dollar, so your change is: 

   0 quarter(s), 0 dime(s), 1 nickel(s), 0 penny(ies) 
   -Output 6-
   Enter price of item (in cents): 99
   You bought an item for 99 cent(s) and gave me a dollar, so your change is: 

   0 quarter(s), 0 dime(s), 0 nickel(s), 1 penny(ies) 
   -Output 7 | Other Condition-
   Enter price of item (in cents): 0
   You bought an item for 0 cent(s) and gave me a dollar, so your change is: 

   4 quarter(s), 0 dime(s), 0 nickel(s), 0 penny(ies)
   -Output 8 | Other Condition-
   Enter price of item (in cents): 100
   You bought an item for 100 cent(s) and gave me a dollar, so your change is: 

0 quarter(s), 0 dime(s), 0 nickel(s), 0 penny(ies) 
   -Outputs Concluded-

****************************************************/