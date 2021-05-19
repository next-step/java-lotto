package study;

public class StringAddCalculator {
    private static final int DEFAULT_VALUE = 0;

    public static int splitAndSum(String input) {
        SumCalculator sumCalCulator = new SumCalculator(input, DEFAULT_VALUE);
        if(sumCalCulator.isUnusable()){
            return DEFAULT_VALUE;
        }

        return sumCalCulator.sum();
    }
}
