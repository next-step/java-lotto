package calculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StringInput {
    private static final String BASIC_DELIMITER = "[,:]";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private String input;

    StringInput() {
        this(null);
    }

    StringInput(String input) {
        this.input = input;
    }

    String validate(String input) {
        if (input == null || input.isEmpty()) {
            return "0";
        }
        return input;
    }

    String[] basicSplit(String input) {
        return input.split(BASIC_DELIMITER);
    }

    String[] inputSplitWithCustom(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return basicSplit(input);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringInput that = (StringInput) o;
        return Objects.equals(input, that.input);
    }

    @Override
    public int hashCode() {
        return Objects.hash(input);
    }
}
