package calculator;

import calculator.domain.StringCalculator;
import calculator.domain.Tokenizer;
import calculator.view.InputView;
import calculator.view.ResultView;

public class CalculatorApplication {

    public static void main(String[] args) {
        String text = InputView.getText();

        Tokenizer tokenizer = new Tokenizer(text);

        StringCalculator stringCalculator = new StringCalculator(tokenizer.getNumbers());
        int result = stringCalculator.getResult();

        ResultView.printResult(result);
    }
}
