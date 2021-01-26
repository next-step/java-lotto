package calculator.string.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator implements Calculator {
    public String expression;
    public List<String> splitSymbols;

    public StringCalculator() {
        this.splitSymbols = Arrays.asList(":", ",");
    }

    @Override
    public void inputExpression(String expression) {
        this.expression = expression;
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

    public String findSymbol() {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(this.expression);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return customDelimiter;
        }
        return null;
    }

    public void addSymbol(String newSymbol) {
        this.splitSymbols.add(newSymbol);
    }
}