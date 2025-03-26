package calculator.domain;

import calculator.domain.exception.UnexpectedOperatorException;
import java.util.Arrays;

public enum Operator {

    PLUS("+") {
        @Override
        public Number apply(Number left, Number right) {
            return left.add(right);
        }
    },
    MINUS("-") {
        @Override
        public Number apply(Number left, Number right) {
            return left.subtract(right);
        }
    },
    MULTIPLY("*") {
        @Override
        public Number apply(Number left, Number right) {
            return left.multiplyBy(right);
        }
    },
    DIVIDE("/") {
        @Override
        public Number apply(Number left, Number right) {
            return left.divideBy(right);
        }
    };

    private final String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public static Operator from(String operator) {
        return Arrays.stream(values())
            .filter(e -> e.operator.equals(operator))
            .findFirst()
            .orElseThrow(UnexpectedOperatorException::new);
    }

    public abstract Number apply(Number left, Number right);

}
