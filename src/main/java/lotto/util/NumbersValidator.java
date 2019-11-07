package lotto.util;

import java.util.List;

/**
 * Created by yusik on 2019/11/07.
 */
public class NumbersValidator {

    public static boolean validateRange(List<Integer> numbers, int min, int max) {
        return numbers.stream()
                .allMatch(number -> number >= min && number <= max);
    }

    public static boolean validateSize(List<Integer> numbers, int size) {
        return size == numbers.size();
    }

    public static boolean validateDuplicate(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() == numbers.size();
    }

}
