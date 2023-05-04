package calculator;

import calculator.domain.Tokenizer;
import calculator.domain.StringCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String input = InputView.input();
        List<String> tokens = Tokenizer.devide(input);
        OutputView.print(StringCalculator.calculate(tokens));
    }
}
