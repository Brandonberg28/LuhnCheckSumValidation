import java.util.*;
import java.io.*;
import java.text.*;

/* 
The Luhn formula is a widely used system for validating ID numbers.
Using the original number, double the value of every other digit. 
Then add all the values of the individual digits together (if a doubled
value now has two digits, add the digits individually). The ID number
is valid if the sum is divisible by 10.
*/

public class LuhnChecksumValidation
{
   private static boolean checkLuhnValidation(String cardNo)
   {
      int checkSum = 0;
      for(int i=0; i<cardNo.length(); i++)
      {
         if(i%2 != 0)
         {
            int num = cardNo.charAt(i) - '0';   //get the number at charAt(i) as an int
            checkSum += doubledDigitValue(num); //double every other digit and add to the checkSum
         }
         else 
         {
            checkSum += cardNo.charAt(i) - '0'; //get the number at charAt(i) as an int
         }
      }
      return (checkSum % 10 == 0);     //return if the checkSum is % 10 == 0
   }
   
   private static int doubledDigitValue(int digit)  //return the digit doubled
   {
      int doubledDigit = digit * 2;
      if(doubledDigit >= 10)                 //if digitDoubled >= 10 then return...
      {                                      
         return 1 + doubledDigit % 10;       //... the digits as 1 + n
      }
      else
      {
         return doubledDigit;                   
      }
   }
   
   
   public static void main(String[] args)
   {
   
      String cardNo;
      int checksum = 0;
      Scanner scan = new Scanner(System.in);
      
      System.out.println("Enter your card number: ");
      cardNo = scan.next();
      
      if(checkLuhnValidation(cardNo)) 
      {
         System.out.println("Card is Valid!");
      }
      else 
      {
         System.out.println("Card is not valid");
      }  
   }
}