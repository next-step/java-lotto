package step1;

class FormulaParser {
    public static final String CUSTOM_DELIMITER_START = "//";
    public static final String CUSTOM_DELIMITER_END = "\n";
    public static final char REGEX_CHARACTER_SET_START = '[';
    public static final char REGEX_CHARACTER_SET_END = ']';
    private final String formula;

    public FormulaParser(String formula) {
        this.formula = formula;
    }

    public String[] parse(String delimiterString) {
        return makeResultFormula().split(makeSplitRegex(delimiterString));
    }

    private String makeResultFormula() {
        if (startWithCustomDelimiterIndicator()) {
            return subtractCustomDelimiterIndicatorFromFormula();
        }
        return formula;
    }

    private String subtractCustomDelimiterIndicatorFromFormula() {
        return formula.substring(formula.indexOf(CUSTOM_DELIMITER_END) + 1);
    }

    private String makeSplitRegex(String defaultDelimiterString) {
        StringBuilder delimiterString = new StringBuilder(defaultDelimiterString);
        if (startWithCustomDelimiterIndicator()) {
            delimiterString.append(extractCustomDelimiter());
        }
        return makeRegexString(delimiterString);
    }

    private String extractCustomDelimiter() {
        return formula.substring(2, formula.indexOf(CUSTOM_DELIMITER_END));
    }

    private String makeRegexString(StringBuilder delimiterString) {
        return delimiterString.insert(0, REGEX_CHARACTER_SET_START).append(REGEX_CHARACTER_SET_END).toString();
    }

    private boolean startWithCustomDelimiterIndicator() {
        return formula.startsWith(CUSTOM_DELIMITER_START);
    }
}
