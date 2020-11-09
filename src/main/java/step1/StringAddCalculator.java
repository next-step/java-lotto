package step1;

public class StringAddCalculator {
    public static int splitAndSum(final String text) {
        final Expression expression = Expression.of(text);
        
        if (expression.isEmpty()) {
            return 0;
        }
        
        if (expression.hasSingleNumber()) {
            return expression.toInteger();
        }
        
        return -1;
    }
}
