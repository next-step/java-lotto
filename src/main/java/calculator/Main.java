package calculator;

import calculator.domain.Number;
import calculator.view.InputView;
import calculator.view.ResultView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String input = inputView.input();

        StringCalculator stringCalculator = new StringCalculator(input);
        Number number = stringCalculator.calculateInOrderOf(input);

        ResultView.printResult(number.intValue());
    }
}
