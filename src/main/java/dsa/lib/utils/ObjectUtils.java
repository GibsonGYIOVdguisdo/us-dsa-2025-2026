package dsa.lib.utils;

public final class ObjectUtils
{

  private ObjectUtils()
  {
  }


  public static String id(Object object)
  {
    return Integer.toHexString(System.identityHashCode(object));
  }

}
