package calculator;

import java.util.Arrays;

public enum Operator {
    ADD("+") {
        @Override
        public int operate(int num1, int num2) {
            return num1 + num2;
        }
    },
    SUBSTRACT("-") {
        @Override
        public int operate(int num1, int num2) {
            return num1 - num2;
        }
    },
    MULTIPLY("*") {
        @Override
        public int operate(int num1, int num2) {
            return num1 * num2;
        }
    },
    DIVIDE("/") {
        @Override
        public int operate(int num1, int num2) {
            if (num2 == 0)
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            return num1 / num2;
        }
    },
    ;

    private final String textOperator;

    Operator(String textOperator) {
        this.textOperator = textOperator;
    }

    public abstract int operate(int num1, int num2);

    public static Operator checkOperator(String sign) {
        return Arrays.stream(values()).filter(operator -> operator.textOperator.equals(sign))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사칙연산 기호가 아닙니다."));
    }
}
