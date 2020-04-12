package practice.controller;

import practice.domain.Calculator;
import practice.view.InputView;
import practice.view.ResultView;

public class CalculatorMain {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        final String formula = inputView.getFormula();

        ResultView resultView = new ResultView();
        resultView.printTitle();
        resultView.printResult(formula, Calculator.Sum(formula));
    }
}
