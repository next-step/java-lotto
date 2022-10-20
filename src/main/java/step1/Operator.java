package step1;

import java.util.Arrays;

public enum Operator {
    PLUS('+') {
        int cal(int num1, int num2) {
            return num1 + num2;
        }
    },
    MINUS('-') {
        int cal(int num1, int num2) {
            return num1 - num2;
        }
    },
    MULTIPLY('*') {
        int cal(int num1, int num2) {
            return num1 * num2;
        }
    },
    DIVIDE('/') {
        int cal(int num1, int num2) {
            return num1 / num2;
        }
    };

    private final char op;

    Operator(char op) {
        this.op = op;
    }

    public static Operator of(char op) {
        return Arrays.stream(values())
                .filter(operator -> operator.op == op)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("사칙역산 형식이 아닙니다."));
    }

    abstract int cal(int num1, int num2);
}
