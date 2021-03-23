package step1.separator;

import step1.number.Numbers;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {
    private final String expression;
    private final String CUSTOM_EXPRESSION_DELIMITER_FORMAT = "//(.)\n(.*)";
    private final String COMMA = ",";
    private final String COLON = ":";
    private final String BAR = "|";

    private final int DELIMITER_POSITION = 1;
    private final int EXPRESSION_POSITION = 2;

    public Separator(String expression) {
        this.expression = expression;
    }



}
