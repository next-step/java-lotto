package com.jaeyeonling.calculate;

public class Separator {

    private static final String DEFAULT_SEPARATOR = ",|:";

    private final String separator;

    public Separator(String expression) {
        this.separator = DEFAULT_SEPARATOR;
    }

    public String[] separate(String expression) {
        return expression.split(separator);
    }
}
