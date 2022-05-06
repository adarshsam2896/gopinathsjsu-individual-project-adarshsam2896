
public class Luxury extends Item
{
  private static int limit=4;
  private static int current=0;
  void add(String name,float price,int quantity)
  {
    super.add(name,price,quantity);
  }
  public String toString()
  {
    return "Luxury";
  }
  boolean categoryCheck()
  { 
    super.categoryCheck();
    if(Luxury.current<Luxury.limit)
    {
      Luxury.current++;
      return true;
    }
    else
    {
      return false;
    }
  }
}