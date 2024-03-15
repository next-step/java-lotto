package calculator;

import java.util.Arrays;

public enum Operator {
    PLUS("+") {
        @Override
        public int apply(int firstNumber, int secondNumber) {
            return firstNumber + secondNumber;
        }
    },
    MINUS("-") {
        @Override
        public int apply(int firstNumber, int secondNumber) {
            return firstNumber - secondNumber;
        }
    },
    MULTIPLE("*") {
        @Override
        public int apply(int firstNumber, int secondNumber) {
            return firstNumber * secondNumber;
        }
    },
    DIVIDE("/") {
        @Override
        public int apply(int firstNumber, int secondNumber) {
            return firstNumber / secondNumber;
        }
    };

    private final String sign;

    Operator(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return this.sign;
    }

    public abstract int apply(int firstNumber, int secondNumber);

    public static Operator valueOfSign(String sign) {
        return Arrays.stream(values())
                .filter(value -> value.getSign().equals(sign))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("정확한 연산자를 입력해주세요."));
    }
}
