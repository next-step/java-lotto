package stringaddcalculator;

import stringaddcalculator.exception.InvalidFormulaException;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class AdditionString extends Number {
    private final String formula;

    private static final String FORBIDDEN_CUSTOM_DELIMITERS = "=-";
    private static final String DELIMITER_REPLACE_FORMAT = "[,:%s]";
    private static final Pattern CUSTOM_DELIMITER = Pattern.compile(
            "^(//(?<DELIMITER>.)\\n)?(?<FORMULA>.*)$"
    );
    public AdditionString(String formula) {
        this.formula = formula;
    }

    private void validCustomDelimiter(String delimiter) {
        if (FORBIDDEN_CUSTOM_DELIMITERS.contains(delimiter))
            throw new InvalidFormulaException(delimiter + " 문자는 커스텀 구분자로 사용할 수 없습니다.");
    }

    private boolean isEmptyFormula() {
        return Objects.isNull(formula) || formula.trim().isEmpty();
    }

    private String[] parseFormula() {
        Matcher matcher = CUSTOM_DELIMITER.matcher(formula);
        if (!matcher.find())
            throw new InvalidFormulaException();

        String parsedFormula = matcher.group("FORMULA");
        String customDelimiter = matcher.group("DELIMITER");

        if (Objects.nonNull(customDelimiter))
            validCustomDelimiter(customDelimiter);

        String replaceFormat = String.format(DELIMITER_REPLACE_FORMAT, customDelimiter);
        return parsedFormula.split(replaceFormat);
    }

    private int parseInt(String strNumber) {
        try {
            int number = Integer.parseInt(strNumber);
            if (number < 0)
                throw new InvalidFormulaException("수식에 음수가 포함되어 있습니다.");
            return number;
        } catch (NumberFormatException e) {
            throw new InvalidFormulaException();
        }
    }

    private int calculate() {
        if (isEmptyFormula())
            return 0;

        String[] strNumbers = parseFormula();
        return Arrays.stream(strNumbers)
                .mapToInt(this::parseInt)
                .sum();
    }

    @Override
    public int intValue() {
        return calculate();
    }

    @Override
    public long longValue() {
        return intValue();
    }

    @Override
    public float floatValue() {
        return intValue();
    }

    @Override
    public double doubleValue() {
        return intValue();
    }
}
