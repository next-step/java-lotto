package stringaccumulator;

public class StringAccumulator {

    private StringAccumulator() {
    }

    public static int splitAndSum(String expression) {
        Expressions expressions = Expressions.of(expression);
        return expressions.sum();
    }

}
