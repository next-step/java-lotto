package com.jaeyeonling.calculate;

public class Separator {

    private static final String DEFAULT_SEPARATOR = ",|:";
    private static final String CUSTOM_PREFIX = "//";
    private static final String NEW_LINE = "\n";

    private final String separator;

    private Separator(String separator) {
        this.separator = separator;
    }

    public static Separator of(final String expression) {
        if (!expression.startsWith(CUSTOM_PREFIX)) {
            return new Separator(DEFAULT_SEPARATOR);
        }

        final String[] splitExpression = expression.split(NEW_LINE);
        final String separator = splitExpression[0].substring(CUSTOM_PREFIX.length());

        return new Separator(separator);
    }

    public String[] separate(final String expression) {
        return expression.split(separator);
    }
}
