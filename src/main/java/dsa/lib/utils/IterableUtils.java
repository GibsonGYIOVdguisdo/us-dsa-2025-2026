package dsa.lib.utils;

import java.util.Iterator;

public final class IterableUtils
{

  private IterableUtils()
  {
  }


  public static <Item> String toString(Iterable<Item> iterable)
  {
    return IterableUtils.toString(iterable, "");
  }


  public static <Item> String toString(Iterable<Item> iterable, String indent)
  {
    return ToStringUtils.toTypedString(iterable, toUntypedString(iterable, indent));
  }


  public static <Item> String toUntypedString(Iterable<Item> iterable)
  {
    return IterableUtils.toUntypedString(iterable, "");
  }


  public static <Item> String toUntypedString(
    Iterable<Item> iterable,
    String indent)
  {
    StringBuilder sb = new StringBuilder();
    sb.append('(');
    Iterator<Item> iterator = iterable.iterator();
    if (iterator.hasNext())
    {
      sb.append('\n');
      while (iterator.hasNext())
      {
        Item item = iterator.next();
        String itemIndent = indent + "  ";
        sb.append(itemIndent);
        sb.append(ToStringUtils.toString(item, itemIndent));
        sb.append('\n');
      }
      sb.append(indent);
    }
    sb.append(')');
    return sb.toString();
  }

}
