package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static int add(String text) {

        if (text == null || "".equals(text)) {
            return 0;
        }

        String delimiter = setDelimiterDefaultValue();

        final Matcher matcher = findCustomDelimiter(text);
        final boolean useCustomDelimiter = matcher.find();
        if (useCustomDelimiter) {
            delimiter = setCustomDelimiterValue(matcher);
        }
        if (useCustomDelimiter) {
            text = replaceInputStringByCustomDelimiterValue(text, delimiter);
        }

        final String[] textSplitValues = splitText(text, delimiter);
        checkTextIntegerType(textSplitValues);
        return sum(textSplitValues);
    }

    private static Matcher findCustomDelimiter(final String text) {
        return Pattern.compile("//(.)\n(.*)").matcher(text);
    }

    private static int sum(final String[] textSplitValues) {
        int result = Integer.parseInt(textSplitValues[0]);
        for (int i = 1; i < textSplitValues.length; i++) {
            result += Integer.parseInt(textSplitValues[i]);
        }
        return result;
    }

    private static void checkTextIntegerType(final String[] textSplitValues) {
        Arrays.stream(textSplitValues).forEachOrdered(StringCalculator::nonIntegerTypeThrownRuntimeException);
    }

    private static void nonIntegerTypeThrownRuntimeException(final String c) {
        try {
            Integer.parseInt(c);
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }
    }

    private static String[] splitText(final String text, final String delimiter) {
        return text.split("(" + delimiter + ")");
    }

    private static String replaceInputStringByCustomDelimiterValue(String text, final String delimiter) {
        return text.replace("//" + delimiter + "\n", "");
    }

    private static String setCustomDelimiterValue(final Matcher matcher) {
        final String delimiter;
        delimiter = matcher.group(1);
        return delimiter;
    }

    private static String setDelimiterDefaultValue() {
        return ",|:";
    }

}
