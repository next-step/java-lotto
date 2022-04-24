package me.devyonghee.common;


import java.util.Arrays;
import java.util.List;

public final class StringSeparator implements StringsProvider {

    private static final String DEFAULT_DELIMITER = " ";

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
        return "StringSeparator{" +
                "string='" + string + '\'' +
                '}';
    }
}
