package stringcalculator.controller;

import stringcalculator.domain.Experssion;
import stringcalculator.view.InputView;
import stringcalculator.view.ResultView;

public class StringCalculator {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        Experssion experssion = new Experssion(inputView.promptExpression());

        ResultView resultView = new ResultView();
        resultView.showResult(experssion.reduce());
    }
}
