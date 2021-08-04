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
        this.matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(this.text);
    }

    public boolean isCustomDelimiter() {
        return matcher.find();
    }

    public String getCustomDelimiter() {
        matcher.matches();
        return matcher.group(1);
    }

    public String[] getNumbers() {
        if (isCustomDelimiter()) {
            text = matcher.group(2);
            String delimiter = getCustomDelimiter();
            return text.split(delimiter);
        }
        return text.split(DELIMITER);
    }
}
