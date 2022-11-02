/**********************************************************************************************************************************************
Name (Full Name): William McNulty   Period:   5
Name of the Lab/Assignment: Person Vehicle Truck
Purpose of the program: 
   -To test and apply knowledge of inheritance in JAVA
   -To test and apply knowledge of classes and class design
   -Program creates objects of Vehicle Person and Truck types
   
Date: 9/25/2021         
What I Learned:  
   -I learned how to use inheritance to reduce code complexity and redudancy
   -I learned how to use overridden methods and multiple layered constructors
   -I learned the importance of good class design to enable interaction with other classes

What I Wonder:
   -I wonder how we can organize objects of the same class
      -Making an index of all Trucks or Vehicles
      -Maybe in use to list all of the trucks that Bob owns
   -I wonder if you can index objects of different types
   -I wonder how inheritance would factor into creating indexes
   -I wonder how we can further use inheritance to reduce code redundancy

The credits: Mr. Lau -taught me in class-
Students (names) you helped and to what extent:  
**********************************************************************************************************************************************/
import java.util.*;

class PD5WilliamMcNultyInheritanceLabDriver
{
   public static void main (String [] args)
   {
      Vehicle v1 = new Vehicle("Bob", 53, "Ford", 8);
      Vehicle v2 = new Vehicle("Bob", 53, "Ford", 8);
      System.out.println(v1.equals(v2));
      System.out.println(v1);
      v1.setOwner("Bob's Son", 18);
      v1.setManufacturer("GMC");
      v1.setNumCylinders(12);
      System.out.println(v1);
      System.out.println();
      Person p1 = new Person("Joe", 74);
      System.out.println(p1);
      v2.setOwner(p1);
      System.out.println();
      System.out.println(v2.getOwner());
      System.out.println(v1.equals(v2));
      
      Truck t1 = new Truck("Dave", 27, "Ford", 6, 10.5, 500);
      Truck t2 = new Truck("Dave", 27, "Ford", 6, 10.5, 500);
      System.out.println(t1.equals(t2));
      System.out.println(t1);
      t1.setNumCylinders(8);
      t1.setLoadCapacity(11.5);
      t1.setOwner(v1.getOwner());
      t1.setTowingCapacity(1000);
      t1.setManufacturer("GMC");
      System.out.println(t1);
      System.out.println(t1.equals(t2));
   } //main
} //driver

class Person
{
  private String name;
  private int    age;
 
  /*
  **pre-constructor call no parameters
  **post-'default' person object is made with "No name yet."
  **and 0 for name and age values
  */
  public Person ()
  {
     name = "No name yet.";
     age = 0;
  }
  
  /*
  **pre-constructor call String name and Int age parameters
  **post-Custom person object is made with Name value and
  **age value assigned in association to called parameters
  */
  public Person (String name, int age) 
  {
     this.name = name; 
     this.age = age;
  }
 
  /*
  **pre-called with object of type Person and a String Name
  **Parameter
  **post-Changes the Person Object's Name variable value
  */
  public void setName (String newName) 
  {
  name = newName;
  }
  
  /*
  **pre-called with object of type Person
  **post-returns an string of name value
  */
  public String getName()
  {
  return name;
  }
  
  /*
  **pre-called with object of type Person
  **post-returns an int of age value
  */
  public int getAge()
  {
  return age;
  }
  
  /*
  **pre-called with object of type Person
  **post-returns a string of the Person object's 
  **variables formatted
  */
  public String toString ()
  {
  return "Name: " + name + "\nAge: " + age ;
  }
 
  /*
  **pre-called with object of type Person
  **and parameter of type person
  **post-returns a boolean value true if the
  **objects are same false if not
  */
  public boolean equals (Person other)
  {
    return (this.name.equalsIgnoreCase(other.name) && this.age == other.age);
  }
}  // Person

class Vehicle
{
   private String manufacturer;
   private int numCylinders;
   private Person owner;
   
   /*
   **pre-constructor call no parameters
   **post-creates values for three instance 
   **variables with values "none", 0 and
   **a default person constructor
   */
   public Vehicle ()
   {
      this.manufacturer = "none";
      this.numCylinders = 0;
      this.owner = new Person();
   }
   
   /*
   **pre-constructor call with String Int and Person
   **parameters
   **post-assigns the parameters to associated variable
   */
   public Vehicle (String manufacturer, int numCylinders, Person owner)
   {
      this.manufacturer = manufacturer;
      this.numCylinders = numCylinders;
      this.owner = owner;
   }
   
   /*
   **pre-constructor call with String Int parameters
   **post-assigns the parameters to associated variable
   **creates a default person object for owner variable
   */
   public Vehicle (String manufacturer, int numCylinders)
   {
      this.manufacturer = manufacturer;
      this.numCylinders = numCylinders;
      this.owner = new Person();
   }
   
   /*
   **pre-constructor call with String Int and
   **Name and Age parameters
   **post-assigns the parameters to associated variable
   **creates a person for owner variable
   */
   public Vehicle (String name, int age, String manufacturer, int numCylinders)
   {
      this.manufacturer = manufacturer;
      this.numCylinders = numCylinders;
      this.owner = new Person(name, age);
   }
   
   /*
   **pre-called with object of type Vehicle
   **and parameter String
   **post-changes manufacturer variable's value
   */
   public void setManufacturer (String manufacturer)
   {
      this.manufacturer = manufacturer;
   }
   
   /*
   **pre-called with object of type Vehicle
   **and parameter int
   **post-changes numCylinders variable's value
   */
   public void setNumCylinders (int numCylinders)
   {
      this.numCylinders = numCylinders;
   }
   
