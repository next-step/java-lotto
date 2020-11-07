package step1;

class StringAddCalculator {

    private final String defaultDelimiterString;

    public StringAddCalculator() {
        this(",:");
    }

    public StringAddCalculator(String defaultDelimiterString) {
        this.defaultDelimiterString = defaultDelimiterString;
    }

    public Long calculate(String formula) {
        if (formula == null) {
            throw new IllegalArgumentException("문자열을 입력하시오.");
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
            throw new RuntimeException(String.format("숫자로 변환가능한 문자가 아닙니다. : %s", formula), e);
        }
    }

    private void ensurePositiveNumber(Long number) {
        if (number < 0L) {
            throw new RuntimeException(String.format("음수는 처리할 수 없습니다. : %d", number));
        }
    }

}
