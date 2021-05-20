package lotto.util;

public class DiffCalc {
    public static double getRate(double total, double val) {
        return val / total;
    }

    public static double getRatePc(double total, double val) {
        return getRate(total, val) * 100;
    }
}
