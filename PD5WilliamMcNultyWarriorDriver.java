/****************************************************
Name (Full Name): William McNulty   Period:   5
Name of the Lab/Assignment:  NerdWars/Warrior Class
Purpose of the program: 
   -to create warriors with stats of strength and iq,
    that are deterimined by clique. Clique and name are
    determined by user input when creating warriors.
   -based on these stats, a fight method can test which
    of two warriors would win in a fight based on their 
    difference in strength and iq
   -this program was written to test our knowledge of
    classes and class design in a practical application
    of class methods.
   
Date: 11/15/2021   
Due Date: 11/21/2021      
What I Learned:  
   -I learned how to use mutator, accessor, equals, toString
    and other custom class methods
   -I learned how to call methods 
   -I learned applications of Math.random
   -I learned how to create and design my own class
   
   
What I Wonder:
   -I wonder how I can layer classes together so that
    objects of different classes can interact.
    Like having another class to create enemies that 
    can fight warriors.
   -I wonder how class methods can be layered to be 
    redundant and fault tolerant based on unexpected
    or unwanted user inputs
   -I wonder if there are more levels of classes
   -I wonder how different classes interact
    -What if they have similar methods, how do they
     inherit to the main/driver class

The credits: 
   -Mr. Lau -taught me in class-
Students (names) you helped and to what extent: 
   -Mason, helped with understanding of Math.random 
    for application in lab
****************************************************/

public class PD5WilliamMcNultyWarriorDriver 
{
   public static void main (String [] args)
   {
      Warrior lau = new Warrior ("lau", 'F');
      Warrior pete = new Warrior ("Peter", 'F');
      
      System.out.println (lau);
      System.out.println (pete);
      
      lau.fight(pete);
   } //main
} //PD5WilliamMcNultyWarriorDriver

class Warrior
{
   private String name;
   private int iq;
   private int strength;
   private char clique;
   
   //pre- The user calls the constructor with no parameters
   //post- A Warrior object is created with 'default' values
   //for variables name and clique "Default Warrior" 'P'
   //instance variables strength and iq are assigned with 
   //generate stats based on clique
   public Warrior ()
   {
      this.name = "Default Warrior";
      this.clique = 'P';
      this.generateStats();
   }
   
   //pre- The user enters a string name and a char value
   //post- A Warrior object is created with name and clique
   //arguements assigned and strength and iq are assigned
   //based on clique
   public Warrior (String name, char clique)
   {
      this.name = name;
      this.clique = clique;
      this.generateStats();
   } //Warrior Constructor
   
   //pre-object of Warrior type calls method
   //post-value for strength instance variable returned
   public int getStrength()
   {
      return strength;
   } //getStrength
   
   //pre-object of Warrior type calls method
   //post-value for iq instance variable returned
   public int getIQ()
   {
      return iq;
   } //getIQ
   
   //pre-object of Warrior type calls method
   //post-value for name instance variable returned
   public String getName()
   {
      return name;
   } //getName
   
   //pre-object of Warrior type calls method
   //post-value for clique instance variable returned
   public char getClique()
   {
      return clique;
   } //getClique
   
   //pre-object of Warrior type calls method with int
   //value parameter
   //post-value for strength instance variable updated
   public void setStrength(int newStrength)
   {
      this.strength = newStrength;
   } //setStrength
   
   //pre-object of Warrior type calls method with int
   //value parameter
   //post-value for iq instance variable updated
   public void setIQ(int newIQ)
   {
      this.iq = newIQ;
   } //setIQ
   
   //pre-object of warrior type calls method with String
   //value parameter
   //post-value for name instance variable updated
   public void setName(String newName)
   {
      this.name = newName;
   } //setName
   
   //pre-object of warrior type calls method with char
   //value parameter
   //post-value for clique instance variable updated
   public void setClique(char newClique)
   {
      this.clique = newClique;
   } //setClique
   
   //pre- An object of type warrior is used to call
   //the method, with a clique instance variable
   //having a value of 'N' 'J' 'P' 'T' or 'F'
   //post-the instance variables strength and iq are
   //given random values in ranges based on clique
   public void generateStats()
   {
      if (clique == 'N')
      {
         this.iq = (int)(Math.random() * 61 + 120);
         this.strength = (int)(Math.random() * 61 + 20);
      }
      else if (clique == 'J')
      {
         this.iq = (int)(Math.random() * 61 + 80);
         this.strength = (int)(Math.random() * 51 + 50);
      }
      else if (clique == 'P')
      {
         this.iq = (int)(Math.random() * 61 + 90);
         this.strength = (int)(Math.random() * 51 + 40);  
      }
      else if (clique == 'T')
      {
         this.iq = (int)(Math.random() * 31 + 60);
         this.strength = (int)(Math.random() * 21 + 80);
      }
      else if (clique == 'F')
      {
         this.iq = (int)(Math.random() * 121 + 60);
         this.strength = (int)(Math.random() * 100 + 1);
      }
      else
      {
         this.iq = 0;
         this.strength = 0;
      }
   } //generateStats
   
   //pre-an object of type Warrior calls method
   //post-all instance variables returned listed as a String value
   public String toString()
   {
      return "Name: " + this.name + "\tClique: " + this.clique + "\tIQ: " +
      this.iq + "\tStrength: " + this.strength;
   } //toString
   
   //pre-an object of type Warrior is used to call the method
   //with the parameter being an object of type Object
   //post-if the objects are both of type Warrior and are have the
   //same instance variables, true will be returned, otherwise false
   public boolean equals(Object obj)
   {
      if (obj instanceof Warrior)
      {
         Warrior other = (Warrior) obj;
         return this.name == other.name && this.clique == other.clique &&
         this.strength == other.strength && this.iq == other.iq;
      }
      else
      {
         return false;
      }
   } //equals
   
   //pre-an object of the Warrior type calls the method with another
   //object of type Warrior as parameter. Both objects have all 
   //instance variable generated
   //post-the output based on the decision guide will print if a 
   //warrior won, who they were and how they won
   public void fight (Warrior other)
   {
      if (this.equals(other))
      {
         System.out.print("These two are the same fighters, they can't brawl.");
      }
      else
      {
         if (this.strength > other.strength)
         {
            if(other.iq > this.iq + 20)
            {
               System.out.print(other.name + " wins by IQ.");
            }
            else
            {
               System.out.print(this.name + " wins on strength.");
            }
         }
         else if (this.strength < other.strength)
         {
            if(this.iq > other.iq + 20)
            {
               System.out.print(this.name + " wins by IQ.");
            }
            else
            {
               System.out.print(other.name + " wins on strength.");
            }

         }
         else
         {
            if(this.iq > other.iq + 20)
            {
               System.out.print(this.name + " wins by IQ.");
            }
            else if (other.iq > this.iq + 20)
            {
               System.out.print(other.name + " wins by IQ.");
            }
            else //if same strength & iq
            {
               System.out.print("This fight is too close to call");
            }
          }

      }
   } //fight
} //Warrior

/*
Outputs:
Name: lau	Clique: N	IQ: 168	Strength: 39
Name: Peter	Clique: J	IQ: 101	Strength: 79
lau wins by IQ.

Name: lau	Clique: N	IQ: 160	Strength: 21
Name: dave	Clique: F	IQ: 122	Strength: 7
lau wins on strength.

Name: lau	Clique: F	IQ: 128	Strength: 89
Name: dave	Clique: F	IQ: 83	Strength: 27
lau wins on strength.

Name: lau	Clique: F	IQ: 99	Strength: 56
Name: Peter	Clique: F	IQ: 75	Strength: 80
lau wins by IQ.
*/