package calculator.utils;

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
            throw new IllegalArgumentException("not allow negative quantity");
        }
        return value;
    }
}
