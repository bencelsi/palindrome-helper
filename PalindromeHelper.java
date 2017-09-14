
import java.awt.*;
import java.io.*;
import java.util.*;

public class PalindromeHelper {
   public static void main (String[] args) throws FileNotFoundException{
      Scanner c = new Scanner(System.in);
      Scanner d = new Scanner(new File("dictionary.txt"));    
      go(c, d);
      
   }
   
   public static void go(Scanner c, Scanner d) throws FileNotFoundException{
      System.out.print("starts with? ");
      String startsWith = c.next().toLowerCase(); 
      System.out.print("show all? (y/n) ");
      Boolean showAll = (c.next() == "y");
      while(d.hasNext()){
         String word = d.next();
         if(word.startsWith(startsWith)){
            if (showAll){
               System.out.println(word);
            } else {
               String reversed = "";
               char[] chars = word.toCharArray();
               for (int i = chars.length-1; i>=startsWith.length(); i--){
                   reversed += chars[i];
               }
               Scanner d2 = new Scanner(new File("dictionary.txt"));
               while (d2.hasNext()){
                  if (d2.next().equals(reversed)){
                     System.out.print(word + "   ");
                     System.out.println(reversed);
                     break;
                  }
               }
            }
         }
      }
      System.out.println("-----DONE-----");     
}
}