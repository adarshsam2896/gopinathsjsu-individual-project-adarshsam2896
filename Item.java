 
public class Item
{
    String name;
    float price;
    int quantity;
    void add(String name,float price,int quantity)
    {
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }
    float calculatePrice(int quantity)
    {
      if(quantity>this.quantity)
      {
        return -1;
      }
      return quantity*price;
    }
    boolean categoryCheck()
    {
      //System.out.println("INSIDE BASE!!");
      return true;
    }

}