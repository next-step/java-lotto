package calculator.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Numbers {

    private static final String NULL_MESSAGE = "null인 값은 생성자에 입력될 수 없습니다.";
    private static final String MIN_SIZE_MESSAGE = "적어도 숫자 %s개의 숫자가 입력되어야 합니다.";
    private static final int MIN_SIZE = 2;
    private static final String NOT_NUMBERS_MESSAGE = "숫자의 위치에 숫자가 아닌 값이 입력되었습니다.";

    private final List<Integer> values;

    public Numbers(final List<Integer> values) {
        validate(values);
        this.values = values;
    }

    public static Numbers from(final List<String> values) {
        return new Numbers(parseIntegerList(values));
    }

    private void validate(List<Integer> values) {
        validateNull(values);
        validateMinSize(values.size());
    }

    private static void validateNull(Object values) {
        if (Objects.isNull(values)) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
    }

    private static void validateMinSize(int size) {
        if (size < MIN_SIZE) {
            throw new IllegalArgumentException(String.format(MIN_SIZE_MESSAGE, MIN_SIZE));
        }
    }

    private static List<Integer> parseIntegerList(List<String> values) {
        return values.stream()
                .map(Numbers::parseInt)
                .collect(Collectors.toList());
    }

    private static int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBERS_MESSAGE);
        }
    }

    public int size() {
        return values.size();
    }

    public int get(int index) {
        return values.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numbers numbers = (Numbers) o;
        return Objects.equals(values, numbers.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }
}
