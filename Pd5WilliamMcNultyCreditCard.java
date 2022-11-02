import java.util.Scanner;
import java.text.DecimalFormat;

public class Pd5WilliamMcNultyCreditCard
{
   public static void main (String [] args)
   {
      int monthlyPayment, counter = 0;
      double balance = 1000;
      Scanner input = new Scanner (System.in);
      
      System.out.print("Enter the monthly payment: ");
      monthlyPayment = input.nextInt();
      
      for (int j = 1; balance >= 0; j++)
      {
         DecimalFormat d = new DecimalFormat ("0.0");
         System.out.print("Month: " + j);
         if ((balance + balance*1.5/100 - monthlyPayment) < 0)
         {
            System.out.print("\tbalance: " + (balance + balance*1.5/100 - monthlyPayment) +
            "\ttotal payments: " + d.format(balance + 1000) + "\n");
            counter++;
            if (counter == 1) 
            {
               System.out.print("\nFinal payment in the 1st month: " + d.format(balance));
            }
            else if (counter == 2) 
            {
               System.out.print("\nFinal payment in the 2nd month: " + d.format(balance));
            }
            else if (counter == 3) 
            {
               System.out.print("\nFinal payment in the 3rd month: " + d.format(balance));
            }
            else 
            {
               System.out.print("\nFinal payment in the " + counter + 
               "th month: " + d.format(balance));
            }
            break;
         }
         else 
         {
            balance = balance + balance*1.5/100 - monthlyPayment;
            System.out.print("\tbalance: " + balance + "\ttotal payments: " +
            (monthlyPayment*j) + "\n");
            counter++;
         }
      }
   } //main
} //Pd5WilliamMcNultyCreditCard