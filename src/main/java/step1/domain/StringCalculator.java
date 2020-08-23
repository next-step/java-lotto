package step1.domain;

import step1.view.InputView;
import step1.view.ResultView;

import java.util.List;

public class StringCalculator {

    public void run() {
        List<Integer> inputFormula = InputView.inputFormula();

        ResultView.printResult(StringAdder.adder(inputFormula));
    }
}
