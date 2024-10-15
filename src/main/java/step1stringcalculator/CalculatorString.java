package step1stringcalculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorString {
    public static final String NON_CALCULATOR_REGEX = "[^0-9+\\-*/\\s]";
    public static final String OPERATOR_REGEX = "[+\\-*/]";
    private final String calculatorString;
    private CurrentNumber currentNumber;

    public CalculatorString(String calculatorString) {
        this.calculatorString = calculatorString.replaceAll("\\s+","");
        currentNumber = new CurrentNumber(calculatorString);
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
        return currentNumber.customMatcher(operatorRegex, mathExpression);
    }

    public int calculate() {
        return currentNumber.calculate(calculatorString);
    }





}
