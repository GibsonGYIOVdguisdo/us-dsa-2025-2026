package dsa.lib;

import dsa.lib.utils.ToDebugStringUtils;

public abstract class DSAObject
  implements DSAInterface
{

  @Override
  public String toString()
  {
    return this.toString("");
  }


  @Override
  public String toDebugString()
  {
    return ToDebugStringUtils.toDebugString(this);
  }

}
