package calculator;

import calculator.domain.Number;
import calculator.view.InputView;
import calculator.view.ResultView;

public class Main {

    public static void main(String[] args) {
        String input = new InputView().input();

        StringCalculator stringCalculator = new StringCalculator(input);
        Number number = stringCalculator.calculate(input);

        ResultView.printResult(number.intValue());
    }
}
