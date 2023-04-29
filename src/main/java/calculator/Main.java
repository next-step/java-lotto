package calculator;

import calculator.domain.Number;
import calculator.view.InputView;
import calculator.view.ResultView;

public class Main {

    public static void main(String[] args) {
        String input = new InputView().input();

        Number number = StringCalculator.calculate(input);

        ResultView.printResult(number.intValue());
    }
}
