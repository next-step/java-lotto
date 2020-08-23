package StringAddCalculator;

public class StringAddCalculator {
    public static int splitAndSum(String expression) {
        int result = toInt(toSplits(expression)[0]);
        for (int i = 0; i < toSplits(expression).length; i += 2){
            String sumOperator = toSplits(expression)[i];
            int second = toInt(toSplits(expression)[i+1]);
            result = calculate(result, sumOperator, second);
        }
        return result;
    }

    private static int calculate(int result, String sumOperator, int second) {
        if (sumOperator == ",||:") {
            result = result + second;
        }
        return result;
    }

    private static int toInt(String expression) {
        return Integer.parseInt(expression);
    }

    private static String[] toSplits(String expression) {
        String[] expressions = new String[0];
        expressions = expression.split(",");
       /* if (regex.isValid( )) {
            expressions = expression.split(regex);
        }
        */
        return expressions;
    }
}
