package step1;

public class StringCalculator {

    private int result;
    private static final String SEPERATOR_CHARACTER = ",";
    private static final int ZERO = 0;

    public StringCalculator() {
        this.result = ZERO;
    }

    public int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return ZERO;
        }
        return sum(input.split(SEPERATOR_CHARACTER));
    }

    private int stringToInteger(String input) {
        if (input == null || "".equals(input)) {
            return ZERO;
        }
        return Integer.parseInt(input);
    }

    private int sum(String[] inputSplit) {
        for (String input : inputSplit) {
            result += stringToInteger(input);
        }
        return result;
    }

    private boolean isNullOrEmpty(String input) {
        if (input == null || "".equals(input)) {
            return true;
        }
        return false;
    }


}
