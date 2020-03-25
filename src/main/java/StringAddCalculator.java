import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class StringAddCalculator {
    public static int addString(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }
        return sum(convertFromStringToNumbers(input));
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static int sum(PositiveNumbers positiveNumbers) {
        return positiveNumbers.sum();
    }

    private static PositiveNumbers convertFromStringToNumbers(String input) {
        List<String> strings = StringSplitter.split(input);
        return covertToNumber(strings);
    }


    private static PositiveNumbers covertToNumber(List<String> stringNumbers) {
        try {
            return stringNumbers.stream()
                    .map(Integer::parseInt)
                    .map(PositiveNumber::new)
                    .collect(collectingAndThen(toList(), PositiveNumbers::new));
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아닌 값은 입력할 수 없습니다.");
        }
    }
}