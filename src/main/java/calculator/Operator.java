package calculator;

import calculator.exception.InvalidOperatorException;
import java.util.Arrays;

public enum Operator {

    ADD("+") {
        @Override
        public int apply(int leftOperand, int rightOperand) {
            return leftOperand + rightOperand;
        }
    },
    SUB("-") {
        @Override
        public int apply(int leftOperand, int rightOperand) {
            return leftOperand - rightOperand;
        }
    },
    MULTIPLY("*") {
        @Override
        public int apply(int leftOperand, int rightOperand) {
            return leftOperand * rightOperand;
        }
    },
    DIV("/") {
        @Override
        public int apply(int leftOperand, int rightOperand) {
            if (rightOperand == 0) {
                throw new DivideByZeroException();
            }
            return leftOperand / rightOperand;
        }
    };

    private final String operatorStr;

    Operator(String operatorStr) {
        this.operatorStr = operatorStr;
    }

    public abstract int apply(int leftOperand, int rightOperand);

    public static Operator getOperator(String symbol) {
        return Arrays.stream(Operator.values())
                .filter(op -> op.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(InvalidOperatorException::new);
    }
}
