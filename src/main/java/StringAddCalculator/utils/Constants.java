package StringAddCalculator.utils;

import java.util.regex.Pattern;

public class Constants {
    public static final String RESULT_FOR_NONE_INPUT = "0";
    public static final int ADD_NULL_OR_BLANK = 0;
    public static final Pattern COMPILER_CUSTOM_DELIMITER = Pattern.compile("//(.)\n(.*)");
    public static final int CUSTOM_DELIMITER_INDEX = 1;
    public static final int AFTER_CUSTOM_DELIMITER_INDEX = 2;

}
