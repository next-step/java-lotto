package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> nums;

    public Lotto(List<Integer> nums) {
        this.nums = nums;
        Collections.sort(this.nums);
    }

    public List<Integer> getNums() {
        return nums;
    }
}
