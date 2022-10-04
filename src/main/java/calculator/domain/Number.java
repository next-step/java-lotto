package calculator.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Number {

    private final long number;

    public Number(final long number) {

        this.number = number;
    }

    public Number(final String number) {

        validate(number);
        this.number = convert(number);
    }

    public static List<Number> from(final List<String> expressions) {

        return convert(expressions);
    }

    private static List<Number> convert(final List<String> expressions) {

        return expressions.stream()
                .filter(expression -> !Operation.match(expression))
                .map(Number::new)
                .collect(Collectors.toList());
    }

    private void validate(String number) {

        validateNullOrEmpty(number);
        validateDigit(number);
    }

    private void validateNullOrEmpty(final String expression) {

        if (expression == null || expression.isBlank()) {
            throw new IllegalArgumentException("입력 값이 null 또는 빈 공백 입니다.");
        }
    }

    private void validateDigit(final String number) {

        for (int i = 0; i < number.length(); i++) {
            checkNumber(number, i);
        }
    }

    private void checkNumber(final String number, final int index) {

        if (!Character.isDigit(number.charAt(index))) {
            throw new IllegalArgumentException("계산기를 잘못 입력하였습니다.");
        }
    }

    private long convert(final String number) {

        return Long.parseLong(number);
    }

    public long getNumber() {
        return this.number;
    }
}
