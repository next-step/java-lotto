package calculator;

import java.util.Arrays;

public enum Operation implements Calculate {
    PLUS("+") {
        @Override
        public int calculate(int i, int j) {
            return i + j;
        }
    },
    MINUS("-") {
        @Override
        public int calculate(int i, int j) {
            return i - j;
        }
    },
    TIMES("*") {
        @Override
        public int calculate(int i, int j) {
            return i * j;
        }
    },
    DIVISION("/") {
        @Override
        public int calculate(int i, int j) {
            if (j == 0) {
                throw new IllegalArgumentException(ZERO_NOT_DIVIDE_MSG);
            }
            return i / j;
        }
    };

    public static final String ZERO_NOT_DIVIDE_MSG = "0은 나눗셈 연산을 할 수 없습니다.";
    private static final String INVALID_OPERATION_MSE = "올바른 기호가 아닙니다.";
    private String name;


    Operation(String name) {
        this.name = name;
    }

    public static Operation fromString(String token) {
        return Arrays.stream(values())
                .filter(v -> v.name.equals(token))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_OPERATION_MSE));
    }
}
