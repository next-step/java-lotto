package lotto.controller;

import lotto.domain.Calculator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class CalculatorMain {

    public static void main(String[] args) {

        InputView inputView = new InputView();

        final String formula = inputView.getFormula();

        ResultView resultView = new ResultView();
        resultView.printTitle();
        resultView.printResult(formula, Calculator.Sum(formula));
    }
}
