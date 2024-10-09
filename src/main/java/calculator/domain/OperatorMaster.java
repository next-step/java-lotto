package calculator.domain;

import calculator.exception.UnsupportedOperatorException;

import java.util.Arrays;

public enum OperatorMaster implements Operator {

    ADDITION("+") {
        @Override
        public int operates(int operand1, int operand2) {
            return operand1 + operand2;
        }
    },
    SUBTRACTION("-") {
        @Override
        public int operates(int operand1, int operand2) {
            return operand1 - operand2;
        }
    },
    MULTIPLICATION("*") {
        @Override
        public int operates(int operand1, int operand2) {
            return operand1 * operand2;
        }
    },
    DIVISION("/") {
        @Override
        public int operates(int operand1, int operand2) {
            return operand1 / operand2;
        }
    }
    ;

    private final String operator;

    OperatorMaster(String operator) {
        this.operator = operator;
    }

    public static int calculate(String operator, int operand1, int operand2) {
        OperatorMaster operatorMaster = findBy(operator);
        return operatorMaster.operates(operand1, operand2);
    }

    private static OperatorMaster findBy(String operator) {
        return Arrays.stream(values())
                .filter(op -> op.supports(operator))
                .findFirst()
                .orElseThrow(() -> new UnsupportedOperatorException("지원하지 않는 연산자입니다."));
    }

    @Override
    public boolean supports(String operator) {
        return operator.equals(this.operator);
    }
}

