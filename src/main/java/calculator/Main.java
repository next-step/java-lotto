package calculator;

import calculator.domain.StringCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Main {
    public static void main(String[] args) {
        int result = StringCalculator.calculate(StringCalculator.devide(InputView.input()));
        OutputView.print(result);
    }
}
