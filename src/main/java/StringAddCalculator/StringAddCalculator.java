package StringAddCalculator;

public class StringAddCalculator {
    public static int splitAndSum(String expression) {
        int first = toInt(toSplits(expression)[0]);
        int second = toInt(toSplits(expression)[1]) ;
        int result = first + second;
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
        String[] expressions = expression.split(",");
       /* if (regex.isValid( )) {
            expressions = expression.split(regex);
        }
        */
        return expressions;
    }
}
