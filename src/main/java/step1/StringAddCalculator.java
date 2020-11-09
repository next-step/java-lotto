package step1;

public class StringAddCalculator {
    public static int splitAndSum(final String text) {
        final Expression expression = Expression.of(text);
        
        if (expression == Expression.EMPTY_EXPRESSION) {
            return 0;
        }
        
        return -1;
    }
}
