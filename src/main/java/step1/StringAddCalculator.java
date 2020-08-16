package step1;

public class StringAddCalculator {
    public static int splitAndSum(String target) {
        if (StringUtils.isEmpty(target)) {
            return 0;
        }
        Expression expression = createExpression(target);
        return expression.stream().reduce(0, (acc, cur) -> acc += cur);
    }

    private static Expression createExpression(String target) {
        return Expression.of(target);
    }
}
