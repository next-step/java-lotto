package calculator.domain;

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
            return i / j;
        }
    };

    private static final String INVALID_OPERATION_MSE = "올바른 기호가 아닙니다.";
    private String operation;


    Operation(String operation) {
        this.operation = operation;
    }


    public static Operation fromString(String token) {
        return Arrays.stream(values())
                .filter(v -> v.name().equals(token))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_OPERATION_MSE));
    }


}
