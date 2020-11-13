package step1;

class StringAddCalculator {

    public static final String PLEASE_ENTER_A_STRING = "문자열을 입력하시오.";
    public static final String NOT_A_STRING_OF_NUMERIC = "숫자로 변환가능한 문자가 아닙니다. : %s";
    public static final String CANNOT_ACCEPT_A_NEGATIVE_NUMBER = "음수는 처리할 수 없습니다. : %d";
    private final String defaultDelimiterString;

    public StringAddCalculator() {
        this(",:");
    }

    public StringAddCalculator(String defaultDelimiterString) {
        this.defaultDelimiterString = defaultDelimiterString;
    }

    public Long calculate(String formula) {
        if (formula == null) {
            throw new IllegalArgumentException(PLEASE_ENTER_A_STRING);
        }

        return sum(new FormulaParser(formula).parse(defaultDelimiterString));
    }

    private Long sum(String[] numericStrings) {
        Long result = 0L;
        for (String numericString : numericStrings) {
            result += toNumber(numericString);
        }
        return result;
    }

    private Long toNumber(String numericString) {
        if (numericString.isEmpty()) {
            return 0L;
        }

        Long number = toLong(numericString);

        ensurePositiveNumber(number);

        return number;
    }

    private Long toLong(String formula) {
        try {
            return Long.valueOf(formula);
        } catch (NumberFormatException e) {
            throw new RuntimeException(String.format(NOT_A_STRING_OF_NUMERIC, formula), e);
        }
    }

    private void ensurePositiveNumber(Long number) {
        if (number < 0L) {
            throw new RuntimeException(String.format(CANNOT_ACCEPT_A_NEGATIVE_NUMBER, number));
        }
    }

}
