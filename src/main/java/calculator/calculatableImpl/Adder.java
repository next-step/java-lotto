package calculator.calculatableImpl;

import calculator.Calculatable;

public class Adder implements Calculatable {
    @Override
    public int run(int firstOperand, int secondOperand) {
        return firstOperand + secondOperand;
    }
}
