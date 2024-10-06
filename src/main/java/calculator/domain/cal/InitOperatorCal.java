package calculator.domain.cal;

import calculator.domain.Calculable;

public class InitOperatorCal implements Calculable {

    @Override
    public int calculate(int preResult, int operand) {
        return operand;
    }
}
