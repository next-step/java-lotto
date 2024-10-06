package calculator.domain.cal;

import calculator.domain.Calculable;

public class MultiplicationCal implements Calculable {

    @Override
    public int calculate(int preResult, int operand) {
        return preResult * operand;
    }
}
