package lotto.util;

public class RateUtils {
    private static final int PERCENTAGE = 100;

    private RateUtils() {
        throw new AssertionError();
    }

    public static double getRate(double total, double val) {
        return val / total;
    }

    public static double getRatePc(double total, double val) {
        return getRate(total, val) * PERCENTAGE;
    }
}
