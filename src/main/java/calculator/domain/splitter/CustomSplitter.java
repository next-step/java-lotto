package calculator.domain.splitter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSplitter implements Splitter{
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

    @Override
    public String[] split(String input) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);
        String[] result = new String[0];

        if (m.find()) {
            String customDelimiter = m.group(1);
            result = m.group(2).split(customDelimiter);
        }

        return result;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
