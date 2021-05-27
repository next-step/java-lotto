package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterExtractor {
    private static final String DEFAULT_DELIMITER = ",|;";
    private static final Pattern DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int DELIMITER_GROUP_INDEX_IN_MATCHER = 1;
    private static final int DATA_GROUP_INDEX_IN_MATCHER = 2;

    private String splitData;

    public String extractDelimiter(String data) {
        Matcher delimiterMatcher = DELIMITER_PATTERN.matcher(data);
        splitData = data;
        if (delimiterMatcher.find()) {
            splitData = delimiterMatcher.group(DATA_GROUP_INDEX_IN_MATCHER);
            return Pattern.quote(delimiterMatcher.group(DELIMITER_GROUP_INDEX_IN_MATCHER));
        }
        return DEFAULT_DELIMITER;
    }


    public String getSplitData() {
        return splitData;
    }
}
