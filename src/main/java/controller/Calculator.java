package controller;

import model.Calculation;
import model.NumberSentence;
import view.InputView;
import view.ResultView;

public class Calculator {
    private final InputView inputView;
    private final ResultView resultView;

    public Calculator(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void start() {
        resultView.printInputNumberSentence();
        NumberSentence numberSentence = inputView.inputNumberSentence();

        int resultNumber = Calculation.calculate(numberSentence);

        resultView.printResultNumber(resultNumber);
    }
}
