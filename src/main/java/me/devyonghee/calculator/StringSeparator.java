package me.devyonghee.calculator;


import java.util.Arrays;
import java.util.List;

final class StringSeparator {

    private static final String DEFAULT_DELIMITER = " ";

    private String string;

    private StringSeparator(String string) {
        if (isBlank(string)) {
            throw new IllegalArgumentException("string to split must be provided");
        }
        this.string = string;
    }

    static StringSeparator from(String string) {
        return new StringSeparator(string);
    }

    List<String> separate() {
        return Arrays.asList(string.split(DEFAULT_DELIMITER));
    }

    private boolean isBlank(String string) {
        return string == null || string.isBlank();
    }
}
