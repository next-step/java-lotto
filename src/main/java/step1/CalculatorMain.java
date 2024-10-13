package step1;

import step1.exception.WrongCalculationException;

public class CalculatorMain {
    private static final CalculatorMachine calculatorMachine = new CalculatorMachine();

    public static void main(String[] args) throws WrongCalculationException {
        calculatorMachine.start();
    }
}
