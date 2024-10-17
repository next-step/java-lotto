package calculator;

import calculator.domain.*;

public class CalculatorInterface {
    public Integer start(String input) {
        Calculator calculator = Calculator.create(input);
        return calculator.calculate().getValue();
    }

    public static void main(String[] args) {
        CalculatorInterface calculatorInterface = new CalculatorInterface();
        System.out.println("result = " + calculatorInterface.start("0 + 0 - 2 * 4 / 2 + 4"));
    }
}
