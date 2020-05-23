package stringcalculator.domain;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;

public enum BasicDelimiter {
    COMMA(","), COLON(":");

    private static final String DELIMITER_JOINER = "|";
    private String type;

    BasicDelimiter(String tyoe) {
        this.type = tyoe;
    }

    public static String convertToRegex() {
        return Arrays.stream(BasicDelimiter.values())
                .map(delimiter -> delimiter.type)
                .collect(joining(DELIMITER_JOINER));
    }
}
