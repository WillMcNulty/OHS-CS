/***********************************************************************************************************************************************
 * Name: William McNulty
 * Period: 6
 * Name of the Lab: AreaFill
 * Purpose of the Program: Given a grid of characters, change all characters of a type to "*"
 * Due Date: 9/30/22
 * Date Submitted: 9/29/22
 * What I learned: 
 * 1. I learned about using exceptions to orient code to be more understandable and simple
 * 2. I learned about using recursion for search
 * How I feel about this lab: This lab was easy and a lot of fun
 * 
 * What I wonder: How can we expand this lab to have more features
 *
 * Student(s) who helped me (to what extent): 
 * Student(s) whom I helped (to what extent): 
 *************************************************************************************************************************************************/

   
import java.util.Scanner;
import java.io.*;
public class PD6WilliamMcNultyAreaFill_shell
{
   public static char[][] grid = null;
   
   public static void main(String[] args) throws FileNotFoundException
   {
      Scanner sc = new Scanner(System.in);
      System.out.print("Filename: ");
      String filename = sc.next();
      grid = read(filename + ".txt");
      display(grid);
      System.out.print("\nEnter ROW COL to fill from: ");
      int row = sc.nextInt();
      int col = sc.nextInt(); 
      fill(grid, row, col, grid[row][col]);
      display(grid);
      sc.close();
   }
   public static char[][] read(String filename)throws FileNotFoundException
   {
      Scanner sc = new Scanner(new File(filename));
      char[][] board = new char[sc.nextInt()][sc.nextInt()];
      for(int i = 0; i < board.length; i++) {
         String row = sc.next();
         board[i] = row.toCharArray();
      }
      return board;
   }
   
   public static void display(char[][] g)
   {              
      for(int i = 0; i < g.length; i++) {
         for(int j = 0; j < g[i].length; j++) {
            System.out.print(g[i][j]);
         }
         System.out.println();
      }
   }
   
          /**
        * pre: method called in main method
        * post: modifies char[][] g and replaces characters of the 
        * index indicated on the grid with a *
        * @param g
        * @param r
        * @param c
        * @param ch
        */

   public static void fill(char[][] g, int r, int c, char ch) //recursive method
   {       
      try{
      if (g[r][c]==ch){
         g[r][c]='*';
         fill(g, r+1, c, ch);
         fill(g, r, c+1, ch);
         fill(g, r, c-1, ch);
         fill(g, r-1, c, ch);
         }
      }
      catch (IndexOutOfBoundsException e){
         
      }
      
   }// fill
}