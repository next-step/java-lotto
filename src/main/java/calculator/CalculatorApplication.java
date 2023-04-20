package calculator;

import calculator.domain.Calculator;

public class CalculatorApplication {

    public static void main(String[] args) {
        String input = InputView.console();
        int calculate = Calculator.calculate(input);
        System.out.println("=" + calculate);
    }

}