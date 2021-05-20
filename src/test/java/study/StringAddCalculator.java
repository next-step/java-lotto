package study;

public class StringAddCalculator {
    private static final int DEFAULT_VALUE = 0;

    public static int splitAndSum(String input) {
        Calculator sumCalculator = new SumCalculator(input, DEFAULT_VALUE);
        return sumCalculator.calculate();
    }

    public static int splitAndConcat(String input) {
        Calculator concatCalculator = new ConcatCalculator(input, DEFAULT_VALUE);
        return concatCalculator.calculate();
    }
}
