
public class Misc extends Item
{
  private static int limit=6;
  private static int current=0;
  void add(String name,float price,int quantity)
  {
    super.add(name,price,quantity);
  }
  public String toString()
  {
    return "Misc";
  }
  boolean categoryCheck()
  {
    super.categoryCheck();
    if(Misc.current<Misc.limit)
    {
      Misc.current++;
      return true;
    }
    else
    {
      return false;
    }
  }
}
