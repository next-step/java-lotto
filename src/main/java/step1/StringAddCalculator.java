package step1;

public class StringAddCalculator {

    private static final int INITIAL_VALUE = 0;

    public static Number calculate(Expression expression) {
        Number ans = new Number(INITIAL_VALUE);

        while (expression.hasNextNumber()) {
            ans = ans.add(expression.nextNumber());
        }

        return ans;
    }
}
