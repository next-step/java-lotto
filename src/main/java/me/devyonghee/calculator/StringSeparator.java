package me.devyonghee.calculator;


import java.util.Arrays;
import java.util.List;

final class StringSeparator implements StringsProvider {

    private static final String DEFAULT_DELIMITER = " ";

    private final String string;

    private StringSeparator(String string) {
        Assert.hasText(string, "string to split must be provided");
        this.string = string;
    }

    static StringSeparator from(String string) {
        return new StringSeparator(string);
    }

    @Override
    public List<String> strings() {
        return Arrays.asList(string.split(DEFAULT_DELIMITER));
    }

    @Override
    public String toString() {
        return "StringSeparator{" +
                "string='" + string + '\'' +
                '}';
    }
}
