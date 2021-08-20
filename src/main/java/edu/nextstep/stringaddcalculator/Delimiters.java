package edu.nextstep.stringaddcalculator;

public class Delimiters {

    private static final String DEFAULT_DELIMITERS_REGEX = ",|:";
    private static final String OR = "|";

    private final String customDelimiter;

    private Delimiters(){
        customDelimiter = null;
    }

    private Delimiters(String customDelimiter) {
        this.customDelimiter = customDelimiter;
    }

    public static Delimiters create() {
        return new Delimiters();
    }

    public static Delimiters create(String customDelimiter) {
        return new Delimiters(customDelimiter);
    }

    public String regex() {
        if (customDelimiter == null) {
            return DEFAULT_DELIMITERS_REGEX;
        }
        return DEFAULT_DELIMITERS_REGEX + OR + customDelimiter;
    }

}
