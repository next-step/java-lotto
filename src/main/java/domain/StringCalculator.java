package domain;

import view.InputView;
import view.ResultView;

import java.util.List;

public class StringCalculator {

    public void run() {
        List<Integer> inputFormula = InputView.inputFormula();

        StringAdder stringAdder = new StringAdder();
        ResultView.printResult(stringAdder.adder(inputFormula));
    }
}
