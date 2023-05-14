package autolotto;

import java.util.List;

public class StringParser {
    private final String delimiter;

    public StringParser(String delimiter) {
        this.delimiter = delimiter;
    }

    public List<String> parse(String input) {
        return List.of(input.split(delimiter));
    }
}
