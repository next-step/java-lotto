package calculator;

import calculator.domain.Calculator;
import calculator.domain.Parser;
import calculator.view.CalculatorInputView;
import calculator.view.CalculatorOutputView;

public class CalculatorApplication {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        Parser parser = new Parser();

        String input = CalculatorInputView.scanString();
        int result = calculator.calculate((parser.parseString(input)));

        CalculatorOutputView.printResult(result);
    }
}
