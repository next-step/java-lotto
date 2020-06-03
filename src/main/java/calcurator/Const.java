package calcurator;

import java.util.regex.Pattern;

public class Const {
    public static final int INITIAL_NUMBER_ZERO = 0;
    public static final int ZERO_NUM = 0;
    public static final int PATTERN_SEPARATOR_INDEX = 1;
    public static final int PATTERN_SEPARATOR_INPUTS = 2;
    public static final String SYMBOL_COMMA_AND_COLON = ",|:";
    public static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");
}
