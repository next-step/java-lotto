package calculator.domain.calculator;

import calculator.domain.Calculable;

public class InitOperatorCalculator implements Calculable {

    @Override
    public int calculate(int preResult, int operand) {
        return operand;
    }
}
