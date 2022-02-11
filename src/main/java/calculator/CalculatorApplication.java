package calculator;

import calculator.domain.NumberTokens;
import calculator.domain.StringCalculator;
import calculator.util.Tokenizer;
import calculator.view.InputView;
import calculator.view.ResultView;

public class CalculatorApplication {

    public static void main(String[] args) {
        String text = InputView.getText();

        Tokenizer tokenizer = new Tokenizer(text);
        NumberTokens numberTokens = tokenizer.getTokenizedNumbers();

        StringCalculator stringCalculator = new StringCalculator(numberTokens);
        int result = stringCalculator.getResult();

        ResultView.printResult(result);
    }
}
