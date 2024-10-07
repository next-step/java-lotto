package step2.util;

public class DoubleUtil {

    public static double twoDecimal(double num) {
        return Double.parseDouble(String.format("%.2f", num));
    }
}
