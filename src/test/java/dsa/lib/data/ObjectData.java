package dsa.lib.data;

import dsa.lib.Source;

public class ObjectData
{

  public static final Source<Object>
    NULL = Source.singleton(null),
    NON_NULL = Source.chain(IntData.ALL.cast(), StringData.NON_NULL.cast()),
    ALL = Source.chain(NULL, NON_NULL);

}
