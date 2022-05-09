package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Formula {
    private final List<String> formula;
    private static final String REGEX_OPERAND = "^[-]?[0-9]";
    private static final String REGEX_OPERATOR = "[+\\-*/]";
    private static final String BLANK_DELIMITER = " ";

    public Formula(String formula) {
        assertIsNullOrEmpty(formula);
        this.formula = splitByDelimiter(formula);
    }

    private void assertIsNullOrEmpty(String formula) {
        if(formula == null || formula.isBlank())   throw new IllegalArgumentException();
    }

    private List<String> splitByDelimiter(String formula) {
        return Arrays.stream(formula.split(BLANK_DELIMITER)).collect(Collectors.toList());
    }

    public List<String> findOperator() {
        return formula.stream().filter(e -> e.matches(REGEX_OPERATOR)).collect(Collectors.toList());
    }

    public List<Integer> findOperand() {
        return formula.stream().filter(e -> e.matches(REGEX_OPERAND)).map(Integer::new).collect(Collectors.toList());
    }
}
