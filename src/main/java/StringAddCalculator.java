public class StringAddCalculator {


    public static int splitAndSum(String expression) {
        Numbers numbers = new Numbers(Expression.split(expression));
        return numbers.sum();
    }

}
