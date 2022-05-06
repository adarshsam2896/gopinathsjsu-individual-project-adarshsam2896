
public class InputTransactionProcesser
{
  private Output op;
  private Error er;
  private Inventory ans;
  String errortext;
  String outputtext;
  float total_cost;
  private TransactionValidation quantity_handler;
  private TransactionValidation category_handler;
  InputTransactionProcesser()
  {
   //ans=Inventory.getInstance();
   ans=Inventory.getInstance();
   op=Output.createInstane();
   //er=Error.createInstane();
   errortext="";
   outputtext="";
   quantity_handler=new QuantityHandler();
   category_handler=new CategoryHandler();
   quantity_handler.setSuccessor(category_handler);
   total_cost=0;

  }

  void formMessage(String name,int quantity)
  {
     
  // System.out.println(quantity_handler.handleRequest(ans,name,quantity));
  String message=quantity_handler.handleRequest(ans,name,quantity);
  if(Output.getInstance()==null)
  {
    if(message.charAt(message.length()-1)=='$')
    {
      errortext+=message;
      errortext+='\n';
    }
  }
  else
  {
    if(message.charAt(message.length()-1)=='$')
    {
      er=Error.createInstane();
      Output.deleteInstance();
      errortext+=message;
      errortext+='\n';
      if(outputtext.equals("")==false)
      { 
        outputtext="";

      }

    }
    else{
      outputtext+=message;
      outputtext+='\n';
      total_cost+=Float.parseFloat(message.split(",")[2]);

    }
  }
   

  }
   



  
}