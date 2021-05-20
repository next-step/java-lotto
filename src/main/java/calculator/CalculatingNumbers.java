package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CalculatingNumbers {

    private static final String ZERO = "0";
    private static final int CUSTOM_DELIMITER_INDEX = 1;
    private static final int CALCULATE_TARGET_INDEX = 2;
    private static final Pattern FORMULA_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_DELIMITER = "[,:]";

    private final List<CalculatingNumber> calculatingNumbers;

    public CalculatingNumbers(String formula) {
        this.calculatingNumbers = parseCalculatorNumbers(delimitFormula(formula));
    }

    private String[] delimitFormula(String formula) {
        Matcher m = FORMULA_PATTERN.matcher(formula);
        if (m.find()) {
            String customDelimiter = m.group(CUSTOM_DELIMITER_INDEX);
            return m.group(CALCULATE_TARGET_INDEX).split(customDelimiter);
        }

        return formula.split(DEFAULT_DELIMITER);
    }

    private List<CalculatingNumber> parseCalculatorNumbers(String[] formula) {
        return Arrays.stream(formula)
                .map(CalculatingNumber::new)
                .collect(Collectors.toList());
    }

    public int sum() {
        return calculatingNumbers.stream()
                .mapToInt(CalculatingNumber::getNumber)
                .sum();
    }
}
