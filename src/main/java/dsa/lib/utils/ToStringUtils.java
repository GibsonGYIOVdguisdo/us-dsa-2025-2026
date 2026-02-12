package dsa.lib.utils;

import dsa.lib.DSAInterface;

public final class ToStringUtils
{

  private ToStringUtils()
  {
  }


  public static String toString(Object object)
  {
    return ToStringUtils.toString(object, "");
  }


  public static String toString(Object object, String indent)
  {
    if (object == null)
    {
      return "null";
    }
    if (object instanceof DSAInterface)
    {
      return ((DSAInterface) object).toString(indent);
    }
    if (object instanceof String)
    {
      return StringUtils.toString((String) object);
    }
    if (object instanceof Iterable)
    {
      return IterableUtils.toString((Iterable<?>) object, indent);
    }
    Class<?> class_ = object.getClass();
    if (class_.isArray() && !class_.getComponentType().isPrimitive())
    {
      return ArrayUtils.toString((Object[]) object, indent);
    }
    return object.toString();
  }


  public static String toTypedString(Object object, String string)
  {
    return object.getClass().getSimpleName() + string;
  }

}
