package calculator.parser;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StringCalculatorParser {

    private static final String STRING_DELIMITER = " ";

    private StringCalculatorParser() {

    }

    public static List<String> split(String input) {
        if (Objects.isNull(input)) {
            return Collections.emptyList();
        }

        return Collections.unmodifiableList(List.of(input.split(STRING_DELIMITER)));
    }
}
