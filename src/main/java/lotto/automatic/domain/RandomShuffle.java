package lotto.automatic.domain;

import java.util.Collections;
import java.util.List;

public class RandomShuffle implements ShuffleStrategy {
    @Override
    public void shuffle(List<Integer> nums) {
        Collections.shuffle(nums);
    }
}
