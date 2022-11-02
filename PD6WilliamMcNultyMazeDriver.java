/*********************************************************************************
NAME: William McNulty
PERIOD: 6
DATE SUBMITTED: 9:30/10:00PM - 10/20/22
DUE DATE: 8:00 AM - 10/21/22
ASSIGNMENT: Maze Lab / Maze Solver

PURPOSE OF THE LAB: 
Given a txt file of a maze solve it and mark the path, also be able to count and print
the number of steps in the path. Our class was assigned this lab to teach us recursive 
principles and experiment with recursive backtracking.


-MISTAKES MADE:
At first I thought of the program without backtracking and gained an idea of how the program
would work, then I moved to approach it with backtracking and ended up getting consistent 
false returns, the path would always not exist. Then I was able to get it to find the path, but
it made every dot a star, that was kind of frustrating so I thought more on the backtracking.
Eventually I concluded that the return type was a boolean so I can only consider the case that 
returns true from the recursion and have that change all of its path to the STEP '*', while the 
false returns would change back to dots.
-NEW CONCEPTS LEARNED:
I learned about recursive back tracking and how to utiliize a recursive method's return value
-HOW I FEEL ABOUT THIS LAB: 
This lab was slightly more challenging given the backtracking aspect, but was a very fun lab.
-CREDITS: 
Mr. Lau in class, Rubber Ducky
-STUDENTS WHOM I HELPED: 
nobody
*/

import java.util.*;
import java.io.*;
public class PD6WilliamMcNultyMazeDriver
{
   public static void main(String[] args) throws FileNotFoundException
   {
      Scanner sc = new Scanner(System.in);
      char[][] retArr;
      Maze m;
   
      System.out.println();
      
      for (;;)
      {
         System.out.print("\nEnter the maze's filename (file extension not needed): ");
         retArr = buildCharArr(sc.next());
         m = new Maze(retArr);
         System.out.println ("Maze: ");
         m.display();
         
         System.out.println("\nWhat do you want to do (choose 1, 2, or 3):");
         System.out.println("   1: Mark only the correct path.");
         System.out.println("   2: Mark only the correct path, and display the count of STEPs.");
         System.out.println("   3: Exit");
      
         m.solve(sc.nextInt());
         
         m.display();  
      } // for
   } // main
   
   // postcondition: take in a filename (without .txt), and return a char[][]
   public static char[][] buildCharArr(String fileName) throws FileNotFoundException
   {
      Scanner sc = new Scanner(new File(fileName + ".txt"));
      char[][] board = new char[sc.nextInt()][sc.nextInt()];
      for(int i = 0; i < board.length; i++) {
         String row = sc.next();
         board[i] = row.toCharArray();
      }
      return board;
   }  // buildCharArr
   
   private static void transfer2DGridToFile (char [][] m) throws FileNotFoundException
   {
      System.out.print ("Enter the name of the output file? \nUse 'txt' as the file extension: ");
      Scanner input = new Scanner (System.in);
      String name = input.next();
      File outputFile = new File (name);
      if (outputFile.exists())
      {
         System.out.println (name + "already exists");
         System.exit(1);
      }
      
      PrintWriter pw = new PrintWriter (outputFile);  
      
      System.out.println ("Enter the dimensions (row and column) of the random maze (separated the numbers with a space): ");
      pw.println(input.next() + " " + input.next());
   
      // transfer the 2D grid to the .txt text file
      for (char [] row : m)
      {
         pw.println (row);
      } 
      pw.close();
   
   } // transfer2DGridToFile

}  //PD6WilliamMcNultyMazeDriver


class Maze
{
   //Constants
   private final char WALL = 'W';
   private final char DOT = '.';
   private final char START = 'S';
   private final char EXIT = 'E';
   private final char STEP = '*';
   //fields
   private char[][] maze;
   private int startRow, startCol;  // store where the start location is
   private boolean S_Exists=false, E_Exists=false;
   
   /** Initializes all the field of a Maze object: maze, startRow, startCol
   */
   public Maze(char[][] inCharArr)    
   {
      maze = inCharArr;
      for (int r = 0; r < maze.length; r++){
         for(int c = 0; c < maze[0].length; c++){
            if (inCharArr[r][c]=='S'){
               startRow = r;
               startCol = c;
            }
         }
      }
   }  // Maze
   
