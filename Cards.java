import java.util.*;

public class Cards
{
 private HashSet<String> cardnumbers;
 Cards()
 {
   cardnumbers=new HashSet<String>();
 }
 public void addCard(String cardno)
 {
   cardnumbers.add(cardno);
 }
 public void printCard()
 {
   System.out.println(cardnumbers);
 }

}