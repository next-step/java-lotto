package stringaddcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Expression {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final Pattern DEFUALT_DELIMITER = Pattern.compile(",|:");
    private static final int CUSTOM_DELIMITER_INDEX = 1;
    private static final int ONLY_EXPRESSION_INDEX = 2;

    private final String expresion;

    public Expression(String expresion) {
        this.expresion = expresion;
    }

    public boolean isNullOrEmpty() {
        return expresion == null || expresion.isEmpty();
    }

    public Numbers numbers() {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(expresion);
        if (matcher.find()) {
            String customDelimiter = matcher.group(CUSTOM_DELIMITER_INDEX);
            String[] split = matcher.group(ONLY_EXPRESSION_INDEX).split(customDelimiter);
            return makeNumbers(split);
        }
        return makeNumbers(DEFUALT_DELIMITER.split(expresion));
    }

    private Numbers makeNumbers(String[] stringNumbers) {
        return new Numbers(Arrays.stream(stringNumbers)
                                 .map(Number::new)
                                 .collect(Collectors.toList()));
    }
}
