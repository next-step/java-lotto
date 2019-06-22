package calculator;

import java.util.Arrays;
import java.util.List;

public class Input {

    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String CUSTOM_DELIMITER_START_SYMBOL = "//";
    private static final String CUSTOM_DELIMITER_END_SYMBOL = "\\n";

    private final String input;

    public Input(String input) {this.input = input;}

    public List<String> split() {

        if (isStartWithCustomDelimiter()) {
            return splitByCustomDelimiter();
        }
        return splitByDefaultDelimiter();
    }

    private boolean isStartWithCustomDelimiter() {

        return input.startsWith(CUSTOM_DELIMITER_START_SYMBOL);
    }

    private List<String> splitByCustomDelimiter() {

        int endIndex = input.indexOf(CUSTOM_DELIMITER_END_SYMBOL);
        String customDelimiter = input.substring(CUSTOM_DELIMITER_START_SYMBOL.length(), endIndex);
        int startTokenIndex = endIndex + CUSTOM_DELIMITER_END_SYMBOL.length();

        return Arrays.asList(input.substring(startTokenIndex).split(customDelimiter));
    }

    private List<String> splitByDefaultDelimiter() {

        return Arrays.asList(input.split(DEFAULT_DELIMITER));
    }

}
