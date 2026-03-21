package dsa.lab09.exercises;

import dsa.lab09.base.PriorityQueueTests;
import dsa.lib.utils.TestClassUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.jupiter.api.extension.RegisterExtension;

@DisplayName("ArrayPriorityQueue")
public class ArrayPriorityQueueTests
{

  @RegisterExtension
  static final ParameterResolver classResolver =
    TestClassUtils.resolver(ArrayPriorityQueue.class);


  @Nested
  public class Max
    implements PriorityQueueTests.Max
  {
  }


  @Nested
  public class Insert
    implements PriorityQueueTests.Insert
  {
  }


  @Nested
  public class RemoveMax
    implements PriorityQueueTests.RemoveMax
  {
  }

}
