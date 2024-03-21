package calculator;

import calculator.domain.Calculator;
import calculator.domain.Numbers;
import calculator.domain.Symbols;
import calculator.view.InputView;
import calculator.view.ResultView;


public class CalculatorApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String[] line = inputView.split(inputView.getInput());
        Calculator calculator = new Calculator(Numbers.create(line), Symbols.create(line));
        int result = calculator.run();
        ResultView.printResult(result);
    }
}
