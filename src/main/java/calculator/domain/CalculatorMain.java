package calculator.domain;

import calculator.io.InputView;
import calculator.io.OutputView;

public class CalculatorMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        Calculator calculator = new Calculator(inputView.input);

        OutputView outputView = new OutputView(calculator.inputList);

    }
}
