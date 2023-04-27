package calculator.domain.operation;

import calculator.domain.expression.Operand;
import calculator.domain.expression.Operator;

import static calculator.domain.expression.Operator.*;

public class DivisionOperation implements ArithmeticOperation {
    @Override
    public boolean supports(Operator operator) {
        return DIVISION.equals(operator);
    }

    @Override
    public int calculate(Operand firstOperand, Operand nextOperand) {
        if (nextOperand.toInt() == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return Math.floorDiv(firstOperand.toInt(), nextOperand.toInt());
    }
}
