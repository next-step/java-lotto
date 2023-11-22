package stringCalculator.enums;

public enum Regex {
    REGEX_BLANK(" "), REGEX_OPERATOR("[+\\-*/]"), REGEX_NUM_OR_OPERATOR("^[0-9]+( [+\\-*/] [0-9]+)*$");

    private final String regex;

    Regex(String regex) {
        this.regex = regex;
    }

    @Override
    public String toString() {
        return this.regex;
    }
}
