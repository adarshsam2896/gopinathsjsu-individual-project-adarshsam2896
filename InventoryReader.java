 
public class InventoryReader
{
  Inventory ans;
  
  InventoryReader()
  {
   ans=Inventory.getInstance();
  }
  void pushToInventory(String name, String category, int quantity, float price )
    {
       //Inventory ans=new Inventory();
       ans.addToInventory(name,category,quantity,price);//place where each input line is parsed and parsed.
       /*for (String i : ans.map.keySet()) 
       {
        System.out.println(ans.map.get(i).getClass().getName());  
      }*/
     //The code from here is to loop through the orders


    }
    

}