package stringcalculator;

public class StringCalculator {

    private static final String ADDITION = "+";
    private static final String SUBTRACTION = "-";
    private static final String MULTIPLICATION = "*";
    private static final String SPLITTER = " ";
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final String NOT_IN_OPERATOR_SET = "사칙 연산 기호가 아닌 기호는 입력 값이 될 수 없습니다.";
    private static final String CANNOT_BE_NULL_OR_BLANK = "입력 값은 null 또는 빈 공백 문자일 수 없습니다.";
    private final OperatorSet operatorSet;

    public StringCalculator(OperatorSet operatorSet) {
        this.operatorSet = operatorSet;
    }

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

    private static int findCalculatedResult(int result, String parsedOperator, int nextValue) {
        if (isAddition(parsedOperator)) {
            result += nextValue;
            return result;
        }
        if (isSubtraction(parsedOperator)) {
            result -= nextValue;
            return result;
        }
        if (isMultiplication(parsedOperator)) {
            result *= nextValue;
            return result;
        }
        return (int) result / nextValue;
    }

    private static boolean isMultiplication(String parsedOperator) {
        return parsedOperator.equals(MULTIPLICATION);
    }

    private static boolean isSubtraction(String parsedOperator) {
        return parsedOperator.equals(SUBTRACTION);
    }

    private static boolean isAddition(String parsedOperator) {
        return parsedOperator.equals(ADDITION);
    }

    private void isValidOperator(String parsedOperator) {
        if (!operatorSet.getOperatorSet().contains(parsedOperator)) {
            throw new IllegalArgumentException(NOT_IN_OPERATOR_SET);
        }
    }

    private static void isNullOrBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(CANNOT_BE_NULL_OR_BLANK);
        }
    }
}
