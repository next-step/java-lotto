package lotto.step1;

import lotto.step1.model.StringAddCalculator;
import lotto.step1.view.InputView;
import lotto.step1.view.ResultView;

import static lotto.step1.model.StringAddCalculator.sum;

public class StringAddCalculatorApplication {
    public static void main(String[] args) {
        ResultView.print(StringAddCalculator.sum(InputView.input()));
    }
}
