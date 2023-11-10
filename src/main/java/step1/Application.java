package step1;

import step1.domain.StringCalculator;
import step1.view.InputView;
import step1.view.OutputView;

public class Application {
    public static void main(String[] args) {
        String input = InputView.input();
        OutputView.printResult(new StringCalculator(input).result());
    }
}
