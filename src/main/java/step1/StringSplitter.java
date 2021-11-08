package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter {

    private static final String EMPTY_DELIMITER_SYMBOL = "";
    private static final int DELIMITER_POSITION = 1;
    private static final int ITEM_POSITION = 2;

    private final String item;
    private final Pattern customDelimiterPattern;

    private StringSplitter(String input, Pattern customDelimiterPattern) {
        this.item = input;
        this.customDelimiterPattern = customDelimiterPattern;
    }

    public static StringSplitter create(String item, Pattern customDelimiterPattern) {
        return new StringSplitter(item, customDelimiterPattern);
    }

    public String getCustomDelimiterSymbol() {
        return getPositionString(DELIMITER_POSITION, EMPTY_DELIMITER_SYMBOL);
    }

    public String getItemString() {
        return getPositionString(ITEM_POSITION, this.item);
    }

    private String getPositionString(int position, String defaultString) {
        Matcher m = this.customDelimiterPattern.matcher(this.item);
        if (!m.find()) {
            return defaultString;
        }
        return m.group(position);
    }

}
