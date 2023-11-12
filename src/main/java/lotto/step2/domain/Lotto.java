package lotto.step2.domain;

import lotto.step2.validator.NumberValidator;

import java.util.Set;

public class Lotto {
    private final Set<Integer> nums;

    public Lotto(Set<Integer> nums) {
        NumberValidator.validateNums(nums);

        this.nums = nums;
    }
    
    public Set<Integer> nums() {
        return this.nums;
    }

    @Override
    public String toString() {
        return this.nums.toString();
    }
}
