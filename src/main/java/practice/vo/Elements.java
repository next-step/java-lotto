package practice.vo;

import aterilio.common.utils.StringUtils;
import practice.exception.InvalidFormatException;
import practice.exception.NegativeElementException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Elements {

    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    private static final int IDX_CUSTOM_DELIMITER_SYMBOL = 1;
    private static final int IDX_CUSTOM_DELIMITER_FORMULA = 2;

    private final List<Integer> elements;

    public Elements(final String formula) {
        this.elements = parse(formula);
    }

    private List<Integer> parse(final String formula) {

        if ( StringUtils.isNullOrEmpty(formula) ) {
            return new ArrayList<>();
        }

        return makeArrayToListWithValidation( split(formula) );
    }

    private String[] split(final String formula) {

        Matcher m = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(formula);
        if (m.find()) {
            String customDelimiter = Pattern.quote(m.group(IDX_CUSTOM_DELIMITER_SYMBOL));
            return m.group(IDX_CUSTOM_DELIMITER_FORMULA).split(customDelimiter);
        }

        return formula.split(DEFAULT_DELIMITER);
    }

    private List<Integer> makeArrayToListWithValidation(final String[] stringElements) {
        List<Integer> elements = new ArrayList<>();
        for (String elm : stringElements) {
            elements.add(validateElementNegative(validateElementNumeric(elm)));
        }
        return elements;
    }

    private int validateElementNumeric(final String item) {
        if ( !StringUtils.isNumeric(item) ) {
            throw new InvalidFormatException(item);
        }
        return Integer.parseInt(item);
    }

    private int validateElementNegative(final int item) {
        if ( item < 0 ) {
            throw new NegativeElementException(item);
        }
        return item;
    }

    public int sum() {

        int result = 0;

        for (int elm : elements) {
            result += elm;
        }

        return result;
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
