package calculator.domain;

import java.util.List;

public class InputManager {
    private String input;

    private InputManager(String input) {
        this.input = input;
    }

    public static InputManager of(String input) {
        if (input == null) {
            input = "";
        }

        return new InputManager(input);
    }

    public Numbers getNumbers() {
        String delimiters = DelimiterUtils.findDelimiters(input);
        String filteredInput = DelimiterUtils.filterCustomDelimiter(input);

        List<String> strings = StringSplitter.split(filteredInput, delimiters);

        return Numbers.of(strings);
    }
}
