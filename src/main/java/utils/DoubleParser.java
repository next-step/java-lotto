package utils;

public class DoubleParser {
    private DoubleParser() {};
    public static double getTwoDecimalPoint(double value) {
        return Math.floor(value * 100) / 100;
    }
}
