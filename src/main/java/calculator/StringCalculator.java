package calculator;

import java.util.stream.Stream;

public class StringCalculator {

    private static final String REGEX_SPLIT_STRING = "[:,]";
    private static final String CUSTOM_SEPARATOR_PREFIX = "//";
    private static final String CUSTOM_SEPARATOR_SUFFIX = "\n";
    private static final String EMPTY_STRING = "";
    private static final int ZERO = 0;

    public int splitAndSum(String string) {

        if (string == null || string.isEmpty()) {
            return ZERO;
        }

        return sum(split(string));
    }

    private String[] split(String string) {
        if (hasCustomSeparator(string)) {
            return string
                    .replace(CUSTOM_SEPARATOR_PREFIX, EMPTY_STRING)
                    .replace(CUSTOM_SEPARATOR_SUFFIX, EMPTY_STRING)
                    .split(String.format("%s|%s", REGEX_SPLIT_STRING, getCustomSeparator(string)));
        }
        return string.split(REGEX_SPLIT_STRING);
    }

    private int sum(String[] string) {
        return Stream.of(string).filter(character -> !character.isEmpty()).mapToInt(Integer::parseInt).sum();
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
