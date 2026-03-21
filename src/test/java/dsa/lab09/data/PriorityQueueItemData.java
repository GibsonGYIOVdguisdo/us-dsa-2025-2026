package dsa.lab09.data;

import dsa.lab04.base.MapItem;
import dsa.lab09.base.PriorityQueueItem;
import dsa.lib.data.IntData;
import dsa.lib.Source;
import dsa.lib.data.StringData;

public class PriorityQueueItemData
{

  public static final Source<PriorityQueueItem<Integer, Integer>> INTS_TO_INTS =
    IntData.ALL.flatReplace((priority) ->
      IntData.ALL.replace((item) ->
        new PriorityQueueItem<>(priority, item)));


  public static final Source<PriorityQueueItem<Integer, String>> INTS_TO_STRINGS =
    IntData.ALL.flatReplace((priority) ->
      StringData.ALL.replace((item) ->
        new PriorityQueueItem<>(priority, item)));


  @SuppressWarnings("rawtypes")
  public static final Source<MapItem> ALL =
    Source.chain(INTS_TO_INTS.cast(), INTS_TO_STRINGS.cast());

}
