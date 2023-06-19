package edu.nextstep.camp.calculator;

public class StringCalculator {

    private static final String DELIMITER = " ";

    public int calculate(String expressionString) {
        if (expressionString == null || expressionString.isBlank()) {
            throw new IllegalArgumentException("number is blank or null");
        }

        String[] expressions = expressionString.split(DELIMITER);

        return calculateByExpressions(expressions);
    }

    private int calculateByExpressions(String[] expressions) {
        IntNumber number = new IntNumber(expressions[0]);

        for (int i = 1; i < expressions.length; i += 2) {
            number.calculateBaseSymbol(expressions[i], expressions[i + 1]);
        }

        return number.getValue();
    }


}
