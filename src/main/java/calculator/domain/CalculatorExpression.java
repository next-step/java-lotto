package calculator.domain;

import calculator.domain.VariableExpression;

public interface CalculatorExpression {

    static final int RADIX = 10;
    VariableExpression calculate(VariableExpression result, VariableExpression variableExpression);
}
