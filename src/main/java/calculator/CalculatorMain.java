package calculator;

import calculator.exception.WrongCalculationException;

public class CalculatorMain {
    private static final CalculatorMachine calculatorMachine = new CalculatorMachine();

    public static void main(String[] args) throws WrongCalculationException {
        calculatorMachine.start();
    }
}
