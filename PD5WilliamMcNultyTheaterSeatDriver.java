/****************************************************************************
 Name: William McNulty
 Lab: TheatreSeat / TheaterPricing Unit 10(2D Array) Lab
 Date submitted: 3/5/2022

 Purpose of the program:
  -"Process data in a two-dimensional array and write methods to modify and display 2-D arrays."
   To manage a two dimensional array of seats in a theater, and manipulate the array via 
   simulation of seat purhchase
 
  -To practice using 2D Arrays, and 2D Array methods/array manipulation
  
 What I Learned (be as specific as possible):
  -I learned how to use for loops and enhanced for loops (nested loops aswell)
   to traverse and manipulate a 2D Array
  -I learned to use practical overloading of methods
  -I learned to emphasize revision of code by thinking of alternatives solutions
   specifically in terms of how to work within a program shell
 
 What I Wondered (be as specific as possible):
  -I wonder how else we can use 2D arrays to manage data like a seating chart
   I know about creating board games with them, but how powerful are they in
   data analysis and manipulation in other settings
  -I wonder how I could have written the program differently. Perhaps instead of
   overloading the pickSeat method, I could have made an internal method(s) that
   would simply change the function of pickSeat() under certain cases. Also
   possibly changing the logic on my conditionals, to optimize their flow
   differently.
 
 The credits: who and/or what website(s) helped you (must state 
 what information you got from your helper or website):
 Mr. Lau taught me in class about the topics of Java and Computer Science

 Students (names) you helped (to what extent): 
 ****************************************************************************/

import java.util.Scanner;
public class PD5WilliamMcNultyTheaterSeatDriver 
{
   public static void main(String[] args) 
   {
      final int YES = 0;        // purchase a ticket
      // define some constants here based on what we use in the code below
      
      TheaterSeatingChart chart = new TheaterSeatingChart();
      boolean notDonePurchasing = true;
      Scanner console = new Scanner (System.in);
      
      while (notDonePurchasing)
      {
         chart.printSeatingChart();
         System.out.print ("\nDo you want to purchase a ticket? \nEnter 0 for Yes, 1 for No: ");
         
         int choice = console.nextInt();
         if (choice == YES)
         {
            int seatChoice = 0;
            while (!(seatChoice == 2 || seatChoice == 1))
            {
               System.out.print ("\n** LET US START **" +
                                 "\nWould you like to choose a seat by number or by price? " +
                                 "\nEnter 1 for \"Choose by number\", 2 for \"Choose by price\": ");
         
               seatChoice = console.nextInt();
               if (!(seatChoice == 2 || seatChoice == 1))
               {
                  System.out.print ("\nThat's not 1 or 2, try again.");
               }
            }
         
            if (seatChoice == 2)
            {
               chart.pickPrice();
            }
            else if (seatChoice == 1)
            {
               chart.pickSeat();
            }
         
         } // outer if
         else
         {
            System.out.println ("\nGoodbye!");
            notDonePurchasing = false;
         }
         
      } // while
   } // main
} // TheaterSeatDriver


class TheaterSeatingChart
{  
  private int [][] seatingChart;
  private static final int NUMROWS = 9;
  private static final int NUMCOLUMNS = 10;
  
