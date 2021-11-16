package step1;

public class StringAddCalculator {

    public static int calculate(Expression expression) {
        int ans = 0;

        while (expression.hasNextNumber()) {
            ans += expression.nextNumber();
        }

        return ans;
    }
}
