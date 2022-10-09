package controller;

import domain.InputValues;
import service.Calculation;
import view.InputView;
import view.ResultView;

public class Main {

    public static void main(String[] args) {

        InputValues inputValues = InputView.inputInfo();
        Calculation calculation = new Calculation();

        int result = calculation.calculateInputValue(inputValues);

        ResultView resultView = new ResultView();
        resultView.printResult(result);

    }
}
