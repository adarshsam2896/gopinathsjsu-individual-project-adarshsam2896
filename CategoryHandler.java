
public class CategoryHandler implements TransactionValidation
{

 private TransactionValidation successor=null;
 public String handleRequest(Inventory inventory,String name,int quantity)
  {
  //if here itself req is not valid then return false
  //else go to next chain
   String res=inventory.updateCategory(name,quantity);
   if(res.equals(" "))
   {
     return " ";
   }
   else
   {
     
      return "valid";
     
   }

  }
  public void setSuccessor(TransactionValidation next)
  {
    this.successor=next;
  }

}