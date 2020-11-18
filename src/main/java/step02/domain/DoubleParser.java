package step02.domain;

public class DoubleParser {
    public static double getTwoDecimalPoint(double value) {
        return Math.floor(value * 100) / 100;
    }
}
