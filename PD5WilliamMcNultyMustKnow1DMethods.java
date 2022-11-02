/**********************************************************************************************************************************************
Name (Full Name): William McNulty   Period:   5
Name of the Lab/Assignment: MustKnow1DMethods
Purpose of the program: 
   -
   -
   -
   
Date: 2/2/2022         
What I Learned:  
   -
   -
   -

What I Wonder:
   -
   -
   -

The credits: Mr. Lau -taught me in class-
Students (names) you helped and to what extent:  
**********************************************************************************************************************************************/
public class PD5WilliamMcNultyMustKnow1DMethods
{
   public static void main (String [] args)
   {
      // when you test your program, modify a accordingly or create
      // other integer arrays for testing purposes
      int [] a = {5,4,3,2,1};
      
      System.out.println(inIncreasingOrder(a));
      System.out.println(inDecreasingOrder(a)); 
      
      print (a);
   
   } // main
   
   // precondition: a.length >= 1 and a is an integer array
   // postcondition: return true if elements in a are in ascending order; otherwise, returns false
   public static boolean inIncreasingOrder (int [] a)
   {
      int last = a[0];
      for (int i = 1; i < a.length; i++)
      {
         if (a[i] <= last)
         {
            return false;
         }
         last = a[i];
      }
      return true;
   }  // inIncreasingOrder
   
   
   // precondition: a.length >= 1 and a is an integer array
   // postcondition: return true if elements in a are in descending order; otherwise, returns false
   public static boolean inDecreasingOrder (int [] a)
   {
      int last = a[0];
      for (int i = 1; i < a.length; i++)
      {
         if (a[i] >= last)
         {
            return false;
         }
         last = a[i];
      }
      return true;
   } // inDecreasingOrder
   
   // precondition: a has been properly initialized and is an integer array
   // postcondition: print out the elements of a and insert a space between adjacent elements
   public static void print (int [] a)
   {
      for (int item : a)
      {
         System.out.print(item + " ");
      }
      /*
      for (int item : a)
      {
         System.out.print(item + " ");
      }
      System.out.println("\n" + inIncreasingOrder(a) + "\n" + inDecreasingOrder(a));
      */
   } // print
} // MustKnow1DMethods

/* 
Outputs:

true
false
1 2 3 4 5

false
false
1 1 3 4 5

false
true
5 4 3 2 1
*/