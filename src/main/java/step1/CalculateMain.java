package step1;

import step1.controller.Calculator;
import step1.domain.Inputs;
import step1.view.InputView;
import step1.view.ResultView;

public class CalculateMain {
    public static void main(String[] args) {
        Inputs inputs = InputView.start();
        ResultView.printResult(new Calculator().calculate(inputs));
    }
}
