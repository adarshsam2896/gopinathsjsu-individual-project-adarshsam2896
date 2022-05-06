import java.util.HashMap;
 
public class Inventory
{
    HashMap<String,Item> map;
    private static Inventory inventory;
    private Inventory()
    {
        map=new HashMap<String,Item>();
    }
    public static Inventory getInstance()
    {
      if(inventory==null)
      {
        inventory=new Inventory();
      }
      return inventory;
    }
    void addToInventory(String name, String category, int quantity, float price)
    {
        Item current= mapNameToCategory(category);
        current.add(name,price,quantity);
        map.put(name,current);
    }
    private Item mapNameToCategory(String name)
    {
        if(name.equals("Essentials"))
        {
          return new Essential();
        }
        else if(name.equals("Luxury"))
        {
          return new Luxury();
        }
        else{
          return new Misc();
        }
    }
    String processOrder(String name,int quantity)
    {
      if(map.containsKey(name)==false)
      {
        return "No Key";
      }
      Item item=map.get(name);
      float total_price=item.calculatePrice(quantity);
      if(total_price==-1)
       {
         return " ";
       }
      return name+","+quantity+","+total_price;
    }
    String updateCategory(String name,int quantity)
    {
      Item item=map.get(name);
      //System.out.println("")
      boolean ans=item.categoryCheck();
      if(ans==true)
      {
        return "Possible";
      }
      else
      {
         return " ";
      }
    }

} 