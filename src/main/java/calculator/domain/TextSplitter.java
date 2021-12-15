package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TextSplitter {
    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int DELIMITER_GROUP_INDEX = 1;
    private static final int NUMBERS_GROUP_INDEX = 2;

    private final String text;

    public TextSplitter(String text) {
        this.text = text;
    }

    public List<Number> textToNumbers() {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(this.text);
        if (m.find()) {
            String customDelimiter = m.group(DELIMITER_GROUP_INDEX);
            return tokensToNumbers(m.group(NUMBERS_GROUP_INDEX).split(customDelimiter));
        }
        return tokensToNumbers(this.text.split(DEFAULT_DELIMITER_REGEX));
    }

    private List<Number> tokensToNumbers(String[] tokens) {
        return Arrays.stream(tokens)
                .map(Number::new)
                .collect(Collectors.toList());
    }

}
