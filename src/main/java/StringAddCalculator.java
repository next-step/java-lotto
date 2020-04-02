public class StringAddCalculator {

    public static int splitAndSum(String expression) {
        Numbers numbers = new Numbers(Expression.toArray(expression));
        return numbers.sum();
    }

}
