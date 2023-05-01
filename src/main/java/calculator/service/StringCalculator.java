package calculator.service;

import calculator.domain.OperandGroup;
import calculator.domain.Operator;
import calculator.domain.OperatorGroup;

public class StringCalculator {
    private final OperatorGroup operatorGroup;
    private final OperandGroup operandGroup;

    public StringCalculator(OperatorGroup operatorGroup, OperandGroup operandGroup) {
        this.operatorGroup = operatorGroup;
        this.operandGroup = operandGroup;
    }

    public int calculate() {
        int result = getInitializeNumber();

        while (operandGroup.isContinue()) {
            int rightOperand = operandGroup.provideOperand();
            Operator operator = operatorGroup.provideOperator();
            result = operatorGroup.operatorExecute(operator, result, rightOperand);
        }
        return result;
    }

    private int getInitializeNumber() {
        return operandGroup.provideOperand();
    }
}
