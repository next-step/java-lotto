package step1stringcalculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorString {
    public static final String NON_CALCULATOR_REGEX = "[^0-9+\\-*/\\s]";
    public static final String OPERATOR_REGEX = "[+\\-*/]";
    private final String calculatorString;

    public CalculatorString(String calculatorString) {
        this.calculatorString = calculatorString;
    }

    public void checkNullAndEmpty() {
        if (Objects.isNull(calculatorString) || calculatorString.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public void checkCalculatorExpression() {
        Pattern pattern = Pattern.compile(NON_CALCULATOR_REGEX);
        Matcher matcher = pattern.matcher(calculatorString);
        if (matcher.find()) {
            throw new IllegalArgumentException();
        }
    }

    public void checkNonOperator() {
        Pattern pattern = Pattern.compile(OPERATOR_REGEX);
        Matcher matcher = pattern.matcher(calculatorString);
        if (!matcher.find()) {
            throw new IllegalArgumentException();
        }
    }
}
