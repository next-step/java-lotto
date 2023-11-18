package step1.controller;

import step1.domain.StringCalculator;
import step1.view.InputView;
import step1.view.ResultView;

public class StringCalculatorController {

    public static void run() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        inputView.printInputMessage();
        String inputExpression = inputView.inputExpression();
        StringCalculator stringCalculator = new StringCalculator(inputExpression);
        resultView.printResultMessage(stringCalculator.calculateExecute());
    }
}
