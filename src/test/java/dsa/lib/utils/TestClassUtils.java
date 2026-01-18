package dsa.lib.utils;

import dsa.lib.ImpossibleException;
import dsa.lib.Source;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import java.lang.reflect.InvocationTargetException;

public class TestClassUtils
{

  public static <T> T construct(Class<T> container)
  {
    try
    {
      return container.newInstance();
    }
    catch (InstantiationException | IllegalAccessException e)
    {
      throw e.getCause() instanceof RuntimeException
        ? (RuntimeException) e.getCause()
        : new ImpossibleException(e);
    }
  }


  public static <T> T construct(Class<T> container, Source<?> items)
  {
    try
    {
      // TODO: size
      return container.getConstructor(Iterable.class).newInstance(items);
    }
    catch (InstantiationException | IllegalAccessException |
           InvocationTargetException | NoSuchMethodException e)
    {
      throw e.getCause() instanceof RuntimeException
        ? (RuntimeException) e.getCause()
        : new ImpossibleException(e);
    }
  }


  public static <T> T construct(
    Class<T> container,
    Source<?> items,
    Source<?> edges)
  {
    try
    {
      return container.getConstructor(Iterable.class, Iterable.class)
        .newInstance(items, edges);
    }
    catch (InstantiationException | IllegalAccessException |
           InvocationTargetException | NoSuchMethodException e)
    {
      throw e.getCause() instanceof RuntimeException
        ? (RuntimeException) e.getCause()
        : new ImpossibleException(e);
    }
  }


  public static ParameterResolver resolver(Class<?> class_)
  {
    return new ParameterResolver()
    {
      @Override
      public boolean supportsParameter(
        ParameterContext parameterContext,
        ExtensionContext extensionContext)
        throws ParameterResolutionException
      {
        return parameterContext.getParameter().getType() == Class.class;
      }


      @Override
      public Object resolveParameter(
        ParameterContext parameterContext,
        ExtensionContext extensionContext)
        throws ParameterResolutionException
      {
        return class_;
      }
    };
  }

}
