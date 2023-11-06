package calculator.domain;

import java.util.regex.Pattern;

public class OperationValidator {

    private OperationValidator() {
    }

    private static final String DETERMINER = " ";
    public static final Pattern NUMBER_PATTERN = Pattern.compile("[0-9]+");

    public static void valid(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException();
        }

        String[] strings = input.split(DETERMINER);
        for(String target : strings) {
            validOperation(target);
        }
    }

    private static boolean isBlank(String input) {
        return input == null || input.isBlank();
    }

    private static void validOperation(String input) {
        if (!Operation.isOperation(input) && isNotNumber(input)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isNotNumber(String input) {
        return !NUMBER_PATTERN.matcher(input).matches();
    }

}
