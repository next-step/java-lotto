package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Number {

    private static final String NEGATIVE_SIGN = "-";

    private final int number;

    public Number(final String number) {
        validateNumberFormat(number);
        validatePositiveNum(number);
        this.number = Integer.parseInt(number);
    }

    public Number(final int number) {
        this.number = number;
    }

    public Number add(Number operand) {
        return new Number(number + operand.getNumber());
    }

    private void validateNumberFormat(final String number) {
        char[] chars = number.toCharArray();

        IntStream.range(0, chars.length)
            .mapToObj(idx -> chars[idx])
            .filter(character -> !Character.isDigit(character))
            .findFirst().ifPresent(character -> {
                throw new IllegalArgumentException("올바른 숫자 포맷이 아닙니다.");
            });
    }

    private void validatePositiveNum(final String number) {
        if (number.contains(NEGATIVE_SIGN)) {
            throw new IllegalArgumentException("숫자가 음수입니다.");
        }
    }

    public int getNumber() {
        return number;
    }
}
