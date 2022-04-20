package controller;

import domain.Calculator;
import ui.InputView;
import ui.ResultView;

public class Controller {
    public static void main(String[] args) {
        ResultView.printResult(new Calculator(InputView.inputFormula()).calculate());
    }
}
