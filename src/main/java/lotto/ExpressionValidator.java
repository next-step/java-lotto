package lotto;

import java.util.HashSet;
import java.util.Set;

public class ExpressionValidator {

    private static final Set<String> OPERATION = new HashSet<>() {{
        add("+");
        add("-");
        add("*");
        add("/");
    }};

    public static void validateEmptyExpression(String inputString) {
        if (isEmptyExpression(inputString)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isEmptyExpression(String inputString) {
        return inputString == null || inputString.isEmpty();
    }

    public static void validateOperation(String operation) {
        if (notContains(operation)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean notContains(String operation) {
        return !OPERATION.contains(operation);
    }
}
