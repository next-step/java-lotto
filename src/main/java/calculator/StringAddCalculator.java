package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER_REGEX = ",|:";
    private static final Pattern CUSTOM_DELIMITER_REGEX = Pattern.compile("//(.*)\n(.*)");

    public int sum(String input) {
        String delimiter = DEFAULT_DELIMITER_REGEX;
        String text = input;

        Matcher m = CUSTOM_DELIMITER_REGEX.matcher(text);
        if (m.find()) {
            delimiter = m.group(1);
            text = m.group(2);
        }

        String[] splitInput = split(text, delimiter);

        int[] numbers = Arrays.stream(splitInput).mapToInt(Integer::parseInt).toArray();

        return Arrays.stream(numbers).reduce(Integer::sum).getAsInt();
    }

    private String[] split(String input, String delimiter) {
        return input.split(delimiter);
    }
}
