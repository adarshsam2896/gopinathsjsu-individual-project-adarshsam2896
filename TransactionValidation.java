 
public interface TransactionValidation
{
  String handleRequest(Inventory inventory,String name,int quantity);
  void setSuccessor(TransactionValidation next);
}