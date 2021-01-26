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
        String splitCase = mergeSymbols();
        String[] numbers = this.expression.split(splitCase);
        int result = 0;
        for (String number : numbers) {
            result += Integer.parseInt(number);
        }

        return result;
    }

    public String mergeSymbols() {
        StringBuilder result = new StringBuilder();
        for (String symbol : this.splitSymbols) {
            result.append(symbol).append("|");
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }
}