package calculator;

public class StringAddCalculator {

    private int result;
    private SplitString splitString;

    public StringAddCalculator() {
        splitString = new SplitString();
    }

    public int splitAndSum(String text) {

        if (Validator.isBlankOrEmpty(text)) {
            return Constants.ZERO;
        }

        if (Validator.isOnlyOneNumber(text)) {
           return Integer.parseInt(text);
        }

        return calculate(text);
    }

    private int calculate(String text) {
        String[] splitNumber = splitString.splitStrings(text);

        for (int i = 0; i< splitNumber.length; i++) {
            Validator.isLessThenZero(splitNumber[i]);
            result += Integer.parseInt(splitNumber[i]);
        }

        return result;
    }




}
