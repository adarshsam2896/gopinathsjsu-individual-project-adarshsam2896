
public class QuantityHandler implements TransactionValidation
{
  private TransactionValidation successor=null;
  public String handleRequest(Inventory inventory,String name,int quantity)
  {
  //if here itself req is not valid then return false
  //else go to next chain
   String res=inventory.processOrder(name,quantity);
   if(res.equals(" "))
   {
     //String next_res = successor.handleRequest(inventory,name,quantity);
     return "Item \""+name+"\" beyond Inventory Quantity$";
   }
   else if(res.equals("No Key"))
   {
     
     return "Item \""+name+"\" is not present in Inventory$";
   }
   else
   {
     if(successor!=null)
     {
       String next_res = successor.handleRequest(inventory,name,quantity);
       if(next_res.equals(" "))
       {
         return "Item \""+name+"\" beyond its category limit$";
       }
       else
       {
         return res;
       }
     }
   }
   return " ";

  }
  public void setSuccessor(TransactionValidation next)
  {
    this.successor=next;
  }

}