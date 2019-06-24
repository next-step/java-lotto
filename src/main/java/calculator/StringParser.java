package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {
    public static final String ADDITIONAL_DELIMITER_REGEX = "//(.)\n(.*)";
    private Matcher matcher;
    private String input;

    public StringParser(String input) {
        this.input = input;
        matcher = Pattern.compile(ADDITIONAL_DELIMITER_REGEX).matcher(input);
    }

    public boolean hasAdditionalDelimiter() {
        return matcher.find();
    }

    public List<String> parseByDelimiter() {
        return Arrays.asList(input.split(",|:"));
    }

    public String parseAdditionalDelimiter() {
        if (!hasAdditionalDelimiter()) {
            throw new RuntimeException("추가적인 구분자가 없는 String 입니다");
        }
        return matcher.group(1);
    }
}
