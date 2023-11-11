package lotto.step2.validator;

import java.util.Set;

public class NumberValidator {
    public static void validateNums(final Set<Integer> nums) {
        validateSize(nums);

        validateValue(nums);
    }

    private static void validateValue(final Set<Integer> nums) {
        for (Integer num : nums) {
            throwExceptionIfValueIsNotValid(num);
        }
    }

    private static void throwExceptionIfValueIsNotValid(final Integer num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException("lotto nums value must be 1 ~ 45");
        }
    }

    private static void validateSize(final Set<Integer> nums) {
        if (nums.size() != 6) {
            throw new IllegalArgumentException("lotto nums size must be 6");
        }
    }
}
