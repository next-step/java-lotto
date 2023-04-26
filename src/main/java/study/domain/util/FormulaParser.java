package study.domain.util;

import java.util.Arrays;
import java.util.List;

public class FormulaParser {

    private static final String DELIMITER = " ";

    private static final String INVALID_INPUT = "입력값이 null 이거나 빈 공백 문자입니다.";

    private List<String> formula;

    public FormulaParser(String input) {
        this.formula = customSplit(input);
    }

    public List<String> getFormula() {
        return formula;
    }

    private List<String> customSplit(String input) {
        if (validator(input)) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        return Arrays.asList(input.split(DELIMITER));
    }

    private boolean validator(String input) {
        return input == null || input.isEmpty() || input.startsWith(DELIMITER);
    }

}
