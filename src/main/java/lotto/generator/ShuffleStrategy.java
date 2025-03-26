package lotto.generator;

import java.util.List;

public interface ShuffleStrategy {
  List<Integer> shuffle(List<Integer> nums);
}
