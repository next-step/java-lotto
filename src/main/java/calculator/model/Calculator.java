package calculator.model;

public class Calculator {

    public static int run(Expression exp) {
        while (!exp.isMonomial()) {
            exp = calculateOnce(exp);
        }
        return exp.getResult();
    }

    private static Expression calculateOnce(Expression exp) {
        int result = calculateBinomial(exp.popBinomial());
        exp.addToFront(result);
        return exp;
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
