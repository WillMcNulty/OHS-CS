import java.io.*;
import java.util.*;

public class PD6WilliamMcNultyPathDriver{
   public static void main (String[] args){
      PathFinder paths = new PathFinder();
      paths.findPathShow(0, 0, 2, 2, "");
      System.out.println(paths.findPathCount(0, 0, 2, 2));
      System.out.println(paths.findPathExist(0, 0, 2, 2));
   }
}
class PathFinder{ 
   PathFinder (){
      //object
   }
   public void findPathShow(int sx, int sy, int tx, int ty, String s){
      if (sx == tx && sy == ty){
         System.out.println(s);
      }
      else if (!(sx>tx || sy>ty)){
         findPathShow(sx+1, sy, tx, ty, s + "E.");
         findPathShow(sx, sy+1, tx, ty, s + "N.");
         findPathShow(sx+1, sy+1, tx, ty, s + "NE.");
      }
   }
   public int findPathCount(int sx, int sy, int tx, int ty){
      if (sx==tx && sy==ty){
         return 1;
      }
      else if (sx>tx || sy>ty){
         return 0;
      }
      else{
         return findPathCount(sx+1, sy, tx, ty) + findPathCount(sx, sy+1, tx, ty) + findPathCount(sx+1, sy+1, tx, ty);
      }
   }
   public boolean findPathExist(int sx, int sy, int tx, int ty){
      if (sx==tx && sy==ty){
         return true;
      }
      else if (sx>tx || sy>ty){
         return false;
      }
      else {
         return (findPathExist(sx+1, sy, tx, ty) || findPathExist(sx, sy+1, tx, ty) || findPathExist(sx+1, sy+1, tx, ty));
      }
   }
}//PathFinder 