   /**
   */
   public void display()
   {
      if(maze==null) 
         return;
      for(int a = 0; a<maze.length; a++)
      {
         for(int b = 0; b<maze[0].length; b++)
         {
            System.out.print(maze[a][b]);
         }
         System.out.println("");
      }
      System.out.println("");
   }  // display
   
   /**
   */
   public void solve(int n)
   {
      final int FIND_PATH = 1;
      final int FIND_PATH_AND_COUNT_PATH_LENGTH = 2;
      final int QUIT = 3;
   
      if(n == FIND_PATH)
      {
         if (!markTheCorrectPath(startRow, startCol))
            System.out.println ("No Path found!");
      }
      else if(n == FIND_PATH_AND_COUNT_PATH_LENGTH)
      {
         if (!markCorrectPathAndCountStars(startRow, startCol, 0))
            System.out.println ("No Path found!");
      
      }
      else if (n == QUIT)
      {
         System.out.println("Goodbye!\n"); 
         System.exit (0);
      }
        
      else System.out.println("Invalid choice\n");
   }  // solve
   
   /**
     precondition:passed to an instantiated Maze object with a maze array,
                  int r is startRow and int c is startCol
     postcondition: The maze array is changed with the path now marked with STEP
                    '*' and the. Returns if a path is found
    */
   private boolean markTheCorrectPath(int r, int c)
   {
      if (r<0||c<0||r==maze.length||c==maze[0].length||maze[r][c]==STEP||maze[r][c]==WALL||maze[r][c]=='O')
         return false;
      else if(maze[r][c]==EXIT)
         return true;
      maze[r][c]='O';
      boolean isPath=markTheCorrectPath(r + 1, c)||markTheCorrectPath(r - 1, c)||
                     markTheCorrectPath(r, c + 1)||markTheCorrectPath(r, c - 1);
      if (isPath){       
         maze[r][c]=STEP;
         maze[startRow][startCol]=START;
      }
      else 
         maze[r][c]=DOT;          
      return isPath;
      } // markTheCorrectPath
   
