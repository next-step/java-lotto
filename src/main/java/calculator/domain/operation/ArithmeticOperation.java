package calculator.domain.operation;

import calculator.domain.expression.Operand;
import calculator.domain.expression.Operator;

public interface ArithmeticOperation {

    boolean supports(Operator operator);

    int calculate(Operand firstOperand, Operand nextOperand);
}
