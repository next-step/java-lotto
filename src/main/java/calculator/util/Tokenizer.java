package calculator.util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Tokenizer {

    private static final String STANDARD_DELIMITER_COMMA = ",";
    private static final String STANDARD_DELIMITER_COLON = ":";

    private final List<Integer> tokenizedNumbers;

    public Tokenizer(String text) {
        this.tokenizedNumbers = tokenize(text);
    }

    private List<Integer> tokenize(String text) {
        if (isCustomDelimiter(text)) {
            final String CUSTOM_DELIMITER = text.substring(text.indexOf("/") + 2, text.indexOf("\n"));

            final String formattedText = text
                .replaceAll("[//\n]", "")
                .replaceFirst(CUSTOM_DELIMITER, "")
                .trim();

            return parseInt(formattedText.split(
                STANDARD_DELIMITER_COMMA + "|" + STANDARD_DELIMITER_COLON + "|"
                    + CUSTOM_DELIMITER));
        }

        return parseInt(text
            .split(STANDARD_DELIMITER_COMMA + "|" + STANDARD_DELIMITER_COLON));
    }

    public static List<Integer> parseInt(String[] tokens) {
        try {
            return Arrays.stream(tokens).map(Integer::parseInt).collect(Collectors.toList());
        } catch (NumberFormatException | NullPointerException e) {
            throw new IllegalArgumentException("[ERROR] 지정된 구분자 외의 문자열이 있습니다.");
        }
    }

    public static boolean isCustomDelimiter(String text) {
        return Pattern.compile("//(.)\n(.*)").matcher(text).find();
    }

    public List<Integer> getTokenizedNumbers() {
        return tokenizedNumbers;
    }
}
