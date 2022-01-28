package stringcalculator.domain;

import java.util.Arrays;
import java.util.List;

public class Delimiter {

    private List<String> tokens;

    public Delimiter(final String input) {
        this.tokens = splitByDelimiter(input);
    }

    public List<String> splitByDelimiter(String input) {
        return Arrays.asList(input.split("[,:]"));
    }

    public List<String> getNumbers() {
        return tokens;
    }
}
