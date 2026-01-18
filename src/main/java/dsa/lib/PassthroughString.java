package dsa.lib;

public class PassthroughString
{

  private String string;


  public PassthroughString(String string)
  {
    this.string = string;
  }


  @Override
  public String toString()
  {
    return this.string;
  }

}
