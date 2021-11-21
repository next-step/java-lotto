package stringaddcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Expression {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final Pattern DEFUALT_DELIMITER = Pattern.compile(",|:");

    private final String expresion;

    public Expression(String expresion) {
        this.expresion = expresion;
    }

    public boolean isNullOrEmpty() {
        return expresion == null || expresion.isEmpty();
    }

    public List<Number> numbers() {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(expresion);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] split = matcher.group(2).split(customDelimiter);
            return makeNumbers(split);
        }
        return makeNumbers(DEFUALT_DELIMITER.split(expresion));
    }

    private List<Number> makeNumbers(String[] stringNumbers) {
        return Arrays.stream(stringNumbers)
                     .map(Number::new)
                     .collect(Collectors.toList());
    }
}
