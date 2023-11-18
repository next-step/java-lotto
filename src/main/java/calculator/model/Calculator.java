package calculator.model;

import java.util.List;

public class Calculator {

    public static int run(Expression expression) {
        while (expression.isNotMonomial()) {
            expression = calculateOnce(expression);
        }
        return expression.getResult();
    }

    private static Expression calculateOnce(Expression expression) {
        int result = calculateBinomial(expression.popBinomial());
        List<String> tokens = expression.tokens();
        tokens.add(0, String.valueOf(result));
        return new Expression(tokens);
    }

    private static int calculateBinomial(Binomial bin) {
        if (bin.getOperationType() == Operator.ADD) {
            return add(bin.getLeftNumber(), bin.getRightNumber());
        }
        if (bin.getOperationType() == Operator.SUB) {
            return sub(bin.getLeftNumber(), bin.getRightNumber());
        }
        if (bin.getOperationType() == Operator.MUL) {
            return multiple(bin.getLeftNumber(), bin.getRightNumber());
        }
        return divide(bin.getLeftNumber(), bin.getRightNumber());
    }

    private static int add(int left, int right) {
        return left + right;
    }

    private static int sub(int left, int right) {
        return left - right;
    }

    private static int multiple(int left, int right) {
        return left * right;
    }

    private static int divide(int left, int right) {
        return left / right;
    }
}
