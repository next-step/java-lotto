package calculator;

import calculator.exception.WrongCalculationException;
import calculator.model.Operands;
import calculator.model.Operators;

public class CalculatorMain {
    private static final CalculatorMachine calculatorMachine = new CalculatorMachine(new Operands(), new Operators());

    public static void main(String[] args) throws WrongCalculationException {
        calculatorMachine.start();
    }
}
