package stringCalculator;

import stringCalculator.domain.Calculator;
import stringCalculator.view.InputView;
import stringCalculator.view.ResultView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        Calculator calculator = new Calculator(inputView.stringInputView());
        resultView.calculatePrint(calculator.calculateResult());
    }
}
