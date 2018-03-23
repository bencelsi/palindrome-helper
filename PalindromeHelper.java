import java.awt.*;
import java.io.*;
import java.util.*;

public class PalindromeHelper {
   public static void main (String[] args) throws FileNotFoundException{
      Scanner c = new Scanner(System.in);
      Scanner d = new Scanner(new File("dictionary.txt"));
      Scanner e = new Scanner(new File("dictionary.txt"));
	  ArrayList<String> al = new ArrayList<String>();
      while(e.hasNext()){
		  al.add(e.next());
	  }
      Object[] al2 = al.toArray();
      //System.out.print(firstStartsWith(al.toArray(), "hi"));
      //go(c, d);
   }
   
   
   public static void go(Scanner c, Scanner d) throws FileNotFoundException{
      System.out.print("Find words that start with:");
      String startsWith = c.next().toLowerCase(); 
      System.out.print("1. show all \n 2. only show words where remaining letters reversed make a word");
      Boolean showAll = (c.next() == "1");
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
   
   public static int firstStartsWith(String str, String[] d) {
	   return fswHelper(str, d, 0, d.length);
   }
   
   //finds the index of the first words that starts with the given input
   public static int fswHelper(String str, String[] d, int l, int r) {
	   int mid = l + (r-1)/2;
	   if (l > r) {
		   return -1;
	   } else if (d[mid].startsWith(str) && (mid == 0 || !d[mid-1].startsWith(str))) {
		   return mid;
	   } else if (d[mid].compareTo(str) < 0) {
		   return fswHelper(str, d, mid+1, r);
	   } else {
		   return fswHelper(str, d, l, mid-1);   
	   }
   }
}