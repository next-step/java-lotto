package stringformula;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SumFormula {
    private final String CUSTOM_DELIMITER_PREFIX = "\\";
    private final String DEFAULT_DELIMITERS = ":|,";
    private final String stringFormula;

    private SumFormula(String stringFormula) {
        this.stringFormula = stringFormula;
    }

    public static SumFormula of(String formula) {
        return new SumFormula(formula);
    }

    public Number result() {
        Operands operands = getOperands();

        return operands.sumAll();
    }

    private Operands getOperands() {
        String delimiter = getDelimiters(stringFormula);

        return new Operands(Arrays.stream(getRemovePrefixFormula()
                .split(delimiter))
                .map(Number::valueOf)
                .collect(Collectors.toList()));
    }

    private String getRemovePrefixFormula() {
        if(stringFormula.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            return stringFormula.substring(CUSTOM_DELIMITER_PREFIX.length() + 1);
        }

        return stringFormula;
    }

    private String getDelimiters(String formula) {
        if (formula.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            return String.valueOf(formula.charAt(formula.indexOf(CUSTOM_DELIMITER_PREFIX) + 1));
        }

        return DEFAULT_DELIMITERS;
    }
}
