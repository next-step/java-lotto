package lotto.step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {
    private static final String DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private String text;
    private Matcher matcher;

    public Delimiter(String text) {
        this.text = text;
        this.matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(text);
    }

    public boolean checkCustomDelimiter() {
        return matcher.find();
    }

    public String getCustomDelimiter() {
            text = matcher.group(2);
            if (isOriginalContainsCustom(matcher.group(1))){
                return DELIMITER;
            }
            return DELIMITER+"|"+matcher.group(2);
    }

    public boolean isOriginalContainsCustom(String customDelimiter){

        return DELIMITER.contains(customDelimiter);
    }
}
