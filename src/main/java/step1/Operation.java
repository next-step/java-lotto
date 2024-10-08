package step1;

import java.util.Arrays;

public enum Operation {
    PLUS("+") {
        public int apply(int x, int y) {
            return x + y;
        }
    },
    MINUS("-") {
        public int apply(int x, int y) {
            return x - y;
        }
    },
    MULTIPLY("*") {
        public int apply(int x, int y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        public int apply(int x, int y) {
            if (y == 0) {
                throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
            }

            return x / y;
        }
    };

    private String operator;

    Operation(String operator) {
        this.operator = operator;
    }

    public static Operation findBySign(String sign) {
        return Arrays.stream(Operation.values())
                     .filter(operator -> operator.has(sign))
                     .findAny()
                     .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
    }

    public static boolean hasOperator(String sign) {
        return Arrays.stream(Operation.values())
                     .anyMatch(operator -> operator.has(sign));
    }

    private boolean has(String sign) {
        return operator.equals(sign);
    }

    public abstract int apply(int x, int y);
}


