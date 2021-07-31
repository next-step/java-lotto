package calculators;

import calculators.vo.Number;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NumberGenerator {

    private static final String REGEX = "//(.)\n(.*)";
    private static final String COMMA = ",";
    private static final String COLON = ":";
    private static final int FIRST_GROUP_INDEX = 1;
    private static final int SECOND_GROUP_INDEX = 2;
    private static final Pattern pattern = Pattern.compile(REGEX);

    public List<Number> getNumbers(String text) {
        String separator = COLON;

        Matcher matcher = pattern.matcher(text);
        String input = text;

        if (matcher.matches()) {
            separator = matcher.group(FIRST_GROUP_INDEX);
            input = matcher.group(SECOND_GROUP_INDEX);
        }

        input = input.replaceAll(separator, COMMA);
        String[] separatedInputs = input.split(COMMA);

        return Arrays.stream(separatedInputs)
                .map(Number::from)
                .collect(Collectors.toList());
    }
}
