package lotto;

import lotto.domain.Calculator;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class Main {
    public static void main(String[] args) {
        String input = InputView.input();
        int result = Calculator.calculate(input);
        ResultView.printResult(result);
    }
}
