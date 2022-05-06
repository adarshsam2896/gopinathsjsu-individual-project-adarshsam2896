abstract class Rental
  {
       //private Date rentDate;
       //private Date dueDate;
       private double rentalFee;
       public boolean isOverdue() 
       {
         //Date now = new Date();
         return true; 
       }
}

class BookRental extends Rental
  {
    private String bookTitle;
    private String author;
    
    
  }

class MovieRental extends Rental
 {
   private String movieTitle;
   private int classification;
    
  }
  public class sol
  {
      public static void main(String args[])
      {
          Rental a = new Rental();
          Rental b = new BookRental();
          System.out.println(a.isOverdue());
      }
  }