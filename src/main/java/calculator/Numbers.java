package calculator;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Numbers {

    private static final int MIN_NUMBERS_SIZE = 1;
    private final List<Number> numbers;

    public static Numbers from(String expression, Pattern delimiterPattern) {
        checkNotNull(expression, delimiterPattern);
        List<Number> numbers = createPositives(expression, delimiterPattern);
        return new Numbers(numbers);
    }

    private static List<Number> createPositives(String expression, Pattern delimiterPattern) {
        return stream(delimiterPattern.split(expression))
                .map(Number::from)
                .collect(Collectors.toList());
    }

    public Numbers(List<Number> numbers) {
        checkNotEmpty(numbers);
        this.numbers = numbers;
    }

    private static void checkNotNull(Object... objects) {
        for (Object object : objects) {
            checkNotNull(object);
        }
    }

    private static void checkNotNull(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("필수 값이 없습니다.");
        }
    }

    private static void checkNotEmpty(List<Number> numbers) {
        checkNotNull(numbers);
        if (numbers.size() < MIN_NUMBERS_SIZE) {
            throw new IllegalArgumentException("하나 이상의 Number가 필요합니다.");
        }
    }

    public int sum() {
        return numbers.stream()
                .reduce(Number::plus)
                .orElseThrow(() -> new IllegalStateException("positives is empty"))
                .getNumber();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numbers that = (Numbers) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
