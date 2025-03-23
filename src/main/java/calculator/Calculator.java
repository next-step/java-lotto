package calculator;

import view.InputView;
import view.ResultView;

import java.math.BigDecimal;

public class Calculator {
    private final CalculateStrategy calculateStrategy = new InOrderCalculator();

    public void calculate() {
        String input = InputView.read("계산식을 입력해주세요.");
        BigDecimal result = calculateStrategy.calculate(Tokenizer.tokenize(input));
        ResultView.printResult(result);
    }
}
