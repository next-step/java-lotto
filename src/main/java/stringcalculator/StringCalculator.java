package stringcalculator;

public class StringCalculator {
    private static final String NOT_ALLOW_NULL_OR_EMPTY_MESSAGE = "비거나 null값은 허용되지 않습니다.";
    private static final int FIRST_NUMBER_INDEX = 0;
    private static final int SECOND_NUMBER_INDEX = 2;
    private static final int ALLOW_STRINGS_LENGTH = 3;
    private static final String ALLOW_LENGTH_EXCEED_MESSAGE = "허용된 길이를 초과했습니다.";
    private static final String STRING_SPLIT_DELIMITER = " ";

    public int plus(String expression) {
        checkEmpty(expression);
        checkLengthExceed(expression);

        int firstNumber = getFirstNumber(expression);
        int secondNumber = getSecondNumber(expression);

        return firstNumber + secondNumber;
    }

    public int minus(String expression) {
        checkEmpty(expression);
        checkLengthExceed(expression);

        int firstNumber = getFirstNumber(expression);
        int secondNumber = getSecondNumber(expression);

        return firstNumber - secondNumber;
    }

    public int multiply(String expression) {
        checkEmpty(expression);
        checkLengthExceed(expression);

        int firstNumber = getFirstNumber(expression);
        int secondNumber = getSecondNumber(expression);

        return firstNumber * secondNumber;
    }

    public int division(String expression) {
        checkEmpty(expression);
        checkLengthExceed(expression);

        int firstNumber = getFirstNumber(expression);
        int secondNumber = getSecondNumber(expression);

        return firstNumber / secondNumber;
    }

    private void checkLengthExceed(String expression) {
        String[] strings = getStrings(expression);
        if (strings.length > ALLOW_STRINGS_LENGTH) {
            throw new IllegalArgumentException(ALLOW_LENGTH_EXCEED_MESSAGE);
        }
    }

    private int getSecondNumber(String expression) {
        String[] strings = getStrings(expression);
        return toInt(strings[SECOND_NUMBER_INDEX]);
    }

    private int getFirstNumber(String expression) {
        String[] strings = getStrings(expression);
        return toInt(strings[FIRST_NUMBER_INDEX]);
    }

    private int toInt(String string) {
        return Integer.parseInt(string);
    }

    private String[] getStrings(String expression) {
        return expression.split(STRING_SPLIT_DELIMITER);
    }

    private void checkEmpty(String expression) {
        if (expression == null || expression.isBlank()) {
            throw new IllegalArgumentException(NOT_ALLOW_NULL_OR_EMPTY_MESSAGE);
        }
    }
}
