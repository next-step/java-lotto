package step1;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static String[] split(String text){
        // java.util.regex 패키지의 Matcher, Pattern import
        if(StringUtils.isEmpty(text)) {
            return new String[0];
        }

        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);

            return tokens;
        }

        return text.split(DEFAULT_DELIMITER);
    }
}
