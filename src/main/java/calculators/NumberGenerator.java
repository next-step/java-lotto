package calculators;

import calculators.vo.Number;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NumberGenerator {

    private static final String CUSTOM_SEPARATOR_PARSER_REGEX = "//(.)\n(.*)";
    private static final String COMMA = ",";
    private static final String COLON = ":";
    private static final int SEPARATOR_INDEX = 1;
    private static final int NUMERIC_TEXT_INDEX = 2;
    private static final Pattern pattern = Pattern.compile(CUSTOM_SEPARATOR_PARSER_REGEX);

    public List<Number> parse(String input) {
        String commaSeparatedNumericText = changeCommaSeparatedNumericText(input);
        String[] separatedInputs = commaSeparatedNumericText.split(COMMA);
        return Arrays.stream(separatedInputs)
                .map(Number::from)
                .collect(Collectors.toList());
    }

    private String changeCommaSeparatedNumericText(String input) {
        String separator = COLON;

        Matcher matcher = pattern.matcher(input);
        String numericText = input;

        if (matcher.matches()) {
            separator = matcher.group(SEPARATOR_INDEX);
            numericText = matcher.group(NUMERIC_TEXT_INDEX);
        }

        return numericText.replaceAll(separator, COMMA);
    }
}
