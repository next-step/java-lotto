package controller;

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
        NumberSentence numberSentence = inputView.inputNumberSentence();



    }
}
