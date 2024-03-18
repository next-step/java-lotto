package stringCalculator;

public class Calculator {
    private static final String SPLIT_REGEX = " ";
    private static final String ADD = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";

    public int calculate(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException("공백은 계산처리가 안됩니다!");
        }

        String[] strings = input.split(SPLIT_REGEX);

        int result = Integer.parseInt(strings[0]);

        for (int i = 0; i < strings.length; i++) {
            validateOperator(i, strings);
        }

        for (int i = 1; i < strings.length; i++) {
            result = calculate(i, result, strings);
        }

        return result;
    }

    private void validateOperator(int i, String[] strings) {
        if (isOperationIndex(i)) {
            judgmentFourBasicOperations(strings, i);
        }
    }

    private int calculate(int i, int result, String[] strings) {
        if (isNumberIndex(i)) {
            result = add(strings, i, result);
            result = minus(strings, i, result);
            result = multiply(strings, i, result);
            result = divide(strings, i, result);
        }
        return result;
    }

    private boolean isBlank(String input) {
        return input == null || input.isBlank();
    }

    private int divide(String[] strings, int i, int result) {
        if (DIVIDE.equals(strings[i - 1])) {
            result /= Integer.parseInt(strings[i]);
        }
        return result;
    }

    private int multiply(String[] strings, int i, int result) {
        if (MULTIPLY.equals(strings[i - 1])) {
            result *= Integer.parseInt(strings[i]);
        }
        return result;
    }

    private int minus(String[] strings, int i, int result) {
        if (MINUS.equals(strings[i - 1])) {
            result -= Integer.parseInt(strings[i]);
        }
        return result;
    }

    private int add(String[] strings, int i, int result) {
        if (ADD.equals(strings[i - 1])) {
            result += Integer.parseInt(strings[i]);
        }
        return result;
    }

    private boolean isNumberIndex(int i) {
        return i % 2 == 0;
    }

    private boolean isOperationIndex(int i) {
        return i % 2 == 1;
    }

    private void judgmentFourBasicOperations(String[] strings, int i) {
        if (isNotFourBasicOperations(strings[i])) {
            throw new IllegalArgumentException("사칙연산으로만 계산이 가능합니다!");
        }
    }

    private boolean isNotFourBasicOperations(String strings) {
        return !(ADD.equals(strings) || MINUS.equals(strings) || MULTIPLY.equals(strings) || DIVIDE.equals(strings));
    }
}
