package stringpluscalculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Separators {
    private static final String CUSTOM_SEPARATORS_PREFIX = "//";
    private static final String CUSTOM_SEPARATORS_SUFFIX = "\\n";
    private static final String SPLIT_DELIMITER = "|";

    private List<Separator> separators = Arrays.asList(new Separator(":"), new Separator(","));

    public Separators(String input) {
        if (hasCustomSeparator(input)) {
            this.separators = Arrays.asList(new Separator(searchCustomSeparator(input)));
        }
    }

    public String getSplitSeparator() {
        return separators.stream()
                .map(Separator::getSeparator)
                .collect(Collectors.joining(SPLIT_DELIMITER));
    }

    public static String getInputWithoutCustomSeparator(String input) {
        if (hasCustomSeparator(input)) {
            return input.substring(input.indexOf(CUSTOM_SEPARATORS_SUFFIX) + CUSTOM_SEPARATORS_SUFFIX.length());
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
}