   /**
     precondition: A maze object is instantiated, the count is zero on first call
                   int r and int c are the Startrow and startCol of the maze
     postcondition: The maze array is changed with the path now marked with STEP
                    '*' and the number of steps from start to end in path are
                    printed. Returns if a path is found.
                    
    */
   private boolean markCorrectPathAndCountStars(int r, int c, int count)
   {
      if (r<0||c<0||r==maze.length||c==maze[0].length||maze[r][c]==STEP||maze[r][c]==WALL||maze[r][c]=='O')
         return false;
      else if(maze[r][c]==EXIT){
         System.out.println("Number of Steps: " + count);
         return true;
      }
      count++;
      maze[r][c]='O';//temporary marker
      boolean isPath = markCorrectPathAndCountStars(r + 1, c, count)||markCorrectPathAndCountStars(r - 1, c, count)||
                     markCorrectPathAndCountStars(r, c + 1, count)||markCorrectPathAndCountStars(r, c - 1, count);
      if (isPath){
         maze[r][c]=STEP;
         maze[startRow][startCol]=START;
      }
      else //backtracking case
         maze[r][c]=DOT;
      return isPath;
   } // markCorrectPathAndCountStars
   

}
  /*
  OUTPUTS:
  
       ----jGRASP exec: java PD6WilliamMcNultyMazeDriver
 
 
 Enter the maze's filename (file extension not needed): maze1
 Maze: 
 WWWWWWWW
 W....W.W
 WW.WW..W
 W....W.W
 W.W.WW.E
 S.W.WW.W
 WW.....W
 WWWWWWWW
 
 
 What do you want to do (choose 1, 2, or 3):
    1: Mark only the correct path.
    2: Mark only the correct path, and display the count of STEPs.
    3: Exit
 2
 Number of Steps: 14
 WWWWWWWW
 W....W.W
 WW.WW..W
 W***.W.W
 W*W*WW*E
 S*W*WW*W
 WW.****W
 WWWWWWWW
 
 
 Enter the maze's filename (file extension not needed): maze2
 Maze: 
 WWWSWWWWWW
 W....W.W.W
 WWWW.....W
 W...W.WW.W
 W.W....W.W
 WEWWWWWWWW
 
 
 What do you want to do (choose 1, 2, or 3):
    1: Mark only the correct path.
    2: Mark only the correct path, and display the count of STEPs.
    3: Exit
 2
 Number of Steps: 13
 WWWSWWWWWW
 W..**W.W.W
 WWWW**...W
 W***W*WW.W
 W*W***.W.W
 WEWWWWWWWW
 
 
 Enter the maze's filename (file extension not needed): maze3
 Maze: 
 ..WW
 W..S
 E.WW
 
 
 What do you want to do (choose 1, 2, or 3):
    1: Mark only the correct path.
    2: Mark only the correct path, and display the count of STEPs.
    3: Exit
 2
 Number of Steps: 4
 ..WW
 W**S
 E*WW
 
 
 Enter the maze's filename (file extension not needed): maze5NoPath
 Maze: 
 WWEWW
 W...W
 W.W.X
 WWWWW
 
 
 What do you want to do (choose 1, 2, or 3):
    1: Mark only the correct path.
    2: Mark only the correct path, and display the count of STEPs.
    3: Exit
 2
 No Path found!
 WWEWW
 W...W
 W.W.X
 WWWWW
 
 
 Enter the maze's filename (file extension not needed): maze6NoPath
 Maze: 
 WWWWW
 W...W
 W.W.W
 S.WWE
 WWWWW
 
 
 What do you want to do (choose 1, 2, or 3):
    1: Mark only the correct path.
    2: Mark only the correct path, and display the count of STEPs.
    3: Exit
 2
 No Path found!
 WWWWW
 W...W
 W.W.W
 ..WWE
 WWWWW
 
 
 Enter the maze's filename (file extension not needed): maze1
 Maze: 
 WWWWWWWW
 W....W.W
 WW.WW..W
 W....W.W
 W.W.WW.E
 S.W.WW.W
 WW.....W
 WWWWWWWW
 
 
 What do you want to do (choose 1, 2, or 3):
    1: Mark only the correct path.
    2: Mark only the correct path, and display the count of STEPs.
    3: Exit
 1
 WWWWWWWW
 W....W.W
 WW.WW..W
 W***.W.W
 W*W*WW*E
 S*W*WW*W
 WW.****W
 WWWWWWWW
 
 
 Enter the maze's filename (file extension not needed): maze2
 Maze: 
 WWWSWWWWWW
 W....W.W.W
 WWWW.....W
 W...W.WW.W
 W.W....W.W
 WEWWWWWWWW
 
 
 What do you want to do (choose 1, 2, or 3):
    1: Mark only the correct path.
    2: Mark only the correct path, and display the count of STEPs.
    3: Exit
 1
 WWWSWWWWWW
 W..**W.W.W
 WWWW**...W
 W***W*WW.W
 W*W***.W.W
 WEWWWWWWWW
 
 
 Enter the maze's filename (file extension not needed): maze3
 Maze: 
 ..WW
 W..S
 E.WW
 
 
 What do you want to do (choose 1, 2, or 3):
    1: Mark only the correct path.
    2: Mark only the correct path, and display the count of STEPs.
    3: Exit
 1
 ..WW
 W**S
 E*WW
 
 
 Enter the maze's filename (file extension not needed): maze5NoPath
 Maze: 
 WWEWW
 W...W
 W.W.X
 WWWWW
 
 
 What do you want to do (choose 1, 2, or 3):
    1: Mark only the correct path.
    2: Mark only the correct path, and display the count of STEPs.
    3: Exit
 1
 No Path found!
 WWEWW
 W...W
 W.W.X
 WWWWW
 
 
 Enter the maze's filename (file extension not needed): maze6NoPath
 Maze: 
 WWWWW
 W...W
 W.W.W
 S.WWE
 WWWWW
 
 
 What do you want to do (choose 1, 2, or 3):
    1: Mark only the correct path.
    2: Mark only the correct path, and display the count of STEPs.
    3: Exit
    
 
 