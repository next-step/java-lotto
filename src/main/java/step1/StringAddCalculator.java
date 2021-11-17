package step1;

public class StringAddCalculator {

    public static Number calculate(Expression expression) {
        Number ans = new Number(0);

        while (expression.hasNextNumber()) {
            ans = ans.add(expression.nextNumber());
        }

        return ans;
    }
}
