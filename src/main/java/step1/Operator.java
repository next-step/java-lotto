package step1;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Operator implements CalculateInterface {
    PLUS("+") {
        @Override
        public int calculate(int first, int second) {
            return first + second;
        }
    },
    MINUS("-") {
        @Override
        public int calculate(int first, int second) {
            return first - second;
        }
    },
    MULTIPLE("*") {
        @Override
        public int calculate(int first, int second) {
            return first * second;
        }
    },
    DIVIDE("/") {
        @Override
        public int calculate(int first, int second) {
            return first / second;
        }
    };

    private final String sign;

    Operator(String sign) {
        this.sign = sign;
    }

    public static Operator findOperatorEnum(String sign) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.sign.equals(sign))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("해당하는 연산자가 없습니다."));
    }
}
