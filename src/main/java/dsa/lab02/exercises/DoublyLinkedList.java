package dsa.lab02.exercises;

import dsa.lab02.base.LinkedList;
import dsa.lab02.base.LinkedNode;
import dsa.lib.DSAObject;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * A doubly-linked list.
 * <p>
 * Nodes are directly-linked to both their predecessors and successors.
 * Holds references to both the first and last nodes (if non-empty).
 *
 * @param <Item> the item type
 */
public class DoublyLinkedList<Item>
  extends DSAObject  // NOTE: Don't worry about the `extends DSAObject`.
  implements LinkedList<Item>
{

  /** The number of contained items/nodes. */
  private int size = 0;
  // NOTE: Not all doubly-linked list implementations include this (for the same
  //       reasons as with singly-linked lists).


  /** The first node in the list (null if empty). */
  private Node<Item> first = null;


  /** The last node in the list (null if empty). */
  private Node<Item> last = null;
  // NOTE: Unlike singly-linked lists, _all_ doubly-linked list implementations
  //       include this.


  //<editor-fold defaultstate="collapsed" desc="Constructors">


  /**
   * Construct an empty doubly-linked list.
   */
  public DoublyLinkedList()
  {
  }


  /**
   * Construct a doubly-linked list containing the given items.
   *
   * @param items the items
   */
  public DoublyLinkedList(Iterable<Item> items)
  {
    for (Item item : items)
    {
      this.insertLast(item);
    }
  }


  /**
   * Construct a doubly-linked list containing the given items.
   *
   * @param items the items
   */
  @SafeVarargs
  public DoublyLinkedList(Item... items)
  {
    this(Arrays.asList(items));
  }


  //</editor-fold>


  @Override
  public int size()
  {
    return this.size;
  }


  @Override
  public Node<Item> node(int index)
    throws IndexOutOfBoundsException
  {
    if (index < 0 || index >= this.size)
    {
      throw new IndexOutOfBoundsException();
    }

    // TODO: Implement DoublyLinkedList.node(int index);
    return null;
  }


  @Override
  public void insert(int index, Item item)
    throws IndexOutOfBoundsException
  {
    if (index < 0 || index > this.size)
    {
      throw new IndexOutOfBoundsException();
    }

    // TODO: Implement DoublyLinkedList.insert(int index, Item item);
  }


  @Override
  public Item remove(int index)
    throws IndexOutOfBoundsException
  {
    if (index < 0 || index >= this.size)
    {
      throw new IndexOutOfBoundsException();
    }

    // TODO: Implement DoublyLinkedList.remove(int index);
    return null;
  }


  /**
   * A node in a doubly-linked list.
   * <p>
   * Holds direct links to both the previous and next nodes.
   *
   * @param <Item> the item type
   */
  public static class Node<Item>
    extends DSAObject
    implements LinkedNode<Item>
  {

    /** The list that contains this node. */
    private DoublyLinkedList<Item> list;


    /** The previous node immediately before this one (null if first). */
    private Node<Item> previous;


    /** The item that this node contains. */
    private Item item;


    /** The next node immediately after this one (null if last). */
    private Node<Item> next;


    /**
     * Construct a node with the given item.
     *
     * @param list the containing linked list
     * @param item the contained item
     */
    public Node(DoublyLinkedList<Item> list, Item item)
    {
      this(list, null, item, null);
    }


    /**
     * Construct a node with the given predecessor and item.
     *
     * @param list     the containing linked list
     * @param previous the previous node
     * @param item     the contained item
     */
    public Node(DoublyLinkedList<Item> list, Node<Item> previous, Item item)
    {
      this(list, previous, item, null);
    }


    /**
     * Construct a node with the given item and successor.
     *
     * @param list the containing linked list
     * @param item the contained item
     * @param next the next node
     */
    public Node(DoublyLinkedList<Item> list, Item item, Node<Item> next)
    {
      this(list, null, item, next);
    }


    /**
     * Construct a node with the given predecessor, item and successor.
     *
     * @param list     the containing linked list
     * @param previous the previous node
     * @param item     the contained item
     * @param next     the next node
     */
    public Node(
      DoublyLinkedList<Item> list,
      Node<Item> previous,
      Item item,
      Node<Item> next)
    {
      this.list = list;
      this.previous = previous;
      this.item = item;
      this.next = next;
    }


    @Override
    public DoublyLinkedList<Item> list()
    {
      return this.list;
    }


    @Override
    public Item item()
    {
      return this.item;
    }


    @Override
    public void setItem(Item item)
    {
      this.item = item;
    }


    @Override
    public Node<Item> previous()
    {
      return this.previous;
    }


    @Override
    public Node<Item> next()
    {
      return this.next;
    }


    @Override
    public void insertPrevious(Item item)
    {
      // TODO: Implement DoublyLinkedList.Node.insertPrevious(Item item);
    }


    @Override
    public void insertNext(Item item)
    {
      // TODO: Implement DoublyLinkedList.Node.insertNext(Item item);
    }


    @Override
    public Item remove()
    {
      // TODO: Implement DoublyLinkedList.Node.remove();
      return null;
    }


    @Override
    public Item removePrevious()
      throws NoSuchElementException
    {
      if (this.isFirst())
      {
        throw new NoSuchElementException();
      }

      return this.previous.remove();
    }


    @Override
    public Item removeNext()
      throws NoSuchElementException
    {
      if (this.isLast())
      {
        throw new NoSuchElementException();
      }

      return this.next.remove();
    }

  }

}
