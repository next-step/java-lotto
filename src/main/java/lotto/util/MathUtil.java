package lotto.util;

public class MathUtil {

    public static double roundUp(double number) {
        return Math.round(number * 100) / 100.0;
    }
}
