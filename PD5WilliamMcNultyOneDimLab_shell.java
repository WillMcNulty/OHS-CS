  /*****************************************************************************************************************
NAME: William McNulty
PERIOD: 5
DUE DATE: IN CLASS 1/14/2022

PURPOSE: Practice creating array methods  

WHAT I LEARNED: Null 
         
CREDITS (BE SPECIFIC: FRIENDS, PEERS, ONLINE WEBSITE): 
IN CLASS
****************************************************************************************************************/

public class PD5WilliamMcNultyOneDimLab_shell
{
   public static void main(String[] args)
   {
      int [] array = {15, -5, 25, 75, 9, -2, -80, -100, 99, 21, 23, 40, 45, 67,
                       100, 44, 28, 1, 3};
                                  
      System.out.println ("Max: " + findMax(array));
      System.out.println ("Min: " + findMin(array));
      System.out.println ("MaxIndex: " + findMaxIndex(array));
      System.out.println ("MinIndex: " + findMinIndex(array));
      System.out.println ("Search result: " + find (array, 3));
   
      System.out.print ("Positive array: " );
      printArray (posArray(array));
      System.out.println();
      System.out.print ("Negative array: " );
      printArray (negArray(array));
      System.out.println();
   				   
      System.out.print ("Even members array: " );
      printArray (evenMembers(array));
      System.out.println();  
      System.out.print ("Odd members array: " );
      printArray (oddMembers(array));
      System.out.println(); 			
          
      System.out.println("Sum : " + sum(array));
      System.out.println("Avg : " + average(array));
   
   }  // main

   // postcondition: find and return the max element in a
   public static  int findMax(int [] a)
   {
      int max = a[0];
      for (int item : a)
      {
         if (item > max)
         {
            max = item;
         } 
      }
      return max;
   }
   // postcondition: find and return the index of the max element in a
   public static int findMaxIndex(int [] a)
   {
      int indexTarget = findMax(a);
      int indexCounter = 0;
      for (int item : a)
      {
         if (item == indexTarget)
         {
            return indexCounter;
         }
         indexCounter++;
      }
      return -1; //condition for if non existent
   }

   // postcondition: find and return the min element in a
   public static int findMin(int [] a)
   {
      int min = a[0];
      for (int item : a)
      {
         if (item < min)
         {
            min = item;
         } 
      }
      return min;
   }
   // postcondition: find and return the index of the min element in a
   public static int findMinIndex(int [] a)
   {
      int indexTarget = findMin(a);
      int indexCounter = 0;
      for (int item : a)
      {
         if (item == indexTarget)
         {
            return indexCounter;
         }
         indexCounter++;
      }
      return -1; //condition for if non existent
   }

   // postcondition: check to see if target can be found in a or not.  If yes, return
   //                true; otherwise, returns false.
   public static boolean find (int [] a, int target)
   {
      boolean checker = false;
      for (int item : a)
      {
         if (item == target)
         {
            checker = true;
         }
      }
      return checker;	
   } 
   
   // postcondition: put all the negative numbers in an array and return it
   // Hint: 
   // Step 1: Use a for loop to find out how many negative numbers are in parameter a
   // Step 2: Use that number to create an int array of that size
   // Step 3: Use a for loop to traverse a and whenever a negative number is found,
   //             store that number in the newly created negative array.
   public static int [] negArray (int [] a)
   {
      int negCount = 0;
      int negIndex = 0;
      for (int item : a)
      {
         if (item < 0)
         {
            negCount++;
         }
      }
      int[] negList = new int[negCount];
      for (int item : a)
      {
         if (item < 0)
         {
            negList[negIndex] = item;
            negIndex++;
         }
      }
      
      return negList;      // null is a reference used in Java
   }

   // postcondition: put all the positive numbers in a in an array and return the array
   public static int [] posArray(int [] a)
   {
      int posCount = 0;
      int posIndex = 0;
      for (int item : a)
      {
         if (item > 0)
         {
            posCount++;
         }
      }
      int[] posList = new int[posCount];
      for (int item : a)
      {
         if (item > 0)
         {
            posList[posIndex] = item;
            posIndex++;
         }
      }
      
      return posList;
   }
	
   // postcondition: sum up all the numbers in a and return the sum
   public static int sum (int [] a)
   {
      int sum = 0;
      for (int item : a)
      {
         sum += item;
      }
      return sum;
   }
   // postcondition: find the average of all the numbers in a 
   public static double average(int [] a)
   {
      return sum(a) / a.length;
   }
	
   // postcondition: put all the even numbers in a in an array and return the array
   public static int [] evenMembers(int [] a)
   {
      int evenCount = 0;
      int evenIndex = 0;
      for (int item : a)
      {
         if (item % 2 == 0)
         {
            evenCount++;
         }
      }
      int[] evenList = new int[evenCount];
      for (int item : a)
      {
         if (item % 2 == 0)
         {
            evenList[evenIndex] = item;
            evenIndex++;
         }
      }
      
      return evenList;
   	
   }
	
   // postcondition: put all the odd numbers in a in an array and return the array	 
   public static  int [] oddMembers(int [] a)
   {
      int oddCount = 0;
      int oddIndex = 0;
      for (int item : a)
      {
         if (item % 2 == 1)
         {
            oddCount++;
         }
      }
      int[] oddList = new int[oddCount];
      for (int item : a)
      {
         if (item % 2 == 1)
         {
            oddList[oddIndex] = item;
            oddIndex++;
         }
      }
      
      return oddList;
   }
	
   // postcondition: print all the elements in a onto the screen
   // Suggestion: practice using for-each loop
   public static void printArray (int [] a)
   {
      /*
      for (int i = 0; i < a.length; i++)
         System.out.print (a[i] + " ");  // don't use println
      */
      for (int item : a)
      {
         System.out.print(item + " ");
      }
   }

}