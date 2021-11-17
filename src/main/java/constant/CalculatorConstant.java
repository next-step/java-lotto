package constant;

import java.util.regex.Pattern;

/**
 * @author han
 */
public class CalculatorConstant {

    public static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    public static final int DEFAULT_SUM = 0;

    private CalculatorConstant() {
    }
}
