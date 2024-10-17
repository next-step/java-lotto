package step1stringcalculator;

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

    public int calculate(String calculatorString) {
        currentCalculationResult = Integer.parseInt(String.valueOf(calculatorString.charAt(FIRST_NUMBER_INDEX)));
        IntStream.range(1, calculatorString.length() - 1)
                .forEachOrdered(i -> runCalculate(calculatorString, i));
        return currentCalculationResult;
    }

    public void runCalculate(String calculatorString, int i) {
        String currentOperator = String.valueOf(calculatorString.charAt(i));
        Matcher matcher = customMatcher(OPERATOR_REGEX, currentOperator);
        if (matcher.find()) {
            int nextNumber = Integer.parseInt(String.valueOf(calculatorString.charAt(i + 1)));
            choiceCalculate(currentOperator, nextNumber);
        }
    }

    public void choiceCalculate(String currentOperator, int nextNumber) {
        if ("+".equals(currentOperator)) {
            currentCalculationResult = sum(currentCalculationResult, nextNumber);
        } else if ("-".equals(currentOperator)) {
            currentCalculationResult = decrease(currentCalculationResult, nextNumber);
        } else if ("*".equals(currentOperator)) {
            currentCalculationResult = multiplication(currentCalculationResult, nextNumber);
        } else if ("/".equals(currentOperator)) {
            currentCalculationResult = division(currentCalculationResult, nextNumber);
        }

    }


    public Matcher customMatcher(String operatorRegex, String mathExpression) {
        Pattern pattern = Pattern.compile(operatorRegex);
        return pattern.matcher(mathExpression);
    }

    public static int sum(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    public static int decrease(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }

    public static int multiplication(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }

    public static int division(int firstNumber, int secondNumber) {
        return Math.floorDiv(firstNumber, secondNumber);
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
