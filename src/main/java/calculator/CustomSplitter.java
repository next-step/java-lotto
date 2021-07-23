package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSplitter implements Splitter {

    public static final int DELIMITER_GROUP = 1;
    public static final int PATTERN_GROUP = 2;

    @Override
    public SplitNumber split(String str) {
        Pattern pattern = SplitType.CUSTOM.getPattern();
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            String customDelimiter = matcher.group(DELIMITER_GROUP);
            String[] split = matcher.group(PATTERN_GROUP).split(customDelimiter);
            return new SplitNumber(split);
        }

        return new SplitNumber(new String[0]);
    }
}
