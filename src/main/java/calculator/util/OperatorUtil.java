package calculator.util;

import calculator.exception.ValidateOperatorException;

import java.util.regex.Pattern;

public class OperatorUtil {

    private static final Pattern OPERATOR = Pattern.compile("[+\\-*/]");

    private OperatorUtil() {
        throw new AssertionError();
    }

    public static String isOperator(String input) {
        if (OPERATOR.matcher(input).matches()) {
            return input;
        }
        throw new ValidateOperatorException();
    }
}
