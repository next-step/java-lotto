package calculator;

import calculator.domain.StringCalculator;
import calculator.view.InputView;
import calculator.view.ResultView;

import java.util.Arrays;

public class CalculatorController {

    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator(Arrays.asList(InputView.getInput()));
        ResultView.view(stringCalculator.calculate());
    }
}
