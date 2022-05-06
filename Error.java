public class Error
{

private static Error err;
  private Error()
  {

  }
  public static Error createInstane()
  {
    if(err==null)
      {
        err=new Error();
      }
      return err;
  }
  public static Error getInstance()
  {
     return err;
  }
  public static void deleteInstance()
  {
    err=null;
  }

}
