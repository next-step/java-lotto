package StringAddCalculator;

public class StringAddCalculator {
    public static int splitAndSum(String expression) {
        int first = Integer.parseInt(splitToExpression(expression)[0]);
        for (int i = 0; i < splitToExpression(expression).length; i += 2){
            String sumOperator = splitToExpression(expression)[i];
            int second = Integer.parseInt(splitToExpression(expression)[i+1]);
            first = calculate(expression);
        }
        return first;
    }

    private static String[] splitToExpression(String expression) {
        String[] expressions = expression.split(" ");
        return expressions;
    }
}
