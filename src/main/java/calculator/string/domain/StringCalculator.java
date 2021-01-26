package calculator.string.domain;

import java.util.Arrays;
import java.util.List;

public class StringCalculator implements Calculator {
    public String expression;
    public List<String> splitSymbols;

    public StringCalculator() {
        this.splitSymbols = Arrays.asList(":", ",");
    }

    @Override
    public void inputExpression(String expression) {
        this.expression = expression;
        // call custom symbol method
    }

    @Override
    public int calculation() {
        // calculation
        return 3;
    }
}