package lotto.vo;

import lotto.exception.InvalidFormatException;
import lotto.exception.NegativeElementException;
import lotto.utils.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Elements {

    private static final char SPLIT_SEPARATOR = '|';

    private static final String DEFAULT_DELIMITER_COMMA = ",";
    private static final String DEFAULT_DELIMITER_COLON = ":";

    private final String formula;
    private final List<Integer> elements;

    public Elements(final String formula) {
        this.formula = formula;
        this.elements = parse();
    }

    private List<Integer> parse() {

        if ( StringUtils.isNullOrEmpty(formula) ) {
            return new ArrayList<>();
        }

        return makeList( split(formula, DEFAULT_DELIMITER_COMMA, DEFAULT_DELIMITER_COLON) );
    }

    private String[] split(final String formula, final String ... delimiters) {
        final String delimiterList = StringUtils.serialize(delimiters, SPLIT_SEPARATOR);
        return formula.split(delimiterList);
    }

    private List<Integer> makeList(final String[] stringElements) {
        List<Integer> elements = new ArrayList<>();
        for (String elm : stringElements) {
            validateElementNegative(validateElementNumeric(elm));
            elements.add(Integer.parseInt(elm));
        }
        return elements;
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

    public List<Integer> getElements() {
        return this.elements;
    }

    @Override
    public boolean equals(Object obj) {
        if ( obj instanceof Elements ) {
            return this.elements.equals( ((Elements)obj).elements );
        }
        if ( obj instanceof Integer[] ) {
            return this.elements.equals( Arrays.asList( (Integer[]) obj ) );
        }
        return this.elements.equals( obj );
    }

    @Override
    public String toString() {
        return "{" + StringUtils.serialize(this.elements.toArray()) + "}";
    }
}
