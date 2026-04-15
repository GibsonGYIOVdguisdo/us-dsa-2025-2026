package dsa.lab09.exercises;

import dsa.lab03.solutions.DynamicArray;
import dsa.lab04.solutions.MergeSorter;
import dsa.lab09.base.PriorityQueueItem;
import dsa.lab09.base.PriorityQueue;
import dsa.lib.DSAObject;

import java.util.Arrays;

/**
 * A sorted array priority queue.
 *
 * @param <Priority> the priority type
 * @param <Item>     the item type
 */
public class SortedArrayPriorityQueue<Priority extends Comparable<Priority>, Item>
  extends DSAObject
  implements PriorityQueue<Priority, Item>
{

  private DynamicArray<PriorityQueueItem<Priority, Item>> items;


  //<editor-fold defaultstate="collapsed" desc="Constructors">


  /**
   * Construct an empty sorted array priority queue.
   */
  public SortedArrayPriorityQueue()
  {
    this.items = new DynamicArray<>();
  }


  /**
   * Construct a sorted array priority queue containing the given items.
   *
   * @param items the items
   */
  public SortedArrayPriorityQueue(Iterable<PriorityQueueItem<Priority, Item>> items)
  {
    this.items = new DynamicArray<>(items);
    new MergeSorter().sort(this.items);
  }


  /**
   * Construct a sorted array priority queue containing the given items
   * more efficiently than {@link #SortedArrayPriorityQueue(Iterable)}.
   *
   * @param items the items
   * @param size  the number of items
   * @throws IllegalArgumentException if {@code size} != {@code n}
   *                                  (where {@code n} is {@code items}'s size)
   */
  public SortedArrayPriorityQueue(
    Iterable<PriorityQueueItem<Priority, Item>> items,
    int size)
    throws IllegalArgumentException
  {
    this.items = new DynamicArray<>(items, size);
    new MergeSorter().sort(this.items);
  }


  /**
   * Construct a sorted array priority queue containing the given items.
   *
   * @param items the items
   */
  @SafeVarargs
  public SortedArrayPriorityQueue(PriorityQueueItem<Priority, Item>... items)
  {
    this(Arrays.asList(items), items.length);
  }


  //</editor-fold>


  @Override
  public int size()
  {
    return this.items.size();
  }


  @Override
  public PriorityQueueItem<Priority, Item> max()
  {
    if (this.isEmpty())
    {
      return null;
    }

    return this.items.last();
  }


  @Override
  public void insert(PriorityQueueItem<Priority, Item> item)
  {

    for (int i = 0; i < this.items.size(); i++){
        if (this.items.get(i).compareTo(item) >= 0){
          this.items.insert(i, item);
          return;
        }
    }
    this.items.insert(this.items.size(), item);

  }


  @Override
  public PriorityQueueItem<Priority, Item> removeMax()
  {
    if (this.isEmpty())
    {
      return null;
    }

    PriorityQueueItem<Priority, Item> max = this.items.last();

    this.items.remove(this.items.size() - 1);

    return max;
  }


  //<editor-fold defaultstate="collapsed" desc="Iteration">


  @Override
  public Iterable<PriorityQueueItem<Priority, Item>> items()
  {
    return this.items.reversed();
  }


  @Override
  public Iterable<PriorityQueueItem<Priority, Item>> reversed()
  {
    return this.items;
  }


  //</editor-fold>

}
