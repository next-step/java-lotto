package calculator.calculatableImpl;

import calculator.Calculatable;

public class Divider implements Calculatable {
    @Override
    public int run(int firstOperand, int secondOperand) {
        return firstOperand / secondOperand;
    }
}
