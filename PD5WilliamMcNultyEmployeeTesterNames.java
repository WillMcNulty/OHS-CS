/**********************************************************************************************************************************************
Name (Full Name): William McNulty   Period:   5
Name of the Lab/Assignment: EmployeeTesterNames
Purpose of the program: 
   -To reformat names of employees
   -To learn about using methods that return one dimensional arrays
   -To simulate having to create a program that has to fit a "bosses" design
   
Date: 1/30/2022         
What I Learned:  
   -I learned how to use enhanced for loops
   -I learned how to traverse, create, and use data from one dimensional arrays
   -I learned how to write methods that return one dimensional arrays

What I Wonder:
   -This lab was formatted in a way of you had to make your program under a "bosses" rules. I like this, and wonder how a "bosses" 
    guidelines can effect a programmer's code/project (Making it harder or easier)
   -I wonder what kind of challenge reformatting a two (or larger) dimensional array is like.
   -I wonder how the reformatting of a one dimensional array like this list of names, compares to reformatting a two dimensional grid
    like compressing an image file

The credits: Mr. Lau -taught me in class-
Students (names) you helped and to what extent:  
**********************************************************************************************************************************************/
import java.util.*;

public class PD5WilliamMcNultyEmployeeTesterNames
{
   public static void main (String[] args)
   {
      String[] lastNames = new String[] {"Smith", "Davidson", "Lau", "Roberts", "Simpson", "Balboa", "Han"};
      String[] formattedNames = new String[lastNames.length];
      formattedNames = EmployeeNames.convertName(lastNames);
      for (String item : formattedNames)
      {
         System.out.println(item);
      }
   }
} //EmployeeTesterNames

class EmployeeNames
{
   //pre-a one dimensional string array is passed to method
   //each string is 2 or more characters
   //post-a reformatted one dimensional string array is returned
   //purpose- to reformat an array of lastnames into a company's
   //desired format
   public static String[] convertName(String[] names)
   {
      int index = 0;
      String[] formattedNames = new String[names.length];
      for (String item : names)
      {
         String newName = "";
         newName = item.substring(item.length()-1) + ". " + item.substring(item.length()-2, item.length()-1) +
         ". " + item;
         formattedNames[index] = newName;
         index++;
      }
      return formattedNames;
   } //convertName
} //EmployeeNames

/*
Outputs:
h. t. Smith
n. o. Davidson
u. a. Lau
s. t. Roberts
n. o. Simpson
a. o. Balboa
n. a. Han

*/