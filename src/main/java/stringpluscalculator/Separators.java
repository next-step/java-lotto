package stringpluscalculator;

import java.util.Arrays;

public class Separators {
    private static final String CUSTOM_SEPARATORS_PREFIX = "//";
    private static final String CUSTOM_SEPARATORS_SUFFIX = "\n";
    private static final String SPLIT_DELIMITER = "|";

    private String[] separators = {":", ","};

    public Separators(String input) {
        if (hasCustomSeparator(input)) {
            this.separators = new String[]{searchCustomSeparator(input)};
        }
    }

    public String getSplitSeparator() {
        return String.join(SPLIT_DELIMITER, this.separators);
    }

    public static String getInputWithoutCustomSeparator(String input) {
        if (hasCustomSeparator(input)) {
            return input.split(CUSTOM_SEPARATORS_SUFFIX)[1];
        }
        return input;
    }

    private static boolean hasCustomSeparator(String input) {
        if (input.startsWith(CUSTOM_SEPARATORS_PREFIX) &&
                input.indexOf(CUSTOM_SEPARATORS_SUFFIX) > CUSTOM_SEPARATORS_PREFIX.length()) {
            return true;
        }
        return false;
    }

    private String searchCustomSeparator(String input) {
        int suffixIndex = input.indexOf(CUSTOM_SEPARATORS_SUFFIX);

        return input.substring(CUSTOM_SEPARATORS_PREFIX.length(), suffixIndex);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Separators that = (Separators) o;
        return Arrays.equals(separators, that.separators);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(separators);
    }
}
