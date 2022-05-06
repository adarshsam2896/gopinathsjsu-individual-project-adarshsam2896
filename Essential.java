
public class Essential extends Item
{
  private static int limit=3;
  private static int current=0;
  void add(String name,float price,int quantity)
  {
    super.add(name,price,quantity);
  }
  public String toString()
  {
    return "Essential";
  }
  boolean categoryCheck()
  {
    super.categoryCheck();
    if(Essential.current<Essential.limit)
    {
      Essential.current++;
      return true;
    }
    else
    {
      return false;
    }
  }
}