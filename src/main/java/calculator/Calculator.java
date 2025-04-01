package calculator;

import view.InputView;
import view.ResultView;

import java.math.BigDecimal;
import java.util.List;

public class Calculator {
    private final CalculateStrategy calculateStrategy = new InOrderCalculator();

    public void calculate() {
        String input = InputView.read("계산식을 입력해주세요.");
        List<String> tokens = Tokenizer.tokenize(input);
        BigDecimal result = calculateStrategy.calculate(tokens);
        ResultView.printResult(result);
    }
}
