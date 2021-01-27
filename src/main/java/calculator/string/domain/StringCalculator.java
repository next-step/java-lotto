package calculator.string.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator implements Calculator {
    public String expression;
    public List<String> splitSymbols;

    public StringCalculator() {
        this.splitSymbols = new ArrayList<>(Arrays.asList(":", ","));
    }

    @Override
    public void inputExpression(String expression) {
        addSymbol(findSymbol(expression));
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

    public String findSymbol(String expression) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(expression);
        if (m.find()) {
            String customDelimiter = m.group(1);
            this.expression = m.group(2);
            return customDelimiter;
        }

        this.expression = expression;
        return null;
    }

    public void addSymbol(String newSymbol) {
        this.splitSymbols.add(newSymbol);
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