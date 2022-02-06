package calculator;

import calculator.domain.StringCalculator;
import calculator.view.InputView;
import calculator.view.ResultView;

public class CalculatorApplication {

    public static void main(String[] args) {
        String text = InputView.getText();

        StringCalculator stringCalculator = new StringCalculator(text);

        ResultView.printResult(stringCalculator.add());
    }
}
