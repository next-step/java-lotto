package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitUtil {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final int ACCEPTED_NUMBER_OF_CUSTOM_DELIMITER = 1;
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.*)\n(.*)");
    private static final int GROUP_NUMBER_CUSTOM_DELIMITER = 1;
    private static final int GROUP_NUMBER_OPERANDS = 2;

    private static final String ERROR_INVALID_NUMBER_OF_CUSTOM_DELIMITER = "한 개의 커스텀 구분자만 입력해주세요.";

    public static String[] splitByDelimiter(String input) {
        List<Operand> operands = new ArrayList<>();
        return splitAccordingly(input);
    }

    private static String[] splitAccordingly(String input) {
        Matcher delimiterMatcher = CUSTOM_DELIMITER_PATTERN.matcher(input);

        if (delimiterMatcher.find()) {
            return byCustomDelimiter(delimiterMatcher.group(GROUP_NUMBER_OPERANDS), delimiterMatcher.group(GROUP_NUMBER_CUSTOM_DELIMITER));
        }

        return byDefaultDelimiter(input, DEFAULT_DELIMITER);
    }

    private static String[] byCustomDelimiter(String operands, String delimiter) throws IllegalArgumentException{
        if (delimiter.length() > ACCEPTED_NUMBER_OF_CUSTOM_DELIMITER){
            throw new IllegalArgumentException(ERROR_INVALID_NUMBER_OF_CUSTOM_DELIMITER);
        }
        return operands.split(DEFAULT_DELIMITER+"|"+delimiter);
    }

    private static String[] byDefaultDelimiter(String operands, String delimiter) {
        return operands.split(delimiter);
    }
}
