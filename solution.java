
import java.io.*;  
import java.io.BufferedReader;  
import java.io.FileReader;  
import java.io.IOException; 


public class solution
{
  public static void main(String args[])
  {
   
  String line = "";  
  Cards card=new Cards();
  //String splitBy = ",";  
  try   
  {  
  //parsing a CSV file into BufferedReader class constructor  
  System.out.println("Please Enter the Inventory fle name");
  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  // Reading data using readLine
  String name = reader.readLine();
 
  BufferedReader br = new BufferedReader(new FileReader(name)); 
  InventoryReader iventoryreader=new InventoryReader(); 
  boolean cardseq=false;
  while ((line = br.readLine()) != null)   //returns a Boolean value  
  {  
    if(line.charAt(0)==','){
      //System.out.println(line);
      
      continue;

    }
    //System.out.println(line);
  String[] input = line.split(",");    // use comma as separator  
  if(cardseq==true)
  {
    //System.out.println(input[0]);
    card.addCard(input[0]);

    continue;
  }
  
  if(input[0].equals("Item") || input[0].equals("Items")||input[0].equals("Cards")||input[0].equals("CardNumber"))
  {
    if(input[0].equals("CardNumber"))
    {
      cardseq=true;
    }
    continue;

  }
  //System.out.println(""+input[0]+" ,"+input[1]+" ,"+input[2]+" ,"+input[3]);  
  //System.out.println(line);
  iventoryreader.pushToInventory(input[0],input[1],Integer.parseInt(input[2]),Float.parseFloat(input[3]));


  }
  
  line = "";
  
  
  //System.out.println("----------------OUTPUT STARTS FROM HERE:------------");
//boolean stop=false;
//int count=0;
  InputTransactionProcesser inputprocesser=new InputTransactionProcesser();
  System.out.println("Please Enter the Order file name ");
  reader = new BufferedReader(new InputStreamReader(System.in));
  // Reading data using readLine
  name = reader.readLine();
  /*if(name.equals("1"))
  {
    stop=true;
    System.out.println("All the output files are in the path"+System.getProperty("user.dir"));
    break;
  }*/
  br = new BufferedReader(new FileReader(name)); 
  while ((line = br.readLine()) != null)  
  {  
    
    
  String[] input = line.split(",");    
    if(input[0].equals("Item"))
    {
      continue;
    }
    
    /*if(input.length>=2)
    {
      card.addCard(input[2]);
    }*/
    inputprocesser.formMessage(input[0],Integer.parseInt(input[1]));
    


  }
//card.printCard();
 
    FileWriter writer ; 
  if(Error.getInstance()==null)
  {
     writer = new FileWriter("output.csv");
     String[] temp=inputprocesser.outputtext.split("\n");
     //System.out.println(temp[0]);
     String final_result="Item,Quantity,Price,Total Price"+"\n";
     final_result+=temp[0]+","+String.valueOf(inputprocesser.total_cost)+"\n";
    for(int i=1;i<temp.length;i++)
    {
     final_result+=temp[i]+"\n";
    }  
    writer.write(final_result);
    writer.close();
    System.out.println("Output in output.csv");
    Output.deleteInstance();
    inputprocesser.outputtext="";
  }
  else
  {
    
     writer = new FileWriter("error.txt");
    String[] temp=inputprocesser.errortext.split("\n");
     
     String final_result="Please correct the following items"+"\n";
     
    for(int i=0;i<temp.length;i++)
    {
     final_result+=temp[i].substring(0,temp[i].length()-1)+"\n";
    }  
    writer.write(final_result);
    writer.close();
    System.out.println("Error reason in error.txt");
    Error.deleteInstance();
    inputprocesser.errortext="";

  }
  //inputprocesser=null;


  
  }   
  catch (IOException e)   
  {   
  System.out.println("Wrong file name : Does not exsist or corrupted"); 
  }  
}     



  }


