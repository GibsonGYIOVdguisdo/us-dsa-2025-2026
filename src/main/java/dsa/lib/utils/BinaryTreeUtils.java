package dsa.lib.utils;

import java.util.function.Function;

public final class BinaryTreeUtils
{

  private BinaryTreeUtils()
  {
  }


  public static <Tree, Node> String toString(
    Tree tree,
    Function<Tree, Node> getRoot,
    String indent)
  {
    StringBuilder sb = new StringBuilder();
    sb.append(tree.getClass().getSimpleName());
    sb.append('(');
    Node root = getRoot.apply(tree);
    if (root != null)
    {
      sb.append('\n');
      String itemIndent = indent + "  ";
      sb.append(itemIndent);
      sb.append(ToStringUtils.toString(root, itemIndent));
      sb.append('\n');
      sb.append(indent);
    }
    sb.append(')');
    return sb.toString();
  }

}
