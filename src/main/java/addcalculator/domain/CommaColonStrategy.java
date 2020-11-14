package addcalculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommaColonStrategy implements SplitStrategy{

    private static final String COMMA_COLON_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";

    @Override
    public String[] split(String inputValue) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(inputValue);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return inputValue.split(COMMA_COLON_DELIMITER);
    }
}
