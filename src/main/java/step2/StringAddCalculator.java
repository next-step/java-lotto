package step2;

public class StringAddCalculator {

    private static final int BASE_ZERO_NUMBER = 0;

    public static int splitAndSum(String text) {
        if (isNullOrEmpty(text)) return BASE_ZERO_NUMBER;


        StringMatcher stringMatcher = new StringMatcher(text);
        if (stringMatcher.find()) {
            return getSumOfTokens(stringMatcher.text(), stringMatcher.delimiter());
        }
        return getSumOfTokens(text, StringMatcher.DEFAULT_REGEX);
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static int getSumOfTokens(String text, String delimiter) {
        PositiveNumbers positiveNumbers = new PositiveNumbers(text.split(delimiter));
        return calculateText(positiveNumbers);
    }

    private static int calculateText(PositiveNumbers positiveNumbers) {
        int sum = 0;

        for (int i = 0; i < positiveNumbers.length(); ++i) {
            sum += positiveNumbers.getIntValue(i);
        }
        return sum;
    }
}
