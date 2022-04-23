package StringCalculator.model;

import StringCalculator.Exception.InvalidArithmethicException;

import java.util.Arrays;

public enum ArithmeticSign {
    ADDITION("+") {
        @Override
        int calculate(int a, int b) {
            return a + b;
        }
    },
    SUBTRACTION("-") {
        @Override
        int calculate(int a, int b) {
            return a - b;
        }
    },
    DIVISION("/") {
        @Override
        int calculate(int a, int b) {
            if (b == 0) {
                throw new InvalidArithmethicException("0으로 나눌수 없습니다.");
            }
            return a / b;
        }
    },
    MULTIPLICATION("*") {
        @Override
        int calculate(int a, int b) {
            return a * b;
        }
    };

    private final String sign;

    ArithmeticSign(String sign) {
        this.sign = sign;
    }

    public static ArithmeticSign findSign(String text) {
        return Arrays.stream(values()).filter(key -> key.sign.equals(text)).findFirst().orElseThrow(IllegalArgumentException::new);
    }

    abstract int calculate(int a, int b);
}
