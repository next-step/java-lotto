package calculator;

import java.util.stream.Stream;

public class StringCalculator {

    private static final String REGEX_SPLIT_STRING = ":|,";
    private static final int ZERO = 0;
    private static final String CUSTOM_SEPARATOR_PREFIX = "//";
    private static final String CUSTOM_SEPARATOR_SUFFIX = "\n";

    public int splitAndSum(String string) {

        if (string == null || string.isEmpty()) {
            return ZERO;
        }

        if (hasCustomSeparator(string)) {
            return Stream.of(string
                    .replace("//", "")
                    .replace("\n", "")
                    .split(getCustomSeparator(string)))
                    .filter(e -> !e.isEmpty())
                    .mapToInt(Integer::parseInt)
                    .sum();
        }

        return Stream.of(string.split(REGEX_SPLIT_STRING)).mapToInt(Integer::parseInt).sum();
    }

    private String getCustomSeparator(String string) {
        int customSeparatorPrefixIndex = string.indexOf(CUSTOM_SEPARATOR_PREFIX);
        int customSeparatorSuffixIndex = string.indexOf(CUSTOM_SEPARATOR_SUFFIX);
        return string.substring(customSeparatorPrefixIndex + 2, customSeparatorSuffixIndex);
    }

    private boolean hasCustomSeparator(String string) {
        if (string.contains(CUSTOM_SEPARATOR_PREFIX) && string.contains(CUSTOM_SEPARATOR_SUFFIX)) {
            int customSeparatorPrefixIndex = string.indexOf(CUSTOM_SEPARATOR_PREFIX);
            int customSeparatorSuffixIndex = string.indexOf(CUSTOM_SEPARATOR_SUFFIX);
            return customSeparatorPrefixIndex < customSeparatorSuffixIndex;
        }
        return false;
    }
}
