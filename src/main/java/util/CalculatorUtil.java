package util;

public class CalculatorUtil {
    private CalculatorUtil(){
    }

    public static int divideWholeNumber(int target, int divideNumber) {
        if (target < divideNumber || divideNumber == 0) {
            return 0;
        }

        return target / divideNumber;
    }

    public static float divideFloatNumber(int target, int divideNumber) {
        if (divideNumber == 0) {
            return 0;
        }

        return target / divideNumber;
    }
}
