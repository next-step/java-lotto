package domain;

import view.InputView;
import view.ResultView;

import java.util.List;

public class StringCalculator {

    public void run() {
        List<Integer> inputFormula = InputView.inputFormula();

        ResultView.printResult(StringAdder.adder(inputFormula));
    }
}
