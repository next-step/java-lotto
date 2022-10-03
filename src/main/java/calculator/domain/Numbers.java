package calculator.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Numbers {

    private static final String MIN_SIZE_MESSAGE = "적어도 숫자 2개의 숫자가 입력되어야 합니다.";
    private static final String NOT_NUMBERS_MESSAGE = "숫자의 위치에 숫자가 아닌 값이 입력되었습니다.";

    private final List<Integer> values;

    public Numbers(final List<Integer> values) {
        validate(values.size());
        this.values = values;
    }

    public static Numbers of(final List<String> values) {
        return new Numbers(parseIntegerList(values));
    }

    private static void validate(int size) {
        if (size < 2) {
            throw new IllegalArgumentException(MIN_SIZE_MESSAGE);
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
