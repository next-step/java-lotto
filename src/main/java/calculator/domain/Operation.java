package calculator.domain;

import java.util.InputMismatchException;


public enum Operation {
    PLUS("+") {
        public int calculate(int first, int second) {
            return first + second;
        }
    },
    SUBTRACT("-") {
        public int calculate(int first, int second) {
            return first - second;
        }
    },
    MULTIPLY("*") {
        public int calculate(int first, int second) {
            return first * second;
        }
    },
    DIVIDE("/") {
        public int calculate(int first, int second) {
            return first / second;
        }
    };

    private final String sign;

    Operation(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return sign;
    }

    public abstract int calculate(int first, int second);

    public static Operation findOperationBySign(String text) {
        for (Operation operation : Operation.values()) {
            if (operation.toString().equals(text)) {
                return operation;
            }
        }

        throw new InputMismatchException("잘못된 사칙연산 기호 입니다.");
    }


}
