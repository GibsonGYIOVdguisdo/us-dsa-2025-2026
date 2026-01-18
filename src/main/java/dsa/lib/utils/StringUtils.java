package dsa.lib.utils;

import java.util.regex.Matcher;

public final class StringUtils
{

  private StringUtils()
  {
  }


  public static String toString(String string)
  {
    return string == null ? "null" :
      "\"" + string.replaceAll("\"", Matcher.quoteReplacement("\\\""))
        .replaceAll("\n", Matcher.quoteReplacement("\\n")) + "\"";
  }

}
