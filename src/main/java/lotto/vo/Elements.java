package lotto.vo;

import lotto.exception.InvalidFormatException;
import lotto.exception.NegativeElementException;
import lotto.utils.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Elements {

    private static final String DEFAULT_DELIMITER = "[,:]";

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

        return makeList( split(formula) );
    }

    private String[] split(final String formula) {

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(formula);
        if (m.find()) {
            String customDelimiter = Pattern.quote(m.group(1));
            return m.group(2).split(customDelimiter);
        }

        return formula.split(DEFAULT_DELIMITER);
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
