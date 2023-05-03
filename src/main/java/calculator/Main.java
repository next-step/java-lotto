package calculator;

import calculator.domain.Tokenizer;
import calculator.domain.StringCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Main {
    public static void main(String[] args) {
        OutputView.print(StringCalculator.calculate(Tokenizer.devide(InputView.input())));
    }
}
