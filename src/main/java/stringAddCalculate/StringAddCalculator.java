package stringAddCalculate;

public class StringAddCalculator {

    public static int add(String expression) {
        if (isNullOrEmpty(expression)) {
            return 0;
        }

        NumberExpression numberExpression = new NumberExpression(expression);
        return numberExpression.getNumbers().stream()
                .map(Number::getNumber)
                .reduce(0,Integer::sum);
    }

    private static boolean isNullOrEmpty(String expression) {
        return expression == null || expression.isEmpty();
    }
}
