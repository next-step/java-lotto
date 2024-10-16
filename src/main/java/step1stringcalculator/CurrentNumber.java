package step1stringcalculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class CurrentNumber {
    public static final String OPERATOR_REGEX = "[+\\-*/]";
    public static final int FIRST_NUMBER_INDEX = 0;
    private int currentNumber;

    public CurrentNumber(int currentNumber) {
        this.currentNumber = currentNumber;
    }

    public int calculate(String calculatorString) {
        currentNumber = Integer.parseInt(String.valueOf(calculatorString.charAt(FIRST_NUMBER_INDEX)));
        IntStream.range(1, calculatorString.length() - 1)
                .forEachOrdered(i -> runCalculate(calculatorString, i));
        return currentNumber;
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
            currentNumber = sum(currentNumber, nextNumber);
        } else if ("-".equals(currentOperator)) {
            currentNumber = decrease(currentNumber, nextNumber);
        } else if ("*".equals(currentOperator)) {
            currentNumber = multiplication(currentNumber, nextNumber);
        } else if ("/".equals(currentOperator)) {
            currentNumber = division(currentNumber, nextNumber);
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
        CurrentNumber that = (CurrentNumber) o;
        return currentNumber == that.currentNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(currentNumber);
    }
}
