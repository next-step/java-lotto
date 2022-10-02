package step1;

import step1.controller.CalculatorController;
import step1.view.InputView;
import step1.view.ResultView;

public class CalculatorApplication {
    public static void main(String[] args) {
        new CalculatorController(new InputView(), new ResultView()).run();
    }
}
