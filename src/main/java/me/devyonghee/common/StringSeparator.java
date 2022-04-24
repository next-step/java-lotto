package me.devyonghee.common;


import java.util.Arrays;
import java.util.List;

public final class StringSeparator implements StringsProvider {

    private static final String DEFAULT_DELIMITER = " ";
    private static final String TO_STRING_START = "StringSeparator{";
    private static final char TO_STRING_END = '}';
    private static final String TO_STRING_STRING_FIELD = "string=";

    private final String string;
    private final String delimiter;

    private StringSeparator(String string, String delimiter) {
        Assert.hasText(string, "string to split must be provided");
        this.delimiter = delimiter;
        this.string = string;
    }

    public static StringSeparator from(String string) {
        return new StringSeparator(string, DEFAULT_DELIMITER);
    }

    public static StringSeparator of(String string, String delimiter) {
        if (delimiter == null) {
            return from(string);
        }
        return new StringSeparator(string, delimiter);
    }

    @Override
    public List<String> strings() {
        return Arrays.asList(string.split(delimiter));
    }

    @Override
    public String toString() {
        return TO_STRING_START +
                TO_STRING_STRING_FIELD + string +
                TO_STRING_END;
    }
}
