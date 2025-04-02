package step1;

import step1.view.InputView;
import step1.view.OutputView;

public class Main {
    public static void main(String[] args) {
        String input = InputView.inputExpression();
        Calculator calculator = new Calculator(input);
        OutputView.printResult(calculator.calculate());
    }
}
