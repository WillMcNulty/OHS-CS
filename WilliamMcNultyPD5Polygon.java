/*
   This lab was very simple, but required choice about program design. I am realizing that
   designing the program with Triangle as an abstract class could allow for less data waste 
   and more program flexibility, however, removes the oppurtunity of having a Triangle object, 
   unless, you were to create a subclass for triangle construction.
   I wrote that before changing the code to an abstract class. Design process changes throughout
   development and understanding when to use abstraction is important for program effeciency and
   code reuse.
   
   The purpose of the program was to create different polygons and apply understanding of the
   interface and abstact class java components.
*/

import java.util.*;

class PolygonDriver {
   public static void main(String[] args){
   //test shit
   IsocelesTriangle it = new IsocelesTriangle(1,2);
   EquilateralTriangle et = new EquilateralTriangle(1);
   Rectangle r = new Rectangle(3, 5);
   Square s = new Square(3);
   Pentagon p = new Pentagon(5);
   Hexagon h = new Hexagon(6);
   Octogon o = new Octogon(8);
   Polygon[] shapeArray = {it, et, r, s, p, h, o};
   for (Polygon item: shapeArray){
      System.out.println("I made a shape");
      System.out.println(item.toString());
      System.out.println("Here is the Area: " + item.area() + ", This is the Perimeter: " + item.perimeter());
      System.out.println();
   }
}
}
interface Polygon {
   
   double area();
   double perimeter();
   String toString();
}

abstract class Triangle implements Polygon {
   private double base;
   
   Triangle(double b)
   {
      base = b;
   }
   public double getBase(){
      return this.base;
   }

}
class IsocelesTriangle extends EquilateralTriangle {
   private double side;
   IsocelesTriangle(double base, double n1)
   {
      super(base);
      this.side=n1;
   }
   
   public double area(){
      return Math.sqrt(this.perimeter()/2*(this.perimeter()/2-this.getBase())*(this.perimeter()/2-this.side)*(this.perimeter()/2-side));
   }
   public double perimeter(){
      return this.getBase() + 2*this.side;
   }
   public String toString(){
      return "Isoceles Triangle with Base: " + this.getBase() + ", Side Lengths: " + this.side;
   }
}
class EquilateralTriangle extends Triangle {
   EquilateralTriangle(double base)
   {
      super(base);
   }
   public double area(){
      return Math.sqrt(this.perimeter()/2*(this.perimeter()/2-this.getBase())*(this.perimeter()/2-this.getBase())*(this.perimeter()/2-this.getBase()));
   }
   public double perimeter(){
      return this.getBase()*3;
   }
   public String toString(){
      return "Equilateral Triangle with Base: " + this.getBase();
   }
}



abstract class Quadrilateral implements Polygon{
   double base;
   double length;
   Quadrilateral(double b, double l){
      base=b;length=l;
   }
   
   public double getLength(){
      return length;
   }
   public double getBase(){
      return base;
   }
}

class Rectangle extends Quadrilateral{
   
   Rectangle(double b, double l){
      super(b,l);
   }
   
   public double area(){
      return this.getLength()*this.getBase();
   }
   
   public double perimeter(){
      return 2*this.getLength() + 2*this.getBase();
   }
   public String toString(){
      return "Rectangle with Base: " + this.getBase() + ", Length: " + this.getLength();
   }
   
}

class Square extends Rectangle{
   Square (double b){
      super(b,b);
   }
   public double area(){
      return super.area();
   }
   public double perimeter(){
      return super.perimeter();
   }
   public String toString(){
      return "Square with Base: " + this.getBase();
   }
}

class Pentagon implements Polygon {
   private double side;
   Pentagon (double sideN){
      side = sideN;
   }
   public double area() {
      return .25 * Math.sqrt(5*(5+ 2*Math.sqrt(5)))*side*side;
   }
   
   public double perimeter () {
      return 5*side;
   }
   public String toString(){
      return "Pentagon with Base: " + side;
   }
}

class Hexagon implements Polygon {
   private double side;
   Hexagon(double sideN) {
      side = sideN;
   }
   public double area() {
      return (3*Math.sqrt(3))/3*side*side;
   }
   public double perimeter() {
      return 6*side;
   }
   public String toString(){
      return "Hexagon with Base: " + side;
   }
}

class Octogon implements Polygon {
   private double side;
   Octogon(double sideN) {
      side = sideN;
   }
   public double area() {
      return 2*(1+Math.sqrt(2))*side*side;
   }
   public double perimeter(){
      return 8*side;
   }
   public String toString(){
      return "Octogon with Base: " + side;
   }
}
