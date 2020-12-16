package step2;

public class RateCalculator {
    public static double calculate(Money output, Money input) {
        double value = ((double) output.getValue()) / ((double) input.getValue());
        return Math.floor(value * 100) / 100.0;
    }
}
