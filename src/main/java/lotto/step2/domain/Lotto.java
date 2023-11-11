package lotto.step2.domain;

import java.util.Set;

public class Lotto {
    private Set<Integer> nums;

    public Lotto(Set<Integer> nums) {
        validateNums(nums);
        
        this.nums = nums;
    }

    private void validateNums(final Set<Integer> nums) {
        validateSize(nums);

        validateValue(nums);
    }

    private void validateValue(final Set<Integer> nums) {
        for (Integer num : nums) {
            throwExceptionIfValueIsNotValid(num);
        }
    }

    private void throwExceptionIfValueIsNotValid(final Integer num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException("lotto nums value must be 1 ~ 45");
        }
    }

    private void validateSize(final Set<Integer> nums) {
        if (nums.size() != 6) {
            throw new IllegalArgumentException("lotto nums size must be 6");
        }
    }

    public Set<Integer> nums() {
        return this.nums;
    }
}
