package stringformula;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SumFormula {
    private final String CUSTOM_DELIMITER_PREFIX = "\\";
    private final List<String> DEFAULT_DELIMITERS = Arrays.asList(",", ":");
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
        List<String> delimiters = getDelimiters(stringFormula);

        String lastDelimiter = delimiters.get(delimiters.size() - 1);
        String convertedStringFormula = getConvertedFormula(stringFormula, delimiters);

        return new Operands(Arrays.stream(convertedStringFormula
                .split(lastDelimiter))
                .map(Number::valueOf)
                .collect(Collectors.toList()));
    }

    private String getConvertedFormula(String formula, List<String> delimiters) {
        String lastDelimiter = delimiters.get(delimiters.size() - 1);
        String convertedStringFormula = formula;

        if(formula.startsWith("\\")) {
            convertedStringFormula = convertedStringFormula.substring(2);
        }

        for (String delimiter : delimiters) {
            if (delimiter.equals(lastDelimiter)) {
                break;
            }

            convertedStringFormula = convertedStringFormula.replaceAll(delimiter, lastDelimiter);
        }

        return convertedStringFormula;
    }

    private List<String> getDelimiters(String formula) {
        if (formula.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            String delimiter =
                    String.valueOf(formula.charAt(formula.indexOf(CUSTOM_DELIMITER_PREFIX) + 1));
            return Collections.singletonList(delimiter);
        }

        return DEFAULT_DELIMITERS;
    }
}
