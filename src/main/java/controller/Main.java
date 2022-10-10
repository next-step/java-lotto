package controller;

import service.InputValueParser;
import service.Calculator;
import view.InputView;
import view.ResultView;

public class Main {

    public static void main(String[] args) {

        InputValueParser inputValueParser = InputView.inputInfo();
        Calculator calculator = new Calculator();

        int result = calculator.calculateInputValue(inputValueParser);

        ResultView resultView = new ResultView();
        resultView.printResult(result);
    }
}
