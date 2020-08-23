package StringAddCalculator;

public class StringAddCalculator {
    public static int splitAndSum(String expression) {
        int first = toInt(splitToExpression(expression)[0]);
        for (int i = 0; i < splitToExpression(expression).length; i += 2){
            String sumOperator = splitToExpression(expression)[i];
            int second = toInt(splitToExpression(expression)[i+1]);
            first = calculate(expression);
        }
        return first;
    }

    private static int toInt(String expression) {
        return Integer.parseInt(expression);
    }

    private static String[] splitToExpression(String expression) {
        String[] expressions = expression.split(" ");
        return expressions;
    }
}
