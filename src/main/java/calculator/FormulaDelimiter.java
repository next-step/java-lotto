package calculator;

public enum FormulaDelimiter {

    COMMA(","),
    COLON(":")
    ;

    private static final int FIRST_INDEX = 0;
    private final String value;

    FormulaDelimiter(String value) {
        this.value = value;
    }

    public static String[] split(String text) {
        FormulaDelimiter first = FormulaDelimiter.values()[FIRST_INDEX];
        for (FormulaDelimiter delimiter : FormulaDelimiter.values()) {
            text = text.replace(delimiter.value, first.value);
        }
        return text.split(first.value);
    }
}