  // precondition: none
  // postcondition: a TheatreSeatingChart object is
  // created with the pre-stated prices
   public TheaterSeatingChart()
   {
      int[][] seatingChartConstruct = {
                             {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
                             {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
                             {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
                             {10, 10, 20, 20, 20, 20, 20, 20, 10, 10},
                             {10, 10, 20, 20, 20, 20, 20, 20, 10, 10},
                             {10, 10, 20, 20, 20, 20, 20, 20, 10, 10},
                             {20, 20, 30, 30, 40, 40, 30, 30, 20, 20},
                             {20, 30, 30, 40, 50, 50, 40, 30, 30, 20},
                             {30, 40, 50, 50, 50, 50, 50, 50, 40, 30}
                          };
      this.seatingChart = seatingChartConstruct;
   }
    
   // precondition: a TheaterSeatingChart object exists
   // postcondition: the chart is printed in the desired formatt
   public void printSeatingChart()
   {
      System.out.println("**************************************");
      System.out.print("Seat #: ");
      for (int i = 1; i<=NUMCOLUMNS; i++)
      {
         System.out.print(i + " ");
      }
      System.out.println();
      for (int i = 0; i<NUMROWS; i++)
      {
         System.out.print("Row " + (NUMROWS-i) + ": ");
         for (int element : this.seatingChart[i])
         {
            System.out.print(element + " ");
         }
         System.out.println();
      }
      System.out.println();
      System.out.println("\nLEGEND: " + "\nnumber represents ticket price" +
                       "\n-1 inidicates the seat has been sold" + 
                       "\n*********************************");
   
   }  // printSeatingChart
   

   
   
   // precondition: a valid, TheatreSeatingChart object is created
   // per the constructor
   // postcondition: a seat is selected and marked as purchased 
   // after a selection of seats was listed based on price preferred
   public void pickPrice()
   {  
      Scanner console = new Scanner (System.in);
      for (;;)
      {
      System.out.print("\nPlease input your preferred price: ");
      int price = console.nextInt();
      System.out.println();
      if(price == 10 || price == 20 || price == 30 || price == 40 || price == 50)
      {
         for (int i = 0; i<NUMROWS; i++)
         {
            for (int k = 0; k<NUMCOLUMNS; k++)
            {
               if(this.seatingChart[i][k] != -1 && this.seatingChart[i][k] == price)
               {
                  System.out.println("Row " + (NUMROWS-i) + ", Seat " + (k+1));
               }
            }
         }
         this.pickSeat(price);
         return;
      }
      else
      {
         System.out.println("I\'m sorry. The theater does not offer any seats for $" + price +
                          ". Please choose a ticket price from $10-$50.");
         continue;
      }
      }//for
   } // pickPrice
   
   
   
   
   // precondition: a valid, TheatreSeatingChart object is created
   // per the constructor
   // postcondition: a seat is selected and marked as purchased 
   // based on a selected seat row and column (row seat)
   public void pickSeat()
   {
      Scanner console = new Scanner (System.in);
      for (;;)
      {
         System.out.print("\nPlease input your preferred row. ");
         int row = console.nextInt();
         System.out.print("Please input your preferred seat. ");
         int column = console.nextInt();
         if (!(column > 0 && column < 11 && row >= 0 && row < 10))
         {
            System.out.println("\nYou chose a wrong seat!");
            continue;
         }
         else if (this.seatingChart[NUMROWS-row][column-1] == -1)
         {
            System.out.println("\nI\'m sorry, that seat has already been purchased");
            System.out.println("\nLet us start over again.");
            return;
         }
         else if (this.seatingChart[NUMROWS-row][column-1] != -1)
         {
            System.out.println("\nYou have purchased Seat " + column + " in Row " + row + " for $" + 
                             this.seatingChart[NUMROWS-row][column-1] + ". \nThank you!");
            this.seatingChart[NUMROWS-row][column-1] = -1;
            return;
         }
         else
         {
            System.out.println("\nYou chose a wrong seat!");
            continue;  
         }
      }  
   } // pickSeat
   
   // precondition: a valid, TheatreSeatingChart object is created
   // per the constructor, a price int is passed to method
   // postcondition: a seat is selected and marked as purchased 
   // based on a selected seat row and column (row seat), only if
   // the selected seat has a price equal to the price passed to 
   // the method
   public void pickSeat(int price)
   {
      Scanner console = new Scanner (System.in);
      for (;;)
      {
         System.out.print("\nPlease input your preferred row. ");
         int row = console.nextInt();
         System.out.print("Please input your preferred seat. ");
         int column = console.nextInt();
         if (!(column > 0 && column < 11 && row >= 0 && row < 10))
         {
            System.out.println("\nYou chose a wrong seat!");
            continue;
         }
         else if (this.seatingChart[NUMROWS-row][column-1] == -1)
         {
            System.out.println("\nI\'m sorry, that seat has already been purchased");
            System.out.println("\nLet us start over again.");
            return;
         }
         else if (this.seatingChart[NUMROWS-row][column-1] != -1 && this.seatingChart[NUMROWS-row][column-1] == price)
         {
            System.out.println("You have purchased Seat " + column + " in Row " + row + " for $" + 
                             this.seatingChart[NUMROWS-row][column-1] + ". \nThank you!");
            this.seatingChart[NUMROWS-row][column-1] = -1;
            return;
         }
         else
         {
            System.out.println("\nYou chose a wrong seat!");
            continue;  
         }
      }  
   } // pickSeat OVERLOADED METHOD
   
   // you might need to write some private methods for this class for
   // internal use only

} // TheaterSeatingChart

/*Outputs
For Outputs:

In Case 1, a row 2 seat 3 is purchased based on user input

In Case 2, it is assumed the desired input when warned was row 2 seat 8
as opposed to row 8 seat 2. This is due to the program design being believed
to have pickPrice() only allow the user to pick seats under the selected price.

In Case 3, upon picking row 2 seat 3, an already purchased seat, the program
prompts the user to pick a new seat by 'starting over'. Then the user tries
to select a seat that doesn't exist. Then the user does that again. Then
the user selects and purchases and a valid seat.

In Case 4, the user ends the program by selecting 1 for No.

 ----jGRASP exec: java PD5WilliamMcNultyTheaterSeatDriver
 **************************************
 Seat #: 1 2 3 4 5 6 7 8 9 10 
 Row 9: 10 10 10 10 10 10 10 10 10 10 
 Row 8: 10 10 10 10 10 10 10 10 10 10 
 Row 7: 10 10 10 10 10 10 10 10 10 10 
 Row 6: 10 10 20 20 20 20 20 20 10 10 
 Row 5: 10 10 20 20 20 20 20 20 10 10 
 Row 4: 10 10 20 20 20 20 20 20 10 10 
 Row 3: 20 20 30 30 40 40 30 30 20 20 
 Row 2: 20 30 30 40 50 50 40 30 30 20 
 Row 1: 30 40 50 50 50 50 50 50 40 30 
 
 
 LEGEND: 
 number represents ticket price
 -1 inidicates the seat has been sold
 *********************************
 
 Do you want to purchase a ticket? 
 Enter 0 for Yes, 1 for No: 0
 
 ** LET US START **
 Would you like to choose a seat by number or by price? 
 Enter 1 for "Choose by number", 2 for "Choose by price": 1
 
 Please input your preferred row. 2
 Please input your preferred seat. 3
 
 You have purchased Seat 3 in Row 2 for $30. 
 Thank you!
 **************************************
 Seat #: 1 2 3 4 5 6 7 8 9 10 
 Row 9: 10 10 10 10 10 10 10 10 10 10 
 Row 8: 10 10 10 10 10 10 10 10 10 10 
 Row 7: 10 10 10 10 10 10 10 10 10 10 
 Row 6: 10 10 20 20 20 20 20 20 10 10 
 Row 5: 10 10 20 20 20 20 20 20 10 10 
 Row 4: 10 10 20 20 20 20 20 20 10 10 
 Row 3: 20 20 30 30 40 40 30 30 20 20 
 Row 2: 20 30 -1 40 50 50 40 30 30 20 
 Row 1: 30 40 50 50 50 50 50 50 40 30 
 
 
 LEGEND: 
 number represents ticket price
 -1 inidicates the seat has been sold
 *********************************
 
 Do you want to purchase a ticket? 
 Enter 0 for Yes, 1 for No: 0
 
 ** LET US START **
 Would you like to choose a seat by number or by price? 
 Enter 1 for "Choose by number", 2 for "Choose by price": 2
 
 Please input your preferred price: 5
 
 I'm sorry. The theater does not offer any seats for $5. Please choose a ticket price from $10-$50.
 
 Please input your preferred price: 60
 
 I'm sorry. The theater does not offer any seats for $60. Please choose a ticket price from $10-$50.
 
 Please input your preferred price: 30
 
 Row 3, Seat 3
 Row 3, Seat 4
 Row 3, Seat 7
 Row 3, Seat 8
 Row 2, Seat 2
 Row 2, Seat 8
 Row 2, Seat 9
 Row 1, Seat 1
 Row 1, Seat 10
 
 Please input your preferred row. 9
 Please input your preferred seat. 1
 
 You chose a wrong seat!
 
 Please input your preferred row. 8
 Please input your preferred seat. 2
 
 You chose a wrong seat!
 
 Please input your preferred row. 2
 Please input your preferred seat. 8
 You have purchased Seat 8 in Row 2 for $30. 
 Thank you!
 **************************************
 Seat #: 1 2 3 4 5 6 7 8 9 10 
 Row 9: 10 10 10 10 10 10 10 10 10 10 
 Row 8: 10 10 10 10 10 10 10 10 10 10 
 Row 7: 10 10 10 10 10 10 10 10 10 10 
 Row 6: 10 10 20 20 20 20 20 20 10 10 
 Row 5: 10 10 20 20 20 20 20 20 10 10 
 Row 4: 10 10 20 20 20 20 20 20 10 10 
 Row 3: 20 20 30 30 40 40 30 30 20 20 
 Row 2: 20 30 -1 40 50 50 40 -1 30 20 
 Row 1: 30 40 50 50 50 50 50 50 40 30 
 
 
 LEGEND: 
 number represents ticket price
 -1 inidicates the seat has been sold
 *********************************
 
 Do you want to purchase a ticket? 
 Enter 0 for Yes, 1 for No: 0
 
 ** LET US START **
 Would you like to choose a seat by number or by price? 
 Enter 1 for "Choose by number", 2 for "Choose by price": 1
 
 Please input your preferred row. 2
 Please input your preferred seat. 3
 
 I'm sorry, that seat has already been purchased
 
 Let us start over again.
 **************************************
 Seat #: 1 2 3 4 5 6 7 8 9 10 
 Row 9: 10 10 10 10 10 10 10 10 10 10 
 Row 8: 10 10 10 10 10 10 10 10 10 10 
 Row 7: 10 10 10 10 10 10 10 10 10 10 
 Row 6: 10 10 20 20 20 20 20 20 10 10 
 Row 5: 10 10 20 20 20 20 20 20 10 10 
 Row 4: 10 10 20 20 20 20 20 20 10 10 
 Row 3: 20 20 30 30 40 40 30 30 20 20 
 Row 2: 20 30 -1 40 50 50 40 -1 30 20 
 Row 1: 30 40 50 50 50 50 50 50 40 30 
 
 
 LEGEND: 
 number represents ticket price
 -1 inidicates the seat has been sold
 *********************************
 
 Do you want to purchase a ticket? 
 Enter 0 for Yes, 1 for No: 0
 
 ** LET US START **
 Would you like to choose a seat by number or by price? 
 Enter 1 for "Choose by number", 2 for "Choose by price": 1
 
 Please input your preferred row. 9
 Please input your preferred seat. 11
 
 You chose a wrong seat!
 
 Please input your preferred row. 1
 Please input your preferred seat. 11
 
 You chose a wrong seat!
 
 Please input your preferred row. 9
 Please input your preferred seat. 2
 
 You have purchased Seat 2 in Row 9 for $10. 
 Thank you!
 **************************************
 Seat #: 1 2 3 4 5 6 7 8 9 10 
 Row 9: 10 -1 10 10 10 10 10 10 10 10 
 Row 8: 10 10 10 10 10 10 10 10 10 10 
 Row 7: 10 10 10 10 10 10 10 10 10 10 
 Row 6: 10 10 20 20 20 20 20 20 10 10 
 Row 5: 10 10 20 20 20 20 20 20 10 10 
 Row 4: 10 10 20 20 20 20 20 20 10 10 
 Row 3: 20 20 30 30 40 40 30 30 20 20 
 Row 2: 20 30 -1 40 50 50 40 -1 30 20 
 Row 1: 30 40 50 50 50 50 50 50 40 30 
 
 
 LEGEND: 
 number represents ticket price
 -1 inidicates the seat has been sold
 *********************************
 
 Do you want to purchase a ticket? 
 Enter 0 for Yes, 1 for No: 1
 
 Goodbye!
 
  ----jGRASP: operation complete.
outputs*/