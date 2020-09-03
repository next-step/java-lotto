package stringAddCalculator;

import java.util.Arrays;
import java.util.Objects;

public class StringAddCalculator {

    public static int splitAndSum(String value) {
        if (isNullOrEmpty(value)) {
            return 0;
        }
        return sum(StringUtils.split(value));
    }

    private static boolean isNullOrEmpty(String value) {
        return Objects.isNull(value) || value.isEmpty();
    }

    private static int sum(String[] tokens) {
        return Arrays.stream(tokens)
                .mapToInt(StringAddCalculator::mapToPositiveInt)
                .sum();
    }

    private static int mapToPositiveInt(String value) {
        int number = Integer.parseInt(value);
        if (number < 0) {
            throw new RuntimeException("인자로 음수가 올 수 없습니다.");
        }
        return number;
    }
}
