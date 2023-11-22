package stringCalculator.enums;

public enum regex {
    REGEX_BLANK(" "), REGEX_OPERATOR("[+\\-*/]"), REGEX_NUM_OR_OPERATOR("^[0-9]+( [+\\-*/] [0-9]+)*$");

    private final String regex;

    regex(String regex) {
        this.regex = regex;
    }

    @Override
    public String toString() {
        return this.regex;
    }
}
