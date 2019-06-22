package step1;

public class StringCalculator {
    private static final int ZERO = 0;
    private static final String SEPARATOR_COMMA = ",";

    public int calculate(String inputString) {
        if (inputString == null || "".equals(inputString)) {
            return ZERO;
        }
        if (!inputString.contains(",")) {
            return Integer.parseInt(inputString);
        }
        int calculations = ZERO;
        for (String element : inputString.split(SEPARATOR_COMMA)) {
            calculations += Integer.parseInt(element);
        }
        return calculations;
    }
}
