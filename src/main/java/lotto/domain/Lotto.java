package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    public static final int LOTTO_NUM_SIZE = 6;
    private final List<Integer> nums;

    public Lotto(List<Integer> nums) {
        validate(nums);
        this.nums = nums;
        Collections.sort(this.nums);
    }

    public List<Integer> getNums() {
        return nums;
    }

    private void validate(List<Integer> nums) {
        if (nums.size() != LOTTO_NUM_SIZE) {
            throw new IllegalArgumentException("Lotto 숫자의 사이즈는 6개 입니다.");
        }
    }
}
