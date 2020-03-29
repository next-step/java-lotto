package stringaddcalculator;

public class StringAddCalculator {
    private static final int ZERO = 0;

    public int splitAndSum(String inputString) {
        if (isNullOrEmpty(inputString)) {
            return ZERO;
        }
        return sum(inputString);
    }

    private int sum(String inputString) {
        String[] splitNumbers = inputString.split(",|:");
        int result = 0;
        for(String splitNumber : splitNumbers) {
            result += Integer.parseInt(splitNumber);
        }
        return result;
    }

    private boolean isNullOrEmpty(String inputString) {
        if(inputString == null || inputString.equals("")) {
            return true;
        }
        return false;
    }
}
