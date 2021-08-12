package stringaddcalculator;

public class Delimiters {
    private static final String DEFAULT_DELIMITERS_REGEX = ",|:";
    private static final String OR = "|";
    private final String CUSTOM_DELIMITER;

    private Delimiters(){
        CUSTOM_DELIMITER = null;
    }

    private Delimiters(String customDelimiter) {
        CUSTOM_DELIMITER = customDelimiter;
    }

    public static Delimiters create() {
        return new Delimiters();
    }

    public static Delimiters create(String customDelimiter) {
        return new Delimiters(customDelimiter);
    }

    public String regex() {
        if (CUSTOM_DELIMITER == null) {
            return DEFAULT_DELIMITERS_REGEX;
        }
        return DEFAULT_DELIMITERS_REGEX + OR + CUSTOM_DELIMITER;
    }

}
