package calculator;

import calculator.view.CalculatorInputView;
import calculator.view.CalculatorResultView;

public class CalculatorApplication {
    public static void main(String[] args) {
        String input = CalculatorInputView.inputArithmeticExpression();
        int result = Calculator.splitAndCalculate(input);
        CalculatorResultView.printResult(result);
    }
}
