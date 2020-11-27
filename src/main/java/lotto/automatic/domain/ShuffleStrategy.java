package lotto.automatic.domain;

import java.util.List;

public interface ShuffleStrategy {

    void shuffle(List<Integer> nums);
}
