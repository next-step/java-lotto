package util;

public class CalculatorUtil {
    private CalculatorUtil(){
    }

    public static int divide(int target, int divideNumber) {
        if (target < divideNumber || divideNumber == 0) {
            return 0;
        }

        return target / divideNumber;
    }
}
