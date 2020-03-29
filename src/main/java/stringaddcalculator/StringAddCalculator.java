package stringaddcalculator;

public class StringAddCalculator {
    private int result;
    private static final int ZERO = 0;

    public StringAddCalculator() {
        this.result = ZERO;
    }

    public int splitAndSum(String inputString) {
        if (isNullOrEmpty(inputString)) {
            return ZERO;
        }
        return Integer.parseInt(inputString);
    }

    private boolean isNullOrEmpty(String inputString) {
        if(inputString == null || inputString.equals("")) {
            return true;
        }
        return false;
    }
}
