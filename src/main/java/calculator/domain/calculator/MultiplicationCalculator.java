package calculator.domain.calculator;

import calculator.domain.Calculable;

public class MultiplicationCalculator implements Calculable {

    @Override
    public int calculate(int preResult, int operand) {
        return preResult * operand;
    }
}
