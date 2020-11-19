package calculator.domain;

public class StringAddCalculator {

    public static int splitAndSum(String text) {

        if (StringPreConditionChecker.isRightString(text)) {
            return calculateTokenString(StringDelimiterParser.parseText(text));
        }
        return 0;
    }

    private static int calculateTokenString(String[] splitStrings) {

        int sum = 0;
        for (String num : splitStrings) {
            sum += Integer.parseInt(num);
        }

        return sum;
    }

}
