package calculator;

import static java.lang.Integer.parseInt;

public class Calculator {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n";
    private static final RuntimeException exception = new RuntimeException("잘못된 입력 값 입니다");

    public String[] parse(String input) {
        return input.split(DEFAULT_DELIMITER+"|"+CUSTOM_DELIMITER_REGEX);
    }

    public int calculator(String[] values) {
        int result = 0;
        for(String value : values) {
            result = add(result, toIntWithValidation(value));
        }
        return result;
    }

    private int add(int a, int b) {
        return a+b;
    }

    private int toIntWithValidation(String input) {
        int convert = 0;
        if ( input.isBlank() || input.isEmpty() ) {
            return 0;
        }
        try {
            convert = parseInt(input);
        } catch (NumberFormatException e) {
            throw exception;
        }
        if ( convert <= 0 ) {
            throw exception;
        }
        return convert;
    }
}
