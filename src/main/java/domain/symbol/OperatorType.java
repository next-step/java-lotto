package domain.symbol;

import domain.symbol.operator.AddOperator;
import domain.symbol.operator.DivideOperator;
import domain.symbol.operator.MultiplyOperator;
import domain.symbol.operator.SubtractOperator;

public enum OperatorType {
    ADD("+", new AddOperator()),
    SUBTRACT("-", new SubtractOperator()),
    MULTIPLY("*", new MultiplyOperator()),
    DIVIDE("/", new DivideOperator());

    private final String value;
    private final Operator operator;

    OperatorType(String value, Operator operator) {
        this.value = value;
        this.operator = operator;
    }

    public Operand operate(Operand firstOperand, Operand secondOperand) {
        return operator.operate(firstOperand, secondOperand);
    }

    public static OperatorType findOperatorByString(String value) {
        OperatorType operatorType = null;
        for (OperatorType candidateOperatorType : OperatorType.values()) {
            operatorType = matchValue(value, operatorType, candidateOperatorType);
        }

        if (operatorType == null) {
            throw new IllegalArgumentException("Invalid operator");
        }

        return operatorType;
    }

    private static OperatorType matchValue(String value, OperatorType currentOperatorType, OperatorType operatorType) {
        if (currentOperatorType != null) {
            return currentOperatorType;
        }

        if (operatorType.value.equals(value)) {
            return operatorType;
        }
        return null;
    }
}
