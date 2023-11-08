package calculator.domain;

import java.util.regex.Pattern;

public class OperationValidator {

    private OperationValidator() {
    }

    private static final String DETERMINER = " ";
    private static final Pattern NUMBER_PATTERN = Pattern.compile("[0-9]+");

    public static void validate(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException();
        }

        validateInput(input);
    }

    private static boolean isBlank(String input) {
        return input == null || input.isBlank();
    }

    private static void validateInput(String input) {
        String[] strings = input.split(DETERMINER);

        validateStartWithNumber(strings);
        validateEndWithNumber(strings);
        validateOddStrings(strings);
        validateNumberNextOperation(strings);
    }

    private static void validateStartWithNumber(String[] strings) {
        String startString = strings[0];
        if (!isNumber(startString)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateEndWithNumber(String[] strings) {
        String endString = strings[strings.length - 1];
        if (!isNumber(endString)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateOddStrings(String[] strings) {
        if (isOddNumber(strings.length)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isOddNumber(int number) {
        return number % 2 == 0;
    }

    private static void validateNumberNextOperation(String[] strings) {
        for (int i = 0; i < strings.length - 1; i += 2) {
            if (!isNumberNextOperation(strings[i], strings[i + 1])) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static boolean isNumberNextOperation(String stringNumber, String stringOperation) {
        return isNumber(stringNumber) && Operation.isOperation(stringOperation);
    }


    private static boolean isNumber(String input) {
        return NUMBER_PATTERN.matcher(input).matches();
    }

}
