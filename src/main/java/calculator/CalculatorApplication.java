package calculator;

import calculator.domain.Calculator;
import calculator.domain.CalculatorItems;

public class CalculatorApplication {

    public static void main(String[] args) {
        String input = InputView.console();
        int calculate = Calculator.calculate(new CalculatorItems(input));
        System.out.println("=" + calculate);
    }

}