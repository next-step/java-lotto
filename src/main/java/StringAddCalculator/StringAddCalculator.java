package StringAddCalculator;

import StringAddCalculator.utils.checkString;

public class StringAddCalculator {
    public static int splitAndSum(String expression) {
        if (checkString.isNullOrBlank(expression)) {
            return 0;
        }
        int result = toInt(toSplits(expression)[0]);
        for (int i = 1; i < toSplits(expression).length; i++) {
            int second = toInt(toSplits(expression)[i]);
            result = result + second;
        }
        return result;
    }

    /* private static int calculate(int first, String sumOperator, int second) {
        int result = first;
        if (sumOperator == ",") {
            result = first + second;
        }
        return result;
    }

     for (int i = 0; i < toSplits(expression).length; i += 2){
            String sumOperator = toSplits(expression)[i];
            int second = toInt(toSplits(expression)[i+1]);
     */

    private static int toInt(String expression) {
        return Integer.parseInt(expression);
    }

    private static String[] toSplits(String expression) {
        if (checkString.isNullOrBlank(expression)) {
            expression = "0";
        }
        String[] expressions = expression.split(",");
        return expressions;

       /* if (regex.isValid( )) {
            expressions = expression.split(regex);
        }
        */
    }
}
