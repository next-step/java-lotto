package calculator;

import calculator.view.InputView;
import calculator.view.ResultView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        ResultView.printResult(new StringCalculator(inputView.input()).result());

        inputView.closeScanner();
    }
}
