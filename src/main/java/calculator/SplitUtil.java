package calculator;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitUtil {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int GROUP_NUMBER_CUSTOM_DELIMITER = 1;
    private static final int GROUP_NUMBER_OPERANDS = 2;

    public static Operands splitByDelimiter(String input) {
        List<Operand> operands = new ArrayList<>();

        String[] splitString = splitAccordingly(input);
        for (String operand : splitString) {
            operands.add(new Operand(operand));
        }
        return new Operands(operands);
    }

    private static String[] splitAccordingly(String input) {
        Matcher delimiterMatcher = CUSTOM_DELIMITER_PATTERN.matcher(input);

        if (delimiterMatcher.find()) {
            return byCustomDelimiter(delimiterMatcher.group(GROUP_NUMBER_OPERANDS), delimiterMatcher.group(GROUP_NUMBER_CUSTOM_DELIMITER));
        }

        return byDefaultDelimiter(input, DEFAULT_DELIMITER);
    }

    private static String[] byCustomDelimiter(String operands, String delimiter) {
        return operands.split(DEFAULT_DELIMITER+"|"+delimiter);
    }


    private static String[] byDefaultDelimiter(String operands, String delimiter) {
        return operands.split(delimiter);
    }
}
