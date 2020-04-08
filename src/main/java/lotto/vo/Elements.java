package lotto.vo;

import lotto.exception.InvalidFormatException;
import lotto.exception.NegativeElementException;
import lotto.utils.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Elements {

    private static final String DEFAULT_DELIMITER_COMMA = ",";
    private static final String DEFAULT_DELIMITER_COLON = ":";

    private final String formula;
    private final List<Integer> elements;

    public Elements(final String formula) {

        this.formula = formula;
        validateFormulaEmpty();

        final List<String> stringElements = new ArrayList<String>( split(formula, DEFAULT_DELIMITER_COMMA, DEFAULT_DELIMITER_COLON) );
        validateElement(stringElements);

        this.elements = parseElementToInteger(stringElements);
    }

    private List<String> split(final String formula, final String ... delimiters) {
        final String delimiterList = StringUtils.serialize(delimiters, '|');
        return Arrays.asList(formula.split(delimiterList));
    }

    private void validateFormulaEmpty() {
        if ( StringUtils.isNullOrEmpty(formula) ) {
            throw new InvalidFormatException(formula);
        }
    }

    private void validateElement(List<String> stringElements) {
        for (String elm : stringElements) {
            validateElementNegative(validateElementNumeric(elm));
        }
    }

    private Integer validateElementNumeric(final String item) {
        if ( !StringUtils.isNumeric(item) ) {
            throw new InvalidFormatException(formula);
        }
        return Integer.parseInt(item);
    }

    private void validateElementNegative(final Integer item) {
        if ( item < 0 ) {
            throw new NegativeElementException(formula);
        }
    }

    private List<Integer> parseElementToInteger(List<String> stringElements) {
        List<Integer> elements = new ArrayList<>();
        for (String elm : stringElements) {
            elements.add(Integer.parseInt(elm));
        }
        return elements;
    }
}
