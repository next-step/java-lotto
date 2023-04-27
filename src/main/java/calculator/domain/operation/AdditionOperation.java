package calculator.domain.operation;

import calculator.domain.expression.Operand;
import calculator.domain.expression.Operator;

import static calculator.domain.expression.Operator.ADDITION;

public class AdditionOperation implements ArithmeticOperation {

    @Override
    public boolean supports(Operator operator) {
        return ADDITION.equals(operator);
    }

    @Override
    public int calculate(Operand firstOperand, Operand nextOperand) {
        return firstOperand.toInt() + nextOperand.toInt();
    }

}
