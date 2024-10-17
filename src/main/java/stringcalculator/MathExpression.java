package stringcalculator;

import java.util.Objects;
import java.util.regex.Matcher;

public class MathExpression {
    public static final String NON_CALCULATOR_REGEX = "[^0-9+\\-*/\\s]";
    public static final String OPERATOR_REGEX = "[+\\-*/]";
    private String mathExpression;


    public MathExpression(String mathExpression) {
        this.mathExpression = mathExpression;

    }

    public void checkNullAndEmpty() {
        if (Objects.isNull(mathExpression) || mathExpression.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public void checkMathExpressionRegex() {
        Matcher matcher = MatcherUtil.customMatcher(NON_CALCULATOR_REGEX, mathExpression);
        if (matcher.find()) {
            throw new IllegalArgumentException();
        }
    }

    public void checkNonOperator() {
        Matcher matcher = MatcherUtil.customMatcher(OPERATOR_REGEX, mathExpression);
        if (!matcher.find()) {
            throw new IllegalArgumentException();
        }
    }

    public int calculate(CurrentCalculationResult currentCalculationResult) {
        return currentCalculationResult.calculate(mathExpression);
    }

    public void removeWhiteSpace() {
        this.mathExpression = mathExpression.replaceAll("\\s+","");
    }


}
