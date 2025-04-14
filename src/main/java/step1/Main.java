package step1;

import step1.domain.Calculator;
import step1.view.InputView;
import step1.view.OutputView;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String[] input = inputView.init();
        Calculator calculator = new Calculator();
        OutputView outputView = new OutputView();
        outputView.print(calculator.calculate(input).getValue());
    }
}
