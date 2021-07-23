package calculator;

public class StringAddCalculator {

    private static final int ZERO_VALUE = 0;

    private StringAddCalculator() {
    }

    public static int splitAndSum(String str) {
        if (isEmpty(str)) {
            return ZERO_VALUE;
        }

        return Integer.parseInt(str);
    }

    private static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
