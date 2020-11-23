package calculator.domain;

public class StringAddCalculator {

    private static final int DEFAULT_NUMBER_ZERO = 0;

    private StringAddCalculator() {
        throw new AssertionError();
    }

    public static int splitAndSum(String text) {

        if (StringPreConditionChecker.isRightString(text)) {
            return calculateTokenString(StringDelimiterParser.parseText(text));
        }
        return DEFAULT_NUMBER_ZERO;
    }

    private static int calculateTokenString(String[] splitStrings) {

        int sum = 0;
        for (String num : splitStrings) {
            int i = Integer.parseInt(num);
            if (i < 0 ) {
                throw new RuntimeException();
            }
            sum += i;
        }

        return sum;
    }

}
