package calculator;

import java.util.Arrays;

public enum Operator {
    PLUS("+") {
        public int apply(int x, int y) {
            return x + y;
        }
    },
    MINUS("-") {
        @Override
        public int apply(int x, int y) {
            return x - y;
        }
    },
    MULTIPLY("*") {
        @Override
        public int apply(int x, int y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        @Override
        public int apply(int x, int y) {
            return x / y;
        }
    };

    private final String sign;

    Operator(String sign) {
        this.sign = sign;
    }

    public static Operator findOperatorByToken(String token) {
        return Arrays.stream(values())
                .filter(value -> value.sign.equals(token))
                .findAny()
                .orElse(null);
    }

    public abstract int apply(int x, int y);
}
