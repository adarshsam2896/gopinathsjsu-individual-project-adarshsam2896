public class Output
{
  private static Output out;
  private Output()
  {

  }
  public static Output createInstane()
  {
    if(out==null)
      {
        out=new Output();
      }
      return out;
  }
  public static Output getInstance()
  {
     return out;
  }
  public static void deleteInstance()
  {
    out=null;
  }
}