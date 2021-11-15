package calculation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Number {
    private static final String NEGATIVE_NUMBER_ERROR_MESSAGE = "error : 음수는 사용할수 없습니다.";
    private final List<Integer> number;

    public Number(String[] numbers) {
        this(changeToIntegerArrayType(numbers));
    }

    public Number(List<Integer> numbers) {
        checkNegativeNumber(numbers);
        this.number = Collections.unmodifiableList(numbers);
    }

    private static List<Integer> changeToIntegerArrayType(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    private void checkNegativeNumber(List<Integer> numbers) {
        long count = numbers.stream()
                .filter(number -> number < 0)
                .count();

        if (count > 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR_MESSAGE);
        }
    }

    public int sum() {
        return number.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
