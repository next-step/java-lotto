package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {
    private static final String COMMA_DELIMITER = ",";
    private static final String COLON_DELIMITER = ":";
    private static final String DEFAULT_DELIMITER_REGEX = ",|:";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

    // 이렇게 메소드 하나를 거쳐서 전달하면 클라이언트와 메소드간의 의존성을 좀 줄여주는 역할을 할 수 있을까요??
    public String[] split(String input) {
        return getSplitInput(input);
    }

    private String[] getSplitInput(String input) {
        if (input.contains(COLON_DELIMITER) || input.contains(COMMA_DELIMITER)) {
            return getDefaultSplit(input);
        }

        if (input.matches(CUSTOM_DELIMITER_REGEX)) {
            return getCustomSplitText(input);
        }

        return new String[]{input};
    }

    public String[] getDefaultSplit(String input) {
        return input.split(DEFAULT_DELIMITER_REGEX);
    }

    public String[] getCustomSplitText(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);
        if (matcher.find()) {
            String delimiter = matcher.group(1);
            return matcher.group(2).split(delimiter);
        }

        throw new RuntimeException(ErrorMessage.NO_DELIMITER);
    }
}
