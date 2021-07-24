package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserDefineSplitter implements Splitter {

    public static final int DELIMITER_GROUP = 1;
    public static final int PATTERN_GROUP = 2;

    @Override
    public SplitNumber split(String separateStr) {
        Pattern pattern = SplitType.USER_DEFINE.getPattern();
        Matcher matcher = pattern.matcher(separateStr);
        if (!matcher.find()) {
            throw new IllegalArgumentException();
        }
        String customDelimiter = matcher.group(DELIMITER_GROUP);
        String[] split = matcher.group(PATTERN_GROUP).split(customDelimiter);

        return new SplitNumber(split);
    }
}
