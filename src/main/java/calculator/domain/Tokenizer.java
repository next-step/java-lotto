package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Tokenizer {

    private static final String STANDARD_DELIMITER_COMMA = ",";
    private static final String STANDARD_DELIMITER_COLON = ":";
    private static final List<Integer> EMPTY = new ArrayList<>();

    private final List<Integer> numbers;

    public Tokenizer(String text) {
        this.numbers = tokenize(text);
    }

    private List<Integer> tokenize(String text) {
        if (isEmptyOrNull(text)) {
            return EMPTY;
        }

        if (isCustomDelimiter(text)) {
            final String CUSTOM_DELIMITER = text.substring(text.indexOf("/") + 2,
                text.indexOf("\n"));

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

    private boolean isEmptyOrNull(String text) {
        return Objects.isNull(text) || text.isEmpty();
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
