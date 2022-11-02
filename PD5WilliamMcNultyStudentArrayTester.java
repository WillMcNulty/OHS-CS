/**********************************************************************************************************************************************
Name (Full Name): William McNulty   Period:   5
Name of the Lab/Assignment: StudentArrayTester
Purpose of the program: 
   -Create, Analyze, and Change an array representative of a Student Body
   -Practice declaring, creating, altering, using, and traversing one dimensional arrays
   -Practice using enhanced for loops and search algorithims
   
Date: 1/30/2022         
What I Learned:  
   -I learned how to use enhanced for loops and search algorithims effciently
   -I learned how
   -

What I Wonder:
   -I wonder how this could be used for oakton as a whole, or for specific classes to rank students and track academic performance
   -I wonder how I could create a program similar to this but designed to track a sports team, and how players compare/rank
   -I wonder how a two dimensional array would be used to track students performance (perhaps comparing additional aspects)

The credits: Mr. Lau -taught me in class-
Students (names) you helped and to what extent:  
**********************************************************************************************************************************************/
import java.util.*;

public class PD5WilliamMcNultyStudentArrayTester
{
   public static void main (String [] args)
   {
      StudentBody students = new StudentBody();
      students.init();

      Scanner keyboard = new Scanner (System.in);
      System.out.println ("Enter the id of the student you are looking for: "); 
      int studentID = keyboard.nextInt();

      Student	target =students.search(studentID); 

      if	(target != null)
      System.out.println(target); else
      System.out.println ("Student not found … ");

      System.out.println("Student Body Information:\n" + students);

      Student[] honorsStudents = students.aboveAvgStudents();


      System.out.println("The honors students are: "); 
           for (Student s: honorsStudents)
           {
               System.out.println (s);              
           }
 
   } // end of main
} // StudentArrayTester

class StudentBody
{
	private Student[] students;
	
   //pre- none
   //post- creates a blank array with a length of 3
   public StudentBody()
   {
      students = new Student[3];
	} //StudentBody
   
   //pre- 3 student objects are passed to method
   //post- creates an array with 3 student objects
	public StudentBody(Student s1, Student s2, Student s3)
   {
      students = new Student[] {s1, s2, s3};
	} //StudentBody
   
   //pre- must be called with a valid studentBody object
   //post- adds 3 students to the array of students based on user input
	public void init()
   {
      for (int i = 0; i < students.length; i++)
      {
         Scanner s  = new Scanner(System.in);
         System.out.println("Student " + (1+i) + ":" + "\nEnter the student's name: ");
         String name = s.nextLine();
         System.out.println("Enter the student's id: ");
         int id = s.nextInt();
         System.out.println("Enter the student's GPA: ");
         double gpa = s.nextDouble();
         students[i] = new Student(name, id, gpa);
      }
	} //init
	
	//returns null if Student with ID “id” is not found in students
	public Student search(int id)
   {
	   int target = id;
      for (Student item : students)
      {
         if (item.getStudentID() == target)
         {
            return item;
         } 
      }
      return null;  
	}

	//returns a double representing the average GPA of all students in the
   //student body
   //pre- valid studentbody object
   //post- returns a gpa double value
	public double calcAvgGPA()
   {
	   double total = 0;
      for (Student item : students)
      {
         double gpa = item.getGPA();
         total += gpa;
      }
      return total/students.length;
	}

	/* returns an array of Students that contain first students in StudentBody 
         whose GPA is greater than the average GPA of the student body
	   you must call the calcAvgGPA method in this method to get credit
	*/
   //pre- valid studentbody object
   //post- returns an array of all student objects in initial array
   //that have gpa above the average gpa
	public Student[] aboveAvgStudents()
   {
	   double average = this.calcAvgGPA();
      int count = 0;
      for (Student item : students)
      {
         double gpa = item.getGPA();
         if (gpa > average)
         {
            count++;
         }
      }
      Student[] aboveAvgStudents = new Student[count];
      int index = 0;
      for (Student item : students)
      {
         double gpa = item.getGPA();
         if (gpa > average)
         {
            aboveAvgStudents[index] = item;
            index++;
         }
      }
      return aboveAvgStudents;
	}
	
   //pre- valid studentbody object
   //post- returns a string of all objects in array
   public String toString()
   {
	   String s = "";
      for (Student item : students)
      {
         s += item + "\n";
      }
      return s;
   }
} // StudentBody

class Student
{
   private String name;
   private int studentID;
   private double gPA;
   
   /* precondition: none
   postcondition: create a Student object with default instance variable values */
   public Student()
   {
      name = "unknown";
      studentID = 0;
      gPA = 0.0;
   }
   
   /* precondition: method must be called with String representing name, int representing student ID,      and double from 0.0-5.0 representing GPA
   postcondition: create a Student object with specified instance variable values */
   public Student(String iName, int iStudentID, double iGPA)
   {
      name = iName;
      studentID = iStudentID;
      gPA = iGPA;
   }
   
   /* precondition: must be called with valid Student object
   postcondition: returns the name, student ID, and GPA of a student in the form of a string */
   public String toString(){
      return "Name: "+name+"\tStudent ID: "+studentID+"\tGPA: "+gPA;
   }

   /* precondition: must be called with valid Student object, must be called with a double argument from 0.0-5.0
   postcondition: reassign the value of the argument to a Student’s GPA*/ 
   public void setGPA(double nGPA)
   {
      gPA=nGPA;
   }
   
   /* precondition: must be called with valid Student object
   postcondition: return the name of the Student */ 
   public String getName()
   {
      return name;
   }
   
   /* precondition: must be called with valid Student object
   postcondition: will return the ID of the Student*/ 
   public int getStudentID()
   {
      return studentID;
   }
   
   /* precondition: must be called with valid Student object
   postcondition: will return the GPA of the Student*/ 
   public double getGPA()
   {
      return gPA;
   }

   
} // Student

/*
Outputs:
Student 1:
Enter the student's name: 
Bob
Enter the student's id: 
1
Enter the student's GPA: 
5.0
Student 2:
Enter the student's name: 
Jim
Enter the student's id: 
2
Enter the student's GPA: 
4.0
Student 3:
Enter the student's name: 
Robert
Enter the student's id: 
3
Enter the student's GPA: 
1.0
Enter the id of the student you are looking for: 
2
Name: Jim	Student ID: 2	GPA: 4.0
Student Body Information:
Name: Bob	Student ID: 1	GPA: 5.0
Name: Jim	Student ID: 2	GPA: 4.0
Name: Robert	Student ID: 3	GPA: 1.0

The honors students are: 
Name: Bob	Student ID: 1	GPA: 5.0
Name: Jim	Student ID: 2	GPA: 4.0

*/