   /*
   **pre-called with object of type Vehicle
   **and parameter Person
   **post-changes owner variable's value
   */
   public void setOwner (Person owner)
   {
      this.owner = owner;
   }
   
   /*
   **pre-called with object of type Vehicle
   **and parameters name age STRING INT
   **post-changes owner variable's value
   */
   public void setOwner (String name, int age)
   {
      this.owner = new Person(name, age);
   }
   
   /*
   **pre-called with object of type Vehicle
   **post-returns String value of manufacturer
   */
   public String getManufacturer ()
   {
      return this.manufacturer;
   }
   
   /*
   **pre-called with object of type Vehicle
   **post-returns int value of numCylinders
   */
   public int getNumCylinders ()
   {
      return this.numCylinders;
   }
   
   /*
   **pre-called with object of type Vehicle
   **post-returns Person value of owner
   */
   public Person getOwner ()
   {
      return this.owner;
   }
   
   /*
   **pre-called with object of type Vehicle
   **post-returns a string of the Vehicle object's 
   **variables formatted
   */
   public String toString ()
   {
      return "Manufacturer: " + this.manufacturer +
      "\nNumber of Cylinders: " + this.numCylinders + "\nOwner: \n\tName: " + 
      owner.getName() + "\n\tAge: " + owner.getAge();
   }
   
   /*
   **pre-called with object of type Vehicle
   **and parameter of type Vehicle
   **post-returns a boolean value true if the
   **objects are same false if not
   */
   public boolean equals (Object o)
   {
      if (o instanceof Vehicle)
      {
         Vehicle other = (Vehicle) o;
         return this.owner.getName() == other.owner.getName() &&
         this.owner.getAge() == other.owner.getAge() &&
         this.manufacturer == other.manufacturer &&
         this.numCylinders == other.numCylinders;
      }
      else
         return false;
   } //equals
} //Vehicle

class Truck extends Vehicle
{
   private double loadCapacity;
   private int towingCapacity;
   
   /*
   **pre-constructor call with no parameters
   **post-assigns the 'default' values to all variables
   */
   public Truck ()
   {
      super();
      this.loadCapacity = 0;
      this.towingCapacity = 0;
   }
   
   /*
   **pre-constructor call with owner manufact towCap
   **loadCap and numCyclin INT STRING PERSON parameters
   **post-assigns the parameters to associated variable
   */
   public Truck (String manufact, int numCylin, Person owner, double loadCap, int towCap)
   {
      super(manufact, numCylin, owner);
      this.loadCapacity = loadCap;
      this.towingCapacity = towCap;
   }
   
   /*
   **pre-constructor call with manufact towCap Name Age
   **loadCap and numCyclin INT STRING PERSON parameters
   **post-assigns the parameters to associated variable
   **creates a person for owner variable
   */
   public Truck (String name, int age, String manufact, int numCylin, double loadCap, int towCap)
   {
      super(name, age, manufact, numCylin);
      this.loadCapacity = loadCap;
      this.towingCapacity = towCap;
   }
   
   /*
   **pre-constructor call with manufact towCap
   **loadCap and numCyclin INT STRING PERSON parameters
   **post-assigns the parameters to associated variable
   **creates a default person for owner variable
   */
   public Truck (String manufact, int numCylin, double loadCap, int towCap)
   {
      super(manufact, numCylin);
      this.loadCapacity = loadCap;
      this.towingCapacity = towCap;
   }
   
   /*
   **pre-called with object of type Truck
   **and parameter double
   **post-changes loadCapacity variable's value
   */
   public void setLoadCapacity (double loadCapacity)
   {
      this.loadCapacity = loadCapacity;
   }
   
   /*
   **pre-called with object of type Truck
   **and parameter int
   **post-changes towingCapacity variable's value
   */
   public void setTowingCapacity (int towingCapacity)
   {
      this.towingCapacity = towingCapacity;
   }
   
   /*
   **pre-called with object of type Truck
   **post-returns int value of loadCapacity
   */
   public double getLoadCapacity ()
   {
      return this.loadCapacity;
   }
   
   /*
   **pre-called with object of type Truck
   **post-returns int value of towingCapacity
   */
   public int getTowingCapacity ()
   {
      return this.towingCapacity;
   }
   
   /*
   **pre-called with object of type Truck
   **post-returns a string of the Truck object's 
   **variables formatted
   */
   public String toString ()
   {
      return super.toString() + "\nLoad Capacity: " + loadCapacity + 
      "\nTowing Capacity: " + towingCapacity;
   }
   
   /*
   **pre-called with object of type Truck
   **and parameter of type Truck
   **post-returns a boolean value true if the
   **objects are same false if not
   */
   public boolean equals (Object o)
   {
      if (o instanceof Truck)
      {
         Truck other = (Truck) o;
         return super.equals(other) && this.towingCapacity == 
         other.towingCapacity && this.loadCapacity == other.loadCapacity;
      }
      else
         return false;
   } //equals
} //Truck

/* OUTPUT TEST
true
Manufacturer: Ford
Number of Cylinders: 8
Owner: 
   Name: Bob
   Age: 53
Manufacturer: GMC
Number of Cylinders: 12
Owner: 
	Name: Bob's Son
	Age: 18

Name: Joe
Age: 74

Name: Joe
Age: 74
false
true
Manufacturer: Ford
Number of Cylinders: 6
Owner: 
	Name: Dave
	Age: 27
Load Capacity: 10.5
Towing Capacity: 500
Manufacturer: GMC
Number of Cylinders: 8
Owner: 
	Name: Bob's Son
	Age: 18
Load Capacity: 11.5
Towing Capacity: 1000
false

*/