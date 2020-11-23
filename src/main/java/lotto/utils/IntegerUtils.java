package lotto.utils;

import lotto.constant.ErrorMessage;

import java.util.List;
import java.util.stream.Collectors;

public class IntegerUtils {
    private IntegerUtils() {
    }

    public static List<Integer> parsePositiveInt(List<String> values) {
        return values.stream()
                .map(Integer::parseInt)
                .map(IntegerUtils::validPositive)
                .collect(Collectors.toList());
    }

    private static Integer validPositive(Integer value) {
        if (value < 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_NEGATIVE_QUANTITY);
        }
        return value;
    }
}
