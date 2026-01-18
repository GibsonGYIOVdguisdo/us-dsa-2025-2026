package dsa.lib.utils;

import dsa.lib.ImpossibleException;

import java.lang.reflect.Field;

public final class ClassUtils
{

  private ClassUtils()
  {
  }


  @SuppressWarnings("unchecked")
  public static <FieldType> FieldType field(
    Object object,
    String fieldName)
  {
    Class<?> class_ = object.getClass();
    try
    {
      Field field = class_.getDeclaredField(fieldName);
      field.setAccessible(true);
      return (FieldType) field.get(object);
    }
    catch (NoSuchFieldException | IllegalAccessException e)
    {
      throw new ImpossibleException(e);
    }
  }


  public static boolean isBoxed(Class<?> class_)
  {
    return class_ == Boolean.class || class_ == Character.class
      || class_ == Byte.class || class_ == Short.class
      || class_ == Integer.class || class_ == Long.class
      || class_ == Float.class || class_ == Double.class;
  }

}
