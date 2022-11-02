/*
   I learned about recursive principles in this lab. The emphasis on
   base cases and building around them.
*/

import java.util.*;   
public class PD6WiliamMcNultyRecursionLab
{
   //Pre: c is a lower case letter - Post: all lower case letters a-char c are printed 
   public static void letters(char c)
   {
      if ((int)c == 97){
         System.out.print("a");
      }
      else{
         letters((char)(c-1));
         System.out.print(c);
      }
   }
	//Pre: none - Post: returns number of times two can go into x
   public static int twos(int x)
   {
      if(x%2==1){
         return 0;
      }
      else {
         return 1 + twos(x/2);
      }
   }
	//Pre: none - Post: returns if x is a power of 3
   public static boolean powerof3(int x)
   {
      if (x==3){
         return true;
      }
      else if (x<3){
         return false;
      }
      else{
         return powerof3(x/3);
      }
   }
	//Pre: none - Post: returns String of x reversed 
   public static String reverse(long x)
   {
     if (x/10==0){
        return "" + x;
     }
     else {
        if (x<0){
           return "" + x%10 + reverse(Math.abs(x)/10);
        }
        else {
           return "" + x%10 + reverse(x/10);
        }
     }
   }
	//Pre: x > 0 - Post: Prints x in base 5
   public static void base5(int x)
   {
      if (x<5){
         System.out.print(x);
      }
      else {
         base(x/5);
         base(x%5);
      }
   }
	// Pre: x > 0 - Post: Prints x with commas
   public static void printWithCommas(long x)
   {
      if(x/1000<1){
         System.out.print(x);
      }
      else {
         printWithCommas(x/1000);
         System.out.print("," + (x/100%10)+ "" + (x/10%10) +""+ x%10);
      }
   }
	
	
   public static void main(String []args)
   {
      Scanner scan = new Scanner (System.in);
      int choice;
      do
      {
         System.out.println("\n\n1)Letters"+
                           "\n2)Twos"+
                           "\n3)Power Of 3"+
                           "\n4)Reverse"+
                           "\n5)Base 5"+
                           "\n6)Print With Commas"+
                           "\n7)Exit");
         choice = scan.nextInt();
         if (choice == 1)
         {
            System.out.println("Enter a letter");
            char charA = scan.next().charAt(0);
            if (charA < 'a' || charA > 'z')
               System.out.println("That letter not valid");
            else
               letters(charA);
         }
         else if (choice == 2)
         {
            System.out.println("Enter a number");
            System.out.println(twos(scan.nextInt()));
         }
         else if (choice == 3)
         {
            System.out.println("Enter a number");
            System.out.println(powerof3(scan.nextInt()));
         }
         else if (choice == 4)
         {
            System.out.println("Enter a number");
            System.out.println(reverse(scan.nextLong()));
         }
         else if (choice == 5)
         {
            System.out.println("Enter a number");
            int number = scan.nextInt();
            if (number > 0)
               base5(number);
            else
               System.out.println("That number is not valid");
         }
         else if (choice == 6)
         {
            System.out.println("Enter a number");
            long number = scan.nextLong();
            if (number > 0)
               printWithCommas(number);
            else
               System.out.println("That number is not valid");
         }
      }while(choice != 7);
   }
}