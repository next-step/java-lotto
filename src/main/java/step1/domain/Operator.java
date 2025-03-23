package step1.domain;

import java.util.Arrays;

public enum Operator implements Calculable {
    ADD("+") {
        @Override
        public int calculate(int left, int right) {
            return left + right;
        }
    },
    MINUS("-") {
        @Override
        public int calculate(int left, int right) {
            return left - right;
        }
    },
    MULTIPLE("*") {
        @Override
        public int calculate(int left, int right) {
            return left * right;
        }
    },
    DIVIDE("/") {
        @Override
        public int calculate(int left, int right) {
            if (right == 0) throw new ArithmeticException("0으로 나눌 수 없습니다.");
            return left / right;
        }
    };

    public final String sign;

    Operator(String sign) {
        this.sign = sign;
    }

    public static Operator from(String sign) {
        return Arrays.stream(values())
                .filter(op -> op.sign.equals(sign))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 연산자는 유효하지 않습니다. " + sign));
    }


}
