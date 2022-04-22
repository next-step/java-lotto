package Calculator;

import static Calculator.ExpressionCaseChecker.*;

public class ExpressionPreWorker {

    private ExpressionPreWorker() {
    }

    static String[] validateAndSplitExpression(String exp) {
        validateNotBlank(exp);

        String[] splitExp = splitExpression(exp);

        checkOnlyNumber(splitExp);
        checkOnlyOperator(splitExp);
        checkPossibleExpression(splitExp);

        return splitExp;
    }

    private static void validateNotBlank(String exp) {
        if (exp == null || exp.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private static String[] splitExpression(String exp) {
        return exp.split(" ");
    }


}
