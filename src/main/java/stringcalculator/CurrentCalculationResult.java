package stringcalculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class CurrentCalculationResult {
    public static final String OPERATOR_REGEX = "[+\\-*/]";
    public static final int FIRST_NUMBER_INDEX = 0;
    private int currentCalculationResult;

    public CurrentCalculationResult(int currentCalculationResult) {
        this.currentCalculationResult = currentCalculationResult;
    }

    public int calculate(String mathExpression) {
        currentCalculationResult = Integer.parseInt(String.valueOf(mathExpression.charAt(FIRST_NUMBER_INDEX)));
        IntStream.range(1, mathExpression.length() - 1)
                .forEachOrdered(i -> runCalculate(mathExpression, i));
        return currentCalculationResult;
    }

    public void runCalculate(String mathExpression, int MathExpressionIndex) {
        String currentOperator = String.valueOf(mathExpression.charAt(MathExpressionIndex));
        Matcher matcher = MatcherUtil.customMatcher(OPERATOR_REGEX, currentOperator);
        if (matcher.find()) {
            int nextNumber = Integer.parseInt(String.valueOf(mathExpression.charAt(MathExpressionIndex + 1)));
            choiceCalculate(currentOperator, nextNumber);
        }
    }

    public void choiceCalculate(String currentOperator, int nextNumber) {
        MathOperator mathOperator = MathOperator.selectOperator(currentOperator);
        currentCalculationResult = mathOperator.apply(currentCalculationResult,nextNumber);
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrentCalculationResult that = (CurrentCalculationResult) o;
        return currentCalculationResult == that.currentCalculationResult;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(currentCalculationResult);
    }
}
