package lotto.generator;

import java.util.Collections;
import java.util.List;

public class CollectionsShuffleStrategy implements ShuffleStrategy {

  @Override
  public List<Integer> shuffle(List<Integer> nums) {
    Collections.shuffle(nums);
    return nums;
  }
}
