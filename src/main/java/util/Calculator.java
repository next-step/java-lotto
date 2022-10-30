package util;

public class Calculator {
    public static String rateOfProfit(long cost, long profit) {
        return String.format("%.2f", (double) profit / cost);
    }

    public static double divide(long a, long b) {
        return a / b;
    }
}
