package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NextStepPatternReader implements PatternReader {

    private static final String BASIC_DELIMITER = ",|:";

    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    @Override
    public Numbers read(final String value) {
        Matcher matcher = CUSTOM_PATTERN.matcher(value);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] numbers = matcher.group(2)
                    .split(customDelimiter);
            return Numbers.of(numbers);
        }

        return Numbers.of(value.split(BASIC_DELIMITER));
    }
}
