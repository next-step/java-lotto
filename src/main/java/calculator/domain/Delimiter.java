package calculator.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Delimiter {
    COMMA(","), COLON(":");

    private static final String TYPE_DIVISION = "|";
    private final String type;

    Delimiter(String type) {
        this.type = type;
    }

    public static String joinTypes() {
        return Arrays.stream(values())
                .map(delimiter -> String.valueOf(delimiter.type))
                .collect(Collectors.joining(TYPE_DIVISION));
    }
}
