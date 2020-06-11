package step2.util;

public class MathUtils {
    public static double calculateYield(double winningAmount, double purchaseAmount) {
        if (winningAmount == 0) {
            return 0;
        }
        return winningAmount / purchaseAmount;
    }

    public static double floorDecimal(double number, int decimalPoint) {
        double value = Math.pow(10, decimalPoint);

        return Math.floor(number * value) / value;
    }
}
