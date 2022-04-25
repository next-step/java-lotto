package Calculator;

import static Calculator.ExpressionCaseChecker.*;

public class ExpressionPreWorker {

    private static final String EMPTY_STRING = " ";

    private ExpressionPreWorker() {
    }

    public static String[] validateAndSplitExpression(String exp) {
        validateNotBlank(exp);

        String[] splitExp = splitExpression(exp);

        checkExpression(splitExp);

        return splitExp;
    }

    private static void validateNotBlank(String exp) {
        if (exp == null || exp.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private static String[] splitExpression(String exp) {
        return exp.split(EMPTY_STRING);
    }
}
