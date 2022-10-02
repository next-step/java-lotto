package calculator;

import calculator.exception.InvalidOperatorException;

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
            return leftOperand / rightOperand;
        }
    };

    private final String operatorStr;

    Operator(String operatorStr) {
        this.operatorStr = operatorStr;
    }

    public abstract int apply(int leftOperand, int rightOperand);

    public static Operator getOperator(String operatorStr) {
        for (Operator op : Operator.values()) {
            if (op.operatorStr.equals(operatorStr)) {
                return op;
            }
        }
        throw new InvalidOperatorException();
    }
}
