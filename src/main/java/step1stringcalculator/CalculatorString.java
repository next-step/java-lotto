package step1stringcalculator;

import java.util.Objects;
import java.util.regex.Matcher;

public class CalculatorString {
    public static final String NON_CALCULATOR_REGEX = "[^0-9+\\-*/\\s]";
    public static final String OPERATOR_REGEX = "[+\\-*/]";
    private String calculatorString;
    private CurrentCalculationResult currentCalculationResult;

    public CalculatorString(String calculatorString) {
        this.calculatorString = calculatorString;
        currentCalculationResult = new CurrentCalculationResult(0);
    }

    public void checkNullAndEmpty() {
        if (Objects.isNull(calculatorString) || calculatorString.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public void checkCalculatorExpression() {
        Matcher matcher = customMatcher(NON_CALCULATOR_REGEX,calculatorString);
        if (matcher.find()) {
            throw new IllegalArgumentException();
        }
    }

    public void checkNonOperator() {
        Matcher matcher = customMatcher(OPERATOR_REGEX,calculatorString);
        if (!matcher.find()) {
            throw new IllegalArgumentException();
        }
    }

    private Matcher customMatcher(String operatorRegex, String mathExpression) {
        return currentCalculationResult.customMatcher(operatorRegex, mathExpression);
    }

    public int calculate() {
        removeWhiteSpace();
        return currentCalculationResult.calculate(calculatorString);
    }

    private void removeWhiteSpace() {
        this.calculatorString = calculatorString.replaceAll("\\s+","");
    }


}
