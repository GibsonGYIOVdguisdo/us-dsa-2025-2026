package dsa.lib.utils;

import dsa.lib.ImpossibleException;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public final class ToDebugStringUtils
{

  private ToDebugStringUtils()
  {
  }


  public static String toDebugString(Object object)
  {
    StringBuilder sb = new StringBuilder();
    toDebugString(object, null, "", sb, new ArrayList<>());
    return sb.toString();
  }


  private static void toDebugString(
    Object object,
    Class<?> class_,
    String indent,
    StringBuilder sb,
    List<Object> seen)
  {
    if (object != null)
    {
      Class<?> objectClass = object.getClass();
      if (class_ == null || class_.isAssignableFrom(objectClass))
      {
        class_ = objectClass;
      }
    }
    if (class_ != null)
    {
      sb.append(class_.getCanonicalName());
      sb.append(" (");
      sb.append(class_.isPrimitive()
        ? "primitive"
        : class_.isArray()
          ? "array"
          : class_.isInterface() ? "interface" : "class");
      sb.append(')');
    }
    if (object == null)
    {
      sb.append('\n');
      sb.append(indent);
      sb.append("'-- ");
      sb.append("null");
      return;
    }
    if (class_.isPrimitive())
    {
      sb.append('\n');
      sb.append(indent);
      sb.append("'-- ");
      sb.append(object);
      return;
    }
    sb.append('\n');
    sb.append(indent);
    sb.append("Object ID: ");
    sb.append(ObjectUtils.id(object));
    if (ClassUtils.isBoxed(class_))
    {
      sb.append('\n');
      sb.append(indent);
      sb.append("'-- ");
      sb.append(object);
      return;
    }
    if (class_ == String.class)
    {
      sb.append('\n');
      sb.append(indent);
      sb.append("'-- ");
      sb.append(StringUtils.toString((String) object));
      return;
    }
    if (seen.contains(object))
    {
      sb.append('\n');
      sb.append(indent);
      sb.append("(see further up for contents)");
      return;
    }
    seen.add(object);
    if (class_.isArray())
    {
      int length = Array.getLength(object);
      boolean empty = length == 0;
      sb.append('\n');
      sb.append(indent);
      sb.append(empty ? "'-- " : "|-- ");
      sb.append(".length");
      sb.append('\n');
      sb.append(indent);
      sb.append(empty ? "    " : "|   ");
      sb.append("'-- ");
      toDebugString(
        length,
        int.class,
        indent + (empty ? "    " : "|   ") + "    ",
        sb,
        seen);
      for (int index = 0; index < length; index++)
      {
        boolean last = index == length - 1;
        sb.append('\n');
        sb.append(indent);
        sb.append(last ? "'-- " : "|-- ");
        sb.append('[');
        sb.append(index);
        sb.append(']');
        sb.append('\n');
        String itemIndent = indent + (last ? "    " : "|   ");
        sb.append(itemIndent);
        sb.append("'-- ");
        toDebugString(
          Array.get(object, index),
          null,
          itemIndent + "    ",
          sb,
          seen);
      }
    }
    else
    {
      Field[] fields = class_.getDeclaredFields();
      int length = fields.length;
      for (int index = 0; index < length; index++)
      {
        boolean last = index == length - 1;
        Field field = fields[index];
        sb.append('\n');
        sb.append(indent);
        sb.append(last ? "'-- " : "|-- ");
        sb.append('.');
        sb.append(field.getName());
        sb.append('\n');
        String fieldIndent = indent + (last ? "    " : "|   ");
        sb.append(fieldIndent);
        sb.append("'-- ");
        field.setAccessible(true);
        try
        {
          toDebugString(
            field.get(object),
            field.getType(),
            fieldIndent + "    ",
            sb,
            seen);
        }
        catch (IllegalAccessException e)
        {
          throw new ImpossibleException();
        }
      }
    }
  }

}
