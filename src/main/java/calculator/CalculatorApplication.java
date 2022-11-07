package calculator;

import calculator.domain.Calculator;
import calculator.domain.Parser;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorApplication {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        Parser parser = new Parser();

        String input = InputView.scanString();
        int result = calculator.calculate((parser.parseString(input)));

        OutputView.printResult(result);
    }
}
