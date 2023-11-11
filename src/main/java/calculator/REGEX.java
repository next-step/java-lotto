package calculator;

import java.util.regex.Pattern;

public class REGEX {
    static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");
    static final Pattern OPERATION_PATTERN = Pattern.compile("[+\\-*/]");
}
