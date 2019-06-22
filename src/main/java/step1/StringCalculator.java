package step1;

public class StringCalculator {
    private static final int ZERO = 0;

    public int calculate(String inputString) {
        if (inputString == null || "".equals(inputString)) {
            return ZERO;
        }
        return Integer.parseInt(inputString);
    }
}
