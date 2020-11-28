package lotto.automatic.domain;

import java.util.List;

@FunctionalInterface
public interface ShuffleStrategy {

    void shuffle(List<Integer> nums);
}
