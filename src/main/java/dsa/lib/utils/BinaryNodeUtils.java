package dsa.lib.utils;

import java.util.function.Function;

public final class BinaryNodeUtils
{

  private BinaryNodeUtils()
  {
  }


  @SuppressWarnings("SuspiciousRegexArgument")
  public static <Node, Item> String toString(
    Node node,
    Function<Node, Node> getLeft,
    Function<Node, Node> getRight,
    Function<Node, Item> getItem,
    String indent)
  {
    StringBuilder sb = new StringBuilder();
    Item item = getItem.apply(node);
    String itemStr = ToStringUtils.toString(item, indent);
    String spaces = itemStr.substring(itemStr.lastIndexOf('\n') + 1)
      .replaceFirst("^ +", "")
      .replaceAll(".", " ");
    sb.append(itemStr);
    Node left = getLeft.apply(node);
    Node right = getRight.apply(node);
    if (left != null || right != null)
    {
      sb.append(" <-P-+-R-> ");
      if (right != null)
      {
        sb.append(BinaryNodeUtils.toString(
          right,
          getLeft,
          getRight,
          getItem,
          indent + spaces + "     |     "));
      }
      sb.append('\n');
      sb.append(indent);
      sb.append(spaces);
      sb.append("     '-L-> ");
      if (left != null)
      {
        sb.append(BinaryNodeUtils.toString(
          left,
          getLeft,
          getRight,
          getItem,
          indent + spaces + "           "));
      }
    }
    return sb.toString();
  }

}
