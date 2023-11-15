package lotto.domain;

import java.util.List;

public interface ShuffleStrategy {
    List<Integer> shufflable(List<Integer> list);
}
