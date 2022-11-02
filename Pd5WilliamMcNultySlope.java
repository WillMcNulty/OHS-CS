/****************************************************
Name (Full Name): William McNulty   Period:   5
Name of the Lab/Assignment:  Slope
Purpose of the program: 
   -To calculate the slope of a line and the equation of
    the same line given two points
   -To learn use of if statements and conditionals in a 
    program
   
Date: 10/12/2021         
What I Learned:  
   -I learned how to use if-statements and to nest/link them
    to create chains that can execute different sequences
    and also to eliminate undesired paths/inputs
    (a user entering the same points twice)
   -
   
What I Wonder:
   -I wonder how we can use different kinds of loops with
    conditionals to break programs when non-desired
    inputs occur (breaking the program after same points
    are entered, causing the program to prompt again)
   -

The credits: 
   -Mr. Lau -taught me in class-
Students (names) you helped and to what extent: 
   -In class helping Alden with how conditionals
    are set up and how the boolean/logic operators
    work
****************************************************/

import java.util.Scanner;
import java.text.DecimalFormat;

public class Pd5WilliamMcNultySlope
{
   public static void main (String [] args)
   {
      //declarations
      Scanner input = new Scanner (System.in);
      
      double slope; //the slope of the line
      int y1; //y-value of point 1
      int y2; //y-value of point 2
      int x1; //x-value of point 1
      int x2; //x-value of point 2
      double intercept; //the y intercept value
      
      DecimalFormat d = new DecimalFormat ("0.0"); //one space decimal format
      
      for ( int i = 1; i<=5; i++ ) { //loop the program five times
         
         //prompts and assignment
         System.out.print("Enter the coordinates of point 1 with a space between x y: ");
         x1 = input.nextInt();
         y1 = input.nextInt();
      
         System.out.print("Enter the coordinates of point 2 with a space between x y: ");
         x2 = input.nextInt();
         y2 = input.nextInt();
      
         //conditionals checking if have same values
         if (y1 == y2 && x1 != x2) //horizontal line
         {
            System.out.println("Alert! The line is horizontal.");
            System.out.println("Equation of the line: y = " + d.format(y1) + "\n");
         }
         else if (y1 != y2 && x1 == x2) //vertical line
         {
            System.out.println("Alert! The line is vertical.");
            System.out.println("Equation of the line: x = " + d.format(x1) + "\n");
         }
         else if (y1 == y2 && x1 == x2) //same coordinates entered
         {
            System.out.println("These points are the same! Invalid output.");
            System.out.println("Equation of the line: there is not a unique line through these points \n");
         }
         else //the line is a valid function
         {
            slope = (double)(y2 - y1) / (x2 - x1); //find slope, the slope of the line
            intercept = y1 - slope*x1; //find intercept, the y-int
        
            //determine text formatting depending on the value of the intercept
            if (intercept > 0) //the y-intercept is positive use the "+" sign
            {
               System.out.println("Equation of the line: y = " + d.format(slope) + "x + " + d.format(Math.abs(intercept)) + "\n");
            }
            else if (intercept < 0) //the y-intercept is negative use the "-" sign
            {
               System.out.println("Equation of the line: y = " + d.format(slope) + "x - " + d.format(Math.abs(intercept)) + "\n");
            }
            else //the y-intercept is zero do not include it
            {
               System.out.println("Equation of the line: y = " + d.format(slope) + "x\n");
            }


         }
      } //loop
      
   } //main
} //Pd5WilliamMcNultySlope

/***************************************************************************
Enter the coordinates of point 1 with a space between x y: 6 -8
Enter the coordinates of point 2 with a space between x y: 6 12
Alert! The line is vertical.
Equation of the line: x = 6.0

Enter the coordinates of point 1 with a space between x y: -3 7
Enter the coordinates of point 2 with a space between x y: 5 7
Alert! The line is horizontal.
Equation of the line: y = 7.0

Enter the coordinates of point 1 with a space between x y: -1 -2
Enter the coordinates of point 2 with a space between x y: 1 1
Equation of the line: y = 1.5x - 0.5

Enter the coordinates of point 1 with a space between x y: 1 3
Enter the coordinates of point 2 with a space between x y: 2 6
Equation of the line: y = 3.0x

Enter the coordinates of point 1 with a space between x y: 2 3
Enter the coordinates of point 2 with a space between x y: 2 3
These points are the same! Invalid output.
Equation of the line: there is not a unique line through these points 

Enter the coordinates of point 1 with a space between x y: 6 9
Enter the coordinates of point 2 with a space between x y: 5 8
Equation of the line: y = 1.0x + 3.0

Enter the coordinates of point 1 with a space between x y: 10 8
Enter the coordinates of point 2 with a space between x y: 4 6
Equation of the line: y = 0.3x + 4.7

Enter the coordinates of point 1 with a space between x y: -3 -8
Enter the coordinates of point 2 with a space between x y: -4 -10
Equation of the line: y = 2.0x - 2.0

Enter the coordinates of point 1 with a space between x y: 0 8
Enter the coordinates of point 2 with a space between x y: 9 0
Equation of the line: y = -0.9x + 8.0

Enter the coordinates of point 1 with a space between x y: 7 6
Enter the coordinates of point 2 with a space between x y: 5 4
Equation of the line: y = 1.0x - 1.0
***************************************************************************/
