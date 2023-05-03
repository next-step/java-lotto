package stringcalculator;

import java.util.Arrays;

import static stringcalculator.Operator.isValidOperator;

public class StringCalculator {

    private static final String SPLITTER = " ";
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final String CANNOT_BE_NULL_OR_BLANK = "입력 값은 null 또는 빈 공백 문자일 수 없습니다.";

    public int calculate(String input) {
        isNullOrBlank(input);

        String[] parsedInput = findParsedInput(input);
        int result = getInitialValue(parsedInput);

        for (int currentIndex = 1; currentIndex < parsedInput.length - ONE; currentIndex += TWO) {
            String parsedOperator = parsedInput[currentIndex];
            isValidOperator(parsedOperator);

            int nextValue = getNextValue(parsedInput, currentIndex);
            result = findCalculatedResult(result, parsedOperator, nextValue);
        }
        return result;
    }

    private static int getNextValue(String[] parsedInput, int currentIndex) {
        return Integer.parseInt(parsedInput[currentIndex + 1]);
    }

    private static int getInitialValue(String[] parsedInput) {
        return Integer.parseInt(parsedInput[ZERO]);
    }

    private static String[] findParsedInput(String input) {
        return input.split(SPLITTER);
    }

    private int findCalculatedResult(int result, String parsedOperator, int nextValue) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.getSign().equals(parsedOperator))
                .mapToInt(operator -> operator.calculate(result, nextValue))
                .sum();
    }

    private static void isNullOrBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(CANNOT_BE_NULL_OR_BLANK);
        }
    }
}
