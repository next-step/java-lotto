package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculatorParser {

    private static final String SPLIT_CUSTOM_STRING = "//(.)\n(.*)";
    private static final String SPLIT_COMMON_STRING = "[,:]";

    private final String input;

    public StringCalculatorParser(String input) {
        this.input = input;
    }

    public String[] parser() {
        if (input.contains("-")) {
            throw new IllegalArgumentException("계산기에 음수는 올 수 없습니다.");
        }

        Matcher m = Pattern.compile(SPLIT_CUSTOM_STRING).matcher(input);

        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return input.split(SPLIT_COMMON_STRING);
    }
}
