package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    private static final Pattern CUSTOM_DELIMITER_REGEX = Pattern.compile("//(.*)\n(.*)");

    public int[] parseToIntArray(String text) {
        Matcher m = CUSTOM_DELIMITER_REGEX.matcher(text);
        if (m.find()) {
            String delimiter = m.group(1);
            return convertInt(m.group(2).split(delimiter));
        }

        return convertInt(text.split(DEFAULT_DELIMITER_REGEX));
    }

    private int[] convertInt(String[] stringNumbers) {
        try {
            return Arrays.stream(stringNumbers).mapToInt(Integer::parseInt).toArray();
        } catch (NumberFormatException e) {
            throw new NumberFormatException("``stringNumbers` is must be number format");
        }
    }
}
