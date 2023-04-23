package calculator;

import calculator.view.InputView;
import calculator.view.ResultView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        StringCalculator stringCalculator = new StringCalculator(inputView.input());

        ResultView.printResult(stringCalculator.result());
    }
}
