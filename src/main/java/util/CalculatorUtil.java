package util;

public class CalculatorUtil {
    private CalculatorUtil() {
    }

    public static int divideWholeNumber(int target, int divideNumber) {
        return (int) Math.round(divide(target, divideNumber));
    }

    public static double divide(long target, long divideNumber) {
        if (divideNumber == 0) {
            return 0;
        }

        return target / divideNumber;
    }
}
