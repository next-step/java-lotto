package calculator;

import java.util.Arrays;

public enum Arithmetic {
    PLUS("+") {
        @Override
        Number calculate(Number number1, Number number2) {
            return new Number(number1.getNumber() + number2.getNumber());
        }
    },
    MINUS("-") {
        @Override
        Number calculate(Number number1, Number number2) {
            return new Number(number1.getNumber() - number2.getNumber());
        }
    },
    MULTIPLICATION("*") {
        @Override
        Number calculate(Number number1, Number number2) {
            return new Number(number1.getNumber() * number2.getNumber());
        }
    },
    DIVIDE("/") {
        @Override
        Number calculate(Number number1, Number number2) {
            if (number1.getNumber() % number2.getNumber() != 0) {
                throw new IllegalArgumentException("나눗셈은 결과값이 정수로 떨어져야만 합니다.");
            }
            return new Number(number1.getNumber() / number2.getNumber());
        }
    };

    private final String sign;

    Arithmetic(String sign) {
        this.sign = sign;
    }

    public static Arithmetic findSign(String sign) {
        return Arrays.stream(Arithmetic.values())
                .filter(a -> a.sign.equals(sign))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사칙연산 기호가 아닙니다!"));
    }

    abstract Number calculate(Number number1, Number number2);

}
