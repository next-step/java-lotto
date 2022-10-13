package calculator;

import calculator.view.InputView;
import calculator.domain.StringCalculator;
import calculator.view.ResultView;

public class CalculatorController {

    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator(InputView.getInput());
        ResultView.view(stringCalculator.calculate());
    }
}
