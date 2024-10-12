package calculator;

import calculator.domain.Calculator;
import calculator.ui.InputView;
import calculator.ui.ResultView;

public class Main {
    public static void main(String[] args) {
        String input = InputView.input();
        int result = Calculator.calculate(input);
        ResultView.printResult(result);
    }
}
