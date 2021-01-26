package stringadder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final String[] EMPTY_ARRAY = {};
    private static final String DEFAULT_DELIMITER = ",|:";

    private String delimiter;
    private String input;

    public Validator(String input) {
        delimiter = DEFAULT_DELIMITER;
        this.input = input;
    }

    public Validator(String delimiter, String input) {
        this.delimiter = delimiter;
        this.input = input;
    }

    private boolean checkInputIsEmpty() {
        return (input == null) || (input.isEmpty());
    }

    private void checkCustomDelimiter() {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            delimiter = m.group(1);
            input = m.group(2);
        }
    }

    public String[] validate() {
        if (checkInputIsEmpty()) {
            return EMPTY_ARRAY;
        }
        checkCustomDelimiter();
        return input.split(delimiter);
    }
}
