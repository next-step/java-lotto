package calculator;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    private static final String DEFAULT_DELIMITER = ",|:";

    public List<String> parseInput(String userInput) {
        return Arrays.asList(userInput.split(DEFAULT_DELIMITER));
    }
}
