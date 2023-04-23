package step1.domain.model;

import step1.exception.NumberIllegalStateException;

import java.util.Objects;

public class Number {
    private static final String DELIMITER = "[0-9]+";

    private int number;

    public Number(String number) {
        if (!isNumber(number)) {
            throw new NumberIllegalStateException("유효한 숫자가 아닙니다.");
        }
        this.number = Integer.parseInt(number);
    }

    public static Number from(String number) {
        return new Number(number);
    }

    private boolean isNumber(String number) {
        return (Objects.nonNull(number) && number.matches(DELIMITER));
    }

    public int getNumber() {
        return number;
    }
}
