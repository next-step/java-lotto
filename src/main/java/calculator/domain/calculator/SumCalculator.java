package calculator.domain.calculator;

import calculator.domain.Calculable;

public class SumCalculator implements Calculable {

    @Override
    public int calculate(int preResult, int operand) {
        return preResult + operand;
    }
}
