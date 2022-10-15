package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Number {

    private static final int MIN = 1;
    private static final int MAX = 45;

    private int number;

    public Number(final int number) {

        validate(number);
        this.number = number;
    }

    public static Number from(final String input) {

        try {
            return new Number(Integer.parseInt(input));
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("숫자만 입력해야 합니다.");
        }
    }

    public static List<Integer> range() {

        return IntStream.range(MIN, MAX)
                .boxed()
                .collect(Collectors.toList());
    }

    private void validate(final int number) {

        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException("로또 숫자는 1 ~ 45 사이여야 합니다.");
        }
    }

    public int getNumber() {

        return this.number;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {

        return Objects.hash(number);
    }
}
