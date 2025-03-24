package stringCalculator;

import java.util.regex.Pattern;

public class StringValidator {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");
    private static final Pattern OPERATOR_PATTERN = Pattern.compile("[+\\-*/]");

    public boolean validate(String input) {
        validateNullOrEmpty(input);
        validateNumberOrOperator(input);
        return true;
    }

    private void validateNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input value is null or empty.");
        }
    }

    private void validateNumberOrOperator(String input) {
        String[] tokens = input.split(" ");

        for (int i = 0; i < tokens.length; i++) {
            if (!isValidToken(i, tokens[i])) {
                throw new IllegalArgumentException("Number or operator is not valid.");
            }
        }

        isValidTokenSize(tokens.length);
    }

    private void isValidTokenSize(int length) {
        if (length % 2 != 1) {
            throw new IllegalArgumentException("The sum of the number of operators and numbers is always odd.");
        }
    }

    private boolean isValidToken(int index, String token) {
        return (isNumberPosition(index) && isNumber(token)) ||
               (isOperatorPosition(index) && isOperator(token));
    }


    private boolean isNumberPosition(int index) {
        return index % 2 == 0;
    }

    private boolean isNumber(String number) {
        return NUMBER_PATTERN.matcher(number).matches();
    }

    private boolean isOperatorPosition(int index) {
        return !isNumberPosition(index);
    }

    private boolean isOperator(String operator) {
        return OPERATOR_PATTERN.matcher(operator).matches();
    }
}
