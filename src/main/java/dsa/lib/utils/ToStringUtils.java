package dsa.lib.utils;

import dsa.lib.DSAInterface;

/**
 * Abandon all coding standards ye who enter here!
 * This is not normally what you would ever want to do.
 * Here we're using reflection
 * https://docs.oracle.com/javase/tutorial/reflect/index.html
 * to essentially manually implement dynamic dispatch.
 * https://en.wikipedia.org/wiki/Dynamic_dispatch
 * Usually you can just let Java select the appropriate
 * overload of a given method (given its argument(s)),
 * but because Java implemented generics using type erasure
 * https://en.wikipedia.org/wiki/Type_erasure
 * https://docs.oracle.com/javase/tutorial/java/generics/erasure.html
 * that doesn't work well in this case.
 * (SinglyLinkedList<T> is erased to SinglyLinkedList<Object>,
 * so this overload is always chosen for the list's items
 * even if one of the others might be better.)
 * We're also using reflection to access private fields in some cases.
 * (In the lab 1 interfaces we don't include iteration,
 * Basically, this is the hackiest Java ever, and is not "good code".
 * Don't write code like this if you can help it.
 */
public class ToStringUtils
{

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
