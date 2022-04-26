package calculator.model;

import java.util.Objects;

public enum Symbol {
    ADDITION("+"), SUBTRACTION("-"), MULTIPLICATION("*"), DIVISION("/");

    private static final String REGEX = "^[+\\-*/]+$";
    private final String desc;

    Symbol(String desc) {
        this.desc = desc;
    }

    public static Symbol convert(String operator) {

        if (!operator.matches(REGEX)) {
            throw new IllegalArgumentException("사칙연산 기호만 사용 가능합니다.");
        }

        if (Objects.equals(operator, SUBTRACTION.desc)) {
            return Symbol.SUBTRACTION;
        }

        if (Objects.equals(operator, MULTIPLICATION.desc)) {
            return Symbol.MULTIPLICATION;
        }

        if (Objects.equals(operator, DIVISION.desc)) {
            return Symbol.DIVISION;
        }

        return Symbol.ADDITION;
    }
}
